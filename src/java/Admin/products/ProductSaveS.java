/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.products;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Kasun Kalhara
 */
public class ProductSaveS extends HttpServlet {

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

                String brand_id = null;
                String category_1_id = null;
                String category_2_id = null;
                String category_3_id = null;
                String product_name = null;
                String description = null;

                String specifications_name = null; //[]
                String specifications_value = null;//[]
                String specifications_unit = null;//[]

                String purchase_date = null;
                String MFD = null;
                String EXP = null;
                String purchase_price = null;
//                String old_price = null;
                String discount = null;
                String selling_price = null;
                String w_years = null;
                String w_months = null;
                String w_dates = null;
                String QTY = null;
                String pickup = null;

                String delivery_pond = null;
                String delivery_days = null;
                String delivery_area = null;//[]

                String images = null;//[]

                String rurl = "04_admin/product/product_save.jsp?";

                Collecter01.i = 0; // ilagata sepe collect karanna kalin
                Collecter01.specifications.clear();
                Collecter01.delivery_areas = "";
                Collecter01.product_images.clear();

                FileItemFactory item = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(item);

                List<FileItem> list = upload.parseRequest(request);

                for (FileItem fileItem : list) {

                    if (fileItem.isFormField()) { //form field
                        switch (fileItem.getFieldName()) {
                            case "sel01n":
                                System.out.println("BRAND_ID-------------:" + fileItem.getString());
                                brand_id = fileItem.getString();
                                if (checkDigit(brand_id.trim())) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please select the brand");
                                }
                                break;
                            case "sel02n":
                                System.out.println("CATEGORY1_ID---------:" + fileItem.getString());
                                category_1_id = fileItem.getString();
                                if (checkDigit(category_1_id.trim())) {
                                } else {
                                    response.sendRedirect(rurl + "msg=Please select the category 1");
                                }
                                break;
                            case "sel03n":
                                System.out.println("CATEGORY2_ID---------:" + fileItem.getString());
                                category_2_id = fileItem.getString();
                                if (checkDigit(category_2_id.trim())) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please select the category 2");
                                }
                                break;
                            case "sel04n":
                                System.out.println("CATEGORY3_ID---------:" + fileItem.getString());
                                category_3_id = fileItem.getString();
                                if (checkDigit(category_3_id.trim())) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please select the category 3");
                                }
                                break;
                            case "txf01n":
                                System.out.println("PRODUCT_NAME---------:" + fileItem.getString());
                                product_name = fileItem.getString();
                                if (checkString(product_name.trim())) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the  product name");
                                }
                                break;
                            case "txa01n":
                                System.out.println("DESCRIPTION----------:" + fileItem.getString());
                                description = fileItem.getString();
                                if (checkString(description.trim())) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the description");
                                }

                                break;
                            case "spe01n":
                                System.out.println("SPECIFICATION_NAME----------:" + fileItem.getString());
                                specifications_name = fileItem.getString();
                                if (checkString(specifications_name.trim())) {
                                    Collecter01.collectSpec(specifications_name.trim());
                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the specifications name");
                                }
                                break;
                            case "spe02n":
                                System.out.println("SPECIFICATION_VALUE---------:" + fileItem.getString());
                                specifications_value = fileItem.getString();
                                if (checkString(specifications_value.trim())) {

                                    Collecter01.collectSpec(specifications_value.trim());
                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the specifications value");
                                }
                                break;
                            case "spe03n":
                                System.out.println("SPECIFICATION_UNIT----------:" + fileItem.getString());
                                specifications_unit = fileItem.getString();
                                if (specifications_unit == null || specifications_unit.equals("")) {
                                    specifications_unit = "";
                                } else {
                                    Collecter01.collectSpec(specifications_unit.trim());
                                }

                                break;
                            case "dat01n":
                                System.out.println("PURCHASE_DATE--------:" + fileItem.getString());
                                purchase_date = fileItem.getString();
                                if (checkString(purchase_date)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please select the purchase date");
                                }
                                break;
                            case "dat02n":
                                System.out.println("MFD------------------:" + fileItem.getString());
                                MFD = fileItem.getString();
                                if (checkString(MFD)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please select the MFD");
                                }
                                break;
                            case "dat03n":
                                System.out.println("EXP------------------:" + fileItem.getString());
                                EXP = fileItem.getString();
                                if (checkString(EXP)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the EXP");
                                }
                                break;
                            case "num01n":
                                System.out.println("PURCHASE_price-------:" + fileItem.getString());
                                purchase_price = fileItem.getString();
                                if (checkDigit(purchase_price)) {
                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the purchase price");
                                }
                                break;
                            case "num03n":
                                System.out.println("DISCOUNT-------------:" + fileItem.getString() + " %");
                                discount = fileItem.getString();
                                if (checkDigit(discount)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the discount");
                                }
                                break;
                            case "num04n":
                                System.out.println("SELLING_PRICE--------:" + fileItem.getString());
                                selling_price = fileItem.getString();
                                if (checkDigit(selling_price)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the selling price value");
                                }
                                break;
                            case "num05n":
                                System.out.println("W_YEARS--------------:" + fileItem.getString());
                                w_years = fileItem.getString();
                                if (checkDigit(w_years)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the warrenty years");
                                }
                                break;
                            case "num06n":
                                System.out.println("W_MONTS--------------:" + fileItem.getString());
                                w_months = fileItem.getString();
                                if (checkDigit(w_months)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the warrenty months");
                                }
                                break;
                            case "num07n":
                                System.out.println("W_DATES--------------:" + fileItem.getString());
                                w_dates = fileItem.getString();
                                if (checkDigit(w_dates)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter th  warrenty dates");
                                }
                                break;
                            case "num08n":
                                System.out.println("QTY------------------:" + fileItem.getString());
                                QTY = fileItem.getString();
                                if (checkDigit(QTY)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please enter the  QTY");
                                }
                                break;
                            case "sel05n":
                                System.out.println("PICKUP---------------:" + fileItem.getString());
                                pickup = fileItem.getString();
                                if (checkString(pickup)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please select the pickup");
                                }
                                break;
                            case "sel06n":
                                System.out.println("DELIVERY_POND--------:" + fileItem.getString());
                                delivery_pond = fileItem.getString();
                                if (checkString(delivery_pond)) {

                                } else {
                                    response.sendRedirect(rurl + "msg=Please select the pay on delivery");
                                }
                                break;
                            case "num09n":
                                System.out.println("DELIVERY_DAYS--------:" + fileItem.getString());

                                if (delivery_pond.trim().equals("Yes")) {
                                    delivery_days = fileItem.getString();
                                    if (checkDigit(delivery_days)) {

                                    } else {
                                        response.sendRedirect(rurl + "msg=Please add the delivery dates");
                                    }
                                } else {

                                }
                                break;
                            case "sel07n":
                                System.out.println("DELIVERY_AREA--------:" + fileItem.getString());//[]

                                if (delivery_pond.trim().equals("Yes")) {
                                    delivery_area = fileItem.getString();
                                    if (checkString(delivery_area)) {
//                                        
                                        Collecter01.collectDeliveryArea(delivery_area.trim());

                                    } else {
                                        response.sendRedirect(rurl + "msg=Please select the delivery areas");
                                    }
                                } else {
                                    delivery_area = fileItem.getString();
                                }

                                break;
                            default:
                                break;

                        }

                    } else {

                        images = fileItem.getName();
                        System.out.println(images);
                        if (checkString(images)) {
                            Long time = System.currentTimeMillis();
                            System.out.println("IMAGES_name----------:" + time);
                            String apath = request.getServletContext().getRealPath("/04_admin/product/img/") + "\\" + time + ".jpg";
                            System.out.println("IMAGES_AP------------:" + apath);
                            String rpath = "04_admin\\product\\img\\" + time + ".jpg";
                            System.out.println("IMAGES_RP------------:" + rpath);
                            fileItem.write(new File(apath));

                            Collecter01.collectImages(rpath);

                        } else {
                            response.sendRedirect(rurl + "msg=Please select images");
                        }

                    }
                }

