/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kasun Kalhara
 */
public class ProductDeleteS extends HttpServlet {

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

            String product_id = request.getParameter("del01n");

            System.out.println(product_id);
//            product_id="";

            if (product_id == null || product_id.trim().equals("") || !product_id.matches("[0-9]+")) {
                response.sendRedirect("admin/product/product_home.jsp?msg=Product Delete Fail");
            } else {

                try {

                    try {
                        String sql1 = "DELETE FROM product_has_specifications WHERE product_idproduct=?;";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        ps1.setInt(1, Integer.parseInt(product_id));
                        System.out.println(ps1);
                        ps1.executeUpdate();
                    } catch (Exception e) {
                    }

                    try {
                        String sql2 = "DELETE FROM stock WHERE product_idproduct=?;";
                        PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                        ps2.setInt(1, Integer.parseInt(product_id));
                        System.out.println(ps2);
                        ps2.executeUpdate();
                    } catch (Exception e) {
                    }

                    try {
                        String sql3 = "DELETE FROM image WHERE product_idproduct=?;";
                        PreparedStatement ps3 = Controller.DB.con().prepareStatement(sql3);
                        ps3.setInt(1, Integer.parseInt(product_id));
                        System.out.println(ps3);
                        ps3.executeUpdate();
                    } catch (Exception e) {
                    }

                    try {
                        String sql4 = "DELETE FROM delivery WHERE product_idproduct=?;";
                        PreparedStatement ps4 = Controller.DB.con().prepareStatement(sql4);
                        ps4.setInt(1, Integer.parseInt(product_id));
                        System.out.println(ps4);
                        ps4.executeUpdate();
                    } catch (Exception e) {
                    }

                    try {
                        String sql5 = "DELETE FROM product WHERE idproduct=?;";
                        PreparedStatement ps5 = Controller.DB.con().prepareStatement(sql5);
                        ps5.setInt(1, Integer.parseInt(product_id));
                        System.out.println(ps5);
                        ps5.executeUpdate();
                    } catch (Exception e) {
                    }

                    response.sendRedirect("04_admin/product/product_home.jsp?msg=Product successfully deleted !&cl=00bf6f");
                } catch (Exception e) {
                    response.sendRedirect("04_admin/product/product_home.jsp?msg=Product Delete Fail");
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
