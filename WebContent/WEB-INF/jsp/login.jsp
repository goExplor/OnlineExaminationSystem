<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>登录界面</title>
    <style>
    </style>
</head>
<body>
  <form action='<c:url value="/indexss.action"></c:url>' method="post"> 
    <div class="dowebok">
        
        <div class="form-item">
            <input id="username" type="text" autocomplete="off" placeholder="用户名" name="uname">
        </div>
        <div class="form-item">
            <input id="password" type="password" autocomplete="off" placeholder="pwd" name="upwd">
        </div>
        <div class="form-item"><button id="submit">登 录</button></div>
        <div class="reg-bar">
            <a class="forget" href='<c:url value="/prelist.action"></c:url>'>返回主页</a>
        </div>
    </div>
   </form>
    <script src="images/jquery.min.js"></script>
   



</body>
</html>