package Backend.demo.Controllers;
import Backend.demo.bo.Log;
import Backend.demo.handler.LogHandler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogController {
    @CrossOrigin
    @PostMapping("/getOtherUsersLogs")
    public ResponseEntity<List<Log>> getOtherLogs(@RequestParam String currentUser)
    {
        System.out.println("Fetching other users logs. Current user is: " + currentUser);
        List<Log> otherLogs = LogHandler.getOtherLogs(currentUser);
        return ResponseEntity.ok(otherLogs);
    }
    @CrossOrigin
    @PostMapping("/getUsersLogs")
    public ResponseEntity<List<Log>> getLogs(@RequestParam String currentUser)
    {
        System.out.println("Fetching current user '" + currentUser + "' logs");
        List<Log> logs = LogHandler.getLogs(currentUser);
        return ResponseEntity.ok(logs);
    }
    @CrossOrigin
    @PostMapping("/createLog")
    public ResponseEntity createLog(@RequestParam String title,
                                    @RequestParam String content,
                                    @RequestParam String currentUser){
        System.out.println("Creating a log for current user: " + currentUser);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        if(LogHandler.createLog(title, content, currentUser)){
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
}
