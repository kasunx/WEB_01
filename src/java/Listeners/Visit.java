/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kasun Kalhara
 */
public class Visit {
//----- USERS -----------------------------------------------------------------------------  

    static HashMap<String, HttpSession> online_users = new HashMap<>();

    public static HttpSession getOnlineUser(String session_id) {

        return online_users.get(session_id);
    }

    public static void putOnlineUser(String session_id, HttpSession se) {
        System.out.println("put hm to user");
        online_users.put(session_id, se);

        for (Object user : getOnlineUsers().values()) {

            HttpSession s = (HttpSession) user;
            System.out.println(s.getId());
            System.out.println(s.getAttribute("username"));
        }

    }

    public static Map getOnlineUsers() {
        return online_users;
    }

    static void removeOnlineUser(String session_id) {
        online_users.remove(session_id);
    }

    //----- VISITORS -----------------------------------------------------------------------------  
    static HashMap<String, HttpSession> online_visitors = new HashMap<>();

    public static HttpSession getOnlineVisitor(String session_id) {
        return online_visitors.get(session_id);
    }

    public static void putOnlineVisitor(String session_id, HttpSession se) {
        System.out.println("put hm to visitor");
        online_visitors.put(session_id, se);

        for (Object visitor : getOnlineVisitors().values()) {
            HttpSession s = (HttpSession) visitor;
            System.out.println(s.getId());
        }
    }

    public static Map getOnlineVisitors() {
        return online_visitors;
    }

    static void removeOnlineVisitor(String session_id, HttpSession se) {

        online_visitors.remove(session_id, se);
    }

}
