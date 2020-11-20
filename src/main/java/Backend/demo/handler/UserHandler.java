package Backend.demo.handler;

import Backend.demo.bo.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class UserHandler {

    public static Boolean login(String user, String pass) {
        if(User.login(user, pass)){
            //HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            //session.setAttribute("currentUser", user);
            return true;
        }
        return false;
    }
    public static boolean createUser(String userN, String passW){
        User.createUser(userN, passW);
        return true;
    }
    public static Collection getUserNamesByName(String name) {
        ArrayList names = new ArrayList();
        Collection users = User.findByName(name);
        for (Iterator it = users.iterator(); it.hasNext();) {
            User user = (User) it.next();
            names.add(new String(user.getName()));
        }
        return names;
    }
}
