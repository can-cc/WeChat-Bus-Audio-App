<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专辑详情</title>
</head>
<body>
	<table>
		<tr>
			<td>专辑：${categoryName}</td>
		</tr>
	</table>
	<table>
		<c:forEach items="${audioList}" var="audio" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td align="center">音频名称： <a
					href="/static/AudioMp3/${categoryName}/${audio.getFilename()}">${audio.getName()}</a></td>
				<td align="center">播放时间：${audio.getPlaytime()}</td>
				<td align="center">比特率：${audio.getBitrate()}</td>
				<td align="center">创建日期：${audio.getCreateDate()}</td>
				<td align="center">修改日期：${audio.getModifiedDate()}</td>
				<td align="center">描述：${audio.getDescription()}</td>
			</tr>
		</c:forEach>
		<table>
			<tr>
				<td><a href="/admin/addAudio?categoryId=${categoryId}&categoryName=${categoryName}"> 添加音频 </a></td>
			</tr>
		</table>
		<table>
		</table>
</body>
</html>