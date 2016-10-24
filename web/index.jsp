<%-- 
    Document   : index
    Created on : Sep 2, 2016, 6:29:49 PM
    Author     : Kasun Kalhara
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>

        <!--BOOTSTRAP-->
        <link rel="stylesheet" type="text/css" href="lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <!--BOOTSTRAP-->

        <!--DEFAULT javascript-->
        <script></script>
        <!--DEFAULT javascript-->

        <!--DEFAULT css-->
        <link rel="stylesheet" type="text/css" href="css/default.css">
        <!--DEFAULT css-->
        <!--HEADER-->
        <link rel="stylesheet" type="text/css" href="01_home/header/header.css">
        <!--HEADER-->


        <!--GLYPHICON-->
        <link rel="stylesheet" type="text/css" href="lib/font-awesome-4.6.3/css/font-awesome.min.css">
        <!--GLYPHICON-->

        <!--MEGA MENU-->
        <link rel="stylesheet" type="text/css" href="01_home/mega_menu/mega_menu.css">
        <script src="01_home/mega_menu/mega_menu.js"></script>
        <!--MEGA MENU-->

        <!--SEARCH CATOGAR-->
        <script src="02_search/search_all_catogary.js"></script>
        <!--SEARCH CATOGAR-->

        <!--BREADCRUMB-->
        <link rel="stylesheet" type="text/css" href="breadcrumb/breadcrumb.css">
        <!--BREADCRUMB-->

        <!--SEARCH-FILTER-->
        <link rel="stylesheet" type="text/css" href="02_search/search_filter.css">
        <script src="02_search/search_filter.js"></script>
        <!--SEARCH-FILTER-->

        <!--SEARCH_CATEGORY-->
        <script src="02_search/advanced_search.js"></script>
        <!--SEARCH_CATEGORY-->

        <!--SEARCH_BAR-->
        <script src="02_search/search_bar.js"></script>
        <!--SEARCH_BAR-->
        <script>
            window.onload = function () {

//                $.get("http://ipinfo.io", function (response) {
//                    alert(response.ip);
//                }, "jsonp");


//                $.getJSON("http://smart-ip.net/geoip-json?callback=?", function (data) {
//                    alert(data.host);
//                });
            }
        </script>

        <!--ADAVANCE SEARCH-->
        <script src="02_search/advanced_search.js"></script>
        <!--ADAVANCE SEARCH-->




        <!--SLIDER IMPORTS-->   
        <!--<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">-->
        <!--<link rel="stylesheet" href="/resources/demos/style.css">-->
        <!--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>-->
        <!--<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>-->
        <link rel="stylesheet" href="lib/slider/jquery-ui.css">
        <script src="lib/slider/jquery-1.12.4.js"></script>
        <script src="lib/slider/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#slider-range").slider({
                    range: true,
                    step: 500,
                    min: 0,
                    max: 100000,
                    values: [1000, 80000],
                    slide: function (event, ui) {
                        $("#amount").val("Rs." + ui.values[ 0 ] + "  -  Rs." + ui.values[ 1 ]);

                    }
                });
                $("#amount").val("Rs." + $("#slider-range").slider("values", 0) +
                        "  -  Rs." + $("#slider-range").slider("values", 1));
            });




            function activeC(o) {

                o.setAttribute('class', 'active');

            }









        </script>
        <!--SLIDER IMPORTS-->   


    </head>
    <body onload="">
        <%
            out.write(request.getHeader("X-FORWARDED-FOR"));

        %>
        <div class="container" >
            <div id="A1" class="row">              
                <div id="A1-1">
                    <label id="lab01i"><a href="#"><i class="fa fa-phone" aria-hidden="true"></i>&nbsp;&nbsp;+ 94 71 16 32 448 </a></label>
                </div>
                <div id="A1-2">
                    <label id="lab02i">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"><i class="fa fa-envelope" aria-hidden="true"></i>&nbsp;&nbsp;info@domain.com</a></label>
                </div>    
                <div id="A1-3">
                    <ul class="nav navbar-nav">
                        <li class="col-xm-1"><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li class="col-xm-1"><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                        <li><a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a></li>
                    </ul>
                </div>
            </div>
            <div id="A2" class="row" >
                <div id="A2-1">
                    <div class="dropdown01">
                        <button id="btn01i" type="button">English &nbsp;&nbsp;&nbsp;<span class="caret"></span></button>
                        <div class="dropdown-content01">
                            <a href="#">Sinhala</a>
                            <a href="#">Tamil</a>
                        </div>
                    </div>
                </div>
                <div id="A2-2">
                    <div class="dropdown01">
                        <button id="btn01i" type="button"><i class="fa fa-usd fa-lg" aria-hidden="true"></i> USD &nbsp;&nbsp;&nbsp;<span class="caret"></span></button>
                        <div class="dropdown-content01">
                            <a href="#"><i class="fa fa-eur fa-lg" aria-hidden="true"></i> Euro</a>
                            <a href="#"><i class="fa fa-inr fa-lg" aria-hidden="true"></i> Rupees </a>
                        </div>
                    </div>
                </div>
                <div id="A2-3" class="pull-right">
                    <div class="dropdown02">
                        <button id="btn02i" type="button"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;&nbsp;My Account &nbsp;&nbsp;&nbsp;<span class="caret"></span></button>
                        <div class="dropdown-content02">
                            <a href="#"><i class="fa fa-heart-o fa-lg" aria-hidden="true"></i>&nbsp;&nbsp;Wishlist</a>
                            <a href="#"><i class="fa fa-balance-scale fa-lg" aria-hidden="true"></i>&nbsp;&nbsp;Compare</a>
                        </div>
                    </div>
                    <label id="lab05i"><a href="03_user/login.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp;&nbsp;Sign in</a></label>
                    <label id="lab06i"><a href="03_user/login.jsp"><i class="fa fa-sign-in fa-lg" aria-hidden="true"></i>&nbsp;&nbsp;Sign up</a></label>
                    <label id="lab03i"><a href="#"><i class="fa fa-mobile fa-lg" aria-hidden="true"></i>&nbsp;&nbsp;Our app</a></label>
                    <label id="lab04i"><a href="#"><i class="fa fa-exclamation-circle fa-lg" aria-hidden="true"></i>&nbsp;&nbsp;Help</a></label>
                </div>
            </div>
            <div id="A3" class="row">
                <div class="bar01c" id="bar01i"></div>
                <div class="bar01c"></div>
                <div class="bar01c"></div>
                <div class="bar02c"></div>
            </div>
            <div id="A4" class="row">
                <div id="A4-1"><a href="index.jsp"><img src="01_home/header/site_logo.png"></a></div>
                <div id="A4-2">
                    <div id="A4-2-1">
                        <input id="seb01i" type="search" placeholder="I'm shopping for..." list="product_name" onkeyup="productName(this)">  
                        <datalist id="product_name" >

                        </datalist>
                    </div>
                    <div id="A4-2-2" >
                        <select id="sel01i" onchange="subFilter1(this)">
                            <%                                try {
                                    String sql1 = "SELECT * FROM product_category1";
                                    PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                    ResultSet rs1 = ps1.executeQuery();
//                                    out.write("<option value>All Categories&nbsp;&nbsp;&nbsp;</option>");

                            %>
                            <option value="">All Categories&nbsp;&nbsp;&nbsp;</option>
                            <%                                while (rs1.next()) {
                            %> 
                            <option value="<%=rs1.getString(1)%>"><%= rs1.getString(2)%></option>

                            <%
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            %>
                        </select>
                    </div>
                    <div id="A4-2-3">
                        <button id="sub01i" type="button" onclick="searchMain()"><i class="fa fa-search fa-2x" aria-hidden="true"></i></button>
                    </div>
                </div>
                <div id="A4-3">
                    <div id="A4-3-1">
                        <i class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i>
                        <lable>
                            <span class="badge "> <%=999999%> </span>
                        </lable>
                        <label>ITEMS</label>
                    </div>
                    <div id="A4-3-2">
                        <i class="fa fa-usd fa-2x" aria-hidden="true"></i>
                        <lable>
                            <span class="badge "> <%=999999.04%> </span>                                                       
                        </lable>
                    </div>
                    <div id="A4-3-3">
                        <button type="button" ><i class="fa fa-cart-arrow-down" aria-hidden="true"></i> &nbsp;Empty cart</button>
                    </div>
                </div>
            </div>
            <div id="A5" class="row">
                <ul class="dropdown-bar03" id="ul01i">
                    <%

                        try {
                            String sql1 = "SELECT * FROM product_category1";
                            PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                            ResultSet rs1 = ps1.executeQuery();
                            while (rs1.next()) {
                    %>
                    <li class="dropdown-item03">         
                        <a href="#home" class="dropdown-button03"><%=rs1.getString(2)%> <span class="dropdown-icon03 caret"></span></a>
                        <div class="dropdown-content03" >
                            <%
                                String sql2 = "SELECT * FROM product_category2 WHERE product_category1_idproduct_category1=?";
                                PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                ps2.setString(1, rs1.getString(1));
                                ResultSet rs2 = ps2.executeQuery();

                                while (rs2.next()) {
                            %>
                            <div class="sub-content03">
                                <h5 class="sub-title03"><a href="#"><%=rs2.getString(2)%></a></h5>
                                    <%
                                        String sql3 = "SELECT * FROM product_category3 WHERE product_category2_idproduct_category2=?";
                                        PreparedStatement ps3 = Controller.DB.con().prepareStatement(sql3);
                                        ps3.setString(1, rs2.getString(1));
                                        ResultSet rs3 = ps3.executeQuery();
                                    %>
                                <ul class="sub-list03">
                                    <%
                                        while (rs3.next()) {
                                    %>
                                    <li><a href="#"><%=rs3.getString(2)%></a></li>
                                        <%
                                            }
                                        %>
                                </ul>
                                <%

                                %>
                            </div>    
                            <%                                }
                            %>
                        </div>
                    </li>
                    <%                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </ul>
            </div>  
            <div id="A6" class="row" >
                <div class="bar03c" id="bar03i"></div>
                <div class="bar04c" ></div>
                <div class="bar04c"></div>
                <div class="bar04c"></div>
            </div>
            <div id="A7">
                <!--<iframe id="if01i" src="01_home/slider/wow slider.html"  style="border: none"></iframe>-->              
            </div>
            <div id="A8" class="row">
                <ul class="breadcrumb" id="ul02i">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#">Private</a></li>
                    <li><a href="#">Pictures</a></li>
                    <li>Vacation</li> 
                </ul>              
            </div>
            <div id="A9" class="row">
                <div id="A9-1">
                    <label id="lab07i">FILTER BY</label>

                    <button class="accordion01" onclick="filter(this)"  >BRAND</button>
                    <div class="panel01">
                        <%
                            try {
                                String sql1 = "SELECT * FROM brand";
                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                ResultSet rs1 = ps1.executeQuery();

                                while (rs1.next()) {
                        %>
                        <div class="checkbox">
                            <label class="lab01c"><input name="chk01c" type="checkbox" value="<%= rs1.getString(1)%>">&nbsp;<%=rs1.getString(2)%></label>
                        </div>
                        <%
                                }
                            } catch (Exception e) {
                            }
                        %>
                    </div>
                    <div id="cat2i">

                    </div>
                    <button  id="btn01ii">PRICE :&nbsp;&nbsp; 
                        <input type="text" id="amount" readonly style="border:0; color:#0066FF; font-weight:bold;">
                    </button>
                    <br><br>
                    <div id="slider-range"></div>
                    <br>                
                    <br>
                    <br>
                    <br>
                </div>
                <div id="A9-2" style=" float: left; max-width: 910px;">
                    <div id="A9-2-A1">

                    </div>
                    <div id="A9-2-A2" >
                        <div style="float: left">
                            <div style="float: left;border: 1px solid #E1E1E1; margin-left: 24px;" >
                                <div style="margin: 7px;width: 261px;height: 261px; background-color: #000">
                                    <div style="width: 261px;height: 209px; background-color: #00bf6f">
                                        <input type="image" src="Untitled 5.jpg" value="ss">
                                    </div>
                                    <div>

                                    </div>
                                    <div>

                                    </div>
                                </div>
                            </div> 

                            <input type="image" src="Untitled 1.jpg" style="width: 277px;margin-left: 24px;">
                            <input type="image" src="Untitled 1.jpg" style="width: 277px;margin-left: 24px;">
                            <input type="image" src="Untitled 1.jpg" style="width: 277px;margin-left: 24px;">
                            <input type="image" src="Untitled 1.jpg" style="width: 277px;margin-left: 24px;">           
                        </div>
                    </div>
                    <div id="A9-2-A3" style="margin-left: 30px; margin-right: 30px">
                        <ul class="pagination" id="pages">

                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
