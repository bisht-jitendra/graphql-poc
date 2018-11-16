package demo.graphql.fetcherss;

import demo.graphql.common.models.User;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("userIdInFetcher")
public class UserIdInFetcher implements DataFetcher<List<User>>
{
    @Autowired
    RestTemplate restTemplate;

    private String allUserEndpoint = "http://localhost:9090/users/";

    @Override
    public List<User> get(DataFetchingEnvironment environment)
    {
        List<User> users = new ArrayList<>();
        for(Long id : (Collection<Long>)environment.getArgument("ids")) {
            users.add(restTemplate.getForObject(allUserEndpoint+id, User.class));
        }

        return users;
    }
}
