<%@ page import="java.util.*,com.bank.model.Account" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Accounts</title>

<style>

/* Reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', sans-serif;
}

/* Body */
body {
    background: linear-gradient(135deg, #36d1dc, #5b86e5);
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

/* Container */
.container {
    background: #fff;
    width: 95%;
    max-width: 1100px;
    padding: 25px;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.2);
}

/* Header */
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}

.header h2 {
    color: #333;
}

/* Button */
.back-btn {
    text-decoration: none;
    background: #333;
    color: white;
    padding: 10px 15px;
    border-radius: 6px;
    transition: 0.3s;
}

.back-btn:hover {
    background: black;
}

/* Table */
table {
    width: 100%;
    border-collapse: collapse;
    overflow: hidden;
    border-radius: 10px;
}

/* Table Header */
table th {
    background: #5b86e5;
    color: white;
    padding: 12px;
}

/* Table Cells */
table td {
    padding: 12px;
    text-align: center;
}

/* Zebra Rows */
table tr:nth-child(even) {
    background: #f2f2f2;
}

/* Hover Effect */
table tr:hover {
    background: #e6ebff;
}

/* Delete Button */
.delete-btn {
    text-decoration: none;
    color: white;
    background: #e63946;
    padding: 6px 12px;
    border-radius: 5px;
    transition: 0.3s;
}

.delete-btn:hover {
    background: #c1121f;
}

/* Empty Message */
.no-data {
    text-align: center;
    margin-top: 20px;
    color: red;
}

/* Responsive */
@media(max-width: 768px) {
    table {
        font-size: 12px;
    }
}

</style>

</head>

<body>

<div class="container">

    <!-- Header -->
    <div class="header">
        <h2>All Accounts</h2>
        <a href="adminDashboard.jsp" class="back-btn">Back</a>
    </div>

    <%
        List<Account> list = (List<Account>) request.getAttribute("accounts");

        if(list != null && !list.isEmpty()){
    %>

    <!-- Table -->
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Account No</th>
            <th>Balance</th>
            <th>Action</th>
        </tr>

        <%
            for(Account acc : list){
        %>

        <tr>
            <td><%= acc.getUserId() %></td>
            <td><%= acc.getFullName() %></td>
            <td><%= acc.getEmail() %></td>
            <td><%= acc.getAccountNumber() %></td>
            <td><%= acc.getBalance() %></td>
            <td>
                <a class="delete-btn"
                   href="DeleteAccountServlet?id=<%= acc.getUserId() %>"
                   onclick="return confirm('Are you sure to delete this account?');">
                   Delete
                </a>
            </td>
        </tr>

        <%
            }
        %>

    </table>

    <%
        } else {
    %>

    <p class="no-data">No Accounts Found</p>

    <%
        }
    %>

</div>

</body>
</html>