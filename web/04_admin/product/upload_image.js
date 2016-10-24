/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getFileName() {

    var filename = document.getElementById('selectFile').value;
    var f = filename.split('\\');
    document.getElementById('fileName').value = f[f.length - 1];

    var a = document.getElementById('selectFile').files;
    for (var i = 0; i < a.length; i++) {
        alert(a[i].name + " -- " + ((a[i].size / 1024) / 1024).toFixed(2) + ' MB');
    }
}

function readURL(input) {

//    alert(input.nodeName);
//    getFileName();

    var c = 0;

    for (var i = 0; i < input.files.length; i++) {

       
        if (input.files[i] !== null) {

            var reader = new FileReader();

            reader.onload = function (e) {
                var elem = document.createElement('img');
                elem.setAttribute('id', c);
                elem.setAttribute('class', 'myimgs');
                elem.setAttribute('src', e.target.result);
//                elem.setAttribute('height', '100');
                elem.setAttribute('width', '130');
                elem.setAttribute('onclick', 'deleteimage(' + c + ')');

                document.getElementById('myimg').appendChild(elem);
                c++;
            };
            reader.readAsDataURL(input.files[i]);
        }
    }

}

function deleteimage(a) {

    $('#' + a).remove();

    //    var x = document.getElementById('myimg');
    //     var s = document.getElementById(a);
    //     x.removeChild(s); 
}

