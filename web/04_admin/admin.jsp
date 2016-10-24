<%-- 
    Document   : admin
    Created on : Sep 18, 2016, 1:36:36 PM
    Author     : Kasun Kalhara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="../lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="../lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <script>
            $(document).ready(
                    function () {
                        $("#B-1 ul li").click(function () {
                            $(this).addClass('selected').siblings().removeClass("selected");

                        });
                    }
            );
        </script>
        <style >

            #B-1 ul li.selected { background-color: #4CAF50;}
            *{
                margin: 0px;
                padding: 0px;
            }
            #A{
                width: 100%;
                background-color: #39bf87;
            }
            #B{

            }
            #B-1{
                float: left;
                background-color: #00bf6f;
                height: 100%;
                width: 15%;
                position: fixed;
            }

            #B-2{
                float: left;
                background-color: #008AC3;
                height: 100%;
                width: 85%;
                /*position: fixed;*/
                margin-left: 205px;
            }
            #B-1 ul{
                list-style-type: none;
                margin: 0;
                padding: 0;
                width: 15%;
                background-color: #f1f1f1;
                position: fixed;
                height: 100%;
                overflow: auto;
            }
            #B-1 ul li a{
                display: block;
                color: #000;
                padding: 8px 16px;
                text-decoration: none;

            }
            #B-1 ul li a.active {
                background-color: #4CAF50;
                color: white;
            }

            #B-1 ul li a:hover:not(.active) {
                background-color: #555;
                color: white;
            }
            #B-1ai{
                margin: 0px;
                padding: 0px;
            }
        </style>

    </head>
    <body>
        <div id="A">
            aaa
        </div>
        <!--<div id="B">-->
        <div id="B-1">

            <!--<img src="../admin/ss.jpg">-->
            <ul>
                <li><a id="B-1ai" href="#"></a></li>
                <li ><a href="categories/categories.jsp" target="B-2ifn">CATEGORIES</a></li>
                <li><a href="product/product_home.jsp" target="B-2ifn">PRODUCT_HOME</a></li>
                <li><a href="product/product_save.jsp" target="B-2ifn">PRODUCT_SAVE</a></li>
                <li><a href="users/all_users.jsp" target="B-2ifn">ALL USERS</a></li>
                <li><a href="users/online_users.jsp" target="B-2ifn">ONLINE USERS</a></li>
                <li><a href="#">AAA</a></li>
                <li><a href="#">AAA</a></li>
            </ul>
        </div>
        <div id="B-2">

            <iframe name="B-2ifn" width="100%" height="100%"  scrolling="yes" style=" position: fixed; border: none;" src="product/product_home.jsp"></iframe>
        </div>
        <!--</div>-->

    </body>
</html>
