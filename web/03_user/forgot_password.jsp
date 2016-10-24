<%-- 
    Document   : forgot_password
    Created on : Oct 16, 2016, 3:45:59 PM
    Author     : Kasun Kalhara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--BOOTSTRAP-->
        <link rel="stylesheet" type="text/css" href="../lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="../lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="../lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <!--BOOTSTRAP-->

        <title>JSP Page</title>

        <style>
            #snackbar {
                visibility: hidden;
                min-width: 250px;
                margin-left: -125px;
                background-color:red;
                /*background-color: #00bf6f;*/
                color: #fff;
                text-align: center;
                border-radius: 2px;
                padding: 16px;
                position: fixed;
                z-index: 1;
                left: 50%;
                bottom: 30px;
                font-size: 17px;
            }

            #snackbar.show {
                visibility: visible;
                -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
                animation: fadein 0.5s, fadeout 0.5s 2.5s;
            }

            @-webkit-keyframes fadein {
                from {bottom: 0; opacity: 0;}
                to {bottom: 30px; opacity: 1;}
            }

            @keyframes fadein {
                from {bottom: 0; opacity: 0;}
                to {bottom: 30px; opacity: 1;}
            }

            @-webkit-keyframes fadeout {
                from {bottom: 30px; opacity: 1;}
                to {bottom: 0; opacity: 0;}
            }

            @keyframes fadeout {
                from {bottom: 30px; opacity: 1;}
                to {bottom: 0; opacity: 0;}
            }

            *{

                font-family: "Oswald";
            }
        </style>
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
    <center>
        <h3>Forget your password ?</h3>
        <p>Enter your email address below we will send your password</p><br>
        <form action="../ForgotPasswordS" method="POST">
        <label>E-mail address&nbsp;&nbsp;:&nbsp;</label> <input type="email" required name="ema01n" style="width:20%"><br><br>
        <input type="submit" value="&nbsp;SEND&nbsp;" class="btn btn-primary btn-sm" style="border-radius: 0px;background-color: #4F4F4F">
        </form>
        <div id="snackbar"></div>
        <br> <br> <br>
    </center>
</body>
</html>
