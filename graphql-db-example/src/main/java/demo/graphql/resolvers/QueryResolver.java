package demo.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver
{
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(int offset, int limit) {
        return userRepository.findAll(PageRequest.of(offset, limit)).getContent();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(new User());
    }

    public List<User> getUserByIdIn(List<Long> ids) {
        return userRepository.findAllById(ids);
    }
}
