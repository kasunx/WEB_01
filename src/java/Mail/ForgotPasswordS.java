/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

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
public class ForgotPasswordS extends HttpServlet {

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

            String email = request.getParameter("ema01n");

            System.out.println(email);

            if (email == null || email.trim().equals("")) {
                response.sendRedirect("03_user/forgot_password.jsp?msg=Inalid email address");
            } else {
                try {

                    String sql1 = "SELECT * FROM login WHERE username=?";
                    PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                    ps1.setString(1, email);
                    System.out.println(ps1);
                    ResultSet rs1 = ps1.executeQuery();

                    if (rs1.next()) {

                        try {
                            String sql2 = "SELECT password FROM login WHERE username=?";
                            PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                            ps2.setString(1, email);
                            System.out.println(ps2);
                            ResultSet rs2 = ps2.executeQuery();

                            if (rs2.next()) {

                                int st = Mail.SendMail.sendSimpleMail(email, "Your password is :" + rs2.getString(1));

                                if (st == 1) {
                                    response.sendRedirect("03_user/forgot_password.jsp?msg=Password successfully send to your e-mail address&cl=00bf6f");
                                } else {
                                    response.sendRedirect("03_user/forgot_password.jsp?msg=e-mail send fail internal server error");

                                }

                            }

                        } catch (Exception e) {

                        }

                    } else {
                        response.sendRedirect("03_user/forgot_password.jsp?msg=Inalid email address");
                    }

                } catch (Exception e) {

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
