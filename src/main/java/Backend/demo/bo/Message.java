package Backend.demo.bo;

import Backend.demo.db.MessageDB;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Message {
    private int id;
    private String title;
    private String content;
    private Timestamp sent;
    private User toUser;
    private User fromUser;

    /*public Message(int _id, String _title, String _content, Timestamp _sent, User _toUser, User _fromUser){
        id = _id;
        title = _title;
        content = _content;
        sent = _sent;
        toUser = _toUser;
        fromUser = _fromUser;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSent(Timestamp sent) {
        this.sent = sent;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public static boolean sendMessage(String title, String content, String toUser, String currUser) {
        return MessageDB.sendMessage(title, content, toUser, currUser);
    }

    public static ArrayList<Message> getMessages(String currUser) {
        return MessageDB.getMessages(currUser);
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Timestamp getSent() { return sent; }
    public User getToUser() { return toUser; }
    public User getFromUser() { return fromUser; }
}
