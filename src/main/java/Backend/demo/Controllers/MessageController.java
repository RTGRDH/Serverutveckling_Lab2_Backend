
package Backend.demo.Controllers;
import Backend.demo.bo.Message;
import java.util.List;
import Backend.demo.handler.MessageHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @CrossOrigin
    @GetMapping("/getMessages")
    public ResponseEntity<List<Message>> getMessages(@RequestParam String currentUser)
    {
        System.out.println("Fetching current user '" + currentUser + "' messages");
        List<Message> msgs = MessageHandler.getMessages(currentUser);
        return ResponseEntity.ok(msgs);
    }
    @CrossOrigin
    @PostMapping("/sendMessage")
    public ResponseEntity sendMessage (@RequestBody Message msg) {
        System.out.println("Sending message to user '" + msg.getToUser().getUsername() + "'");
        System.out.println("Message sent from '" + msg.getFromUser().getUsername() + "'");
        if(MessageHandler.sendMessage(msg.getTitle(), msg.getContent(), msg.getToUser().getUsername(), msg.getFromUser().getUsername())){
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
}
