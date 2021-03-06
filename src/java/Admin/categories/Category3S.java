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
public class Category3S extends HttpServlet {

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
                        String sql0 = "SELECT * FROM product_category3 WHERE " + co.split(",")[0] + "=? AND " + co.split(",")[1] + "=?;";
                        PreparedStatement ps0 = Controller.DB.con().prepareStatement(sql0);

                        ps0.setInt(1, Integer.parseInt(vl.split(",")[0].trim()));
                        ps0.setString(2, vl.split(",")[1].trim());
                        System.out.println(ps0);
                        ResultSet rs0 = ps0.executeQuery();
                        if (rs0.first()) {
                            out.write("Can't save This Category 3 allready in data base");
                        } else {
                            try {
                                String sql2 = "INSERT INTO product_category3 (" + co.split(",")[0] + "," + co.split(",")[1] + ") VALUE (?,?)";
                                PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                ps2.setInt(1, Integer.parseInt(vl.split(",")[0].trim()));
                                ps2.setString(2, vl.split(",")[1].trim());
                                System.out.println(ps2);
                                ps2.executeUpdate();
//                                out.write("Category 1 Save success");
                            } catch (Exception e2) {
                                out.write("Category 3 Save Fail");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (Integer.parseInt(pt) == 2) {

                }
//--SAVE----------------------------------------------------------------------------------------------------------  
            } else if (qu.equals("up")) {
                System.out.println("update");
//--UPDATE--------------------------------------------------------------------------------------------------------
                if (Integer.parseInt(pt) == 1) {
                    try {
                        String sql0 = "SELECT * FROM product_category3 WHERE " + co + "=? AND " + wr.split(",")[1] + "=?;";
                        PreparedStatement ps0 = Controller.DB.con().prepareStatement(sql0);
                        ps0.setString(1, vl);
                        ps0.setInt(2, Integer.parseInt(cl.split(",")[1]));
                        System.out.println(ps0);
                        ResultSet rs0 = ps0.executeQuery();
                        if (rs0.first()) {
                            out.write("Can't save This Category 3 allready in data base");
                        } else {
                            try {
                                String sql2 = "UPDATE product_category3 SET " + co + "=? WHERE " + wr.split(",")[0] + "=?;";
                                PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                ps2.setString(1, vl);
                                ps2.setInt(2, Integer.parseInt(cl.split(",")[0]));
                                System.out.println(ps2);
                                ps2.executeUpdate();
//                                        out.write("Category 1 Save success");
                            } catch (Exception e2) {
                                out.write("Category 3 Save Fail");
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
                        String sql1 = "SELECT " + co + " FROM product_category3 WHERE " + wr + "=?";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        ps1.setInt(1, Integer.parseInt(cl));
                        System.out.println(ps1);
                        ResultSet rs1 = ps1.executeQuery();
                        while (rs1.next()) {
                            System.out.println(rs1.getInt(1) + "-" + rs1.getString(2));
                            out.write("<tr>"
                                    + "<td>" + rs1.getInt(1) + "</td>"
                                    + "<td>" + rs1.getString(2) + "</td>"
                                    + "<td><input type=\"button\" class=\"btn btn-primary btn-xs\" value=\"Update\" onclick=\"updateCategory3('up','1','name','0','idproduct_category3,product_category2_idproduct_category2','" + rs1.getInt(1) + "," + rs1.getInt(3) + "')\"></td>"
                                    + "<td><input type=\"button\" class=\"btn btn-danger btn-xs\" value=\"Delete\" onclick=\"deleteCategory3('de','1','*','0','idproduct_category3'," + rs1.getInt(1) + ")\"></td>"
                                    + "</tr>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (Integer.parseInt(pt) == 2) {
                    try {
                        String sql1 = "SELECT * FROM product_category3 WHERE product_category2_idproduct_category2=?";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        ps1.setInt(1, Integer.parseInt(cl));
                        System.out.println(ps1);
                        ResultSet rs1 = ps1.executeQuery();
                        out.write("<option></option>");
                        while (rs1.next()) {
                            out.write(" <option value=\"" + rs1.getString(1) + "\">" + rs1.getString(2) + "</option>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
//--SEARCH--------------------------------------------------------------------------------------------------------
            } else if (qu.equals("de")) {
                System.out.println("delete");
//--DELETE--------------------------------------------------------------------------------------------------------
                if (Integer.parseInt(pt) == 1) {
                    try {
                        String sql1 = "SELECT " + co + " FROM product_category3 WHERE idproduct_category3=?;";
                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                        ps1.setInt(1, Integer.parseInt(cl));
                        System.out.println(ps1);

                        ResultSet rs1 = ps1.executeQuery();
//
                        if (rs1.first()) {
                            try {
                                String sql2 = "DELETE FROM product_category3 WHERE " + wr + "=?;";
                                PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                ps2.setInt(1, Integer.parseInt(cl));
                                System.out.println(ps2);
                                ps2.executeUpdate();
//                                out.write("Category 3 Delete success");
                            } catch (Exception e2) {
                                out.write("Category 3 Delete Fail !.. Category 3 has sub Category 3");
                            }
                        } else {
                            out.write("Can't delete This Category 3 not in database");
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
