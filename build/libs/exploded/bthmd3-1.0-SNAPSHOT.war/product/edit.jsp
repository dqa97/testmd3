<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/1/2021
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<p>
    <a href="/product">Back</a>
</p>
<form action="/product?action=edit" method="post">
    <fieldset>
        <legend>Insert Product</legend>
        <input type="hidden" name="id" value="${editProduct.getId()}">
        <table class="table table-striped">
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"value=""></td>
            </tr>
            <tr>
                <td>Prime:</td>
                <td><input type="text" name="price" id="price" value=""></td>
            </tr>

            <tr>
                <td>Quantity:</td>
                <td><input type="text" name="quantity" id="quantity" value=""></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><input type="text" name="color" id="color" value=""></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><input type="text" name="status" id="status" value=""></td>
            </tr>


        </table>
        <input type="submit" value="Edit Product">
    </fieldset>
</form>
</body>
</html>
