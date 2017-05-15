<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>注册</title>
        <link rel="icon" type="image/png" href="styles/images/favicon.png">
		<link rel="shortcut icon" type="image/png" href="styles/images/favicon.png"/>

        <!-- CSS -->
        <link rel="stylesheet" href="styles/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/css/font-awesome.min.css">
		<link rel="stylesheet" href="styles/css/form-elements.css">
		<link rel="stylesheet" href="styles/css/common.css">
        <link rel="stylesheet" href="styles/css/login.css">
        <link rel="stylesheet" href="styles/css/list.css">
        
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
    
    <script type="text/javascript">
        function signup() {
			var registerReqVO = new Object();
			registerReqVO.userName = $("#form-username").val();
			registerReqVO.password = $("#form-password").val();    
			registerReqVO.password2 = $("#form-password2").val(); 
        	
            $.ajax({
                url: '/xproject/user/register',
                type: 'POST',
                contentType: 'application/json;charset=utf-8', //设置请求头信息
                async: false,
                dataType: 'json',
                data: JSON.stringify(registerReqVO),    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
                success : function (r) {
                        //alert(r.data);   
                        var data = r.data;
                        //$("#form-username").attr("value", data.result);
                        var code = r.code;
                        
                        
                        if(code == 0){
                        	alert('注册成功');
                        	window.location.href = '/xproject/index';
                        }else if(code == 402){
                        	alert(r.subMsg);
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

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h2>注册账号</h2>
                            		<h4>
                            			<a href="/xproject/login">登录</a><b> | </b>
                            			<a href="/xproject/sign_up">注册</a>
                            		</h4>
                                    
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">用户名</label>
			                        	<input type="text" name="form-username" placeholder="用户名" class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">密码</label>
			                        	<input type="password" name="form-password" placeholder="密码" class="form-password form-control" id="form-password">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password2">再次输入密码</label>
			                        	<input type="password" name="form-password2" placeholder="再次输入密码" class="form-password form-control" id="form-password2">
			                        </div>
			                        <button type="submit" class="btn" onclick="signup()">注册</button>
		                    </div>
                        </div>
                    </div>

                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="styles/js/jquery.min.js"></script>
        <script src="styles/js/bootstrap.min.js"></script>
        <script src="styles/js/jquery.backstretch.min.js"></script>
        <script src="styles/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>
</html>