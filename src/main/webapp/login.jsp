<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>欢迎登陆</title>
    <link href="${pageContext.request.contextPath }/statics/css/login.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/login.js"></script>
</head>
<body>
<div class="main">
    <p class="title">欢迎使用工大学生综合平台</p>
    <p><input class="text" type="text" id="userName" placeholder="用户名"/><span class="sp">√</span></p>
    <p><input class="text" type="password" id="password" placeholder="密码"/><span class="sp">√</span></p>
    <p class="pp"><input type="text" id="yanzm" placeholder="验证码"/>
        <img id="captcha_img" alt="点击更换" title="点击更换"
             onclick="changeVerifyCode(this)" src="${pageContext.request.contextPath }/Kaptcha"/>
    </p>
    <p><input id="img" type="button" value="登录"/></p>
    <p class="p1">还没有账号吗？<a href="register.jsp">立即注册</a><input type="checkbox" id="box" class="box"/><label for="box">我是管理员</label></p>
</div>
</body>
</html>
