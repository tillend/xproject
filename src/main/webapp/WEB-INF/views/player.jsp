<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>直播平台</title>
<script type="text/javascript">
<!--
function getLight(pars){if(pars=="open"){close_light(this)}else{close_light(this)}};function thisMovie(movieName){if(navigator.appName.indexOf("Microsoft")!=-1){return window[movieName]}else{return document[movieName]}}
//-->
</script>

<style type="text/css">
<!--
.video { OVERFLOW: hidden; WIDTH: 100%; POSITION: relative}
.close_light_bg {DISPLAY: none; BACKGROUND: #000; FILTER: alpha(opacity = 95); LEFT: 0px; WIDTH: 100%; POSITION: absolute; TOP: 0px; HEIGHT: 100%; opacity: .95}

body { padding:10px;}
div.help { line-height:32px; font-size:14px;}
-->
</style>
</head>

<body> 
<div class="close_light_bg" id="close_light_bg"></div>
<!--极酷阳光播放器/代码开始-->
<script type="text/javascript" src="styles/js/swfobject.js"></script>
<div class="video" id="CuPlayer"><b><img src="images/loading.gif"  /> 网页视频播放器加载中，请稍后...<a href="http://www.cuplayer.com/cuplayer" target="_blank">点此升级&gt;&gt;</a></b></div>
<script type="text/javascript">
var so = new SWFObject("styles/xml/player.swf","myCuPlayer","700","410","9","#000000");
so.addParam("allowfullscreen","true");
so.addParam("allowscriptaccess","always");
so.addParam("wmode","opaque");
so.addParam("quality","high");
so.addParam("salign","lt");
//播放器设置文件-----------------------------
so.addVariable("JcScpFile","CuSunV2setLive.xml"); //配置文件
//视频文件及略缩图--------------------------
/* 以下这行仅为rtmp直播时写法示例，直播信号是关的，请对应换成你自己的直播流使用 */
so.addVariable("JcScpServer","rtmp://localhost/live"); //流媒体服务器
so.addVariable("JcScpVideoPath","changeme"); //直播流名称

so.addVariable("JcScpAutoPlay","yes"); //是否自动播放
so.addVariable("JcScpImg","images/startpic.jpg"); //视频缩略图
//-----------------------------------------
so.addVariable("JcScpSharetitle","直播演示实例"); //视频标题
so.write("CuPlayer");
</script>
<script language=javascript src="styles/js/jquery-1.4.2.min.js" type=text/javascript></script> 
<script language=javascript src="styles/js/action.js" type=text/javascript></script>
<!--极酷阳光播放器/代码结束-->


<!-- help/End -->
<div style="display:none;">
<script type="text/javascript" src="http://www.cuplayer.com/CuPlayer/js/stat.js"></script>
</div>
</body>
</html>

