<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addCategory</title>
</head>
<body>

	<form action="/admin/addCategory" method="post">
		专辑名称：<input type="text" name="name"><br>
		描述：<input type="text" name="description"><br>
		<input type="submit" value="注册"><input type="reset" value="重置">
	</form>
	<!--表单结束-->

</body>
</html>