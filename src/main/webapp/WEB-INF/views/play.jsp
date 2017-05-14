<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" href="styles/images/favicon.png">
	<link rel="shortcut icon" type="image/png" href="styles/images/favicon.png"/>

    <title>直播平台</title>

    <!-- Bootstrap core CSS -->
    <link href="styles/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="styles/css/navbar-fixed-top.css" rel="stylesheet">
    <link href="styles/css/common.css" rel="stylesheet">
    <link href="styles/css/room.css" rel="stylesheet">
    <link href="styles/css/list.css" rel="stylesheet">
    
    <script type="text/javascript" src="styles/js/swfobject.js"></script>

    </script>
    
             <script type="text/javascript">
        function logout() {
            $.ajax({
                url: '/xproject/user/logout',
                type: 'POST',
                contentType: 'application/json;charset=utf-8', //设置请求头信息
                async: false,
                dataType: 'json',
                success : function (r) {
                        //alert(r.data);   
                        var data = r.data;
                        //$("#form-username").attr("value", data.result);
                        var code = r.code;
                        
                        
                        if(code == 0){
                        	alert('注销成功');
                        	window.location.href = '/xproject/index';
                        }else if(code == 402){
                        	alert('系统错误');
                        }else if(code == 405){
                        	alert('请登录');
                        	window.location.href = '/xproject/login';
                        }
                	
                },
                error: function(){
                    alert('Error');
                }
            });
            //handleData(data); 
            
        }

    </script>
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">希声</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="/xproject">首页</a></li>
            <li><a href="#about">热门</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">分类<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">蜘蛛纸牌</a></li>
                <li><a href="#">英雄联盟</a></li>
                <li><a href="#">王者荣耀</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">导航</li>
                <li><a href="#">分链接</a></li>
                <li><a href="#">分链接</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/xproject/star">关注</a></li>
            <li class="active"><a href="/xproject/login">登录<span class="sr-only">(current)</span></a></li>
            <li><a href="#" onclick="logout()">注销</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container" style="height: 700px">
    	
    	<!-- 房间左侧 -->
    	<div class="room-left fl">
    		<!-- 主播信息 -->
    		<div class="room-mes">
    			<div class="archor-pic fl">
    				<img class="img-rounded header-pic" alt="主播头像" src="styles/images/archor-pic.jpg">
    			</div>
    			
    			<div class="relate-text fl">
    				<div class="room-title">
    					<h3 name="title">啦啦啦啦啦啦</h3>
    				</div>
    				<div class="room-type">
    					<h5 name="type">英雄联盟</h5>
    				</div>
    				<div class="">
    					<ul class="info-list list-inline">
    						<li><h5 name="archor-name">王重阳</h5></li>
    						<li><h5 name="wacther-num">80000</h5></li>
    						<li><h5 name="present-num">111t</h5></li>
    					</ul>
    				</div>
    			</div>
    			
    			<div class="star fr">
    				<a class="btn btn-default" href="#" role="button">关注</a>
    				<a class="btn btn-default" href="#">100000</a>
    			</div>
    		</div>
    		
    		<!-- 播放器 -->
    		<div>
    			<div class="close_light_bg" id="close_light_bg"></div>

				<div class="video" id="CuPlayer">
					<b><img src="images/loading.gif" />网页视频播放器加载中，请稍后...&gt;&gt;</a></b>
				</div>
    		</div>
    		
    		<!--礼物 -->
    	</div>
    	
    	
    	<!-- 房间右侧 -->
    	<div class="room-right fr">
    		<div class="well">弹幕区</div>	
    	</div>
    
    

	</div> <!-- /container -->



<script type="text/javascript">
	var so = new SWFObject("styles/xml/player.swf","myCuPlayer","700","410","9","#000000");
	so.addParam("allowfullscreen","true");
	so.addParam("allowscriptaccess","always");
	so.addParam("wmode","opaque");
	so.addParam("quality","high");
	so.addParam("salign","lt");
	//播放器设置文件-----------------------------
	so.addVariable("JcScpFile","styles/xml/CuSunV2setLive.xml"); //配置文件
	//视频文件及略缩图--------------------------
	/* 以下这行仅为rtmp直播时写法示例，直播信号是关的，请对应换成你自己的直播流使用 */
	so.addVariable("JcScpServer","rtmp://localhost/live"); //流媒体服务器
	so.addVariable("JcScpVideoPath","changeme"); //直播流名称

	so.addVariable("JcScpAutoPlay","yes"); //是否自动播放
	so.addVariable("JcScpImg","styles/images/startpic.jpg"); //视频缩略图
	//-----------------------------------------
	so.addVariable("JcScpSharetitle","直播演示实例"); //视频标题
	so.write("CuPlayer");
</script>
<script language=javascript src="styles/js/jquery-1.4.2.min.js" type=text/javascript></script> 
<script language=javascript src="styles/js/action.js" type=text/javascript></script>
	


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./styles/js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="./styles/js/jquery.min.js"><\/script>')</script>
    <script src="./styles/js/bootstrap.min.js"></script>
    <div style="display:none;">
<script type="text/javascript" src="http://www.cuplayer.com/CuPlayer/js/stat.js"></script>
</div>
  </body>
</html>
