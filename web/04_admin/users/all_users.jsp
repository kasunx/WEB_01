<%-- 
    Document   : all_users
    Created on : Oct 15, 2016, 9:04:02 AM
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
        <link rel="stylesheet" type="text/css" href="../../lib/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="../../lib/bootstrap/jquery-3.1.0.min.js"></script>
        <script src="../../lib/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <title>JSP Page</title>
        <style>
            body{
                width: 1160px;
                /*border: 1px solid black;*/
            }
            #tab00i{
                width: 1125px;
                max-width: 1125px;
                /*border: 1px solid black;*/
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

            function myFunction(msg, color) {

                if (msg == 'null') {
//                    document.getElementById("for01i").reset();

                } else {
//                    document.getElementById("for01i").reset();
                    var x = document.getElementById("snackbar");
                    x.className = "show";
                    x.innerHTML = msg;
                    x.setAttribute('style', 'background-color:#' + color + ';     font-family: "Oswald";');
                    setTimeout(function () {
                        x.className = x.className.replace("show", "");
                    }, 3000);
                }
            }

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
                            cc += "," + checkboxes[i].value;

                        } else {

                        }
                    }
                }

                if (cc != "") {
                    window.open('../../05_email/send_mail.jsp?data=' + cc, '_blank').focus();
                }

            }

            function deleteUsers(uid, ob) {

                var x = confirm('Are u sure want to delete this user');

                if (x) {


                    var xmlhttp;

                    if (window.XMLHttpRequest) {
                        xmlhttp = new XMLHttpRequest();
                    } else {
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }

                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                            var s = xmlhttp.responseText;

                            if (s == 1) {
                                myFunction("user has been successfully deleted", "00bf6f");
//                                alert(ob.parentElement.nodeName);
                                ob.parentElement.parentElement.parentElement.removeChild(ob.parentElement.parentElement);
                            } else {
                                myFunction("user delete fail");

                            }
                        }

                    };

                    xmlhttp.open("GET", "../../DeleteUserS?user_id=" + uid, true);
                    xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencorded');
                    xmlhttp.send();


                }

            }


            function changeAdminPermission(id, st) {
//                var x = confirm('Are u sure want to delete this user');
//
//                if (x) {

//                    alert(id+"____"+st);

                var xmlhttp;

                if (window.XMLHttpRequest) {
                    xmlhttp = new XMLHttpRequest();
                } else {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }

                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                        var s = xmlhttp.responseText;

                        if (s == 1) {
                            myFunction("user permission changed", "00bf6f");
//                                alert(ob.parentElement.nodeName);
//                                ob.parentElement.parentElement.parentElement.removeChild(ob.parentElement.parentElement);
                        } else {
                            myFunction("user permission changed fail");

                        }
                    }

                };

                xmlhttp.open("GET", "../../AdminPermissionS?user_id=" + id + "&st=" + st, true);
                xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencorded');
                xmlhttp.send();


//                }
            }

        </script>
    </head>
    <body>
    <center>
        <tt>
            <h3>All USERS</h3>
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
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            try {

                                String sql1 = "SELECT * FROM login";
                                PreparedStatement ps1 = Controller.DB.con().prepareStatement(sql1);

                                ResultSet rs1 = ps1.executeQuery();

                                while (rs1.next()) {

                        %>
                        <tr>
                            <td><input type="checkbox" name="chk01n" value="<%= rs1.getString(2)%>"></td>
                            <td><%= rs1.getInt(6)%></td>
                            <td><%= rs1.getString(2)%></td>
                            <td><%= rs1.getString(3)%></td>
                            <%
                                try {
                                    String sql2 = "SELECT * FROM user_type WHERE user_iduser=?";
                                    PreparedStatement ps2 = Controller.DB.con().prepareStatement(sql2);
                                    ps2.setInt(1, rs1.getInt(6));

                                    ResultSet rs2 = ps2.executeQuery();

                                    if (rs2.next()) {
                            %>
                            <td><%=  rs2.getString(2)%></td>
                            <%
                                    }
                                } catch (Exception e2) {
                                }

                            %>
                            <td style="color: <%=(rs1.getInt(4) == 1) ? "#00bf6f" : "red"%>"><%=(rs1.getInt(4) == 1) ? "confirmed" : "not confirmed"%></td></td>
                            <td>
                                <%

                                    String a = "";
                                    String b = "";

                                    if (rs1.getInt(5) == 1) {
                                        a = "checked";
                                        b = "";
                                    } else {
                                        a = "";
                                        b = "checked";
                                    }
                                %>
                                <input type="radio" name="rad0<%=rs1.getInt(6)%>n" <%=a%> onclick="changeAdminPermission(<%=rs1.getInt(6)%>, 1)"> ON 
                                <input type="radio" name="rad0<%=rs1.getInt(6)%>n"  <%=b%> onclick="changeAdminPermission(<%=rs1.getInt(6)%>, 0)"> OFF
                            </td>
                            <td>
                                <input type="button" class="btn btn-danger btn-xs" value="Delete" onclick="deleteUsers(<%= rs1.getInt(6)%>, this)">
                                <!--<input type="button" value="VIEW" class="btn btn-default btn-xs">-->
                            </td>
                        </tr>
                        <%
                                }
                            } catch (Exception e1) {
                            }
                        %>
                    </tbody>
                </table>
            </form>
            <div id="snackbar"></div>
            <br> <br> <br>
        </tt>
    </center>
</body>
</html>
