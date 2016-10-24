/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Index;

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
public class MegaMenuData extends HttpServlet {

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

            try {
                String sql1 = "SELECT * FROM product_category1";
                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                ResultSet rs1 = ps1.executeQuery();
                try {
                    while (rs1.next()) {
                        out.write("<li class=\"dropdown-item03\">");
                        out.write("<a href=\"#home\" class=\"dropdown-button03\">" + rs1.getString(2) + " <span class=\"dropdown-icon03 caret\"></span></a>");
                        out.write(" <div class=\"dropdown-content03\" >");

                        String sql2 = "SELECT * FROM product_category2 WHERE product_category1_idproduct_category1=?";
                        PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                        ps2.setString(1, rs1.getString(1));
                        ResultSet rs2 = ps2.executeQuery();
//------------------------------------------------------------------------------                      
                        try {
                            while (rs2.next()) {
                                out.write("<div class=\"sub-content03\">");
                                out.write(" <h5 class=\"sub-title03\"><a href=\"#\">" + rs2.getString(2) + "</a></h5>");
                                String sql3 = "SELECT * FROM product_category3 WHERE product_category2_idproduct_category2=?";
                                PreparedStatement ps3 = Controller.DB.con().prepareStatement(sql3);
                                ps3.setString(1, rs2.getString(1));
                                ResultSet rs3 = ps3.executeQuery();
                                try {
                                    out.write("<ul class=\"sub-list03\">");
                                    while (rs3.next()) {
                                        out.write("<li><a href=\"#\">" + rs3.getString(2) + "</a></li>");
                                    }
                                    out.write("</ul> ");
                                } catch (Exception e) {
                                }
                                out.write("</div>");
                            }
                        } catch (Exception e) {
                        }
//---------------------------------------------------------------------------------------------              
                        out.write("</div>");
                        out.write("</li>");
                    }
                } catch (Exception e) {
                }
            } catch (Exception e) {
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
