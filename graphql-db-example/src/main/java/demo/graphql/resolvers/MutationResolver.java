package demo.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MutationResolver implements GraphQLMutationResolver
{

    @Autowired
    UserRepository userRepository;

    public User createUser(String name, int age, String address)
    {
        User user = new User(name, age, address);
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }
}
