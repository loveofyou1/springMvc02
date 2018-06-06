<%--
  Created by IntelliJ IDEA.
  User: sunlei19
  Date: 2018/6/6
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="fileForm" enctype="multipart/form-data" action="/submitFile.do">
    <text type="file" name="file">导入文件</text>
    <input id="submit" type="submit" value="提交"/>
</form>
</body>
</html>
