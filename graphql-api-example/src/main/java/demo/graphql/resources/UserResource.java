package demo.graphql.resources;

import demo.graphql.common.services.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserResource
{

    @Autowired
    GraphQLService graphQLService;

    @PostMapping
    public ResponseEntity<Object> fetch(@RequestBody String request) {
        return ResponseEntity.ok(graphQLService.getGraphQL().execute(request).getData());
    }
}
