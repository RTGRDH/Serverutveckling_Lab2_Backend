
package Backend.demo.Controllers;

import Backend.demo.bo.User;
import Backend.demo.handler.UserHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User newUser)
    {
        UserHandler.createUser(newUser.getUsername(), newUser.getPassword());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        if(UserHandler.login(user.getUsername(), user.getPassword())){
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
}
