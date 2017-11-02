<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#sub_btn").click(function(){
			var username = $("[name  = username]").val();
			var password = $("[name = password]").val();
			
			 //创建用户正则表达式,检查用户名格式是否正确
			var name = /^[a-z0-9_-]{3,16}$/;
			if(!name.test(username)){
				alert("用户名输入有误,长度必须为3-16位的用户名");
				return false;
				
			}
			//检查密码格式是否有误
			var word = /^[A-Za-z0-9_-]{3,16}$/;
			if(!word.test(password)){
				alert("密码输入有误,请输入包含字母，数字，下划线，减号，3-16位的密码");
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
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<!-- <span class="errorMsg">请输入用户名和密码</span> -->
								<%-- <span class="errorMsg"><%=request.getAttribute("msg")==null?"请您输入用户名和密码":
									request.getAttribute("msg")%> --%>
								<span class="errorMsg">${msg==null?"请输入用户名和密码":msg}
								</span>
							</div>
							<div class="form">
								<form action="client/UserServlet?method=login" method="post">
									<label>用户名称：</label>
									<%-- <input value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" /> --%>
									<input value="${param.username }" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
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