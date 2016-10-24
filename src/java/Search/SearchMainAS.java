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
public class SearchMainAS extends HttpServlet {

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

            String product_name = request.getParameter("PN");

            String price1 = request.getParameter("PR1");
            String price2 = request.getParameter("PR2");

            String brand = request.getParameter("BR");

            String category1 = request.getParameter("CT1");

            String category2 = request.getParameter("CT2");

            System.out.println("NAME :" + product_name);

            System.out.println("PRICE 1:" + price1);
            System.out.println("PRICE 2:" + price2);

//            System.out.println("BRAND :" + brand.substring(1).replace(">", ","));
//            System.out.println("CAT1 :" + category1);
//            System.out.println("CAT2 :" + category2.substring(1).replace(">", ","));
            String pt = "";
            if (product_name == null || product_name.trim().equals("")) {
//                   PRNT 
                pt += "0";
            } else {
//                   PRAT 
                pt += "1";
                try {

                    String sql1 = "SELECT idproduct FROM product WHERE name like ? ";

                    if (price1 == null || price2 == null || price1.trim().equals("") || price2.trim().equals("")) {
//                   PRNT  >>  PRINA
                        pt += "0";

                    } else {
//                        PRIAT
                        pt += "-1";
                        sql1 += " AND idproduct IN (SELECT product_idproduct FROM stock WHERE selling_price BETWEEN ? AND ?)";

                        if (brand == null || brand.trim().equals("")) {

                            pt += "-0";
                            if (category1 == null || category1.trim().equals("")) {
                                pt += "-0-0";
                                //1-1-0-0-0
                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                ps1.setString(1, "%" + product_name + "%");
                                ps1.setInt(2, Integer.parseInt(price1));
                                ps1.setInt(3, Integer.parseInt(price2));

                                System.out.println(pt + "FFFFF");
//                                System.out.println(ps1);

                                searchProduct(ps1);
                                int i = Search.SearcdhData.getPagesCount();
                                System.out.println("pages---" + i);

                                if (i >= 1) {
                                    out.write("<li onclick=\"\"><a href=\"#\" >START</a></li><li><a href=\"#\"><<</a></li>");
                                    for (int j = 1; j < i + 1; j++) {
                                        out.write("<li onclick=\"searchMain3("+j+")\"><a href=\"#\">" + j + "</a></li>");
                                    }
                                    out.write("<li><a href=\"#\">>></a></li><li><a href=\"#\">END</a></li>");
                                }

                            } else if (category2 == null || category2.trim().equals("")) {
                                pt += "-1-0";
                                //1-1-0-1-0
                                sql1 += " AND product_category3_idproduct_category3 IN (SELECT idproduct_category3 FROM product_category3 WHERE product_category2_idproduct_category2 IN (SELECT idproduct_category2 FROM product_category2 WHERE product_category1_idproduct_category1=?))";

                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                ps1.setString(1, "%" + product_name + "%");
                                ps1.setInt(2, Integer.parseInt(price1));
                                ps1.setInt(3, Integer.parseInt(price2));
                                ps1.setInt(4, Integer.parseInt(category1));

                                System.out.println(pt + "EEEEE");
//                                System.out.println(ps1);

                                searchProduct(ps1);
                                int i = Search.SearcdhData.getPagesCount();
                                System.out.println("pages---" + i);
                                out.write(i + "");

                            } else {
                                pt += "-1-1";
                                //1-1-0-1-1
                                sql1 += " AND product_category3_idproduct_category3 IN (SELECT idproduct_category3 FROM product_category3 WHERE product_category2_idproduct_category2 IN (" + category2.substring(1).replace(">", ",") + "))";

                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                ps1.setString(1, "%" + product_name + "%");
                                ps1.setInt(2, Integer.parseInt(price1));
                                ps1.setInt(3, Integer.parseInt(price2));

                                System.out.println(pt + "DDDDD");
//                                System.out.println(ps1);

                                searchProduct(ps1);
                                int i = Search.SearcdhData.getPagesCount();
                                System.out.println("pages---" + i);
                                out.write(i + "");

                            }
                        } else {
                            pt += "-1";
                            sql1 += " AND brand_idbrand IN (" + brand.substring(1).replace(">", ",") + ")";
                            if (category1 == null || category1.trim().equals("")) {
//                              1-1-1-0-0
                                pt += "-0-0";

                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                ps1.setString(1, "%" + product_name + "%");
                                ps1.setInt(2, Integer.parseInt(price1));
                                ps1.setInt(3, Integer.parseInt(price2));

                                System.out.println(pt + "CCCCC");
//                                System.out.println(ps1);

                                searchProduct(ps1);
                                int i = Search.SearcdhData.getPagesCount();
                                System.out.println("pages---" + i);
                                out.write(i + "");

                            } else if (category2 == null || category2.trim().equals("")) {
//                              1-1-1-1-0
                                pt += "-1-0";
                                sql1 += " AND product_category3_idproduct_category3 IN (SELECT idproduct_category3 FROM product_category3 WHERE product_category2_idproduct_category2 IN (SELECT idproduct_category2 FROM product_category2 WHERE product_category1_idproduct_category1=?))";

                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                ps1.setString(1, "%" + product_name + "%");
                                ps1.setInt(2, Integer.parseInt(price1));
                                ps1.setInt(3, Integer.parseInt(price2));
                                ps1.setInt(4, Integer.parseInt(category1));

                                System.out.println(pt + "BBBBB");
//                                System.out.println(ps1);

                                searchProduct(ps1);
                                int i = Search.SearcdhData.getPagesCount();
                                System.out.println("pages---" + i);
                                out.write(i + "");

                            } else {
//                              1-1-1-1-1
                                pt += "-1-1";
                                sql1 += " AND product_category3_idproduct_category3 IN (SELECT idproduct_category3 FROM product_category3 WHERE product_category2_idproduct_category2 IN (" + category2.substring(1).replace(">", ",") + "))";
                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                ps1.setString(1, "%" + product_name + "%");
                                ps1.setInt(2, Integer.parseInt(price1));
                                ps1.setInt(3, Integer.parseInt(price2));

                                System.out.println(pt + "AAAAA");
//                                System.out.println(ps1);

                                searchProduct(ps1);
                                int i = Search.SearcdhData.getPagesCount();
                                System.out.println("pages---" + i);

                            }
                        }
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

    private void searchProduct(PreparedStatement ps1) {

        try {

            ResultSet rs1 = ps1.executeQuery();

            String data = "";

            while (rs1.next()) {
                data += rs1.getInt(1) + ",";
            }

            if (data.equals("")) {
                System.out.println("data na :" + data);
                Search.SearcdhData.pages_data.clear();
            } else {
                Search.SearcdhData.putPageData(data);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
