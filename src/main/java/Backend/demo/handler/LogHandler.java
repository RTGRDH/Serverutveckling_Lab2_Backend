package Backend.demo.handler;

import Backend.demo.bo.Log;
import java.util.ArrayList;
import java.util.List;

public class LogHandler {
    public static String createLog(String title, String content, String currUser) {
        if(Log.createLog(title, content, currUser)){
            return "Index";
        }
        return "login"; //Ändra
    }

    /**
     * Gets a persons personal logs and returns them as a list
     * @param currentUser
     * @return
     */
    public static ArrayList<Log> getLogs(String currentUser) {
        ArrayList<Log> logs = Log.getLogs(currentUser);
        return logs;
    }

    /**
     * Gets all other persons logs and removes the current users log from displaying.
     * Returns a list of logs
     * @param currentUser
     * @return
     */
    public static List<Log> getOtherLogs(String currentUser) {
        ArrayList<Log> temp = Log.getAllLogs();
        ArrayList<Log> withoutUser = removeUsersLogs(temp, currentUser);
        return withoutUser;
    }

    private static ArrayList<Log> removeUsersLogs(ArrayList<Log> temp, String currentUser) {
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getUser().getUsername().equals(currentUser)){
                temp.remove(i);
            }
        }
        return temp;
    }
/*
    public static ArrayList<LogBean> convertToBean(List<Log> toBeConverted){
        ArrayList<LogBean> result = new ArrayList<>();
        for(int i = 0; i < toBeConverted.size(); i++){
            Log temp = toBeConverted.get(i);
            LogBean log = new LogBean();
            log.setId(temp.getId());
            log.setTitle(temp.getTitle());
            log.setContent(temp.getContent());
            log.setUsername(temp.getUser().getName());
            result.add(log);
        }
        return result;
    }

 */
}
