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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @RequestMapping("/getOtherLogs")
    public ResponseEntity<List<Log>> getOtherLogs()
    {
        List<Log> otherLogs = LogHandler.getOtherLogs("ernst");
        return ResponseEntity.ok(otherLogs);
    }
    @RequestMapping("/getLogs")
    public ResponseEntity<List<Log>> getLogs()
    {
        List<Log> logs = LogHandler.getLogs("ernst");
        return ResponseEntity.ok(logs);
    }
}
