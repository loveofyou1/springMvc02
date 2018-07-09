<%--
  Created by IntelliJ IDEA.
  User: sunlei19
  Date: 2018/6/6
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="/js/jquery-3.3.1.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<form id="fileForm" enctype="multipart/form-data" method="post" >
    <input type="file" name="file"/>
    <input id="submit" type="button" value="提交">
</form>
</body>
</html>
<script>
    $("#submit").click(function(){
        var formdata = new FormData(document.getElementById("fileForm"));
        $.ajax({
            url:"/submitFile.do",
            type:"post",
            data:formdata,
            contentType:false, //- 必须false才会自动加上正确的Content-Type
            processData: false, //- 必须false才会避开jQuery对 formdata 的默认处理,XMLHttpRequest会对 formdata 进行正确的处理
            success:function(message){
                alert("ok");
            },
            error:function(){
                alert("fail");
            }
        });
    });
</script>
