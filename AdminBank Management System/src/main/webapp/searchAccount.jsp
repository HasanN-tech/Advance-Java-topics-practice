<%@ page import="com.bank.model.Account" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Account</title>

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
    max-width: 500px;
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

/* Card */
.card {
    background: #f9fafb;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 5px 15px rgba(0,0,0,0.1);
    margin-top: 15px;
}

.card h3 {
    margin-bottom: 10px;
    color: #444;
}

.card p {
    margin: 6px 0;
    color: #555;
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

/* Error Message */
.error {
    text-align: center;
    color: red;
    margin-top: 15px;
}

</style>

</head>

<body>

<div class="container">

    <h2>Search Account</h2>

    <form action="SearchAccountServlet" method="post">
        <div class="form-group">
            <input type="text" name="user_id" placeholder="Enter Account ID" required>
            <input type="submit" value="Search">
        </div>
    </form>

    <%
        Account acc = (Account) request.getAttribute("account");

        if(acc != null){
    %>

    <!-- Account Card -->
    <div class="card">
        <h3>Account Details</h3>
        <p><strong>ID:</strong> <%= acc.getUserId() %></p>
        <p><strong>Name:</strong> <%= acc.getFullName() %></p>
        <p><strong>Email:</strong> <%= acc.getEmail() %></p>
        <p><strong>Account No:</strong> <%= acc.getAccountNumber() %></p>
        <p><strong>Balance:</strong> <%= acc.getBalance() %></p>
    </div>

    <%
        } else if(request.getParameter("user_id") != null){
    %>

        <p class="error">No Account Found</p>

    <%
        }
    %>

    <a href="adminDashboard.jsp" class="back">Back to Dashboard</a>

</div>

</body>
</html>