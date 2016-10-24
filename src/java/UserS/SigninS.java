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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kasun Kalhara
 */
public class SigninS extends HttpServlet {

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

            String url1 = "03_user/login.jsp?msg=";
            String url2 = "index.jsp?msg=";

            String un = request.getParameter("txf01n");
            String pw = request.getParameter("paw01n");
            String rm = request.getParameter("chk01n");

            System.out.println(un + "---" + pw + "---" + rm);

            if (un == null || pw == null | un.trim().equals("") || pw.trim().equals("")) {
                response.sendRedirect(url1 + "Invalid username or password");
            } else if (un.length() < 8 || pw.length() < 8) {
                response.sendRedirect(url1 + "Password must be at least 8 characters long");
            } else {

                try {
                    String sql1 = "SELECT * FROM login WHERE username=? AND password=?";
                    PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                    ps1.setString(1, un.trim());
                    ps1.setString(2, pw.trim());
                    System.out.println(ps1);

                    ResultSet rs1 = ps1.executeQuery();

                    if (rs1.next()) {

//                        System.out.println(rs1.getInt(1));
//                        System.out.println(rs1.getString(2));
//                        System.out.println(rs1.getString(3));
//                        System.out.println(rs1.getInt(4));
//                        System.out.println(rs1.getInt(5));
//                        System.out.println(rs1.getString(6));

                        if (rs1.getInt(4) == 0) {
                            response.sendRedirect(url1 + "Please verify your email address before login&cl=E8AE00");
                        } else if (rs1.getInt(5) == 0) {
                            response.sendRedirect(url1 + "Account Access Temporarily disabled by an administrator");
                        } else {

                            HttpSession se = request.getSession();
                            se.setAttribute("user_id", rs1.getInt(6));
                            se.setAttribute("login_id", rs1.getInt(1));
                            se.setAttribute("username", un);
                            se.setAttribute("password", pw);
                            se.setAttribute("remember_me", rm);
                            se.setAttribute("email_verify", rs1.getInt(4));
                            se.setAttribute("admin_permissions", rs1.getInt(5));
                            
                            
                            Listeners.Visit.putOnlineUser(se.getId(),se);
                            
                            
                            
                            response.sendRedirect(url2 + "");
                        }

                    } else {
                        response.sendRedirect(url1 + "Invalid username or password");
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
