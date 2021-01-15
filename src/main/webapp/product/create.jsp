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
    <title>Create Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body background="">
<p>
    <a href="/product">Back</a>
</p>
<div align="center">
    <form action="/product?action=create" method="post">
        <fieldset>
            <legend>Insert Product</legend>
            <table class="table table-striped">
                <tr>
                    <td>Id:</td>
                    <td><input type="text" name="id" id="id"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" id="price"></td>
                </tr>
                <tr>
                    <td>Quantity:</td>
                    <td><input type="text" name="quantity" id="quantity"></td>
                </tr>
                <tr>
                    <td>Color:</td>
                    <td><input type="text" name="color" id="color"></td>
                </tr>
                <tr>
                    <td>Status:</td>
                    <td><input type="text" name="status" id="status"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" class="btn btn-danger" value="Create Product">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>