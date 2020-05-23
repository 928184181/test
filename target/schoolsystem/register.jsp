<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="${pageContext.request.contextPath }/statics/css/register.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/register.js"></script>
</head>
<body>
<div class="main">
    <p class="title">欢迎注册</p>
    <p><span class="sp1">已有账号?</span><a href="login.jsp">登录</a></p>
    <form action="login/register.do" method="post">
        <p><span class="sp2">长度为4-16个字符,允许数字、字母以及下划线</span></p>
        <p><span class="spf">用户名</span><input type="text" name="userCode" id="userCode" class="inp" maxlength="20"/></p>
        <p><span class="spf">昵&nbsp;&nbsp;称</span><input type="text" name="userName" id="userName" class="inp" maxlength="20"/></p>
        <p><span class="sp2">长度为4-16个字符,允许数字、字母以及下划线</span></p>
        <p><span class="spf">密&nbsp;&nbsp;码</span><input type="text" name="password" id="password" class="inp"/></p>
        <p><span class="spf">手&nbsp;&nbsp;机</span><input type="text" name="phone" id="phone" class="inp"/></p>
        <p><span class="spf">Q&nbsp;&nbsp;Q</span><input type="text" name="qq" id="qq" class="inp"/></p>
        <p><span class="spf">微&nbsp;&nbsp;信</span><input type="text" name="weixin" id="weixin" class="inp" maxlength="20"/></p>
        <p><span class="spf">校&nbsp;&nbsp;区</span>
            <select name="schoolId">
                <option value="1">北校区</option>
                <option value="2">南校区</option>
                <option value="3">葫芦岛校区</option>
            </select>
        </p>
        <p><input type="image" src="${pageContext.request.contextPath }/statics/sysimgs/zc.png" class="img"/></p>
    </form>

</div>
</body>
</html>