<%--
  Created by IntelliJ IDEA.
  User: sunlei
  Date: 2018/9/13
  Time: 下午10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="/js/jquery-3.3.1.js"></script>
<head>
    <title>list</title>
</head>
<body>
<table id="list">
    <thead>
    <th>编号</th>
    <th>名字</th>
    <th>性别</th>
    </thead>
    <tbody>
    <tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
</table>
<input id="submit" type="submit" value="查询">查询</input>
</body>
</html>
<script>
    $(function () {
        $('#submit').click(function () {
            $.ajax({
                    url: '/list',
                    type: 'POST',
                    success: function (result) {
                        if (result != null)

                        {
                            var jsonResult = JSON.parse(result);
                            alert(jsonResult.length);
                            $('#list tbody').html('');
                            var str;
                            for (var i = 0; i < jsonResult.length; i++) {
                                str += '<tr>';
                                str += '<td>' + jsonResult[i].id + '</td>';
                                str += '<td>' + jsonResult[i].name + '</td>';
                                str += '<td>' + jsonResult[i].sex + '</td>';
                                str += '</td>';
                            }
                            $('#list tbody').append(str);
                        }
                    },
                }
            );
        });

    });
</script>