//                if (checkDigit(brand_id)) {
//                    
//                } else {
                System.out.println(checkDigit(brand_id));
                System.out.println(checkString(category_1_id));
                System.out.println(checkString(category_2_id));
                System.out.println(checkString(category_3_id));
//                System.out.println(specifications_name); //null
//                System.out.println(specifications_value); //null
//                System.out.println(specifications_unit); //null
                System.out.println(checkString(purchase_date));
                System.out.println(checkString(MFD));
                System.out.println(checkString(EXP));
                System.out.println(checkDigit(purchase_price));
                System.out.println(checkDigit(selling_price));
                System.out.println(checkDigit(discount));
                System.out.println(checkDigit(w_years));
                System.out.println(checkDigit(w_months));
                System.out.println(checkDigit(w_dates));
                System.out.println(checkDigit(QTY));
                System.out.println(checkString(pickup));
                System.out.println(checkString(delivery_pond));
                System.out.println(delivery_pond.trim().equals("Yes") ? checkDigit(delivery_days) : true);
                System.out.println(delivery_pond.trim().equals("Yes") ? checkString(delivery_area) : true);
                System.out.println(checkString(images));

                if (checkDigit(brand_id)
                        && checkString(category_1_id)
                        && checkString(category_2_id)
                        && checkString(category_3_id)
                        && checkString(purchase_date)
                        && checkString(MFD)
                        && checkString(EXP)
                        && checkDigit(purchase_price)
                        && checkDigit(selling_price)
                        && checkDigit(discount)
                        && checkDigit(w_years)
                        && checkDigit(w_months)
                        && checkDigit(w_dates)
                        && checkDigit(QTY)
                        && checkString(pickup)
                        && checkString(delivery_pond)
                        && delivery_pond.trim().equals("Yes") ? checkDigit(delivery_days) : true
                        && delivery_pond.trim().equals("Yes") ? checkString(delivery_area) : true
                        && checkString(images)) {
                    System.out.println("VALIDATION OK---------------------------------------------------------------------");

//                    try {
//                        String sql0 = "SELECT * FROM product WHERE name=?";
//                        PreparedStatement ps0 = Controller.DB.con().prepareStatement(sql0);
//                        ps0.setString(1, product_name);
//                        System.out.println(ps0);
//                        ResultSet rs0 = ps0.executeQuery();
//
//                        if (rs0.first()) {
//                            response.sendRedirect(rurl + "msg=Can't save This product allready in data base&color=red");
//                        } else {
//                            System.out.println("product eka na");

                            try {
                                String sql1 = "INSERT INTO product VALUES (null,?,?,?,?)";
                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);

                                ps1.setString(1, product_name);
                                ps1.setString(2, description);
                                ps1.setInt(3, Integer.parseInt(brand_id));
                                ps1.setInt(4, Integer.parseInt(category_3_id));
                                System.out.println(ps1);
                                ps1.executeUpdate();

                                try {

                                    String sql2 = "SELECT MAX(idproduct) FROM product WHERE name=?";
                                    PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                    ps2.setString(1, product_name);
                                    System.out.println(ps2);
                                    ResultSet rs2 = ps2.executeQuery();

                                    while (rs2.next()) {
                                        System.out.println(rs2.getInt(1));
//--------------------------------STOCK-------------------------------                                   
                                        try {
                                            String sql3 = "INSERT INTO stock VALUES (null,?,?,?,?,?,?,?,?,?,?)";
                                            PreparedStatement ps3 = Controller.DB.con().prepareStatement(sql3);

                                            ps3.setString(1, purchase_date);
                                            ps3.setInt(2, Integer.parseInt(purchase_price));
//                                        ps3.setInt(3, Integer.parseInt(old_price));
                                            ps3.setInt(3, Integer.parseInt(discount));
                                            ps3.setInt(4, Integer.parseInt(selling_price));
                                            ps3.setString(5, w_years + "," + w_months + "," + w_dates);
                                            ps3.setInt(6, Integer.parseInt(QTY));
                                            ps3.setString(7, pickup);
                                            ps3.setString(8, MFD);
                                            ps3.setString(9, EXP);
                                            ps3.setInt(10, rs2.getInt(1));
                                            System.out.println(ps3);
                                            ps3.executeUpdate();

//----------------------------------IMAGES--------------------------------------------------------------
                                            try {
                                                for (String img_path : Collecter01.product_images) {
                                                    String sql4 = "INSERT INTO image VALUES (?,?)";
                                                    PreparedStatement ps4 = Controller.DB.con().prepareStatement(sql4);
                                                    ps4.setInt(1, rs2.getInt(1));
                                                    ps4.setString(2, img_path);
                                                    System.out.println(ps4);
                                                    ps4.executeUpdate();
                                                }
//----------------------------------DELIVERY------------------------------------------------------------
                                                try {
                                                    String sql5 = "INSERT INTO delivery VALUES (?,?,?,?)";
                                                    PreparedStatement ps5 = Controller.DB.con().prepareStatement(sql5);
                                                    ps5.setInt(1, rs2.getInt(1));

                                                    if (delivery_pond.equals("Yes")) {
                                                        System.out.println("delivery pay yes");
                                                        ps5.setString(2, delivery_pond);
                                                        ps5.setInt(3, Integer.parseInt(delivery_days));
                                                        ps5.setString(4, Collecter01.delivery_areas.substring(1));
                                                        System.out.println(ps5);
                                                        ps5.executeUpdate();
                                                    } else {
                                                        System.out.println("delivery info na save karanna");

                                                        ps5.setString(2, delivery_pond);
                                                        ps5.setInt(3, 0);
                                                        ps5.setString(4, "No");
                                                        System.out.println(ps5);
                                                        ps5.executeUpdate();
                                                    }
//----------------------------------SPECIFICATIONS------------------------------------------------------------
                                                    try {
                                                        String sql6 = "SELECT idSpecifications FROM specifications WHERE name=?";
                                                        PreparedStatement ps6 = Controller.DB.con().prepareStatement(sql6);
                                                        for (Map.Entry<String, List> entry : Collecter01.specifications.entrySet()) {
                                                            System.out.println(entry.getKey() + "---" + entry.getValue().get(0) + "---" + entry.getValue().get(1));

                                                            ps6.setString(1, entry.getKey());
                                                            System.out.println(ps6);
                                                            ResultSet rs6 = ps6.executeQuery();
                                                            int idSpecifications = 0;

                                                            try {
                                                                if (rs6.first()) {
                                                                    System.out.println("Specifications name/id ata____1");
                                                                    idSpecifications = rs6.getInt(1);
                                                                } else {
                                                                    System.out.println("Specifications name/id na____2");
                                                                    try {
                                                                        String sql7 = "INSERT INTO specifications VALUES (null,?)";
                                                                        PreparedStatement ps7 = Controller.DB.con().prepareStatement(sql7);
                                                                        ps7.setString(1, entry.getKey());
                                                                        System.out.println(ps7);
                                                                        ps7.executeUpdate();
                                                                        System.out.println("Specifications new add karanawa____2-1");
                                                                        try {
                                                                            String sql8 = "SELECT idSpecifications FROM specifications WHERE name=?";
                                                                            PreparedStatement ps8 = Controller.DB.con().prepareStatement(sql8);
                                                                            ps8.setString(1, entry.getKey());
                                                                            System.out.println(ps8);
                                                                            ResultSet rs8 = ps8.executeQuery();

                                                                            if (rs8.first()) {
                                                                                System.out.println("new Specifications name/id ata____3-1");
                                                                                idSpecifications = rs8.getInt(1);
                                                                            } else {

                                                                            }
                                                                        } catch (Exception e9) {
                                                                            System.out.println("new Specifications name/id na____3-2");
                                                                        }

                                                                    } catch (Exception e8) {
                                                                        System.out.println("Specifications new add fail____2-2");
                                                                    }
                                                                }
                                                            } catch (Exception e7) {
                                                            } finally {
                                                                try {
                                                                    String sql9 = "INSERT INTO product_has_specifications VALUES (?,?,?,?)";
                                                                    PreparedStatement ps9 = Controller.DB.con().prepareStatement(sql9);
                                                                    ps9.setInt(1, rs2.getInt(1));
                                                                    ps9.setInt(2, idSpecifications);
                                                                    ps9.setString(3, (String) entry.getValue().get(0));
                                                                    ps9.setString(4, (String) entry.getValue().get(1));
                                                                    System.out.println(ps9);
                                                                    ps9.executeUpdate();
                                                                    System.out.println("spec value save kara");

                                                                } catch (Exception e10) {
                                                                    System.out.println("spec value save fail");
                                                                }

                                                            }
                                                        }
                                                    } catch (Exception e6) {
                                                        System.out.println("specifications id load fail fail");
                                                    } finally {
                                                        response.sendRedirect(rurl + "msg=product successfully saved !&cl=00bf6f");

                                                        System.out.println("SAVE COMPLETE---------------------------------------------------------------------");
                                                    }
//----------------------------------SPECIFICATIONS------------------------------------------------------------

                                                } catch (Exception e5) {
                                                    System.out.println("delivery info save fail");
                                                }

//----------------------------------DELIVERY------------------------------------------------------------
                                            } catch (Exception e4) {
                                                System.out.println("images data save fail");
                                            }
//----------------------------------IMAGES--------------------------------------------------------------

                                        } catch (Exception e3) {
                                            System.out.println("stock eke data save fail");
                                        }
//----------------------------------STOCK---------------------------------------------------------------

                                    }

                                } catch (Exception e2) {
                                    System.out.println("product eke id eka load fail");
                                }

                            } catch (Exception e1) {
                                System.out.println("product ekata data save fail");
                            }

//                        }//
//                    } catch (Exception e) {//
//
//                    }//

                } else {
                    System.out.println("VALIDATION FAIL---------------------------------------------------------------------");
                }

//                }
            } catch (Exception e) {
                throw new ServletException(e);
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

    private boolean checkDigit(String val) {

        if (val == null || val.trim().equals("") || !val.matches("[0-9]+")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkString(String val) {
        if (val == null || val.trim().equals("")) {
            return false;
        } else {
            return true;
        }

    }

}
