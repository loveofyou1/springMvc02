<%--
  Created by IntelliJ IDEA.
  User: sunlei19
  Date: 2018/6/6
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #picker {
        display: inline-block;
        color: gray;
    }

    #thelist {
        display: inline-block;

    }
</style>
<link type="text/css" rel="stylesheet" href="/js/uploader/webuploader.css" source="widget"/>
<script src="/js/jquery-3.3.1.js"></script>
<script src="/js/uploader/webuploader.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<%--<form id="fileForm" enctype="multipart/form-data" method="post" >
    <input id="hiddenPut" hidden="hidden" type="text" value="nihao"/>
    <input type="file" name="file" id="uploadFile" />
    <label id="tips" ></label>
    <input id="upload" onclick="changeFile();"/>
    <input id="submit" type="button" value="提交">
</form>--%>
<table>
    <tr>
        <td>
            2. nihao:
            <div id="picker">file</div>
        </td>
        <td>
            <!--用来存放文件信息-->
            <div id="thelist" class="uploader-list"></div>
        </td>
        <td>
            <button id="ctlBtn" class="btn btn-default">开始上传</button>
        </td>
    </tr>

</table>

</div>
</body>
</html>
<script>
    /*    $("#submit").click(function () {
            var formdata = new FormData(document.getElementById("fileForm"));
            $.ajax({
                url: "/submitFile.do",
                type: "post",
                data: formdata,
                contentType: false, //- 必须false才会自动加上正确的Content-Type
                processData: false, //- 必须false才会避开jQuery对 formdata 的默认处理,XMLHttpRequest会对 formdata 进行正确的处理
                success: function (message) {
                    alert("ok");
                },
                error: function () {
                    alert("fail");
                }
            });
        });*/

    $(function () {
        var str = 'No file chosen';
        setStr(str);
        var uploader = WebUploader.create({

            // swf文件路径
            swf: '/js/uploader/Uploader.swf',

            // 文件接收服务端。
            server: '/submitFile.do',

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker'
        });

        // 当有文件被添加进队列的时候
        uploader.on('fileQueued', function (file) {
            if (file != null) {
                $('#thelist').html('');
                $('#thelist').append('<div id="' + file.id + '" class="item inline">' +
                    '<h4 class="info">' + file.name + '</h4>' +
                    '</div>');
            }else {
                setStr(str);
            }
        });

        $('#ctlBtn').on('click', function () {
            uploader.upload();
        });

        uploader.on('uploadSuccess', function (file) {
            alert("success!");
        });

    });

    function setStr(str1) {
        $('#thelist').append('<div' + '" class="item inline">' +
            '<h5 class="info">' + str1 + '</h5>' +
            '</div>');
    }
</script>
