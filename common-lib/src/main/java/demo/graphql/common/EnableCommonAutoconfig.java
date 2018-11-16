package demo.graphql.common;

import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class EnableCommonAutoconfig
{
    private final Logger LOG = LoggerFactory.getLogger(EnableCommonAutoconfig.class);

    @Bean
    public ApplicationRunner populateData(UserRepository userRepository) {
        System.out.println("---------------------------------");
        return args -> {
            LOG.info("Trying to populate users data");
            if(userRepository.count() <= 0 ) {
                LOG.info("Creating 4 users");
                User user1 = new User(1L, "John", 28, "Address 1", LocalDateTime.now());
                User user2 = new User(2L, "Pal", 43, "Address 1", LocalDateTime.now());
                User user3 = new User(3L, "Xyz", 32, "Address 2", LocalDateTime.now());
                User user4 = new User(4L, "Pqr", 38, "Address 2", LocalDateTime.now());

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);
            } else {
                LOG.info("Already populated data so skipping.");
            }
        };
    }
}
