/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function searchMain() {


    var product_name = document.getElementById('seb01i').value;
//    alert("product name : " + product_name);

    var category1 = document.getElementById('sel01i').value;
//    alert("category1 id : " + category1);


    var category2_1 = document.getElementsByName('chk02c');
    var category2_2 = "";
    for (var i = 0; i < category2_1.length; i++) {
        if (category2_1[i].checked) {
//            alert(category2_1[i].value);
            category2_2 += ">" + category2_1[i].value;
        }
    }
//    alert("category2 ids : " + category2_2);

    var brand1 = document.getElementsByName('chk01c');
    var brand2 = "";
    for (var i = 0; i < brand1.length; i++) {
        if (brand1[i].checked) {
//            alert(brand1[i].value);
            brand2 += ">" + brand1[i].value;
        }
    }
//    alert("brand ids : " + brand2);

    var price_range_n = document.getElementById('amount').value;
    var price_range_1 = price_range_n.split("-")[0].trim().substring(3);
    var price_range_2 = price_range_n.split("-")[1].trim().substring(3);
//    alert("Price range : " + price_range_1 + ">" + price_range_2);


//    var checkboxes = document.getElementsByName('chk01n');
//                var cc = "";
//
//                for (var i = 0; i < checkboxes.length; i++) {

    if (product_name == undefined || product_name.trim() == "") {

    } else {
        var data = "PN=" + product_name + "&PR1=" + price_range_1 + "&PR2=" + price_range_2 + "&BR=" + brand2 + "&CT1=" + category1 + "&CT2=" + category2_2;
        searchMain2(data);
    }
}

function searchMain2(data) {

    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            var v = xmlhttp.responseText;
            var ul = document.getElementById('pages');

            if (v == 0 || v == "") {
                ul.innerHTML = "";
            } else {
                ul.innerHTML = v;
                searchMain3(1);
            }


//            document.getElementById('cat2i').innerHTML = "";
//            document.getElementById('cat2i').innerHTML = v;
        } else {
//                alert("1_" + xmlhttp.readyState);
//                alert("2_" + xmlhttp.status);
        }
    };

    var url = "SearchMainAS?" + data;
//    alert(url);

    xmlhttp.open("GET", url, true);
    xmlhttp.send();

}
function searchMain3(page){
  
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            var v = xmlhttp.responseText;
            var ul = document.getElementById('pages');

            if (v == 0 || v == "") {
//                ul.innerHTML = "";
            } else {
//                ul.innerHTML = v;
            }


//            document.getElementById('cat2i').innerHTML = "";
//            document.getElementById('cat2i').innerHTML = v;
        } else {
//                alert("1_" + xmlhttp.readyState);
//                alert("2_" + xmlhttp.status);
        }
    };

    var url = "SearchMainBS?page=" + page;
    alert(url);

    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}































function subFilter1(x) {
    var category1 = x.value;

    if (category1 == undefined || category1 == "") {
        document.getElementById('cat2i').innerHTML = "";
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
                document.getElementById('cat2i').innerHTML = "";
                document.getElementById('cat2i').innerHTML = v;
            } else {
//                alert("1_" + xmlhttp.readyState);
//                alert("2_" + xmlhttp.status);
            }
        };
        var data = "category1=" + category1.trim();
        xmlhttp.open("GET", "SearchCat2forCat1S?" + data, true);
        xmlhttp.send();
    }
}