<%--
  Created by IntelliJ IDEA.
  User: sunlei19
  Date: 2018/7/9
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery-3.3.1.js"></script>
<html>
<head>
    <title>查询界面</title>
</head>
<body>
<form>
    <button type="button" id="query" value="查询">查询</button>
</form>
</body>
</html>
<script>
    $('#query').click(function () {
        $.ajax({
            url:"/page5Query.do",
            method: "get",
            success: function (message) {
                alert(message);
            },
            error: function () {
                alert("fail");
            }
        });
    });
</script>
