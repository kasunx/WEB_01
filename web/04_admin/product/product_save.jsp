<%-- 
    Document   : Admin
    Created on : Jun 21, 2016, 5:28:03 PM
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

        <link rel="stylesheet" type="text/css" href="../../lib/font-awesome-4.6.3/css/font-awesome.min.css">

        <script src="product_save.js"></script>
        <link rel="stylesheet" type="text/css" href="product_save.css">
        <script src="delivery.js"></script>   

        <!--IMAGE UPLOAD-->
        <script src="upload_image.js"></script>
        <script src="../../lib/upload/jquery.js" ></script>
        <script src="../../lib/upload/jquery.form.js" ></script>
        <script src="../../lib/upload/progressBarScript.js" ></script>
        <!--IMAGE UPLOAD-->

        <script>

            window.onload = function () {
                //                document.getElementById('myimg').innerHTML = "";
                myFunction("<%= request.getParameter("msg")%>", "<%= request.getParameter("cl")%>");
            };

            function myFunction(msg, color) {
                //                alert(msg);
                //                alert(color);
                if (msg == 'null') {
                    document.getElementById("for01i").reset();

                } else {
                    document.getElementById("for01i").reset();
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
        <form method="POST" action="../../ProductSaveS" class="form-horizontal" enctype="multipart/form-data" id="for01i">
            <center>
                <%
//                request.getParameter("msg");
                %>
                <tt>
                    <h2>SAVE PRODUCT</h2>
                    <table id="tab01i" border="0px" >
                        <tr>
                            <td align="right" style="width: 127px">Brand :</td>
                            <td>
                                <select name="sel01n" id="sel01i" required class="w1"> <option></option>
                                    <%                                        try {
                                            String sql1 = "SELECT * FROM brand";
                                            PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                            ResultSet rs1 = ps1.executeQuery();
                                            while (rs1.next()) {%><option value="<%=rs1.getString(1)%>"><%=rs1.getString(2)%></option><%}
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                    %>
                                </select>
                            </td> 
                            <td colspan="4"></td>
                        </tr>
                        <tr>
                            <td align="right">Category 1 :</td>
                            <td style="width: 269px">
                                <select class="w1" name="sel02n" id='sel02i' onchange="searchCategory1('se', '2', '0', '0', '0', this.value)" required ><option></option><%try {
                                        String sql1 = "SELECT * FROM product_category1";
                                        PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                        ResultSet rs1 = ps1.executeQuery();
                                        while (rs1.next()) {%><option value="<%=rs1.getString(1)%>"><%=rs1.getString(2)%></option><%}
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }%>
                                </select>
                            </td> 
                            <td align="right" style="width: 117px">Category 2 :</td>
                            <td style="width: 269px"><select class="w1" name="sel03n" id="sel03i" onchange="searchCategory2('se', '2', '0', '0', '0', this.value)" required ></select></td> 
                            <td align="right">Category 3 :</td>
                            <td style="width: 269px"><select class="w1" name="sel04n" id="sel04i" onchange="selectCategory3('se', '2', '0', '0', '0', this.value)" required ></select></td> 
                        </tr>
                        <tr>
                            <td align="right">Product Name :</td>
                            <td colspan="5" ><input name="txf01n" type="text"  required class="w0"></td>
                        </tr>
                        <tr>
                            <td align="right">Description :</td>
                            <td colspan="7" ><textarea name="txa01n" id="txa01i" required class="w0" rows="4"></textarea></td>
                        </tr>
                        <tr>
                            <td align="right">Specifications :</td>
                            <td colspan="5">
                                <table border="0px" id="tab02i" >
                                    <thead>
                                    <th>Specification</th><th></th><th>Value</th><th>Unit</th><th>Remove</th>
                                    </thead>
                                    <tbody id="tab02ibody">

                                    </tbody>
                                    <tfoot>                            
                                        <tr>
                                            <td>
                                                <input type="text" placeholder="Name" id="t02i" style="width: 267px" list="browser01" onchange="loadUnits(this.value)">
                                                <datalist id="browser01">
                                                    <%
                                                        try {
                                                            String sql1 = "SELECT * FROM specifications";
                                                            PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                                            ResultSet rs1 = ps1.executeQuery();
                                                            while (rs1.next()) {
                                                    %><option value="<%=rs1.getString(2)%>"></option>
                                                    <%}
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                        }
                                                    %>
                                                </datalist>
                                            </td>
                                            <td>
                                                <label style="margin:5px">:</label>
                                            </td>
                                            <td>   
                                                <input type="text" placeholder="Value" id="t03i" style="width: 267px">
                                            </td>
                                            <td>
                                                &nbsp;<input type="text" placeholder="Unit" id="t04i" style="width: 80px"  list="browser02"><!-- onchange="loadUnits(document.getElementById('t02i')) -->
                                                <datalist id="browser02">

                                                </datalist>
                                            </td>
                                            <td colspan="1">                                       
                                                <input type="button" value="Add New" onclick="addSpecifications(document.getElementById('t02i').value, document.getElementById('t03i').value, document.getElementById('t04i').value)" class=" btn btn-info btn-sm" style="margin-left: 5px;">                                  
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">Purchase Date :</td>
                            <td ><input name="dat01n" type="date" required class="w1"></td>              
                            <td align="right">MFD :</td>
                            <td ><input name="dat02n" type="date" required class="w1"></td>
                            <td align="right">EXP :</td>
                            <td ><input name="dat03n" type="date" required class="w1"></td>
                        </tr>

                        <tr>
                            <td align="right">Purchase Price :</td>
                            <td ><input name="num01n" type="number" min="0" required  onkeypress="characterValid(event)" class="w1"></td>
                            <td align="right">Selling Price :</td>
                            <td ><input name="num04n" type="number" min="0" required onkeypress="characterValid(event)" class="w1"></td>
                            <td align="right">Discount :</td>
                            <td ><input name="num03n" type="number" min="0" max="60" required onkeypress="characterValid(event)" class="w2"> %</td>

                        </tr>
                        <!--                        <tr>
                                                    <td align="right">Selling Price :</td>
                                                    <td ><input name="num04n" type="number" min="0" required onkeypress="characterValid(event)" class="w1"></td>
                                                </tr>-->
                        <tr>
                            <td align="right">Warranty :</td>
                            <td colspan="5">
                                <input name="num05n" type="number" min="0" required onkeypress="characterValid(event)" class="w4"> Years
                                <input name="num06n" type="number"  min="0" required onkeypress="characterValid(event)" class="w4"> Months
                                <input name="num07n" type="number"  min="0" required onkeypress="characterValid(event)" class="w4"> Dates
                            </td>
                        </tr>
                        <tr>
                            <td align="right">QTY :</td>
                            <td><input name="num08n" type="number" min="0" required onkeypress="characterValid(event)" class="w1"></td>
                        </tr>
                        <tr>
                            <td align="right">Pickup :</td>
                            <td>
                                <select name="sel05n" required class="w1">    
                                    <option></option>
                                    <option>not available</option>
                                    <option>available</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" rowspan="2">Delivery :</td>
                            <td colspan="5" >
                                <label class="w6" style="margin-top:10px;">Pay on delivery</label>
                                <label class="w6" >&nbsp;&nbsp;Days</label>
                                <label class="w6" >&nbsp;&nbsp;&nbsp;Area</label>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3" style="vertical-align: top;">
                                <select name="sel06n" required onchange="deliveryC(this.value)" class="w5">
                                    <option></option>
                                    <option>No</option>
                                    <option>Yes</option>
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input  name="num09n" id="num09i" type="number"  disabled="true" min="0" required onkeypress="characterValid(event)" class="w5">                            
                            </td>
                            <td colspan="2">
                                <select name="sel07n" id="sel07i" multiple required  class="w1" disabled="true">
                                    <option></option>                 
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" rowspan="1">Images :</td>
                            <td colspan="5">
                                <div id="myimg" ></div>
                                <div id="upFile" class="btn btn-info btn-sm">
                                    <span>Select</span>
                                    <input type="file" onchange="readURL(this)" class="upload" name="fil01n" id="selectFile" multiple required accept="image/*"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td></td>

                            <td colspan="5">
                                <button type="reset" class="btn btn-primary"  onclick="clearAll()"><i class="fa fa-times" aria-hidden="true"></i> CLEAR</button>
                                <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> SAVE </button>
                            </td>
                        </tr>
                    </table>
                    <div id="snackbar"></div>
                    <br> <br> <br>
                </tt>
            </center>
        </form>
    </body> 
</html>
