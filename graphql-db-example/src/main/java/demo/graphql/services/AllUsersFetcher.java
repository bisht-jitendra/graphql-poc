package demo.graphql.services;

import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
        int skip = environment.getArgument("skip");
        int limit = environment.getArgument("first");
        return userRepository.findAll(PageRequest.of(skip, limit)).getContent();
    }
}
