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
public class ProductUpdateS extends HttpServlet {

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
                String product_id = null;

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

                String images0 = null;
                String images = null;//[]

                String rurl = null;

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
                            case "hid01n":
                                System.out.println("PRODUCT_ID---------:" + fileItem.getString());
                                product_id = fileItem.getString();
                                if (checkDigit(product_id)) {
                                    rurl = "04_admin/product/product_update.jsp?upd01n=" + product_id + "&";
                                } else {
                                    rurl = "04_admin/product/product_update.jsp?upd01n=" + product_id + "&";
                                    response.sendRedirect(rurl + "msg=Please enter the  product id");
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

                                }
                                break;
                            case "hid02n":
                                System.out.println("DELETE--------:" + fileItem.getString());
                                images0 = fileItem.getString();
                                if (checkString(images0)) {

                                    for (String imn : images0.split(">")) {

                                        System.out.println(imn);
                                    }
                                } else {
                                    System.out.println("delete natha");
//                                    response.sendRedirect(rurl + "msg=Please select the pay on delivery");
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
//                            response.sendRedirect(rurl + "msg=Please select images");
                        }
                    }
                }

                System.out.println(checkString(product_id));
                System.out.println(checkString(product_name));
                System.out.println(checkString(description));
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

                if (checkDigit(product_id)
                        && checkString(product_name)
                        && checkString(description)
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
                        && delivery_pond.trim().equals("Yes") ? checkString(delivery_area) : true) {
                    System.out.println("UPDATE VALIDATION OK---------------------------------------------------------------------");

                    try {
                        String sql00 = "UPDATE product SET name=?, description=? WHERE idproduct=?";
                        PreparedStatement ps00 = Controller.DB.con().prepareStatement(sql00);
                        ps00.setString(1, product_name);
                        ps00.setString(2, description);
                        ps00.setInt(3, Integer.parseInt(product_id));
                        System.out.println(ps00);

                        int x = ps00.executeUpdate();

                        if (x == 1) {
                            try {
                                String sql01 = "UPDATE stock SET purchase_date=?, purchase_price=?, discount=?, selling_price=?, warranty=?, QTY=?, pickup=?, MFD=?, EXP=? WHERE product_idproduct=?";
                                PreparedStatement ps01 = Controller.DB.con().prepareStatement(sql01);
                                ps01.setString(1, purchase_date);
                                ps01.setInt(2, Integer.parseInt(purchase_price));
                                ps01.setInt(3, Integer.parseInt(discount));
                                ps01.setInt(4, Integer.parseInt(selling_price));
                                ps01.setString(5, w_years + "," + w_months + "," + w_dates);
                                ps01.setInt(6, Integer.parseInt(QTY));
                                ps01.setString(7, pickup);
                                ps01.setInt(6, Integer.parseInt(QTY));
                                ps01.setString(7, pickup);
                                ps01.setString(8, MFD);
                                ps01.setString(9, EXP);
                                ps01.setInt(10, Integer.parseInt(product_id));
                                System.out.println(ps01);

                                int x1 = ps01.executeUpdate();

                                if (x1 == 1) {

                                    try {
                                        String sql04 = "SELECT * FROM delivery WHERE product_idproduct=?";
                                        PreparedStatement ps04 = Controller.DB.con().prepareStatement(sql04);
                                        ps04.setInt(1, Integer.parseInt(product_id));
                                        System.out.println(ps04);
                                        ResultSet rs04 = ps04.executeQuery();
                                        if (rs04.next()) {
                                            System.out.println("update karanna delivery id ata");

                                            try {

                                                String sql02 = "UPDATE delivery SET pay_on_delivery=?, days=?, area=? WHERE product_idproduct=?";
                                                PreparedStatement ps02 = Controller.DB.con().prepareStatement(sql02);

                                                try {

                                                    if (delivery_pond.equals("Yes")) {
                                                        ps02.setString(1, delivery_pond);
                                                        ps02.setInt(2, Integer.parseInt(delivery_days));
                                                        ps02.setString(3, Collecter01.delivery_areas.substring(1));
                                                        ps02.setInt(4, Integer.parseInt(product_id));

                                                    } else {

                                                        ps02.setString(1, "No");
                                                        ps02.setInt(2, 0);
                                                        ps02.setString(3, "No");
                                                        ps02.setInt(4, Integer.parseInt(product_id));

                                                    }

                                                    System.out.println(ps02);
                                                    ps02.executeUpdate();
                                                } catch (Exception e) {
                                                } finally {

                                                    try {

                                                        for (String imn : images0.split(">")) {

                                                            if (imn.trim().equals("")) {
                                                            } else {

                                                                String sql5 = "DELETE FROM image WHERE path LIKE ?;";
                                                                PreparedStatement ps5 = Controller.DB.con().prepareStatement(sql5);
                                                                ps5.setString(1, "%" + imn + "%");
                                                                System.out.println(ps5);
                                                                ps5.executeUpdate();
                                                            }

                                                        }

                                                        for (String img_path : Collecter01.product_images) {
                                                            String sql4 = "INSERT INTO image VALUES (?,?)";
                                                            PreparedStatement ps4 = Controller.DB.con().prepareStatement(sql4);
                                                            ps4.setInt(1, Integer.parseInt(product_id));
                                                            ps4.setString(2, img_path);
                                                            System.out.println(ps4);
                                                            ps4.executeUpdate();
                                                        }

                                                    } catch (Exception e) {

                                                    } finally {

                                                        try {

                                                            String sql5 = "SELECT idSpecifications FROM specifications WHERE name=?";
                                                            PreparedStatement ps5 = Controller.DB.con().prepareStatement(sql5);
                                                            for (Map.Entry<String, List> entry : Collecter01.specifications.entrySet()) {
                                                                System.out.println(entry.getKey() + "---" + entry.getValue().get(0) + "---" + entry.getValue().get(1));

                                                                ps5.setString(1, entry.getKey());
                                                                System.out.println(ps5);

                                                                ResultSet rs5 = ps5.executeQuery();
//                                                                int idSpecifications = 0;

                                                                try {
                                                                    if (rs5.first()) {
                                                                        System.out.println("Specifications name/id ata____1");
//                                                                        idSpecifications = rs5.getInt(1);
                                                                    } else {

                                                                        try {
                                                                            System.out.println("Specifications name/id na____2");
                                                                            String sql6 = "INSERT INTO specifications VALUES (null,?)";
                                                                            PreparedStatement ps6 = Controller.DB.con().prepareStatement(sql6);
                                                                            ps6.setString(1, entry.getKey());
                                                                            System.out.println(ps6);
                                                                            ps6.executeUpdate();
                                                                            System.out.println("Specifications new add karanawa____2-1");
                                                                            try {
                                                                                String sql7 = "SELECT idSpecifications FROM specifications WHERE name=?";
                                                                                PreparedStatement ps7 = Controller.DB.con().prepareStatement(sql7);
                                                                                ps7.setString(1, entry.getKey());
                                                                                System.out.println(ps7);
                                                                                ResultSet rs7 = ps7.executeQuery();

                                                                                if (rs7.first()) {
                                                                                    System.out.println("new Specifications name/id ata____3-1");
//                                                                                    idSpecifications = rs7.getInt(1);
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

                                                                        String sql8 = "DELETE FROM product_has_specifications WHERE product_idproduct=?;";
                                                                        PreparedStatement ps8 = Controller.DB.con().prepareStatement(sql8);
                                                                        ps8.setInt(1, Integer.parseInt(product_id));
                                                                        System.out.println(ps8);
                                                                        ps8.executeUpdate();

                                                                    } catch (Exception e) {

                                                                    }

                                                                }

                                                            }

                                                            try {

                                                                for (Map.Entry<String, List> entry : Collecter01.specifications.entrySet()) {

//                                                                    System.out.println(product_id);
//                                                                    System.out.println(entry.getKey());
//                                                                    System.out.println(entry.getValue().get(0));
//                                                                    System.out.println(entry.getValue().get(1));
                                                                    int idSpecifications = 0;

                                                                    try {

                                                                        String sql9 = "SELECT idSpecifications FROM specifications WHERE name=?";
                                                                        PreparedStatement ps9 = Controller.DB.con().prepareStatement(sql9);
                                                                        ps9.setString(1, entry.getKey());
//                                                                        System.out.println(ps7);
                                                                        ResultSet rs9 = ps9.executeQuery();

                                                                        if (rs9.first()) {
//                                                                            System.out.println("new Specifications name/id ata____3-1");
                                                                            idSpecifications = rs9.getInt(1);
                                                                        } else {

                                                                        }

                                                                    } catch (Exception e) {
                                                                    }

//                                                                    System.out.println(product_id);
//                                                                    System.out.println(idSpecifications);
//                                                                    System.out.println(entry.getValue().get(0));
//                                                                    System.out.println(entry.getValue().get(1));
                                                                    try {
                                                                        String sql10 = "INSERT INTO product_has_specifications VALUES (?,?,?,?)";
                                                                        PreparedStatement ps10 = Controller.DB.con().prepareStatement(sql10);
                                                                        ps10.setInt(1, Integer.parseInt(product_id));
                                                                        ps10.setInt(2, idSpecifications);
                                                                        ps10.setString(3, (String) entry.getValue().get(0));
                                                                        ps10.setString(4, (String) entry.getValue().get(1));
                                                                        System.out.println(ps10);
                                                                        ps10.executeUpdate();
                                                                        System.out.println("spec value save kara");
                                                                    } catch (Exception e) {
                                                                        System.out.println("spec value save fail");
                                                                    }
                                                                }

                                                            } catch (Exception e) {
                                                            }

                                                        } catch (Exception e) {

                                                        } finally {
                                                            String xv = rurl + "msg=Product update successful&cl=00bf6f";
                                                            response.sendRedirect(xv);
                                                        }

                                                    }

                                                }

                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }

                                        } else {
                                            System.out.println("update karanna delivery id eka na");
                                        }
                                    } catch (Exception e) {
                                    }

                                } else {
                                    System.out.println("stock update fail");
                                }
                            } catch (Exception e) {

                            }
                        } else {
                            System.out.println("product update fail");
                        }

                    } catch (Exception e) {
                    }
                } else {

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
