
var xmlhttpo;
function adminBrand(data, cbf) {
//    alert(url);
//    alert(data);
    if (window.XMLHttpRequest) {
        xmlhttpo = new XMLHttpRequest();
    } else {
        xmlhttpo = new ActiveXObject();
    }
    xmlhttpo.onreadystatechange = cbf
    xmlhttpo.open('POST', '../../BrandS', true);
    xmlhttpo.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlhttpo.send(data);
}

function searchBrand(qu, pt, co, vl, wr, cl) {
    if (pt.trim() === "" || co.trim() === "") {
    } else {
        var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
        adminBrand(data, function () {
            if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                var v = xmlhttpo.responseText;
                document.getElementById('tab01i').innerHTML = v;
//                document.getElementById('tab02i').innerHTML = v;
//                document.getElementById('tab03i').innerHTML = v;
//                document.getElementById('tab04i').innerHTML = v;
            } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
            }
        }
        );
    }
}
function savehBrand(qu, pt, co, vl, wr, cl) {
    if (vl.trim() === "") {
        alert('Pleaase insert the Brand');
    } else {
        var x1 = confirm('Are u sure want to save this brand ? ');
        if (x1) {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl.trim().toUpperCase() + "&wr=" + wr + "&cl=" + cl;
            adminBrand(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchBrand('se', '1', '*', '0', '0', '0');
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    ;
                    document.getElementById('txf01i').value = "";
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        } else {
            document.getElementById('txf01i').value = "";
        }
    }
}
function updateBrand(qu, pt, co, vl, wr, cl) {
    var x1 = confirm('Are u sure want to update this brand ? ');
    if (x1) {
        vl = prompt("Plese insert the new Brand for update");
        if (vl.trim() === "") {
            alert('Entered Brand Name Empty');
        } else {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminBrand(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchBrand('se', '1', '*', '0', '0', '0');
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    ;
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        }
    } else {
    }
}
function deleteBrand(qu, pt, co, vl, wr, cl) {
    var x1 = confirm('Are u sure want to delete this brand ? ');
    if (x1) {
        if (vl.trim() === "") {
//            alert('Entered Brand Name Empty');
        } else {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminBrand(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchBrand('se', '1', '*', '0', '0', '0');
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    ;
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        }
    } else {
    }
}


function adminCategory1(data, cbf) {
//    alert(url);
//    alert(data);
    if (window.XMLHttpRequest) {
        xmlhttpo = new XMLHttpRequest();
    } else {
        xmlhttpo = new ActiveXObject();
    }
    xmlhttpo.onreadystatechange = cbf
    xmlhttpo.open('POST', '../../Category1S', true);
    xmlhttpo.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlhttpo.send(data);
}
function searchCategory1(qu, pt, co, vl, wr, cl) {
//    var tag1 = document.createElement('input');
//    tag1.setAttribute('type', 'hidden');
//    tag1.setAttribute('value', cl);
//    document.body.appendChild(tag1);

    if (pt.trim() === "" || co.trim() === "") {
    } else {
        var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
        adminCategory1(data, function () {
            if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                var v = xmlhttpo.responseText;
                document.getElementById('tab02i').innerHTML = v;
                document.getElementById('tab03i').innerHTML = "";
                document.getElementById('tab04i').innerHTML = "";
            } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
            }
        }
        );
    }
}
function saveCategory1(qu, pt, co, vl, wr, cl) {
    if (vl.trim() === "") {
        alert('Pleaase insert the Category 1');
    } else {
        var x1 = confirm('Are u sure want to save this Category 1 ? ');
        if (x1) {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory1(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory1('se', '1', '*', '0', '0', '0');
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    ;
                    document.getElementById('txf02i').value = "";
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
                x();
            }
            );
        } else {
            document.getElementById('txf02i').value = "";
        }
    }
}
function updateCategory1(qu, pt, co, vl, wr, cl) {
    var x1 = confirm('Are u sure want to update this Category 1 ? ');
    if (x1) {
        vl = prompt("Plese insert the new Category 1 for update");
        if (vl.trim() === "") {
            alert('Entered Category 1 Name Empty');
        } else {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory1(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory1('se', '1', '*', '0', '0', '0');
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    ;
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        }
    } else {
    }
}
function deleteCategory1(qu, pt, co, vl, wr, cl) {
    var x1 = confirm('Are u sure want to delete this Category 1 ? ');
    if (x1) {
        if (vl.trim() === "") {
//            alert('Entered Category 1 Name Empty');
        } else {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory1(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory1('se', '1', '*', '0', '0', '0');
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    ;
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        }
    } else {
    }
}


function adminCategory2(data, cbf) {
//    alert(data);
    if (window.XMLHttpRequest) {
        xmlhttpo = new XMLHttpRequest();
    } else {
        xmlhttpo = new ActiveXObject();
    }
    xmlhttpo.onreadystatechange = cbf;
    xmlhttpo.open('POST', '../../Category2S', true);
    xmlhttpo.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlhttpo.send(data);
}
function searchCategory2(qu, pt, co, vl, wr, cl) {

    document.getElementById('hid01i').value = cl;
    document.getElementById('txf03i').disabled = false;
    document.getElementById('add03i').disabled = false;

    if (pt.trim() === "" || co.trim() === "") {
    } else {
        var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
        adminCategory2(data, function () {
            if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                var v = xmlhttpo.responseText;
                document.getElementById('tab03i').innerHTML = v;
                document.getElementById('tab04i').innerHTML = "";

            } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
            }
            x();
        }
        );
    }
}
function saveCategory2(qu, pt, co, vl, wr, cl) {
    if (vl.trim().split(',')[1] === "") {
        alert('Pleaase insert the Category 2');
    } else {
        var x1 = confirm('Are u sure want to save this Category 2 ? ');
        if (x1) {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory2(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory2('se', '1', '*', '0', co.split(",")[0], vl.split(",")[0].trim());
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    ;
                    document.getElementById('txf03i').value = "";
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        } else {
            document.getElementById('txf03i').value = "";
        }
    }
}
function updateCategory2(qu, pt, co, vl, wr, cl) {
    var x1 = confirm('Are u sure want to update this Category 2 ? ');
    if (x1) {
        vl = prompt("Plese insert the new Category 2 for update");
        if (vl.trim() === "") {
            alert('Entered Category 2 Name Empty');
        } else {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory2(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory2('se', '1', '*', '0', 'product_category1_idproduct_category1', document.getElementById('hid01i').value);
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        }
    } else {
    }
}
function deleteCategory2(qu, pt, co, vl, wr, cl) {
    var x1 = confirm('Are u sure want to delete this Category 2 ? ');
    if (x1) {
        if (vl.trim() === "") {
//            alert('Entered Category 1 Name Empty');
        } else {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory2(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory2('se', '1', '*', '0', 'product_category1_idproduct_category1', document.getElementById('hid01i').value);
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    ;
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        }
    } else {
    }
}


function adminCategory3(data, cbf) {
//    alert(url);
//    alert(data);
    if (window.XMLHttpRequest) {
        xmlhttpo = new XMLHttpRequest();
    } else {
        xmlhttpo = new ActiveXObject();
    }
    xmlhttpo.onreadystatechange = cbf;
    xmlhttpo.open('POST', '../../Category3S', true);
    xmlhttpo.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlhttpo.send(data);
}
function searchCategory3(qu, pt, co, vl, wr, cl) {
    document.getElementById('hid02i').value = cl;
    document.getElementById('txf04i').disabled = false;
    document.getElementById('add04i').disabled = false;

    if (pt.trim() === "" || co.trim() === "") {
    } else {
        var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
        adminCategory3(data, function () {
            if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                var v = xmlhttpo.responseText;
                document.getElementById('tab04i').innerHTML = v;
                x();
            } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
            }
        }
        );
    }
}
function saveCategory3(qu, pt, co, vl, wr, cl) {
    if (vl.trim().split(',')[1] === "") {
        alert('Pleaase insert the Category 3');
    } else {
        var x1 = confirm('Are u sure want to save this Category 3 ? ');
        if (x1) {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory3(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory3('se', '1', '*', '0', co.split(",")[0], vl.split(",")[0].trim());
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                    document.getElementById('txf04i').value = "";
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        } else {
            document.getElementById('txf04i').value = "";
        }
    }
}
function updateCategory3(qu, pt, co, vl, wr, cl) {
    var x1 = confirm('Are u sure want to update this Category 3 ? ');
    if (x1) {
        vl = prompt("Plese insert the new Category 3 for update");
        if (vl.trim() === "") {
            alert('Entered Category 3 Name Empty');
        } else {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory3(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory3('se', '1', '*', '0', 'product_category2_idproduct_category2', document.getElementById('hid02i').value);
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        }
    } else {
    }
}
function deleteCategory3(qu, pt, co, vl, wr, cl) {
    var x1 = confirm('Are u sure want to delete this Category 3 ? ');
    if (x1) {
        if (vl.trim() === "") {
//            alert('Entered Category 3 Name Empty');
        } else {
            var data = "qu=" + qu + "&pt=" + pt + "&co=" + co + "&vl=" + vl + "&wr=" + wr + "&cl=" + cl;
            adminCategory3(data, function () {
                if (xmlhttpo.readyState === 4 && xmlhttpo.status === 200) {
                    var msg = xmlhttpo.responseText;
                    searchCategory3('se', '1', '*', '0', 'product_category2_idproduct_category2', document.getElementById('hid02i').value);
                    if (msg.trim() === "") {
                    } else {
                        alert(msg);
                    }
                } else {
//                            alert("1_" + xmlhttpo.readyState);
//                            alert("2_" + xmlhttpo.status);
                }
            }
            );
        }
    } else {
    }
}

function x() {
    $("table tbody tr ").click(function () {
        $(this).addClass('selected').siblings().removeClass("selected");

    });
}