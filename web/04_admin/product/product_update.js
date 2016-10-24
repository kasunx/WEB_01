/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function deliveryX(x) {
//    alert(x);
    var days = document.getElementById('num09i');
    var area = document.getElementById('sel07i');
    if (x == 'Yes') {

        days.disabled = false;
        area.disabled = false;
        deliveryArea1();

    } else if (x == 'No') {
        days.disabled = true;
        area.innerHTML = "";
        area.disabled = true;

    }
}
function deliveryArea1() {

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


var xmlhttpo;

function productSearch1(data, URL, cbf) {

//    alert(data);
    if (window.XMLHttpRequest) {
        xmlhttpo = new XMLHttpRequest();
    } else {
        xmlhttpo = new ActiveXObject();
    }
    xmlhttpo.onreadystatechange = cbf;
    xmlhttpo.open('POST', URL, true);
    xmlhttpo.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlhttpo.send(data);
}

var i = 0;
function addSpecifications1(name, value, unit) {
    if (name.trim() == "" || value.trim() == "") {
    } else {
        i++;

//------TABLE-------------------------------------------------------------------
        var tbody = document.getElementById('tab02ibody');

//------TABLE-------------------------------------------------------------------

//------TABLE ROW---------------------------------------------------------------
        var tr = document.createElement('tr');
        tr.setAttribute('id', 'tr' + i + 'i');
        tr.setAttribute('onmouseover', 'A(this)');
//------TABLE ROW---------------------------------------------------------------

//------SPEC NAME---------------------------------------------------------------
        var td1 = document.createElement('td');
        td1.setAttribute("align", "right");
        var name_d = document.createElement('input');
        name_d.setAttribute("type", "text");
        name_d.setAttribute("style", "border:0px;");
        name_d.setAttribute("readonly", "true");
        name_d.setAttribute("value", name.trim());
        name_d.setAttribute("name", "spe01n");

        td1.appendChild(name_d);
//------SPEC NAME---------------------------------------------------------------
//------=========---------------------------------------------------------------
        var td2 = document.createElement('td');
//        td2.setAttribute("style", "border:1px;padding:7px");
        td2.innerHTML = "&nbsp;:&nbsp";
//------=========---------------------------------------------------------------
//------SPEC VALUE--------------------------------------------------------------
        var td3 = document.createElement('td');
        td3.setAttribute("style", "border:0px;");
        var value_d = document.createElement('input');
        value_d.setAttribute("type", "text");
        value_d.setAttribute("style", "border:0px;");
        value_d.setAttribute("readonly", "true");
        value_d.setAttribute("value", value.trim());
        value_d.setAttribute("name", "spe02n");
        td3.appendChild(value_d);
//------SPEC VALUE--------------------------------------------------------------
//------SPEC UNIT---------------------------------------------------------------
        var td4 = document.createElement('td');
        td4.setAttribute("style", "border:0px;");
        var unit_d = document.createElement('input');
        unit_d.setAttribute("type", "text");
        unit_d.setAttribute("style", "border:0px;");
        unit_d.setAttribute("readonly", "true");
        unit_d.setAttribute("value", unit.trim());
        unit_d.setAttribute("name", "spe03n");
        td4.appendChild(unit_d);
//------SPEC UNIT---------------------------------------------------------------
//------CLOSE ICON--------------------------------------------------------------
        var cloi = document.createElement('i');
        cloi.setAttribute("class", "fa fa-times");
        cloi.setAttribute("aria-hidden", "true");
//------CLOSE ICON--------------------------------------------------------------
//------CLOSE BUTTON------------------------------------------------------------
        var input = document.createElement('label');
        input.setAttribute('name', 'spe' + i + 'n');
        input.setAttribute('id', 'spe' + i + 'n');
        input.setAttribute('onclick', 'removeSpecifications1(' + i + ')');
        input.setAttribute('style', 'margin-bottom: 5px');
        input.appendChild(cloi);

        var td5 = document.createElement('td');
        td5.setAttribute("style", "border:0px;");
        td5.appendChild(input);
//------CLOSE BUTTON------------------------------------------------------------

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tbody.appendChild(tr);

        document.getElementById('t02i').value = "";
        document.getElementById('t03i').value = "";
        document.getElementById('t04i').value = "";
    }
}
function removeSpecifications1(tr_index) {
    var x = confirm("Are u seure want to delete this sepecification ?");
    if (x) {
        document.getElementById('tab02i').deleteRow(tr_index);
    } else {
    }
}
function A(x) {
    x.children[4].children[0].setAttribute('onclick', 'removeSpecifications1(' + x.rowIndex + ')');
}

function loadUnits1(value) {
    document.getElementById('t04i').value = null;
    if (value.trim() == "") {
    } else {
        var data = "id=" + value;
        productSearch2(data, '../../UnitsS', function () {
            if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                var v = xmlhttpo.responseText;
                document.getElementById('browser02').innerHTML = "";
                document.getElementById('browser02').innerHTML = v;
            } else {
//                        alert("1_" + xmlhttpo.readyState);
//                        alert("2_" + xmlhttpo.status);
            }

        });
    }
}
function productSearch2(data, URL, cbf) {

//    alert(data);
    if (window.XMLHttpRequest) {
        xmlhttpo = new XMLHttpRequest();
    } else {
        xmlhttpo = new ActiveXObject();
    }
    xmlhttpo.onreadystatechange = cbf;
    xmlhttpo.open('POST', URL, true);
    xmlhttpo.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlhttpo.send(data);
}

function removeSpecifications2(x) {
//    alert('dd');

    var x1 = confirm("Are u seure want to delete this sepecification ?");
    if (x1) {
//        document.getElementById('tab02i').deleteRow(tr_index);
        x.parentElement.parentElement.parentElement.removeChild(x.parentElement.parentElement);
    } else {
    }






//    x.children[4].children[0]
}

function removeImage(x){ 
    
    
//    alert(x.id);
//    
//    alert(document.getElementById('hid02n').value);
//    

    
    var y = x.id+">"+document.getElementById('hid02i').value;

//    alert(y);
document.getElementById('hid02i').value = y;
//    
//    alert(x.parentElement.nodeName);
    x.parentElement.removeChild(x);
}