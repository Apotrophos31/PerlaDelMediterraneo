<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Perla del Mediterraneo: Home</title>
    <link rel="icon" type="image/x-icon" href="../assets/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../assets/styles/main.css">
    <jsp:useBean id="result" scope="request" type="java.lang.String"/>
</head>
<body>
<div class="container">
    <%@include file="../components/header.jsp" %>
    <div class="content">
        <h1>RISULTATO LOGIN: ${result}</h1>
    </div>
    <%@include file="../components/footer.jsp" %>
</div>
</body>
</html>