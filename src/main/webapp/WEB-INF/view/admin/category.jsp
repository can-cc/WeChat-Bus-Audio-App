<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AudioCategory</title>
</head>
<body>

<table>
    <c:forEach items="${categoryList}" var="category" varStatus="vs">  
            <tr>  
                 <td>${vs.index+1}</td>  
                 <td align = "center">专辑名称： <a href="/admin/showCategory?categoryId=${category.getCategoryId()}&categoryName=${category.getName()}">${category.getName()}</a></td>  
                 <td align = "center">专辑编号：${category.getCategoryId()}</td>  
                 <td align = "center">描述：${category.getDescription()}</td> 
                 <td align = "center">创建日期：${category.getCreateDate()}</td>  
                 <td align = "center">修改日期：${category.getModifiedDate()}</td>    
             </tr>  
    </c:forEach>  
</table>

</body>
</html>