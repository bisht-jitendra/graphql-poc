package demo.graphql.fetcherss;

import demo.graphql.common.models.User;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component("allUsersFetcher")
public class AllUserFetcher implements DataFetcher<List<User>>
{
    @Autowired
    RestTemplate restTemplate;

    private String allUserEndpoint = "http://localhost:9090/users";

    @Override
    public List<User> get(DataFetchingEnvironment environment)
    {
        return Arrays.stream(restTemplate.getForObject(allUserEndpoint, User[].class)).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
