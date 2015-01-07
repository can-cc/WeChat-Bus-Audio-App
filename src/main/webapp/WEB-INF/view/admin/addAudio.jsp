<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="../static/script/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>  

${script}

<body>
<h1>往专辑·${categoryName}·中添加音频</h1>
<form action="/admin/addAudio" method="post" enctype="multipart/form-data">
		<select name="categoryId" id="selector">
			<c:forEach items="${categoryList}" var="category" varStatus="vs">
				<option value="${category.getCategoryId()}" >${category.getName()}</option>
			</c:forEach>
		</select> 音频名称：<input type="text" name="name"><br>
		音频：<input type="file" name="audioFile"><br>
		描述：<input type="text" name="description"><br>
		<input type="submit" value="添加"><input type="reset" value="重置">
	</form>
       
</body>
</html>