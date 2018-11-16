package demo.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class QueryResolver implements GraphQLQueryResolver
{
    @Autowired
    RestTemplate restTemplate;

    private String allUserEndpoint = "http://localhost:9090/users/";

    public List<User> getAllUsers(int offset, int limit)
    {
        return Arrays.stream(restTemplate.getForObject(allUserEndpoint, User[].class)).filter(Objects::nonNull)
            .skip(offset).limit(limit).collect(Collectors.toList());
    }

    public User getUserById(long id)
    {
        return restTemplate.getForObject(allUserEndpoint + id, User.class);
    }

    public List<User> getUserByIdIn(List<Long> ids)
    {
        List<User> users = new ArrayList<>();
        for (Long id : ids)
        {
            users.add(restTemplate.getForObject(allUserEndpoint + id, User.class));
        }

        return users;
    }
}
