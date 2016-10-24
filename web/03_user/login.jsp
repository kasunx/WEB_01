<%-- 
    Document   : newjsp
    Created on : Sep 12, 2016, 12:39:23 AM
    Author     : Kasun Kalhara
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!--BOOTSTRAP-->
        <link rel="stylesheet" type="text/css" href="../lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="../lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="../lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <!--BOOTSTRAP-->

        <!--DEFAULT javascript-->
        <script></script>
        <!--DEFAULT javascript-->

        <!--DEFAULT css-->
        <link rel="stylesheet" type="text/css" href="../css/default.css">
        <!--DEFAULT css-->
        <!--HEADER-->
        <link rel="stylesheet" type="text/css" href="../01_home/header/header.css">
        <!--HEADER-->


        <!--GLYPHICON-->
        <link rel="stylesheet" type="text/css" href="../lib/font-awesome-4.6.3/css/font-awesome.min.css">
        <!--GLYPHICON-->

        <!--MEGA MENU-->
        <link rel="stylesheet" type="text/css" href="../01_home/mega_menu/mega_menu.css">
        <script src="../01_home/mega_menu/mega_menu.js"></script>
        <!--MEGA MENU-->

        <!--SEARCH CATOGAR-->
        <script src="../02_search/search_all_catogary.js"></script>
        <!--SEARCH CATOGAR-->

        <!--BREADCRUMB-->
        <link rel="stylesheet" type="text/css" href="../02_search/breadcrumb/breadcrumb.css">
        <!--BREADCRUMB-->

        <!--SEARCH-FILTER-->
        <link rel="stylesheet" type="text/css" href="../02_search/search_filter.css">
        <script src="../02_search/search_filter.js"></script>
        <!--SEARCH-FILTER-->

        <!--SEARCH_CATEGORY-->
        <script src="../02_search/advanced_search.js"></script>
        <!--SEARCH_CATEGORY-->

        <!--SEARCH_BAR-->
        <script src="../03_user/search_bar.js"></script>
        <!--SEARCH_BAR-->

        <link rel="stylesheet" type="text/css" href="login.css">
        <script src="login.js"></script>
        <script>
            window.onload = function () {


//                document.getElementById('hid02i').value = "";
                myFunction("<%= request.getParameter("msg")%>", "<%= request.getParameter("cl")%>");
            };

            function myFunction(msg, color) {

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
        <div class="container">
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
                    <label id="lab05i"><a href="login.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp;&nbsp;Sign in</a></label>
                    <label id="lab06i"><a href="login.jsp"><i class="fa fa-sign-in fa-lg" aria-hidden="true"></i>&nbsp;&nbsp;Sign up</a></label>
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
                <div id="A4-1"><img src="../01_home/header/site_logo.png"></div>
                <div id="A4-2">
                    <div id="A4-2-1">
                        <input id="seb01i" type="search" placeholder="I'm shopping for..." list="product_name" onkeyup="productName2(this)">  
                        <datalist id="product_name" >

                        </datalist>
                    </div>
                    <div id="A4-2-2" >
                        <select id="sel01i" onmouseover="searchAllCatogart()">
                            <%
                                try {
                                    String sql1 = "SELECT * FROM product_category1";
                                    PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);
                                    ResultSet rs1 = ps1.executeQuery();
                                    out.write("<option>All Categories&nbsp;&nbsp;&nbsp;</option>");
                                    while (rs1.next()) {
                                        out.write(" <option>" + rs1.getString(2) + "</option>");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            %>
                        </select>
                    </div>
                    <div id="A4-2-3">
                        <button id="sub01i" type="submit" onclick="searchProduts()"><i class="fa fa-search fa-2x" aria-hidden="true"></i></button>
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
                            try {
                                while (rs1.next()) {
                                    out.write("<li class=\"dropdown-item03\">");
                                    out.write("<a href=\"#home\" class=\"dropdown-button03\">" + rs1.getString(2) + " <span class=\"dropdown-icon03 caret\"></span></a>");
                                    out.write(" <div class=\"dropdown-content03\" >");

                                    String sql2 = "SELECT * FROM product_category2 WHERE product_category1_idproduct_category1=?";
                                    PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                    ps2.setString(1, rs1.getString(1));
                                    ResultSet rs2 = ps2.executeQuery();

                                    try {
                                        while (rs2.next()) {
                                            out.write("<div class=\"sub-content03\">");
                                            out.write(" <h5 class=\"sub-title03\"><a href=\"#\">" + rs2.getString(2) + "</a></h5>");
                                            String sql3 = "SELECT * FROM product_category3 WHERE product_category2_idproduct_category2=?";
                                            PreparedStatement ps3 = Controller.DB.con().prepareStatement(sql3);
                                            ps3.setString(1, rs2.getString(1));
                                            ResultSet rs3 = ps3.executeQuery();
                                            try {
                                                out.write("<ul class=\"sub-list03\">");
                                                while (rs3.next()) {
                                                    out.write("<li><a href=\"#\">" + rs3.getString(2) + "</a></li>");
                                                }
                                                out.write("</ul> ");
                                            } catch (Exception e) {
                                            }
                                            out.write("</div>");
                                        }
                                    } catch (Exception e) {
                                    }

                                    out.write("</div>");
                                    out.write("</li>");
                                }
                            } catch (Exception e) {
                            }
                        } catch (Exception e) {
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
                <div class="col-sm-5" style="margin-left: 48px">
                    <label class="lab01n">LOGIN</label>
                    <form action="../SigninS" method="post" name="form01n" onsubmit="return validateFM01()">
                        <div class="form-group" >
                            <label for="email">Username or Email address:</label>
                            <input type="text" class="form-control bor"  name="txf01n" onkeyup="validateUN01()" required>
                            <label id="labf01i" ></label>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" class="form-control bor" name="paw01n" onkeyup="validatePW01()" required>
                            <label id="labf02i"></label>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" name="chk01n">Remember me</label>
                        </div>
                        <button type="submit" class="btn btn-default bor" style="background-color: #4F4F4F; color: #ffffff;">LOGIN</button><br><br>
                        <a id="anc01i" href="forgot_password.jsp" style="font-size: 15px">Forgot password ?</a>
                            
                    </form>
                </div>
                <div class="col-sm-1"></div>
                <div class="col-sm-5">
                    <label class="lab01n">REGISTER</label>
                    <form action="../SignupS" method="GET" name="form02n" onsubmit="return validateFM02()">
                        <div class="form-group">
                            <label for="email">Email address:</label>
                            <input type="email" class="form-control bor" name="ema01n" onkeyup="validateUN02(this.value)" required>
                            <label id="labf03i" ></label>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" class="form-control bor" name="paw01n" onkeyup="validatePW02()" required >
                            <label id="labf04i" ></label>
                        </div>                      
                        <button type="submit" class="btn btn-default bor" style="background-color: #4F4F4F; color: #ffffff;">REGISTER</button>
                    </form>
                </div>
            </div>
                <div id="snackbar"></div>
                <br> <br> <br>
        </div>
    </body>
</html>
