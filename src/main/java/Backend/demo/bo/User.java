package Backend.demo.bo;

import Backend.demo.db.UserDB;
import java.util.Collection;
public class User {
    private String id;
    private String name;
    private String pass;
    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public static Collection findByName(String name) {
        return UserDB.findByName(name);
    }
    public static Boolean login(String user, String pass) { return UserDB.login(user, pass); }
    public static void createUser(String user, String pass) { UserDB.createUser(user, pass); }
}
