/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserS;

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
public class DeleteUserS extends HttpServlet {

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
            
            String uid = request.getParameter("user_id");
            
            if (uid == null || uid.trim().equals("")) {
            } else {
                try {
                    
                    int uid2 = Integer.parseInt(uid);
                    
                    try {
                        String sql1 = "DELETE FROM login WHERE user_iduser=?";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        ps1.setInt(1, uid2);
                        
                        System.out.println(ps1);
                        
                        int s1 = ps1.executeUpdate();
                        System.out.println(s1);
                        if (s1 == 1) {
                            try {
                                
                                String sql2 = "DELETE FROM user_type WHERE user_iduser=?";
                                PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                ps2.setInt(1, uid2);
                                
                                System.out.println(ps2);
                                
                                int s2 = ps2.executeUpdate();
                                System.out.println(s2);
                                if (s2 == 1) {
                                    
                                    try {
                                        String sql3 = "DELETE FROM user WHERE iduser=?";
                                        PreparedStatement ps3 = Controller.DB.con().prepareStatement(sql3);
                                        ps3.setInt(1, uid2);
                                        
                                        System.out.println(ps3);
                                        
                                        int s3 = ps3.executeUpdate();
                                        System.out.println(s3);
                                        if (s3 == 1) {
                                            out.write("1");
                                        } else {
                                            out.write("0");
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                                
                            } catch (Exception e) {
                                
                            }
                            
                        }
                        
                    } catch (Exception e) {
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
