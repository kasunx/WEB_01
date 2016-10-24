<%-- 
    Document   : product_home
    Created on : Oct 3, 2016, 11:27:29 AM
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

        <!--BOOTSTRAP-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../../lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="../../lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="../../lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <!--BOOTSTRAP-->

        <link rel="stylesheet" type="text/css" href="product_home.css">

        <script type="text/javascript" src="product_home.js"></script>

        <script>

            window.onload = function () {
                //                document.getElementById('myimg').innerHTML = "";
                        myFunction("<%= request.getParameter("msg")%>", "<%= request.getParameter("cl")%>");
            };

            function myFunction(msg, color) {
//                                alert(msg);
//                                alert(color);
                if (msg == 'null') {
//                    document.getElementById("for01i").reset();

                } else {
//                    document.getElementById("for01i").reset();
                    var x = document.getElementById("snackbar");
                    x.className = "show";
                    x.innerHTML = msg;
                    x.setAttribute('style', 'background-color:#' + color + ';  font-family: "Oswald";');
                    setTimeout(function () {
                        x.className = x.className.replace("show", "");
                    }, 3000);
                }
            }
        </script>
    </head>
    <body>
        <!--<img src="img/1475658606235.jpg">-->
    <tt>
        <center>
            <div id="A01">
                <label>Product Name :</label><input id="sea01i" type="search" onkeyup="searchProductName(this.value)" list="data01i">
                <datalist id="data01i">
                    <option value="aa">
                    <option value="ab">
                </datalist>
            </div>
            <div id="A02"  style="overflow-x:auto;">
                <table id="tab01i" class="table table-condensed table-hover table-bordered" >
                    <thead>
                        <tr>
                            <th></th>
                            <th>ID</th>
                            <th>Name</th>
                            <th style="width:100px">Description</th>
                            <th>Specifications</th>
                            <th>Images</th>
                            <th>Purchase date</th>
                            <th>Purchase price</th>
                            <th>Discount</th>
                            <th>Selling price</th>
                            <th>Warranty</th>
                            <th>QTY</th>
                            <th>Pickup</th>
                            <th>MFD</th>
                            <th>EXP</th>
                            <th>Pay on delivery</th>
                            <th>delivery days</th>
                            <th>Area</th>                           

                        </tr>
                    </thead>
                    <tbody>
                        <%
                            try {
                                String sql01 = "SELECT * FROM product";
                                PreparedStatement ps01 = Controller.DB.con().prepareStatement(sql01);
                                ResultSet rs01 = ps01.executeQuery();

                                while (rs01.next()) {
                        %>

                        <tr>
                            <td>
                                <!--<div class="btn-group-vertical">-->
                                <input type="button"class="btn btn-default btn-sm" value="&nbsp;VIEW&nbsp;">
                                <br><br>
                                <form action="product_update.jsp" method="GET">
                                    <input type="hidden" name="upd01n" value="<%= rs01.getInt(1)%>">
                                    <button type="submit"class="btn btn-primary btn-sm">UPDATE</button>
                                </form>
                                <br>
                                <form action="../../ProductDeleteS" method="GET">
                                    <input type="hidden" name="del01n" value="<%= rs01.getInt(1)%>">
                                    <button type="submit"class="btn btn-danger btn-sm">DELETE</button>
                                </form>
                                <!--</div>-->
                            </td>
                            <td><%= rs01.getInt(1)%></td>
                            <td><%= rs01.getString(2)%></td>
                            <td>
                                <textarea cols="30"  readonly ><%= rs01.getString(3)%></textarea>
                            </td>
                            <td>
                                <table>
                                    <%
                                        try {
                                            String sql02 = " SELECT * FROM product_has_specifications WHERE product_idproduct=?";
                                            PreparedStatement ps02 = Controller.DB.con().prepareStatement(sql02);
                                            ps02.setInt(1, rs01.getInt(1));
                                            ResultSet rs02 = ps02.executeQuery();
                                            while (rs02.next()) {
                                    %>
                                    <tr>
                                        <td>
                                            <%
                                                try {
                                                    String sql = "SELECT * FROM specifications WHERE idspecifications=?";
                                                    PreparedStatement ps = Controller.DB.con().prepareStatement(sql);
                                                    ps.setInt(1, rs02.getInt(2));
                                                    ResultSet rs = ps.executeQuery();
                                                    if (rs.next()) {
                                            %>
                                            <%=rs.getString(2)%>
                                            <%
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            %>

                                        </td>
                                        <td>&nbsp;:&nbsp;</td>
                                        <td>
                                            <%=rs02.getDouble(3)%>
                                        </td>
                                        <td>
                                            <%=rs02.getString(4)%>
                                        </td>
                                    </tr>
                                    <%
                                            }
                                        } catch (Exception e) {

                                            e.printStackTrace();
                                        }
                                    %>



                                </table>
                            </td>
                            <%
                                try {

                                    String sql00 = "SELECT * FROM image WHERE product_idproduct=?";
                                    PreparedStatement ps00 = Controller.DB.con().prepareStatement(sql00);
                                    ps00.setInt(1, rs01.getInt(1));

                                    ResultSet rs00 = ps00.executeQuery();

                            %>
                            <td>
                                <%                                    while (rs00.next()) {


                                %>
                                <%= rs00.getString(2).substring(18)%>
                                <%                                    }
                                %>
                            </td>
                            <%
                                } catch (Exception e1) {
                                }
                            %>
                            <%
                                try {
                                    String sql02 = "SELECT * FROM stock WHERE product_idproduct=?";
                                    PreparedStatement ps02 = Controller.DB.con().prepareStatement(sql02);
                                    ps02.setInt(1, rs01.getInt(1));
                                    ResultSet rs02 = ps02.executeQuery();
                                    while (rs02.next()) {
                            %>
                            <td><%= rs02.getString(2)%></td>
                            <td><%= rs02.getString(3)%></td>
                            <td style="width:100px"><%= rs02.getString(4)%> %</td>
                            <td><%= rs02.getString(5)%></td>
                            <td><%= rs02.getString(6).split(",")[0]%>Y:<%= rs02.getString(6).split(",")[1]%>M:<%= rs02.getString(6).split(",")[2]%>D</td>
                            <td><%= rs02.getInt(7)%></td>
                            <td><%= rs02.getString(8)%></td>
                            <td><%= rs02.getString(9)%></td>
                            <td><%= rs02.getString(10)%></td>
                            <%
                                try {
                                    String sql03 = "SELECT * FROM delivery WHERE product_idproduct=?";
                                    PreparedStatement ps03 = Controller.DB.con().prepareStatement(sql03);
                                    ps03.setInt(1, rs01.getInt(1));

                                    ResultSet rs03 = ps03.executeQuery();

                                    if (rs03.next()) {
                                        rs03.beforeFirst();
                                        while (rs03.next()) {
                            %>         
                            <td><%= rs03.getString(2)%></td>
                            <td><%= rs03.getString(3)%></td>


                            <%
                                String da = "";

                                for (String v : rs03.getString(4).split(">")) {

                                    da += v + "\n";

                                }

                            %>
                            <td> <textarea readonly rows=7"><%=da%></textarea></td>
                                <%
                                %>


                            <% }
                            } else {
                            %>         
                            <td></td>
                            <td></td>
                            <td></td>
                            <%
                                    }
                                } catch (Exception e3) {
                                }
                            %>


                        </tr>

                        <%               }
                                    } catch (Exception e2) {

                                    }
                                }
                            } catch (Exception e1) {

                            }

                        %>
                    </tbody>
                </table>
            </div>
        </center>
        <div id="snackbar"></div>
        <br> <br> <br>
    </tt>
</body>
</html>
