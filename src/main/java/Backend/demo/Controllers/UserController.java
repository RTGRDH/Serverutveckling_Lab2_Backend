
package Backend.demo.Controllers;

import Backend.demo.bo.User;
import Backend.demo.handler.UserHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("newUser")
    public void addUser(@RequestBody User newUser)
    {
        UserHandler.createUser(newUser.getName(), newUser.getPass());
    }
    @GetMapping("/login")
    public Boolean login(@RequestBody String username, String password)
    {
        return UserHandler.login(username, password);
    }
}
