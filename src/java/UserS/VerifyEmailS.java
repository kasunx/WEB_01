/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kasun Kalhara
 */
public class VerifyEmailS extends HttpServlet {

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

            String key = request.getParameter("key");
            String email = request.getParameter("email");

//            key = "5936128470357";
//            email = "kasunxkalhara@gmail.com";
            System.out.println("mail send key ------" + key);
            System.out.println("mail send address --" + email);

            if (key == null || key.trim().equals("")) {
                response.sendRedirect("03_user/login.jsp?msg=Email verification fail");
            } else {

                HashMap e_key_hm = Conversion.Collect.getKeyCollection();
                System.out.println("hash key ------" + e_key_hm.get(email));

                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css\">");
                out.println("<script src=\"lib/bootstrap/jquery-3.1.0.min.js\"></script>");
                out.println("<script src=\"lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js\"></script>");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("<style>*{ font-family: \"Oswald\";}</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<center>");
                out.println("<h3>");

                if (key.equals(e_key_hm.get(email))) {

                    System.out.println("matched");

                    try {
                        String sql1 = "UPDATE login SET email_verify=1 WHERE username=?";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        ps1.setString(1, email);

                        System.out.println(ps1);

                        int st = ps1.executeUpdate();

                        if (st == 1) {
                            System.out.println("email verifiacation success");

                            out.println("<h2>Congratulations !</h2>");
                            out.println("you have successfully verified your e-mail address");
                            out.println("<br><br>");
                            out.println("<a href=\"03_user/login.jsp\"><input type=\"button\" value=\"Sign in\" class=\"btn btn-primary btn-sm\" style=\"border-radius: 0px;background-color: #4F4F4F\"></a>");

                        } else {

                            out.println("email verifiacation fail..internal server error");
                             out.println("<br><br>");
                            out.println("<a href=\"03_user/login.jsp\"><input type=\"button\" value=\"Sign in\" class=\"btn btn-primary btn-sm\" style=\"border-radius: 0px;background-color: #4F4F4F\"></a>");

                        }

                    } catch (Exception e) {
                    }
                } else {
                    out.println("<h2>Warning !</h2>");
                    out.println("Record not found...");
                }
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");
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
