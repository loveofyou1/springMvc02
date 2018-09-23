<%--
  Created by IntelliJ IDEA.
  User: sunlei19
  Date: 2018/2/23
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageTwo</title>
</head>
<body onload="checkCookies()">
<div>
    <div id="div1">
        <h5>page 2!</h5>
        <h6>html DOM 学习</h6>
        <p id="hello">hello world!</p>
        <p id="p1">first p</p>
        <p id="p2" class="inline">指定类名</p>
        <input type="text" id="fname" onchange="myFunction()"/>
        <p style="color: red">当你离开输入框后，函数将被触发，将小写字母转为大写字母。</p>
    </div>
    <div id="div2" onmouseover="mOver(this)" onmouseout="mOut(this)" style="background-color: coral">
        Mouse Over Me
    </div>
    <div>
        <a name="html">HTML </a>
        <a name="css">css </a>
        <a name="xml">xml </a>
        <a href="/jsp/showName.jsp#maoDian">javascript </a>
        <p>锚点的数量：
            <script>
                document.write(document.anchors.length);
            </script>
        </p>

        <a href="/redictNewPage">页面跳转mvc</a>

        <img border="0" src="WEB-INF/img/1.jpg" width="20" height="20">
        <img border="0" src="WEB-INF/img/2.jpg" width="20" height="20">
        <p>图片数量：
            <script>
                document.write(document.images.length);
            </script>
        </p>
    </div>
</div>

<script>
    var hello = document.getElementById("hello");
    document.write("<p>文本为：" + hello.innerHTML + "</p>");

    var node = document.createElement("h6");
    node.appendChild(document.createTextNode("appendChild"));
    document.getElementById("hello").appendChild(node);
    //alert(document.getElementById("hello").parentNode);

    var list = document.getElementsByTagName("h5");
    for (var i in list) {
        //alert(list[i]);
    }

    var clazz = document.getElementsByClassName("inline");
    for (var j in clazz) {
        //alert(clazz[j]);
    }

    nodevalue = document.getElementById("hello");

    /**
     * nodetype 元素类型
     元素    1
     属性    2
     文本    3
     注释    8
     文档    9
     */
    document.write(nodevalue.firstChild.nodeName + "," + nodevalue.firstChild.nodeValue + "," + nodevalue.firstChild.nodeType);

    //插入一个新的元素
    var para = document.createElement("p");
    var node = document.createTextNode("this is a new node");
    para.appendChild(node);
    var element = document.getElementById("div1");
    var p1 = document.getElementById("hello");
    element.insertBefore(para, p1);

    //移除一个element
    var del = document.getElementById("p2");
    element.removeChild(del);

    //替换html元素
    var parent = document.getElementById("div1");
    var child = document.getElementById("p1");
    var para = document.createElement("p");
    var node = document.createTextNode("这是一个新的段落。");
    parent.appendChild(node);
    parent.replaceChild(para, child);

    function checkCookies() {
        if (navigator.cookieEnabled) {
            alert("Cookies 可用");
        } else {
            alert("Cookies 不可用");
        }

    }


    function myFunction() {
        var x = document.getElementById("fname");
        x.value = x.value.toUpperCase();
    }

    function mOver(obj) {
        obj.innerHTML = "Thank you!";
    }

    function mOut(obj) {
        obj.innerHTML = "Mouse Over Me!";
    }
</script>
</body>
</html>
