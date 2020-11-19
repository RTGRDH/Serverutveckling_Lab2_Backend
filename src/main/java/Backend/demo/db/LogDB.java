package Backend.demo.db;

import Backend.demo.bo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;

public class LogDB {
    public static boolean createLog(String title, String content, String currUser) {
        LogEntity newLog = new LogEntity();
        newLog.setTitle(title);
        newLog.setContent(content);
        UsersEntity user = UserDB.getUser(currUser);
        newLog.setUserId(user);
        Session session = HibernateUtil.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(newLog);
        session.save(newLog);
        transaction.commit();
        session.close();
        return true;
    }
    public static LogEntity getLog(int logID){
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            LogEntity result = (LogEntity) session.createQuery
                    ("From LogEntity WHERE id = '" + logID + "'")
                    .uniqueResult();
            session.getTransaction().commit();
            return result;
        }finally{
            session.close();
        }
    }

    public static ArrayList<Log> getLogs(String currentUser){
        UsersEntity currUser = UserDB.getUser(currentUser);
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            ArrayList<LogEntity> result = (ArrayList<LogEntity>)
                    session.createQuery("From LogEntity where userId = '" + currUser.getId() + "'")
                            .list();
            return entityToLog(result);
        }finally{
            session.close();
        }
    }

    public static ArrayList<Log> entityToLog(ArrayList<LogEntity> temp){
        ArrayList<Log> result = new ArrayList<>();
        for(int i = 0; i < temp.size(); i++){
            User u = new User(temp.get(i).getUserId().getUsername(), temp.get(i).getUserId().getPassword());
            Log t = new Log(temp.get(i).getId(), temp.get(i).getTitle(), temp.get(i).getContent(), u);
            result.add(t);
        }
        return result;
    }

    public static ArrayList<Log> getAllLogs() {
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            ArrayList<LogEntity> result = (ArrayList<LogEntity>)
                    session.createQuery("From LogEntity ").list();
            return entityToLog(result);
        }finally{
            session.close();
        }
    }
}
