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

    <!-- CSS -->
    <link href="styles/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles/css/common.css" rel="stylesheet">
    <link href="styles/css/navbar-fixed-top.css" rel="stylesheet">
    
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
            <li class="active"><a href="/xproject">首页</a></li>
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
            <li><a href="/xproject/login">登录</a></li>
            <li><a href="#" onclick="logout()">注销</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container" stlye="background-image:url(<%=basePath %>styles/images/bg.jpg);">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h2>基于流媒体技术的Web平台视频直播系统</h2>
        <p>　　视频直播是指利用互联网及流媒体技术进行直播，视频因融合了图像、文字、声音等丰富元素，声形并茂，效果极佳，逐渐成为互联网的主流表达方式。随时互联网络技术的发展，网络视频直播倍受关注，视频直播也让网络变得不再虚拟，更具现实也更贴近生活。在此背景下，结合流媒体技术，研发一个视频直播网站，具有一定的理论意义和实际价值。</p>
      </div>
      
  		      <div class="jumbotron">
<table class="table">
<tr>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
</tr>

<tr>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
<td><a href="/xproject/play"><img src="<%=path %>/styles/images/test.jpg" class="img-responsive" height="150px" width="180px" ></a></td>
</tr>

</table>
      </div>
	</div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./styles/js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="./styles/js/jquery.min.js"><\/script>')</script>
    <script src="./styles/js/bootstrap.min.js"></script>
  </body>
</html>
