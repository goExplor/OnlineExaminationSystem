<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <title>upload</title>
 <link rel="stylesheet" href="css/demo.css" rel="external nofollow" >
</head>
<body>
 <!--遮罩-->
 <div class="overlay"></div>
 <!--模态框-->
 <div id="modal" class="dropbox">
  <div class="items-container">
   <div id="close" style="cursor:pointer;float: right;width:20px">
    <span class="css-close"></span>
   </div>
   <div>
    <p class="head"><b>拖拽文件至此</b></p>
    <div class="content" id="content">
     <table class="table">
      <tbody class="tbody"></tbody>
     </table>
    </div>
    <div class="footer">
     <button class="btn" onclick="upload()">开始上传</button>
    </div>
    <a href='#' onclick='clearAll()' style='position:absolute;bottom:10px;right:30px;'>删除</a>
   </div>
  </div>
 </div>
 <!--页面内容-->
 <div style="margin-top:40vh;text-align: center;">
  <p>拖拽上传演示模板。点击下方按钮，弹出模态框</p>
  <button class="btn" onclick="showModal()">点击上传</button>
 </div>
 <!--嵌入脚本-->
 <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
 <script src="js/demo.js" type="text/javascript"></script>
</body>
</html>