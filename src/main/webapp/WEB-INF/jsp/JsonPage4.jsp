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

<table>
    <tr>
        <td>
            1.文件上传:
            <button id="test" type="button" onclick="uploadFile()">选择文件</button>
        </td>
        <td>
            <label id="testL" onclick="uploadFile()"></label>
            <input id="file" type="file" onchange="uploadFile(this)" style="opacity:0" />
            <%--style="opacity:0"--%>
        </td>
        <td>
            <input id="filename" type="text"/>
            <input id="filesuffix" type="text"/>
            <input id="filetime" type="text"/>
        </td>
        <td>
            <button id="submit" type="submit">提交</button>
        </td>
    </tr>
</table>
</body>
</html>

<script type="text/javascript">
    $(function () {
        $('#testL').html('未选择文件');

    });

    function showJson() {
        window.location.href = '/showJson.do';
    }

    function uploadFile() {
        document.getElementById('file').click();
        $('#testL').html(getFileName($('#file').val()));
    }

    //获取文件名方式二
    function getFileName(file){//通过第二种方式获取文件名
        var arr = file.split('\\');//通过\分隔字符串，成字符串数组
        return arr[arr.length-1];//取最后一个，就是文件名
    }

    // function uploadFile(obj) {
    //     $('#filename').attr("value", obj.files[0].name);
    //     // $('#filepath').attr("value", obj.files[0].name);
    //     $('#filesuffix').attr("value", obj.files[0].type.split('/')[1]);
    //     $('#filetime').attr("value", new Date(obj.files[0].lastModified));
    // }
</script>
