<%-- 
    Document   : send_mail
    Created on : Oct 15, 2016, 7:40:47 PM
    Author     : Kasun Kalhara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="../lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="../lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <style>
            *{
                font-family: "Oswald";
            }
            table{
                width: 98%;
                margin: 0px 10px 0px 10px;
            }
            table tr{
                /*width:100%;*/

            }
            input{
                width: 99%;
                margin-bottom: 9px;
            }
            textarea{
                width: 99%;
            }

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
                left: 45%;
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
        <%

            String address = "";
            if (request.getParameter("data") == null || request.getParameter("data").equals("")) {
                address = "";
            } else {
                address = request.getParameter("data").substring(1);
            }
        %>
    <tt>
        <h3>&nbsp;&nbsp;&nbsp;SEND MAIL</h3>
        <br>
        <form action="../SendMailS" method="POST">
            <table class="" border="0px;">
                <tr>
                    <td style="width:6%">FROM</td>
                    <td style="width:1%">:</td>
                    <td style="width:100%">&nbsp;<input type="email" value="donkkrh@gmail.com" readonly name="from" required></td>
                </tr>
                <tr>
                    <td>TO</td>
                    <td>:</td>
                    <td>&nbsp;<input type="email" value="<%= address%>" readonly name="to" required></td>
                </tr>
                <tr>
                    <td>Subject</td>
                    <td>:</td>
                    <td>&nbsp;<input type="text" name="subject" required></td>
                </tr>
                <tr>
                    <td colspan="3">&nbsp;<textarea rows="20" cols="100" name="msg" required></textarea></td>
                </tr>
                <tr>
                    <td colspan="3" style="text-align: right">
                        <button type="submit" class="btn btn-primary btn-sm" style="margin-right: 8px">&nbsp;&nbsp;Send&nbsp;&nbsp;</button>
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <br>
        <div id="snackbar"></div>
        <br>
    </tt>
</body>
</html>
