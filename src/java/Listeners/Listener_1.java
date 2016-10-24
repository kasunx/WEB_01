/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Kasun Kalhara
 */
public class Listener_1 implements HttpSessionListener {

    static int visit_count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        System.out.println("----- SESSION ID      : " + se.getSession().getId());
        System.out.println("----- SESSION CREATED : ");

        Listeners.Visit.putOnlineVisitor(se.getSession().getId(), se.getSession());
//        visit_count++;
//        System.out.println("----- VISITERS COUNT  : " + visit_count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        System.out.println("----- SESSION ID        : " + se.getSession().getId());
        Listeners.Visit.removeOnlineVisitor(se.getSession().getId(), se.getSession());
        Listeners.Visit.removeOnlineUser(se.getSession().getId());
        System.out.println("----- SESSION DESTROYED :");

    }

}
