/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

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
public class SearchCat2forCat1S extends HttpServlet {

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

            String category1 = request.getParameter("category1");

            if (category1 == null || category1.trim().equals("")) {
            } else {
                try {
                    String sql1 = "SELECT name FROM product_category1 WHERE idproduct_category1=?";
                    PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                    ps1.setInt(1, Integer.parseInt(category1));
                    System.out.println(ps1);
                    ResultSet rs1 = ps1.executeQuery();

                    if (rs1.next()) {

                        try {
                            out.write("<button class=\"accordion01\" onclick=\"filter(this)\">" + rs1.getString(1) + "</button>");
                            out.write("<div class=\"panel01\">");

                            String sql2 = "SELECT * FROM product_category2 WHERE product_category1_idproduct_category1=?";
                            PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                            ps2.setInt(1, Integer.parseInt(category1));
                            ResultSet rs2 = ps2.executeQuery();

                            while (rs2.next()) {

                                out.write("<div class=\"checkbox\">");
                                out.write("<label class=\"lab02c\">");
                                out.write("<input name=\"chk02c\" type=\"checkbox\" value=\"" + rs2.getInt(1) + "\">&nbsp;" + rs2.getString(2) + "");
                                out.write("</label>");
                                out.write("</div>");

                            }

                            out.write("</div>");
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e1) {
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
