<%-- 
    Document   : categories
    Created on : Sep 18, 2016, 12:53:14 PM
    Author     : Kasun Kalhara
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="categories.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../../lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="../../lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="../../lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(
                    function () {
                        $("table tbody tr ").click(function () {
                            $(this).addClass('selected').siblings().removeClass("selected");

                        });
                    }
            );
        </script>
        <style>
            #t01i tbody tr.selected {background-color: #F5F5F5;}
            #t02i tbody tr.selected {background-color: #F5F5F5;}
            #t03i tbody tr.selected {background-color: #F5F5F5;}
            #t04i tbody tr.selected {background-color: #F5F5F5;}

            body{
                width: 1161px;
                /*border: 1px solid black;*/
            }
            #tab00i{
                width: 1125px;
                max-width: 1125px;
                /*border: 1px solid black;*/
            }
        </style>
    </head>
    <body onload="" >
    <center>
        <tt>
            <table id="tab00i">
                <tr>
                    <td valign="top">
                        <table class="table table-hover table-condensed" id="t01i">
                            <caption>BRAND</caption>
                            <thead>
                                <tr>
                                    <th>ID</th><th >NAME</th><th colspan="2"></th>
                                </tr>
                            </thead>
                            <tbody id="tab01i" >
                                <%
                                    try {
                                        String sql1 = "SELECT * FROM brand";
                                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                        ResultSet rs1 = ps1.executeQuery();

                                        while (rs1.next()) {
                                %><tr>
                                    <td><%=rs1.getInt(1)%></td>
                                    <td><%=rs1.getString(2)%></td>
                                    <td><input type="button" class="btn btn-primary btn-xs" value="Update" onclick="updateBrand('up', '1', 'brand_name', '0', 'idbrand',<%=rs1.getInt(1)%>)"></td>
                                    <td><input type="button" class="btn btn-danger btn-xs" value="Delete" onclick="deleteBrand('de', '1', '*', '0', 'idbrand',<%=rs1.getInt(1)%>)"></td>
                                </tr>
                                <%
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                %>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td>Brand :</td>
                                    <td><input type="text" id="txf01i"></td>
                                    <td colspan="2"><input type="button" class="btn btn-success btn-sm" value="&nbsp;Save&nbsp;" onclick="savehBrand('sa', '1', 'brand_name', document.getElementById('txf01i').value, '0', '0')"></td>
                                </tr>
                            </tfoot>
                        </table>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td valign="top">
                        <table class="table table-hover table-condensed" id="t02i">
                            <caption>CATEGORY 1</caption>
                            <thead>
                                <tr>
                                    <th>ID</th><th colspan="3">NAME</th>
                                </tr>
                            </thead>
                            <tbody id="tab02i">
                                <!--<input type="hidden" id="hid01i">-->
                                <%
                                    try {
                                        String sql1 = "SELECT * FROM product_category1";
                                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                        ResultSet rs1 = ps1.executeQuery();
                                        while (rs1.next()) {
                                %><tr>
                                    <!--qu, pt, co, vl, wr, cl-->
                                    <td onclick="searchCategory2('se', '1', '*', '0', 'product_category1_idproduct_category1',<%=rs1.getInt(1)%>)"><%=rs1.getInt(1)%></td>
                                    <td onclick="searchCategory2('se', '1', '*', '0', 'product_category1_idproduct_category1',<%=rs1.getInt(1)%>)"><%=rs1.getString(2)%></td>
                                    <td><input type="button" class="btn btn-primary btn-xs" value="Update" onclick="updateCategory1('up', '1', 'name', '0', 'idproduct_category1',<%=rs1.getInt(1)%>)"></td>
                                    <td><input type="button" class="btn btn-danger btn-xs" value="Delete" onclick="deleteCategory1('de', '1', '*', '0', 'idproduct_category1',<%=rs1.getInt(1)%>)"></td>
                                </tr>
                                <%
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                %>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td>Cat 1 :</td>
                                    <td><input type="text" id="txf02i" ></td>
                                    <td colspan="2"> <input type="button" class="btn btn-success btn-sm" value="&nbsp;Save&nbsp;" onclick="saveCategory1('sa', '1', 'name', document.getElementById('txf02i').value, '0', '0')"></td>
                                </tr>
                            </tfoot>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td valign="top">
                        <table border="0px" class="table table-hover table-condensed col-md-3" id="t03i">
                            <caption>CATEGORY 2</caption>
                            <thead>
                                <tr>
                                    <th>ID</th><th colspan="3">NAME</th>
                                </tr>
                            </thead>
                            <tbody id="tab03i">

                            </tbody>
                            <tfoot>
                                <tr>
                                    <td>Cat 2 :</td>
                                    <td><input type="text" id="txf03i" disabled=""></td>
                                    <td colspan="2"><input type="hidden" id="hid01i" > <input id="add03i" type="button" class="btn btn-success btn-sm" value="&nbsp;Save&nbsp;" onclick="saveCategory2('sa', '1', 'product_category1_idproduct_category1,name', document.getElementById('hid01i').value + ',' + document.getElementById('txf03i').value, '0', '0')" disabled=""></td>
                                </tr>
                            </tfoot>
                        </table>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td valign="top">
                        <table border="0px"class="table table-hover table-condensed col-md-3" id="t04i">
                            <caption>CATEGORY 3</caption>
                            <thead>
                                <tr>
                                    <th>ID</th><th colspan="3">NAME</th>
                                </tr>
                            </thead>
                            <tbody id="tab04i">

                            </tbody>
                            <tfoot>
                                <tr>
                                    <td>Cat 3 :</td>
                                    <td><input type="text" id="txf04i" disabled=""></td>
                                    <td colspan="2"> <input type="hidden" id="hid02i"><input id="add04i"type="button" class="btn btn-success btn-sm" value="&nbsp;Save&nbsp;" onclick="saveCategory3('sa', '1', 'product_category2_idproduct_category2,name', document.getElementById('hid02i').value + ',' + document.getElementById('txf04i').value, '0', '0')" disabled=""></td>
                                </tr>
                            </tfoot>
                        </table>
                    </td>
                </tr>
            </table>
        </tt>
    </center>
</body>
</html>
