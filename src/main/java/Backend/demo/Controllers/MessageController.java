
package Backend.demo.Controllers;
import Backend.demo.bo.Message;
import java.util.List;
import Backend.demo.handler.MessageHandler;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/getMessages")
    public ResponseEntity<List<Message>> getMessages()
    {
        List<Message> msgs = MessageHandler.getMessages("challehallberg");
        return ResponseEntity.ok(msgs);
    }
}
