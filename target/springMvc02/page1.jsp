<%--
  Created by IntelliJ IDEA.
  User: sunlei19
  Date: 2018/2/23
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script src="/js/jquery-3.3.1.js"></script>
<head>
    <title>pageOne</title>
</head>
<body>
<h6>page 1!</h6>

<form id="userForm" method="get">
    <label>姓名：</label><textarea name="userName" cols="10" rows="2"></textarea>
    <br>
    <label>年纪：</label><input name="age" type="text"/>
    <br>
    <label>密码：</label><input name="password" type="password"/>
    <br>
    <input type="button" onclick="submitName()" value="提交">
</form>
</body>
</html>

<script>
    function submitName() {
        var formdata = $("#userForm").serialize();
        $.ajax({
            type: "GET",
            url: "/testAction",
            data: formdata,
            success: function (msg) {
                alert(msg);
            },
            error: function () {
                alert("error");
            }
        });
    }

</script>
