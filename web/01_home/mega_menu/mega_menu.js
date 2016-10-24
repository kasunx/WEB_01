/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function megaMenu() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var x1 = xmlhttp.responseText;
            var x2 = document.getElementById('ul01i');
//                        alert(x2);
            x2.innerHTML = x1;
        } else {
//                        alert(xmlhttp.readyState);
        }
    };
    xmlhttp.open('POST', 'MegaMenuData', true);
    xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlhttp.send();
}