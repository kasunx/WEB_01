/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function searchProductName(val) {


    if (val == null || val.trim() == "") {
    } else {
        var xmlhttp;

        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var v = xmlhttp.responseText;
//                alert(v);
            } else {
//                alert("1_" + xmlhttp.readyState);
//                alert("2_" + xmlhttp.status);
            }

        };

        var data = "../../ProductSearchS?type=1&name=" + val;

        xmlhttp.open('GET', data, true);
//        xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencorded');
        xmlhttp.send();

    }
}
