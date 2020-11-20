package Backend.demo.db;

import Backend.demo.bo.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.ArrayList;

public class MessageDB {

    public static boolean sendMessage(String title, String content, String toUser, String currUser) {
        MessageEntity newMessage = new MessageEntity();
        newMessage.setContent(content);
        newMessage.setFromUser(UserDB.getUser(currUser));
        newMessage.setToUser(UserDB.getUser(toUser));
        newMessage.setTitle(title);
        newMessage.setSent(new Timestamp(System.currentTimeMillis()));
        Session session = HibernateUtil.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(newMessage);
        session.save(newMessage);
        transaction.commit();
        session.close();
        return true;
    }

    public static ArrayList<Message> getMessages(String currUser) {
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            ArrayList<MessageEntity> result = (ArrayList<MessageEntity>) session.createQuery(
                    "From MessageEntity where toUser = '" + UserDB.getUser(currUser).getId() +"'")
                    .list();
            session.getTransaction().commit();
            return entityToClass(result);
        }finally{
            session.close();
        }
    }

    private static ArrayList<Message> entityToClass(ArrayList<MessageEntity> result) {
        ArrayList<Message> r = new ArrayList<>();
        for(int i = 0; i < result.size(); i++){
            User toUser = new User();
            toUser.setUsername(result.get(i).getToUser().getUsername());
            toUser.setPassword(result.get(i).getFromUser().getPassword());
            User fromUser = new User();
            fromUser.setUsername(result.get(i).getFromUser().getUsername());
            fromUser.setPassword(result.get(i).getFromUser().getPassword());
            Message temp = new Message(
                    result.get(i).getId(),
                    result.get(i).getTitle(),
                    result.get(i).getContent(),
                    result.get(i).getSent(),
                    toUser,
                    fromUser);
            r.add(temp);
        }
        return r;
    }
}
