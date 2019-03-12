<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>上传界面</title>
    <style>
    	.textmask{ 
			border:1px solid #cdcdcd; 
			height:24px;
			width:200px;
		} 
		.file{ 
			position:absolute; 
			top:0; 
			right:80px; 
			height:24px; 
			filter:alpha(opacity:0);
			opacity: 0;
			width:260px 
		} 
		.btnupload{
			margin-top: 10px;
		}
    </style>
</head>
<body>
					<div class="fileloader">
					<h3 class="filetitle">教案上传</h3>
					<form id="form1" enctype="multipart/form-data" method="post" action="Upload.aspx">
						<div class="filebox">
							<input type="text" name="textmask" id="testmask" class="testmask" placeholder="点击选择文件">
							<input type="file" name="fileToUpload" id="fileToUpload" onchange="fileSelected();" >
						</div>
						<div id="fileName"></div>
						<div id="fileSize"></div>
						<div id="fileType"></div>
						<div class="filebox">
							<input type="button" class="btnupload btn btn-danger btn-block" onclick="uploadFile()" value="点击上传" />
						</div>
						<div id="progressNumber"></div>
					</form>
				</div>   
	<script type="text/javascript">
		function fileSelected() {
			var file = document.getElementById('fileToUpload').files[0];
			if(file) {
				var fileSize = 0;
				if(file.size > 1024 * 1024)
					fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
				else
					fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
				document.getElementById('fileName').innerHTML = '文件名: ' + file.name;
				document.getElementById('fileSize').innerHTML = '文件大小: ' + fileSize;
			}
		}

		function uploadFile() {
			var checklogin = $('.checklogin').text();
			if(checklogin != "NO") {
				var fd = new FormData();
				fd.append(接口要求属性名称, document.getElementById('fileToUpload').files[0]);
				var xhr = new XMLHttpRequest();
				xhr.upload.addEventListener("progress", uploadProgress, false);
				xhr.addEventListener("load", uploadComplete, false);
				xhr.addEventListener("error", uploadFailed, false);
				xhr.addEventListener("abort", uploadCanceled, false);
				xhr.open("POST", 后台接口);
				xhr.send(fd);
			} else {
				swal({   
					title: "请先登录",   
					text: "",   
					type: "warning",
					showCancelButton: true,   
					confirmButtonColor: "#DD6B55",   
					confirmButtonText: "现在就登录",   
					cancelButtonText: "等下登录",   
					closeOnConfirm: true,   
					closeOnCancel: true }, 
					function(isConfirm){   
						if (isConfirm) {     
							$('.nav-login').click();   
						} 
				});
			}
		}

		function uploadProgress(evt) {
			if(evt.lengthComputable) {
				var percentComplete = Math.round(evt.loaded * 100 / evt.total);
				document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
			} else {
				document.getElementById('progressNumber').innerHTML = '传输失败';
			}
		}

		function uploadComplete(evt) {
			/* 服务器端返回响应时候触发event事件*/
			alert(evt.target.responseText);
		}

		function uploadFailed(evt) {
			swal({title:"传输过程出现错误",text:"",type:"warning"});
		}

		function uploadCanceled(evt) {
			swal({title:"传输已取消",text:"",type:"warning"});
		}
	</script>
</body>
</html>


		