// -----------------------------------------------------------------------------------
// http://wowslider.com/
// JavaScript Wow Slider is a free software that helps you easily generate delicious 
// slideshows with gorgeous transition effects, in a few clicks without writing a single line of code.
// Generated by WOW Slider 7.0
//
//***********************************************
// Obfuscated by Javascript Obfuscator
// http://javascript-source.com
//***********************************************
function ws_basic_linear(i,g,a){var c=jQuery;var f=c(this);var b=c("<div>").addClass("ws_effect ws_basic_linear").css({position:"absolute",display:"none","z-index":2,width:"200%",height:"100%",transform:"translate3d(0,0,0)"}).appendTo(a);var h=c("<div>").css({position:"absolute",left:"auto",top:"auto",width:"50%",height:"100%",overflow:"hidden"}),d=h.clone();b.append(h,d);function e(m,j,k,l){if(i.support.transform&&i.support.transition){if(j.right){j.left=-j.right;delete j.right}j.transform="translate3d("+j.left+"px,0,0)";delete j.left;j.transition="all "+k+"ms cubic-bezier(0.770, 0.000, 0.175, 1.000)";m.css(j);if(l){m.on("transitionend webkitTransitionEnd oTransitionEnd MSTransitionEnd",function(){m.css({transform:"",transition:""});m.off("transitionend webkitTransitionEnd oTransitionEnd MSTransitionEnd");l()})}}else{m.animate(j,{easing:"easeInOutExpo",duration:i.duration,complete:l?l:0})}}this.go=function(j,m,k){b.stop(1,1);if(k==undefined){k=(!!((j-m+1)%g.length)^i.revers?"left":"right")}else{k=k?"left":"right"}c(g[m]).clone().appendTo(h).css(k,0);c(g[j]).clone().appendTo(d).show();if(k=="right"){h.css("left","50%");d.css("left",0)}else{h.css("left",0);d.css("left","50%")}b.css({left:"auto",right:"auto",top:0}).css(k,0).show();var l={};l[k]=-a.width();e(b,l,i.duration,function(){f.trigger("effectEnd");b.hide().find("div").html("")})}};// -----------------------------------------------------------------------------------
// http://wowslider.com/
// JavaScript Wow Slider is a free software that helps you easily generate delicious 
// slideshows with gorgeous transition effects, in a few clicks without writing a single line of code.
// Generated by WOW Slider 7.0
//
//***********************************************
// Obfuscated by Javascript Obfuscator
// http://javascript-source.com
//***********************************************
jQuery("#wowslider-container1").wowSlider({effect:"basic_linear",prev:"",next:"",duration:20*100,delay:20*100,width:1200,height:400,autoPlay:true,autoPlayVideo:false,playPause:true,stopOnHover:false,loop:false,bullets:1,caption:true,captionEffect:"parallax",controls:true,responsive:1,fullScreen:false,gestures:2,onBeforeStep:0,images:0});