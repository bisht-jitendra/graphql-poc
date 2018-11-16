package demo.graphql.services;

import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("allUsersFetcher")
public class AllUsersFetcher implements DataFetcher<List<User>>
{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> get(DataFetchingEnvironment environment)
    {
        return userRepository.findAll();
    }
}
