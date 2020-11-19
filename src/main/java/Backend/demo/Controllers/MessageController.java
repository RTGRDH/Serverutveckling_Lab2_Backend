
package Backend.demo.Controllers;
import Backend.demo.bo.Message;
import java.util.List;
import Backend.demo.handler.MessageHandler;
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
    /*
    @PostMapping("sendMessage")
    public void sendMessage (@RequestBody Message msg)
    {

    }
     */
}
