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

    <title>直播平台-我的关注</title>

    <!-- Bootstrap core CSS -->
    <link href="styles/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="styles/css/navbar-fixed-top.css" rel="stylesheet">
    <link href="styles/css/common.css" rel="stylesheet">
    <link href="styles/css/list.css" rel="stylesheet">

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

  <body style="background-color: #F2F2F2">

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
            <li class="active"><a href="/xproject/star">关注<span class="sr-only">(current)</span></a></li>
            <li><a href="/xproject/login">登录</a></li>
            <li><a href="#" onclick="logout()">注销</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
		<div>
			<div style="float:left;display:inline"><strong>我的关注</strong></div>
			<div style="float:left">
				<ul class="list-inline">
　　					<li><a href="#" class="btn btn-primary btn-sm active" role="button">全部</a></li>
　　					<li><a href="#" class="btn btn-primary btn-sm" role="button">热门游戏</a></li>
　　					<li><a href="#" class="btn btn-primary btn-sm" role="button">移动游戏</a></li>
　　					<li><a href="#" class="btn btn-primary btn-sm" role="button">科技</a></li>
　　				</ul>
			</div>
		</div>
	</div> <!-- /container -->
	

		<div class="video-list-content">
				<ul class="video-list">
　　					<li>    
						<a class="follow-list-all" href="/xproject/play" target="_blank">
    						<span class="imgbox">
    							<b></b>
       				 			<img src="styles/images/test.jpg" width="283" height="163" class="thumb">
    						</span>
							<div class="mes">
        						<div class="mes-tit">
            						<h3 class="ellipsis" title="大司马：正方形打野创始人瓜皮讲师座谈会">大司马：正方形打野创始人瓜皮讲师座谈会</h3>
            						<span class="tag ellipsis">英雄联盟</span>
        						</div>
        						<p>
        							<span class="dy-name fl">芜湖大司马</span>
            						<span class="dy-num fr">47.1万</span>
         						</p>
    						</div>
    					</a>
    				</li>
    				
    				<li>    
						<a class="follow-list-all" href="/xproject/play" target="_blank">
    						<span class="imgbox">
    							<b></b>
       				 			<img src="styles/images/test.jpg" width="283" height="163" class="thumb">
    						</span>
							<div class="mes">
        						<div class="mes-tit">
            						<h3 class="ellipsis" title="大司马：正方形打野创始人瓜皮讲师座谈会">大司马：正方形打野创始人瓜皮讲师座谈会</h3>
            						<span class="tag ellipsis">英雄联盟</span>
        						</div>
        						<p>
        							<span class="dy-name fl">芜湖大司马</span>
            						<span class="dy-num fr">47.1万</span>
         						</p>
    						</div>
    					</a>
    				</li>
　　					<li>    
						<a class="follow-list-all" href="/xproject/play" target="_blank">
    						<span class="imgbox">
    							<b></b>
       				 			<img src="styles/images/test.jpg" width="283" height="163" class="thumb">
    						</span>
							<div class="mes">
        						<div class="mes-tit">
            						<h3 class="ellipsis" title="大司马：正方形打野创始人瓜皮讲师座谈会">大司马：正方形打野创始人瓜皮讲师座谈会</h3>
            						<span class="tag ellipsis">英雄联盟</span>
        						</div>
        						<p>
        							<span class="dy-name fl">芜湖大司马</span>
            						<span class="dy-num fr">47.1万</span>
         						</p>
    						</div>
    					</a>
    				</li>
    				
    				<li>    
						<a class="follow-list-all" href="/xproject/play" target="_blank">
    						<span class="imgbox">
    							<b></b>
       				 			<img src="styles/images/test.jpg" width="283" height="163" class="thumb">
    						</span>
							<div class="mes">
        						<div class="mes-tit">
            						<h3 class="ellipsis" title="大司马：正方形打野创始人瓜皮讲师座谈会">大司马：正方形打野创始人瓜皮讲师座谈会</h3>
            						<span class="tag ellipsis">英雄联盟</span>
        						</div>
        						<p>
        							<span class="dy-name fl">芜湖大司马</span>
            						<span class="dy-num fr">47.1万</span>
         						</p>
    						</div>
    					</a>
    				</li>
　　					<li>    
						<a class="follow-list-all" href="/xproject/play" target="_blank">
    						<span class="imgbox">
    							<b></b>
       				 			<img src="styles/images/test.jpg" width="283" height="163" class="thumb">
    						</span>
							<div class="mes">
        						<div class="mes-tit">
            						<h3 class="ellipsis" title="大司马：正方形打野创始人瓜皮讲师座谈会">大司马：正方形打野创始人瓜皮讲师座谈会</h3>
            						<span class="tag ellipsis">英雄联盟</span>
        						</div>
        						<p>
        							<span class="dy-name fl">芜湖大司马</span>
            						<span class="dy-num fr">47.1万</span>
         						</p>
    						</div>
    					</a>
    				</li>
    				
    				<li>    
						<a class="follow-list-all" href="/xproject/play" target="_blank">
    						<span class="imgbox">
    							<b></b>
       				 			<img src="styles/images/test.jpg" width="283" height="163" class="thumb">
    						</span>
							<div class="mes">
        						<div class="mes-tit">
            						<h3 class="ellipsis" title="大司马：正方形打野创始人瓜皮讲师座谈会">大司马：正方形打野创始人瓜皮讲师座谈会</h3>
            						<span class="tag ellipsis">英雄联盟</span>
        						</div>
        						<p>
        							<span class="dy-name fl">芜湖大司马</span>
            						<span class="dy-num fr">47.1万</span>
         						</p>
    						</div>
    					</a>
    				</li>
    				
　　					<li>    
						<a class="follow-list-all" href="/xproject/play" target="_blank">
    						<span class="imgbox">
    							<b></b>
       				 			<img src="styles/images/test.jpg" width="283" height="163" class="thumb">
    						</span>
							<div class="mes">
        						<div class="mes-tit">
            						<h3 class="ellipsis" title="大司马：正方形打野创始人瓜皮讲师座谈会">大司马：正方形打野创始人瓜皮讲师座谈会</h3>
            						<span class="tag ellipsis">英雄联盟</span>
        						</div>
        						<p>
        							<span class="dy-name fl">芜湖大司马</span>
            						<span class="dy-num fr">47.1万</span>
         						</p>
    						</div>
    					</a>
    				</li>
    				
    				<li>    
						<a class="follow-list-all" href="/xproject/play" target="_blank">
    						<span class="imgbox">
    							<b></b>
       				 			<img src="styles/images/test.jpg" width="283" height="163" class="thumb">
    						</span>
							<div class="mes">
        						<div class="mes-tit">
            						<h3 class="ellipsis" title="大司马：正方形打野创始人瓜皮讲师座谈会">大司马：正方形打野创始人瓜皮讲师座谈会</h3>
            						<span class="tag ellipsis">英雄联盟</span>
        						</div>
        						<p>
        							<span class="dy-name fl">芜湖大司马</span>
            						<span class="dy-num fr">47.1万</span>
         						</p>
    						</div>
    					</a>
    				</li>
　　				</ul>
		</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./styles/js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="./styles/js/jquery.min.js"><\/script>')</script>
    <script src="./styles/js/bootstrap.min.js"></script>
  </body>
</html>
