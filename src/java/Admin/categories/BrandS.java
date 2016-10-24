/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.categories;

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
public class BrandS extends HttpServlet {

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

            String qu = request.getParameter("qu");
            String pt = request.getParameter("pt");
            String co = request.getParameter("co");
            String vl = request.getParameter("vl");
            String wr = request.getParameter("wr");
            String cl = request.getParameter("cl");

            System.out.println("query :" + qu + "\n pattern :" + pt + "\n columns :" + co + "\n values :" + vl + "\n where :" + wr + "\n clouse :" + cl);
            if (qu == null || qu.trim().equals("")
                    || pt == null || pt.trim().equals("")
                    || vl == null || vl.trim().equals("")
                    || co == null || co.trim().equals("")
                    || wr == null || wr.trim().equals("")
                    || cl == null || cl.trim().equals("")) {
                System.out.println("no data");
            } else if (qu.equals("sa")) {
                System.out.println("save");
//--SAVE----------------------------------------------------------------------------------------------------------                
                if (Integer.parseInt(pt) == 1) {
                    try {
                        String sql1 = "SELECT * FROM brand WHERE brand_name=?;";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        ps1.setString(1, vl);
                        System.out.println(ps1);
                        ResultSet rs1 = ps1.executeQuery();
//
                        if (rs1.first()) {
                            out.write("Can't save This Brand allready have database");
                        } else {
                            try {
                                String sql2 = "INSERT INTO brand (" + co + ") VALUE (?);";
                                PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                ps2.setString(1, vl);
                                System.out.println(ps2);
                                ps2.executeUpdate();
//                                out.write("Brand Save success");
                            } catch (Exception e2) {
                                out.write("Brand Save Fail");
                            }
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else if (Integer.parseInt(pt) == 2) {

                }
//--SAVE----------------------------------------------------------------------------------------------------------  
            } else if (qu.equals("up")) {
                System.out.println("update");
//--UPDATE--------------------------------------------------------------------------------------------------------               
                if (Integer.parseInt(pt) == 1) {

                    try {
                        String sql0 = "SELECT * FROM brand WHERE brand_name=?;";
                        PreparedStatement ps0 = Controller.DB.con().prepareStatement(sql0);
                        ps0.setString(1, vl);
                        System.out.println(ps0);
                        ResultSet rs0 = ps0.executeQuery();

                        if (rs0.first()) {
                            out.write("Can't save This Brand allready in data base");
                        } else {
                            try {
                                String sql1 = "SELECT * FROM brand WHERE " + wr + "=?;";
                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                ps1.setInt(1, Integer.parseInt(cl));
                                System.out.println(ps1);
                                ResultSet rs1 = ps1.executeQuery();
                                if (rs1.first()) {
                                    try {
                                        String sql2 = "UPDATE brand SET " + co + "=? WHERE " + wr + "=?;";
                                        PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                        ps2.setString(1, vl);
                                        ps2.setString(2, cl);
                                        System.out.println(ps2);
                                        ps2.executeUpdate();
//                                        out.write("Brand Save success");
                                    } catch (Exception e2) {
                                        out.write("Brand Save Fail");
                                    }
                                } else {
                                    out.write("Can't save This Brand not in database");
                                }
                            } catch (Exception e1) {
                                System.out.println(e1);
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                }
//--UPDATE--------------------------------------------------------------------------------------------------------                 
            } else if (qu.equals("se")) {
                System.out.println("search");
//--SEARCH--------------------------------------------------------------------------------------------------------               
                if (Integer.parseInt(pt) == 1) {
                    try {
                        String sql1 = "SELECT " + co + " FROM brand";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        System.out.println(ps1);
                        ResultSet rs1 = ps1.executeQuery();
                        while (rs1.next()) {
                            System.out.println(rs1.getInt(1) + "  " + rs1.getString(2));
                            out.write("<tr>"
                                    + "<td>" + rs1.getInt(1) + "</td>"
                                    + "<td>" + rs1.getString(2) + "</td>"
                                    + "<td><input type=\"button\" class=\"btn btn-primary btn-xs\" value=\"Update\" onclick=\"updateBrand('up','1','brand_name','0','idbrand'," + rs1.getInt(1) + ")\"></td>"
                                    + "<td><input type=\"button\" class=\"btn btn-danger btn-xs\" value=\"Delete\" onclick=\"deleteBrand('de','1','*','0','idbrand'," + rs1.getInt(1) + ")\"></td>"
                                    + "</tr>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (Integer.parseInt(pt) == 2) {

                } else {

                }
//--SEARCH--------------------------------------------------------------------------------------------------------                
            } else if (qu.equals("de")) {
                System.out.println("delete");
//--DELETE--------------------------------------------------------------------------------------------------------   
                if (Integer.parseInt(pt) == 1) {
                    try {
                        String sql1 = "SELECT * FROM brand WHERE idbrand=?;";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        ps1.setInt(1, Integer.parseInt(cl));
                        System.out.println(ps1);

                        ResultSet rs1 = ps1.executeQuery();

                        if (rs1.first()) {
                            try {
                                String sql2 = "DELETE FROM brand WHERE " + wr + "=?;";
                                PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                ps2.setInt(1, Integer.parseInt(cl));
                                System.out.println(ps2);
                                ps2.executeUpdate();
//                                out.write("Brand Delete success");
                            } catch (Exception e2) {
                                out.write("Cant delete this brand already use");
                            }

                        } else {
                            out.write("Can't delete This Brand not in database");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else if (Integer.parseInt(pt) == 2) {
                }
//--DELETE--------------------------------------------------------------------------------------------------------  
            } else {
                System.out.println("q other");
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
