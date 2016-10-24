/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kasun Kalhara
 */
public class SignupS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url1 = "03_user/login.jsp?msg=";

            String un = request.getParameter("ema01n");
            String pw = request.getParameter("paw01n");

//            un = "kasunxkalhara@gmail.com";
//            pw = "111111111";
            if (un == null || un.trim().equals("") || pw == null || pw.trim().equals("")) {
                response.sendRedirect(url1 + "username or password is empty");
            } else if (un.length() < 8 || pw.length() < 8) {
                response.sendRedirect(url1 + "Use at least 8 characters for username and password");
            } else {
                try {

                    String SQL1 = "SELECT * FROM login WHERE username=? ";
                    PreparedStatement ps1 = Controller.DB.con().prepareStatement(SQL1);
                    ps1.setString(1, un);
                    System.out.println(ps1 + ">>>>>>>");

                    ResultSet rs1 = ps1.executeQuery();

                    if (rs1.next()) {
                        response.sendRedirect(url1 + "This username already exists");
                    } else {

                        //--------ENCYPT KEY EKA GATTA -------------------------------
                        String key = Conversion.Encrypt.getKey();
                        System.out.println("Encript key : " + key);
                        //--------ENCYPT KEY HASH MAP EKATA DAMMA---------------------
                        Conversion.Collect.putKey(un, key);
                        //--------ENCYPT KEY EKA MAIL KARA----------------------------
                        int mg_st = Mail.SendMail.sendingVerificationEmail(un, key);

                        //--------MAIL SEND STATE GANNAWA ---------------------------
                        // 0 send fail
                        // 1 send success
                        if (mg_st == 1) {

                            System.out.println(Conversion.Collect.getKeyCollection());

                            try {

                                String SQL2 = "INSERT INTO user (email) VALUES (?)";
                                PreparedStatement ps2 = Controller.DB.con().prepareStatement(SQL2);
                                ps2.setString(1, un);
                                System.out.println(ps2);

                                int s1 = ps2.executeUpdate();

                                if (s1 == 1) {
                                    String SQL3 = "SELECT * FROM user WHERE email=? ";
                                    PreparedStatement ps3 = Controller.DB.con().prepareStatement(SQL3);
                                    ps3.setString(1, un);
                                    System.out.println(ps3);

                                    ResultSet rs3 = ps3.executeQuery();

                                    if (rs3.next()) {
                                        System.out.println(rs3.getInt(1));

                                        try {
                                            String SQL4 = "INSERT INTO user_type VALUES (?,'user')";
                                            PreparedStatement ps4 = Controller.DB.con().prepareStatement(SQL4);
                                            ps4.setInt(1, rs3.getInt(1));
                                            System.out.println(ps4);

                                            int s4 = ps4.executeUpdate();

                                            System.out.println(s4);

                                            if (s4 == 1) {
                                                try {
                                                    String SQL5 = "INSERT INTO login (username,password,email_verify,admin_permissions,user_iduser) VALUES (?,?,0,1,?)";
                                                    PreparedStatement ps5 = Controller.DB.con().prepareStatement(SQL5);

                                                    ps5.setString(1, un);
                                                    ps5.setString(2, pw);
                                                    ps5.setInt(3, rs3.getInt(1));
                                                    System.out.println(ps5);

                                                    ps5.executeUpdate();

                                                    response.sendRedirect(url1 + "Registration successful, please verify your email address&cl=00bf6f");

                                                } catch (Exception e) {

                                                }
                                            }

                                        } catch (Exception e) {
                                        }

                                    }
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        } else {
                            response.sendRedirect(url1 + "fail connect to server try again later");
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
