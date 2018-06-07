<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD//XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<body>
<form>
    <h2>Hello World!</h2>
    <div>
        <div>
            <div width="80">
                <button id="page1" onclick="alertMsg()"><a href="/page1.jsp">页面一</a></button>
            </div>
            <div width="80">
                <button id="page2"><a href="/page2.jsp">页面二</a></button>
            </div>
        </div>
        <div>
            <div width="80">
                <button id="page3" type="button" value="页面三" onclick="topage3()">页面三</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
<script src="/js/indexJs.js"></script>
<script type="text/javascript">
    function topage3() {
        window.location.href="page3.jsp";
    }
</script>