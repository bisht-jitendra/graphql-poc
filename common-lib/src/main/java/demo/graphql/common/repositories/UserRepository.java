package demo.graphql.common.repositories;

import demo.graphql.common.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}
