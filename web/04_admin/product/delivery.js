/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function () {
        x.className = x.className.replace("show", "");
    }, 3000);
}

function deliveryArea() {


    var xmlhttp;

    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            var v = xmlhttp.responseText;

            var ar = v.split(",");

            var sel = document.getElementById('sel07i');


            var op = "";
            for (var i = 0; i < ar.length; i++) {
                op += "<option>" + ar[i] + "</option>";
            }

            sel.innerHTML = op;
            sel.disabled = false;

//                        document.getElementById('sel07i').innerHTML = "";
//                        document.getElementById('sel07i').innerHTML = v;

        } else {
//            alert("1_" + xmlhttp.readyState);
//            alert("2_" + xmlhttpo.status);
        }

    };

    xmlhttp.open("GET", "delivery_areas.txt", true);
    xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencorded');
    xmlhttp.send();
}
