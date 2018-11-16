package demo.graphql.fetcherss;

import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("userByIdFetcher")
public class UserByIdFetcher implements DataFetcher<User>
{
    @Autowired
    RestTemplate restTemplate;

    private String allUserEndpoint = "http://localhost:9090/users/";

    @Override
    public User get(DataFetchingEnvironment environment)
    {
        return restTemplate.getForObject(allUserEndpoint+environment.getArgument("id"), User.class);
    }
}
