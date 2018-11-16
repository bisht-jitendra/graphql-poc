package demo.graphql.services;

import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userByIdFetcher")
public class UserByIdFetcher implements DataFetcher<User>
{
    @Autowired
    UserRepository userRepository;

    @Override
    public User get(DataFetchingEnvironment environment)
    {
        return userRepository.getOne(environment.getArgument("id"));
    }
}
