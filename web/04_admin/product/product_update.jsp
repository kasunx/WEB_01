<%-- 
    Document   : product_update
    Created on : Oct 6, 2016, 8:47:19 AM
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


        <!--<script src="delivery.js"></script>-->   
        <link rel="stylesheet" type="text/css" href="product_save.css">


        <!--IMAGE UPLOAD-->
        <script src="upload_image.js"></script>
        <script src="../../lib/upload/jquery.js" ></script>
        <script src="../../lib/upload/jquery.form.js" ></script>
        <script src="../../lib/upload/progressBarScript.js" ></script>
        <!--IMAGE UPLOAD-->

        <script src="product_update.js"></script>

        <script>
            window.onload = function () {
                document.getElementById('hid02i').value = "";
                myFunction("<%= request.getParameter("msg")%>", "<%= request.getParameter("cl")%>");
            };

            function myFunction(msg, color) {
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

        <%
            String id = request.getParameter("upd01n");

//            id = "37";
            if (id == null || id.trim().equals("")) {

//                out.write(id);
                response.sendRedirect("product_home.jsp");
            }
        %>

        <form method="POST" action="../../ProductUpdateS" class="form-horizontal" enctype="multipart/form-data" id="for01i">
            <input type="hidden" value="<%=id%>" name="hid01n">
            <center>
                <tt>
                    <h2>UPDATE PRODUCT</h2>
                    <table id="tab01i" border="0px" >
                        <tr>
                            <td align="right"></td>
                            <td style="width: 269px"></td> 
                            <td align="right" style="width: 117px"></td>
                            <td style="width: 269px"></td> 
                            <td align="right"></td>
                            <td style="width: 269px"></td> 
                        </tr>
                        <%
                            String sql01 = "SELECT * FROM product WHERE idproduct=?";
                            PreparedStatement ps01 = Controller.DB.con().prepareStatement(sql01);
                            ps01.setInt(1, Integer.parseInt(id));
                            ResultSet rs01 = ps01.executeQuery();
                            if (rs01.next()) {
                        %>
                        <tr>
                            <td align="right" style="width: 127px">Product ID :</td>
                            <td colspan="5"><%=rs01.getInt(1)%> <input type="hidden" id="hid01i" value="<%=rs01.getInt(1)%>"></td>
                        </tr>
                        <tr>
                            <td align="right">Product Name :</td>
                            <td colspan="5" ><input name="txf01n" type="text"  required class="w0" value="<%=rs01.getString(2)%>"></td>
                        </tr>
                        <tr>
                            <td align="right">Description :</td>
                            <td colspan="7" ><textarea name="txa01n" id="txa01i" required class="w0" rows="4"><%=rs01.getString(3)%></textarea></td>
                        </tr>
                        <%
                            }
                        %>
                        <tr>
                            <td align="right">Specifications :</td>
                            <td colspan="5">
                                <table border="0px" id="tab02i" >
                                    <thead>
                                    <th>Specification</th><th></th><th>Value</th><th>Unit</th><th>Remove</th>
                                    </thead>
                                    <tbody id="tab02ibody" style="text-align: center;">
                                        <%
                                            try {
                                                String sql02 = " SELECT * FROM product_has_specifications WHERE product_idproduct=?";
                                                PreparedStatement ps02 = Controller.DB.con().prepareStatement(sql02);

                                                ps02.setInt(1, Integer.parseInt(id));

                                                ResultSet rs02 = ps02.executeQuery();

                                                while (rs02.next()) {
                                        %>
                                        <tr>
                                            <td align="right">
                                                <%
                                                    try {
                                                        String sql = "SELECT * FROM specifications WHERE idspecifications=?";
                                                        PreparedStatement ps = Controller.DB.con().prepareStatement(sql);
                                                        ps.setInt(1, rs02.getInt(2));

                                                        ResultSet rs = ps.executeQuery();

                                                        if (rs.next()) {
                                                %>

                                                <input type="text" style="border:0px;" readonly="true" value=" <%=rs.getString(2)%>" name="spe01n">
                                                <%
                                                        }

                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }

                                                %>

                                            </td>
                                            <td>&nbsp;:&nbsp;</td>
                                            <td style="border:0px;">
                                                <input type="text" style="border:0px;" readonly="true" value="<%=rs02.getDouble(3)%>" name="spe02n">
                                            </td>
                                            <td style="border:0px;">
                                                <input type="text" style="border:0px;" readonly="true" value="<%=rs02.getString(4)%>" name="spe03n">
                                            </td>
                                            <td style="border:0px;">
                                                <label name="spe2n" id="spe2n"  style="margin-bottom: 5px" onclick="removeSpecifications2(this)"
                                                       <i class="fa fa-times" aria-hidden="true"></i>
                                                </label>
                                            </td>
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
                                            <td>
                                                <input type="text" placeholder="Name" id="t02i" style="width: 267px" list="browser01" onchange="loadUnits1(this.value)">
                                                <datalist id="browser01">
                                                    <%                                                        try {
                                                            String sql1 = "SELECT * FROM specifications";
                                                            PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                                            ResultSet rs1 = ps1.executeQuery();
                                                            while (rs1.next()) {
                                                    %>
                                                    <option value="<%=rs1.getString(2)%>"></option>
                                                    <%      }
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
                                                <input type="button" value="Add New" onclick="addSpecifications1(document.getElementById('t02i').value, document.getElementById('t03i').value, document.getElementById('t04i').value)" class=" btn btn-info btn-sm" style="margin-left: 5px;">                                  
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </td>
                        </tr>


                        <%
                            String sql04 = "SELECT * FROM stock WHERE product_idproduct=?";
                            PreparedStatement ps04 = Controller.DB.con().prepareStatement(sql04);
                            ps04.setInt(1, Integer.parseInt(id));
                            ResultSet rs04 = ps04.executeQuery();

                            if (rs04.next()) {
                        %>
                        <tr>
                            <td align="right">Purchase Date :</td>
                            <td ><input name="dat01n" type="date" required class="w1" value="<%=rs04.getString(2)%>"></td>              
                            <td align="right">MFD :</td>
                            <td ><input name="dat02n" type="date" required class="w1" value="<%=rs04.getString(9)%>"></td>
                            <td align="right">EXP :</td>
                            <td ><input name="dat03n" type="date" required class="w1" value="<%=rs04.getString(10)%>"></td>
                        </tr>
                        <tr>
                            <td align="right">Purchase Price :</td>
                            <td ><input name="num01n" type="number" min="0" required  onkeypress="characterValid(event)" class="w1" value="<%=rs04.getInt(3)%>"></td>
                            <td align="right">Selling Price :</td>
                            <td ><input name="num04n" type="number" min="0" required onkeypress="characterValid(event)" class="w1" value="<%=rs04.getInt(5)%>"></td>
                            <td align="right">Discount :</td>
                            <td ><input name="num03n" type="number" min="0" max="60" required onkeypress="characterValid(event)" class="w2" value="<%=rs04.getInt(4)%>"> %</td>

                        </tr>
                        <tr>
                            <td align="right">Warranty :</td>
                            <td colspan="5">
                                <input name="num05n" type="number" min="0" required onkeypress="characterValid(event)" class="w4" value="<%=rs04.getString(6).split(",")[0]%>"> Years
                                <input name="num06n" type="number"  min="0" required onkeypress="characterValid(event)" class="w4" value="<%=rs04.getString(6).split(",")[1]%>"> Months
                                <input name="num07n" type="number"  min="0" required onkeypress="characterValid(event)" class="w4" value="<%=rs04.getString(6).split(",")[2]%>"> Dates
                            </td>
                        </tr>
                        <tr>
                            <td align="right">QTY :</td>
                            <td><input name="num08n" type="number" min="0" required onkeypress="characterValid(event)" class="w1" value="<%=rs04.getInt(7)%>"></td>
                        </tr>
                        <tr>
                            <td align="right">Pickup :</td>
                            <td>
                                <select name="sel05n" required class="w1">    
                                    <%
                                        if (rs04.getString(8).equals("available")) {
                                    %>
                                    <option>not available</option>
                                    <option selected>available</option>
                                    <%                                    } else {
                                    %>
                                    <option selected>not available</option>
                                    <option >available</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>

                        <%}%>          
                        <tr>
                            <td align="right" rowspan="2">Delivery :</td>
                            <td colspan="5" >
                                <label class="w6" style="margin-top:10px;">Pay on delivery</label>
                                <label class="w6" >&nbsp;&nbsp;Days</label>
                                <label class="w6" >&nbsp;&nbsp;&nbsp;Area</label>
                            </td>
                        </tr>
                        <%

                            String sql05 = "SELECT * FROM delivery WHERE product_idproduct=?";
                            PreparedStatement ps05 = Controller.DB.con().prepareStatement(sql05);
                            ps05.setInt(1, Integer.parseInt(id));
                            ResultSet rs05 = ps05.executeQuery();

                            if (rs05.next()) {

                        %>

                        <tr>
                            <td colspan="3" style="vertical-align: top;">
                                <select name="sel06n" required onchange="deliveryX(this.value)" class="w5">
                                    <%                                        if (rs05.getString(2).equals("Yes")) {
                                    %>
                                    <option>No</option>
                                    <option selected="">Yes</option>
                                    <%
                                    } else {
                                    %>
                                    <option selected></option>
                                    <option >No</option>
                                    <option >Yes</option>
                                    <%
                                        }

                                    %>

                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input  name="num09n" id="num09i" type="number"  min="0" required onkeypress="characterValid(event)" class="w5" value="<%=(rs05.getInt(3) == 0) ? "" : rs05.getInt(3)%>">                            
                            </td>
                            <td colspan="2">
                                <select name="sel07n" id="sel07i" multiple required  class="w1" >
                                    <%

                                       
                                        String a ="All Island, Addalaichenai, Agarapathana, Ahungalla, Akkaraipattu, Akmeemana, Akurana, Akuressa, Alaveddy, Alawathugoda, Alawwa, Alubomulla, Aluthgama, Ambalangoda, Ambalantota, Ampara, Anaikotai, Anamaduwa, Angulukolapelassa, Anuradhpura, Arachchikattuwa, Aralaganwila, Aranayaka, Athurugiriya, Attidiya, Badulla, Balangoda, Bandaragama, Batapola, Battaramulla, Batticaloa, Batuwatta, Bellanwila, Belummahara, Bentota, Beragala, Beruwala, Bibile, Bingiriya, Biyagama, Boossa, Borelasgamuwa, Bulathsinhala, Buttala, Chankanai, Chavakachceri, Chavakachceri, Chilaw, Chinabay, Chundikuli, Chunnakam,, Colombo-01, Colombo-02, Colombo-03, Colombo-04, Colombo-05, Colombo-06, Colombo-07, Colombo-08, Colombo-09, Colombo-10, Colombo-11, Colombo-12, Colombo-13, Colombo-14, Colombo-15, Dambulla, Dankotuwa, Dehiattakandiya, Dehiwela, Delgoda, Deltota, Deniyaya, Dharga Town, Dikoya, Dimbulahalla, Divulapitiya, Diyathalawa, Dummalasuriya, Eheliyagoda, Elpitiya, Embilipitiya, Eravur, Ethul Kotte, Galagedera, Galaha, Galenbindunuwewa, Galewela, Galgamuwa, Galkulama, Galle, Gampaha, Gampola, Ganemulla, Ginigathena, Girandurukotte, Giritale, Giriulla, Godigamuwa, Gokarella, Gomarankadawala, Hali-ella, Hambantota, Hanwella, Hapugala, Haputale, Hemmatagama, Hettipola, Hikkaduwa, Hingurakgoda, Hiniduma, Hokandara, Homagama, Horawpatana, Ingiriya, Ja-Ela, Jaffna, Jayanthipura, Kadawatha, Kadugannawa, Kaduruwela, Kaduwela, Kahawatte, Kaithady, Kalmunai, Kalpitiya, Kalubowila, Kalutara City, Kamburupitiya, Kandy, Kankesanthurai (KKS), Kantalai, Karainagar, Katana, Kataragama, Kattankudy, Katubedda, Katugastota, Katunayake, Katuwana, Kegalle, Kekirawa, Kelaniya, Keppetipola, Kinniya, Kiribathgoda, Kirindiwela, Kobeigama, Kochchikade, Kodikamam, Koggala, Kohuwala, Kokuvil, Kolonnawa, Kondavil, Konwewa, Koppai, Koswatta, Kottawa, Kotte, Kuliyapitiya, Kurunegala, Kuruwita, Lindula, Lunuwila, Madampe, Madapaatha, Madawella, Madulkella, Madurankuliya, Maharagama, Mahawewa, Mahiyangana, Makola, Malabe, Mampitiya, Manipay, Mannar, Maruthanamadam, Maskeliya, Matale, Matara, Mattegoda, Matugama, Mawanella, Mawathagama, Medirigiriya, Mihintale, Minneriya, Mirigama, Mirihana, Monaragala, Moolai, Moragaswewa, Morakanda, Moratuwa, Morawaka, Mt-lavania, Mutur, Nagoda, Nallur, Nattandiya, Nawala, Nawalapitiya, Neervely, Negombo, Nikaweratiya, Nilavelli, Nintavur, Nittambuwa, Nivitigala, Nochchiyagama, Norochcholai, Norton Bridge, Nugegoda, Nuwara Eliya, Oddamavadi, Opanayaka, Orugodawatta, Padaviya, Padukka, Palaviya, Panadura, Pandatharippu, Pannala, Pannipitiya, Paranagama, Passara, Pasyala, Pelawatta, Peliyagoda, Pelmadulla, Pelmadullawatta, Pepiliyana, Piliyandala, Pita Kotte, Point Pedro, Polgahawela, Polonnaruwa, Pugoda, Pulmoddai, Pusselawa, Puttalam, Ragama, Rajagiriya, Rajanganaya, Ramboda, Rambukkana, Ratmalana, Ratnapura, Rattota, Ridigama, Samanthurai, Sandalankawa, Seeduwa, Sigiriya, Siyambalanduwa, Talaimannar, Talawakelle, Tambuttegama, Tangalle, Teldeniya, Thalawathugoda East, Thalawathugoda West, Thelipalai, Tissamaharama, Trincomalee, Udapussallawa, Valvettithurai, Vavuniya, Veyangoda, Wadduwa, Walasmulla, Warakapola, Wariyapola, Wattala, Wattegama, Weeraketiya, Weligama, Welikanda, Welimada, Wellawaya, Wennappuwa, Yapahuwa, Yatiyantota, kantharmadam";
                                        String x = rs05.getString(4);

                                        String b[] = x.split(">");

                                        int i = 0;

                                        for (String arg : a.split(",")) {
                                            for (String arg1 : b) {
                                                if (arg.trim().equals(arg1.trim())) {
                                                    i++;
                                    %> 
                                    <option selected ><%=arg.trim()%></option>
                                    <%
                                        i = 0;
                                        break;
                                    } else {
                                        i++;
                                        if (i == b.length) {
                                    %> 
                                    <option ><%=arg.trim()%></option>
                                    <%
                                                        i = 0;
                                                    }

                                                }
                                            }
                                        }

                                    %>
                                </select>
                            </td>
                        </tr>


                        <%} else {%>

                        <tr>
                            <td colspan="3" style="vertical-align: top;">
                                <select name="sel06n" required onchange="deliveryX(this.value)" class="w5">
                                    <option selected="">No</option>
                                    <option>Yes</option>
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input  name="num09n" id="num09i" type="number"  disabled="true" min="0" required onkeypress="characterValid(event)" class="w5">                            
                            </td>
                            <td colspan="2">
                                <select name="sel07n" id="sel07i" multiple required  class="w1" >

                                </select>
                            </td>
                        </tr>

                        <% }%>

                        <tr>
                            <td align="right" rowspan="1">Images :</td>
                            <td colspan="5">
                                <input type="hidden" id="hid02i" name="hid02n">
                                <div id="myimg" >
                                    <%
                                        String sql06 = "SELECT * FROM image WHERE product_idproduct=?";
                                        PreparedStatement ps06 = Controller.DB.con().prepareStatement(sql06);
                                        ps06.setInt(1, Integer.parseInt(id));
                                        ResultSet rs06 = ps06.executeQuery();

                                        while (rs06.next()) {


                                    %>
                                    <!--<input type="hidden" value="<%=rs06.getString(2).substring(18)%>" name="hid02n" multiple>-->
                                    <img class="myimgs" src="<%="../../" + rs06.getString(2)%>" id="<%=rs06.getString(2).substring(20, rs06.getString(2).length() - 4)%>" width="130" onclick="removeImage(this)">
                                    <%
                                        }
                                    %>
                                </div>
                                <div id="upFile" class="btn btn-info btn-sm">
                                    <span>Select</span>
                                    <input type="file" onchange="readURL(this)" class="upload" name="fil01n" id="selectFile" multiple accept="image/*"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td colspan="5">
                                <button type="submit" class="btn btn-success"><i class="fa fa-refresh" aria-hidden="true"></i> UPDATE </button>
                                <button type="submit" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> DELETE </button>
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
