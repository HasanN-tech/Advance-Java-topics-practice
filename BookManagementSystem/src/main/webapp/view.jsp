<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, com.project.beans.BookBean" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Data</title>
<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #74ebd5, #9face6);
    text-align: center;
}

h1 {
    color: #333;
}

table {
    margin: auto;
    border-collapse: collapse;
    width: 80%;
    background-color: white;
    box-shadow: 0px 5px 15px rgba(0,0,0,0.2);
}

th, td {
    padding: 12px;
    border: 1px solid #ddd;
}

th {
    background-color: #007BFF;
    color: white;
}

tr:hover {
    background-color: #f1f1f1;
}

a {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background-color: black;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

a:hover {
    background-color: #333;
}
</style>
</head>
<body>
<h1>📚 Book List</h1>

<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Author</th>
    <th>Price</th>
    <th>Quantity</th>
</tr>

<%
List<BookBean> list = (List<BookBean>) request.getAttribute("bookList");

if(list != null){
    for(BookBean b : list){
%>
<tr>
    <td><%= b.getBookId() %></td>
    <td><%= b.getBookName() %></td>
    <td><%= b.getAuthor() %></td>
    <td><%= b.getPrice() %></td>
    <td><%= b.getQty() %></td>
</tr>
<%
    }
}
%>

</table>

<br>
<a href="loginSuccess.html">⬅ Back</a>
</body>
</html>