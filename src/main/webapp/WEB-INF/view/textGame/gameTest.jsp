<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Text Game Web Test Page</title>
</head>
<body>
pid<br>
<input id="uid" type="number"><br>
command<br>
<input id="command" type="text"><br>
<button id="click">Go</button><br>
<input id="response" type="text" readOnly="readonly" style="height:250px;">
</body>

<script src="../static/script/jquery/jquery-2.1.1.min.js" type="text/javascript"></script> 

<script type="text/javascript">
$(document).ready(function(){
	  $("#click").click(function(){
	  var pid = $("#uid").val();
	  var command = $("#command").val();
	  $.post("/testGame",
			  {
			    pid:pid,
			    command:command
			  },
			  function(data,status){
				  $("#response").val(data);
			  });
	  });
	});
</script>
</html>