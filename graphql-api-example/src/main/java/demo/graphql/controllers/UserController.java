package demo.graphql.controllers;

import demo.graphql.common.models.User;
import demo.graphql.common.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController
{
    private Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<Object> listUsers() {
        LOG.info("Get All Users request received.....");
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") Long id) {
        LOG.info("Get User by id {} request received.....", id);
        return ResponseEntity.ok(userRepository.findById(id).orElse(new User()));
    }

}
