
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
    @GetMapping("/getMessages")
    public ResponseEntity<List<Message>> getMessages(@RequestParam String currentUser)
    {
        List<Message> msgs = MessageHandler.getMessages(currentUser);
        return ResponseEntity.ok(msgs);
    }

    @PostMapping("/sendMessage")
    public ResponseEntity sendMessage (@RequestBody Message msg) {
        if(MessageHandler.sendMessage(msg.getTitle(), msg.getContent(), msg.getToUser().getUsername(), msg.getFromUser().getUsername())){
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
}
