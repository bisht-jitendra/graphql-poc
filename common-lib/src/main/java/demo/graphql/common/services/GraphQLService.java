package demo.graphql.common.services;

import demo.graphql.common.repositories.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@Configuration
public class GraphQLService
{

    @Value("classpath:users.graphql")
    Resource resource;

    @Autowired
    UserRepository userRepository;

    @Autowired
    @Qualifier("allUsersFetcher")
    private DataFetcher allUsersFetcher;

    @Autowired
    @Qualifier("userByIdFetcher")
    private DataFetcher userByIdFetcher;

    @Autowired
    @Qualifier("userIdInFetcher")
    private DataFetcher userIdInFetcher;

    @Bean
    public GraphQLSchema graphQLSchema() throws IOException
    {
        File schemaFile = resource.getFile();

        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring runtimeWiring = prepareRuntimeWiring();
        return new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private RuntimeWiring prepareRuntimeWiring()
    {
        return RuntimeWiring.newRuntimeWiring()
            .type("Query", typeWiring -> typeWiring.dataFetcher("allUsers", allUsersFetcher)
                .dataFetcher("userById", userByIdFetcher)
                .dataFetcher("userByIdIn", userIdInFetcher)
            )
            .build();
    }

}
