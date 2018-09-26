<%--
  Created by IntelliJ IDEA.
  User: mgrigorova
  Date: 26.09.18
  Time: 15:27
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<form>
    <table border="1">
        <g:each in="${allProducts}" var="thisProduct">
            <tr>
                <td>${thisProduct.name}</td>
                <td>${thisProduct.sku}</td>
                <td>${thisProduct.price}</td>
            </tr>
        </g:each>
    </table>
</form>
</body>
</html>