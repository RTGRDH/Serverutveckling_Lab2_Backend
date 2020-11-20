package Backend.demo.Controllers;
import Backend.demo.bo.Log;
import Backend.demo.handler.LogHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @GetMapping("/getOtherLogs")
    public ResponseEntity<List<Log>> getOtherLogs(@RequestParam String currentUser)
    {
        List<Log> otherLogs = LogHandler.getOtherLogs(currentUser);
        return ResponseEntity.ok(otherLogs);
    }
    @GetMapping("/getLogs")
    public ResponseEntity<List<Log>> getLogs(@RequestParam String currentUser)
    {
        List<Log> logs = LogHandler.getLogs(currentUser);
        return ResponseEntity.ok(logs);
    }
}
