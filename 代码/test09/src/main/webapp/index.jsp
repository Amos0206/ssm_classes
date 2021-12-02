<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/index">登录</a>
<br>
<a href="${pageContext.request.contextPath}/item/index">商品管理</a>
<br>
<a href="${pageContext.request.contextPath}/toEditUser">测试批量修改数据</a>
<br>
<a href="${pageContext.request.contextPath}/toUpload">图片上传</a>
</body>
</html>