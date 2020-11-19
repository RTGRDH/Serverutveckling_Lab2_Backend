package Backend.demo.bo;

import Backend.demo.db.LogDB;

import java.util.ArrayList;

public class Log {
    private int id;
    private String title;
    private String content;
    private User user;

    public Log(int _id, String _title, String _content, User _user) {
        this.id = _id;
        this.title = _title;
        this.content = _content;
        this.user = _user;
    }

    public static ArrayList<Log> getAllLogs() {
        return LogDB.getAllLogs();
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static boolean createLog(String title, String content, String currUser) {
        return LogDB.createLog(title, content, currUser);
    }

    public static ArrayList<Log> getLogs(String currentUser) {
        return LogDB.getLogs(currentUser);
    }
}
