/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.products;

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
public class UnitsS extends HttpServlet {

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

            String specification = request.getParameter("id");

            System.out.println(specification);
            try {
                if (specification == null || specification.trim().equals("")) {
                } else {
                    String sql01 = "SELECT idspecifications FROM specifications WHERE name=?";
                    PreparedStatement ps01 = Controller.DB.con().prepareStatement(sql01);
                    ps01.setString(1, specification);
                    System.out.println(ps01);
                    ResultSet rs01 = ps01.executeQuery();
                    if (rs01.first()) {
                        try {
                            String sql02 = "SELECT DISTINCT unit FROM product_has_specifications WHERE specifications_idSpecifications=?";
                            PreparedStatement ps02 = Controller.DB.con().prepareStatement(sql02);
                            ps02.setInt(1, rs01.getInt(1));
                            System.out.println(ps02);

                            ResultSet rs02 = ps02.executeQuery();
                            
                            while (rs02.next()) {                                
                                System.out.println(rs02.getString(1));
                                out.write("<option value=\""+rs02.getString(1)+"\"></option>");
                            }

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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
