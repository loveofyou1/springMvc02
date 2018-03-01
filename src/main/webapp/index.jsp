<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD//XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<body>
<form>
    <h2>Hello World!</h2>
    <table border="1">
        <tr>
            <td width="80">
                <button id="page1" onclick="alertMsg()"><a href="/page1.jsp">页面一</a></button>
            </td>
            <td width="80">
                <button id="page2"><a href="/page2.jsp">页面二</a></button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script src="/js/indexJs.js"></script>
<script>
    $(function () {
        $("#page1").click(function () {
            alertMsg();
        });
    });

    function alertMsg() {
    }
</script>