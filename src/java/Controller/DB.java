/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.DriverManager;

/**
 *
 * @author Kasun Kalhara
 */
public class DB {

    public static java.sql.Connection c;

    public static java.sql.Connection con() throws Exception {

        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronics_items", "root", "87654321");
//            System.out.println("1");
        }
        return c;
    }
}
