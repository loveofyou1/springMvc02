<%--
  Created by IntelliJ IDEA.
  User: sunlei19
  Date: 2018/6/7
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="/js/jquery-3.3.1.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<button id="showText" type="button" onclick="showJson()" value="显示json">显示json</button>
<div id="jsonText">request:${requestScope.jsonText}</div>
</body>
</html>

<script type="text/javascript">

    function showJson() {
        window.location.href = '/showJson.do';
    }


</script>
