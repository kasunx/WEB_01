/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//LOGIN---------------------------------------------------------------------------            
var v1 = false;
var v2 = false;

function validateUN01() {
    var x1 = document.forms['form01n']['txf01n'];
    var x2 = document.getElementById('labf01i');
    if (x1.value.trim().length < 8) {
        x1.style = "color:red;";
        x2.innerHTML = "Use at least 8 characters.";
        v1 = false;
    } else {
        x1.style = "color:black;";
        x2.innerHTML = "";
        v1 = true;

    }
}

function validatePW01() {
    var x1 = document.forms['form01n']['paw01n'];
    var x2 = document.getElementById('labf02i');
    if (x1.value.length < 8) {
        x1.style = "color:red;";
        x2.innerHTML = "Use at least 8 characters.";
        v2 = false;
    } else {
        x1.style = "color:black;";
        x2.innerHTML = "";
        v2 = true;
    }
}

function validateFM01() {
    validateUN01();
    validatePW01();
    if (v1 !== true || v2 !== true) {
        return false;
    } else {
        return true;
    }
}
//--------------------------------------------------------------------------------


//LOGIN---------------------------------------------------------------------------            
var v3 = false;
var v4 = false;

function validateUN02() {

//    alert(data);

    var x1 = document.forms['form02n']['ema01n'];
    var x2 = document.getElementById('labf03i');
    if (x1.value.trim().length < 8) {
        x1.style = "color:red;";
        x2.innerHTML = "Use at least 8 characters.";
        v3 = false;
    } else {
        userNameExist();

    }
}

function  userNameExist() {

    var data1 = document.forms['form02n']['ema01n'].value;

    var xmlhttpo;
    if (window.XMLHttpRequest) {
        xmlhttpo = new XMLHttpRequest();
    } else {
        xmlhttpo = new ActiveXObject('Microsoft.XMLHTTP');
    }

    xmlhttpo.onreadystatechange = function () {
        if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
            var x = document.forms['form02n']['ema01n'];
            var x1 = xmlhttpo.responseText;
            var x2 = document.getElementById('labf03i');

            if (x1 == null || x1 == "") {

                x.style = "color:black;";
                x2.style = "color:black;";
                x2.innerHTML = "";
                v3 = true;
            } else {
//                alert(x1);
                x.style = "color:red;";
                x2.style = "color:red;";
                x2.innerHTML = x1;
                v3 = false;
            }
        }
    };

    var data = 'un=' + data1;
    xmlhttpo.open('POST', '../UserExistS', true);
    xmlhttpo.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlhttpo.send(data);
}

function validatePW02() {
    var x1 = document.forms['form02n']['paw01n'];
    var x2 = document.getElementById('labf04i');
    if (x1.value.length < 8) {
        x1.style = "color:red;";
        x2.innerHTML = "Use at least 8 characters.";
        v4 = false;
    } else {
        x1.style = "color:black;";
        x2.innerHTML = "";
        v4 = true;
    }
}

function validateFM02() {

    validateUN02();
    validatePW02();

//    alert(v3);
//    alert(v4);
    if (v3 !== true || v4 !== true) {
        return false;
    } else {
        return true;
    }
}
//--------------------------------------------------------------------------------