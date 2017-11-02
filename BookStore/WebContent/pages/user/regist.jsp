<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>

<script type="text/javascript">
	$(function(){
		//为注册按钮绑定单击响应函数
		$("#sub_btn").click(function(){
			var username = $("[name = username]").val();
			var password = $("[name = password]").val();
			var repwd = $("[name = repwd]").val();
			var email = $("[name = email]").val();
			var code = $("[name = code]").val();
			
			 //创建用户正则表达式
			var name = /^[a-z0-9_-]{3,16}$/;
			if(!name.test(username)){
				alert("用户名输入有误,长度必须为3-16位的用户名");
				return false;
			}
			//检查用户名格式是否有误
			var word = /^[A-Za-z0-9_-]{3,16}$/;
			if(!word.test(password)){
				alert("密码输入有误,请输入包含字母，数字，下划线，减号，3-16位的密码");
				return false;
			}
			//确认密码	
			if(repwd != password){
				alert("确认密码输入有误，请重新修改输入");
				return false;
			}
			//检查邮箱输入是否有误
			var eml = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!eml.test(email)){
				alert("邮箱格式有误");
				return false;
			}
			//检查验证码是否为空
			if(code ==""){
				alert("验证码输入为空");
				return false;
			}  
		 	
			if(username == password){
				alert("用户名和密码一样，请修改，防止被盗风险！！");
				return false;
			}
			 
			
			
			
		});
	});












</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		<%@ include file="/WEB-INF/include/user-info.jsp" %>
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
					
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<%-- <span class="errorMsg" ><%=request.getAttribute("error")==null?"欢迎注册!":request.getAttribute("error") %></span> --%>
								<span class="errorMsg" >${error==null?"欢迎注册":error}</span>
							</div>
							<div class="form">
								<form action="client/UserServlet?method=regist" method="post">
									<label>用户名称：</label>
									<%-- <input value="<%=request.getParameter("username")==null?"":request.getParameter("username") %>" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" /> --%>
									<input value="${param.username }" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<%-- <input value="<%=request.getParameter("email")==null?"":request.getParameter("email") %>"class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" /> --%>
									<input value="${param.email }"class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>