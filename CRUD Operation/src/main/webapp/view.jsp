<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ page import="java.util.*, com.hasan.bean.Order" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #74ebd5, #9face6);
    text-align: center;
}

table {
    margin: auto;
    border-collapse: collapse;
    width: 80%;
    background-color: white;
}

th, td {
    padding: 10px;
    border: 1px solid #ddd;
}

th {
    background-color: #007BFF;
    color: white;
}
</style>

</head>
<body>

<h1>Order List</h1>

<table>
<tr>
    <th>ID</th>
    <th>Product</th>
    <th>Quantity</th>
    <th>Status</th>
</tr>

<%
List<Order> list = (List<Order>) request.getAttribute("orderList");

if(list != null){
    for(Order o : list){
%>

<tr>
    <td><%= o.getId() %></td>
    <td><%= o.getProduct() %></td>
    <td><%= o.getQuantity() %></td>
    <td><%= o.getStatus() %></td>
</tr>

<%
    }
}
%>

</table>

<br><br>
<a href="loginSuccess.html">Back</a>

</body>
</html>