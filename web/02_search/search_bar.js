/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function productName(a) {


    if (a.value == null || a.value.trim() == "") {

    } else {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
        }

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var x1 = xmlhttp.responseText;
//                alert(x1);
                var x2 = document.getElementById('product_name');
                x2.innerHTML = "";
                x2.innerHTML = x1;
            } else {
//            alert(xmlhttp.readyState);
            }
        };

        var data = "data=" + a.value.trim();

//        alert(data);
        xmlhttp.open('POST', 'SearchProductNameS', true);
        xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xmlhttp.send(data);
    }
}















