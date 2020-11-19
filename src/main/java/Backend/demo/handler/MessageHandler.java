/*
package Backend.demo.handler;

import Backend.demo.bo.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {
    public static String sendMessage(String title, String content, String toUser, String currUser) {
        if(Message.sendMessage(title, content, toUser, currUser)){
            return "Index";
        }
        return "login";
    }

    public static List<MessageBean> getMessages(String currUser) {
        ArrayList<Message> temp = Message.getMessages(currUser);
        ArrayList<MessageBean> msgs = new ArrayList<>();
        for(int i = 0; i < temp.size(); i++){
            MessageBean msg = new MessageBean();
            msg.setTitle(temp.get(i).getTitle());
            msg.setContent(temp.get(i).getContent());
            msg.setFromUser(temp.get(i).getFromUser().getName());
            msg.setSent(temp.get(i).getSent());
            msg.setToUser(temp.get(i).getToUser().getName());
            msgs.add(msg);
        }
        return msgs;
    }
}
*/