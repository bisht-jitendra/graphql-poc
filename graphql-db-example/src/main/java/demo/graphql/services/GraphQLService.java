package demo.graphql.services;

import demo.graphql.common.repositories.UserRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class GraphQLService
{

    @Value("classpath:users.graphql")
    Resource resource;

    @Autowired
    UserRepository userRepository;

    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException
    {
        File schemaFile = resource.getFile();

        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring runtimeWiring = prepareRuntimeWiring();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private RuntimeWiring prepareRuntimeWiring()
    {
        return RuntimeWiring.newRuntimeWiring()
            .type("Query", typeWiring -> typeWiring.dataFetcher("allUsers", env -> userRepository.findAll())
                .dataFetcher("userById", env -> userRepository.getOne(env.getArgument("id")))
                .dataFetcher("userByIdIn", env -> userRepository.findAllById(env.getArgument("ids")))
            )
            .build();
    }

    public GraphQL getGraphQL()
    {
        return graphQL;
    }
}
