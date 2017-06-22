<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<c:out value="${pageContext.request.contextPath}"></c:out>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>这是Index页面</title>
</head>
<body>
    <h3>控制器访问</h3>
    <br>
    <a href="/SpringMVCTest/loginIndex">请点击此超链接进入 登录界面loginIndex</a>
    <br>
    <br>
    <a href="/SpringMVCTest/helloworld">请点击此超链接helloworld</a>
    <br>
    <br>
    <a href="/SpringMVCTest/hello">请点击此超链接hello</a>
    <br>
    <h3>同目录下</h3>
    <br>
    <a href="nihao.jsp">请点击此超链接nihao.jsp</a>
    <br>
    <a href="success.jsp">请点击此超链接success.jsp</a>
    <br>
    <a href="web/default.html">请点击此超链接default.html</a>
    <br>
    <h3>目录：WEB-INF/views/</h3>
    <br>
    <a href="webinf/views/loginSeccess.jsp">请点击此超链接/WEB-INF/views/loginSeccess.jsp</a>
    <br>
    <a href="webinf/views/VDefault.html">请点击此超链接WEB-INF/views/VDefault.html</a>
    <br>
    <a href="web/WEB-INF/views/VDefault.html">请点击此超链接WEB-INF/views/VDefault.html</a>
    <br>
    <button onclick="action()">${ctx}按钮1</button>
    <br>
</body>
<script>
    function action() {
        var d = "${ctx}" + "${pageContext.request.contextPath}";
        alert(d);
    }
</script>
</html>