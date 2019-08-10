<html>
<body>
<%@ page contentType="text/html; charset=gb2312"%>
<h2>Hello World!</h2>
<a href="servlet/HelloServlet">Get方式请求HellowServlet</a>

<form action="servlet/HelloServlet" method="post">
    <input type="submit" value="Post方式请求HelloServlet">
</form>
</body>
</html>
