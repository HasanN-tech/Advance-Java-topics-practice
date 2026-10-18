<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Transactions</title>

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
    background: linear-gradient(135deg, #667eea, #764ba2);
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

/* Container */
.container {
    background: #fff;
    padding: 30px;
    width: 90%;
    max-width: 900px;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.2);
}

/* Heading */
.container h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
}

/* Form */
.form-group {
    display: flex;
    gap: 10px;
    margin-bottom: 20px;
}

.form-group input[type="text"] {
    flex: 1;
    padding: 12px;
    border-radius: 8px;
    border: 1px solid #ccc;
    transition: 0.3s;
}

.form-group input[type="text"]:focus {
    border-color: #667eea;
    outline: none;
    box-shadow: 0 0 5px rgba(102,126,234,0.5);
}

/* Button */
.form-group input[type="submit"] {
    padding: 12px 20px;
    border: none;
    background: linear-gradient(135deg, #667eea, #5a67d8);
    color: white;
    border-radius: 8px;
    cursor: pointer;
    transition: 0.3s;
}

.form-group input[type="submit"]:hover {
    background: linear-gradient(135deg, #5a67d8, #434190);
}

/* Table */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

table th, table td {
    padding: 12px;
    text-align: center;
}

table th {
    background: #667eea;
    color: white;
}

table tr:nth-child(even) {
    background: #f2f2f2;
}

table tr:hover {
    background: #e6e9ff;
}

/* Back Button */
.back {
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    color: white;
    background: #333;
    padding: 10px 15px;
    border-radius: 6px;
}

.back:hover {
    background: black;
}

/* Responsive */
@media(max-width: 600px) {
    .form-group {
        flex-direction: column;
    }
}

</style>

</head>

<body>

<div class="container">

    <h2>View Transactions</h2>

    <form action="ViewTransactionsServlet" method="get">
        <div class="form-group">
            <input type="text" name="id" placeholder="Enter Account ID (optional)">
            <input type="submit" value="Search">
        </div>
    </form>

    <!-- Transaction Table -->
    <%
        java.util.List<com.bank.model.Transaction> list =
            (java.util.List<com.bank.model.Transaction>) request.getAttribute("transactions");

        if(list != null && !list.isEmpty()){
    %>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Amount</th>
            <th>Type</th>
            <th>Status</th>
            <th>Date</th>
        </tr>

        <%
            for(com.bank.model.Transaction t : list){
        %>

        <tr>
            <td><%= t.getTxnId() %></td>
            <td><%= t.getSenderAccount() %></td>
            <td><%= t.getReceiverAccount() %></td>
            <td><%= t.getAmount() %></td>
            <td><%= t.getTxnType() %></td>
            <td><%= t.getStatus() %></td>
            <td><%= t.getTxnDate() %></td>
        </tr>

        <%
            }
        %>

    </table>

    <%
        } else {
    %>
        <p style="text-align:center; color:red;">No Transactions Found</p>
    <%
        }
    %>

    <a href="adminDashboard.jsp" class="back">Back to Dashboard</a>

</div>

</body>
</html>