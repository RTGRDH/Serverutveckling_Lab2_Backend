
package Backend.demo.handler;

import Backend.demo.bo.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {
    public static Boolean sendMessage(String title, String content, String toUser, String currUser) {
        if(Message.sendMessage(title, content, toUser, currUser)){
            return true;
        }
        return false;
    }

    public static List<Message> getMessages(String currUser) {
        ArrayList<Message> msgs = Message.getMessages(currUser);
        return msgs;
    }
}
