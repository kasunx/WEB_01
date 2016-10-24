<%-- 
    Document   : online_users
    Created on : Oct 15, 2016, 5:11:51 PM
    Author     : Kasun Kalhara
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../../lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="../../lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="../../lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <title>JSP Page</title>
        <style>
            body{
                width: 1160px;
                border: 1px solid black;
            }
            #tab00i{
                width: 1125px;
                max-width: 1125px;
                border: 1px solid black;
            }

            table tr td{
                text-align:center;
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
            function selectAll() {
                var checkboxes = document.getElementsByName('chk01n');
                for (var i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].type == 'checkbox') {
                        checkboxes[i].checked = true;
                    }
                }
            }
            function selectNone() {
                var checkboxes = document.getElementsByName('chk01n');
                for (var i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].type == 'checkbox') {
                        checkboxes[i].checked = false;
                    }
                }
            }

            function sendMail() {
                var checkboxes = document.getElementsByName('chk01n');
                var cc = "";
                for (var i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].type == 'checkbox') {
                        if (checkboxes[i].checked) {
//                            alert(checkboxes[i].value);
//                            window.open('../../05_email/send_mail.jsp', '_blank').focus();
                            cc += ","+checkboxes[i].value;

                        } else {

                        }
                    }
                }

                if (cc != "") {
                    window.open('../../05_email/send_mail.jsp?data=' + cc, '_blank').focus();
                }

            }
        </script>
    </head>
    <body>

    <center>
        <tt>
            <h3>ONLINE USERS</h3>
            <div style="display: flex; flex-direction: row; justify-content: flex-start; margin-left: 16px">
                <input type="button" class="btn btn-primary btn-sm" value="Select all" onclick="selectAll()">&nbsp;
                <input type="button" class="btn btn-default btn-sm" value="Select none" onclick="selectNone()">&nbsp;
                <input type="button" class="btn btn-success btn-sm" value="SEND MAIL" onclick="sendMail()">
            </div>
            <br>
            <form name="for01n">
                <table  id="tab00i" class="table table-condensed table-hover table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>SELECT</th>
                            <th>USER ID</th>
                            <th>USERNAME</th>
                            <th>PASSWORD</th>
                            <th>ACCESS_TYPE</th>
                            <th>EMAIL_VERIFICATION</th>
                            <th>ADMIN_PERMISSION</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%                            Map online_users = Listeners.Visit.getOnlineUsers();

                            for (Object user : online_users.values()) {

                                HttpSession s = (HttpSession) user;
                        %>
                        <tr>
                            <td><input type="checkbox" name="chk01n" value="<%= s.getAttribute("username")%>"></td>
                            <td><%= s.getAttribute("user_id")%></td>
                            <td><%= s.getAttribute("username")%></td>
                            <td><%= s.getAttribute("password")%></td>
                            <td>user</td>
                            <td style="color: #00bf6f"><%=(Integer.parseInt(s.getAttribute("email_verify").toString()) == 1) ? "confirmed" : "not confirmed"%></td>
                            <td style="color: #00bf6f"><%=(Integer.parseInt(s.getAttribute("admin_permissions").toString()) == 1) ? "granted" : "not granted "%></td>                 
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </form>
        </tt>
    </center>
</body>
</html>
