<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Perla del Mediterrano</title>
    <link rel="stylesheet" type="text/css" href="../assets/styles/main.css">
</head>
<body>
    <%@include file="../components/header.jsp" %>
    <h1>INDEX</h1>
    <a href="${pageContext.request.contextPath}/prodotti/lista">Vai ai prodotti</a>

    <div id="login">
        <form action="login/processo" method="post">
            <input name="username" type="text" placeholder="Username...">
            <input name="password" type="password" placeholder="********">
            <input type="submit" value="Login">
        </form>
    </div>

    <%@include file="../components/footer.jsp" %>
</body>
</html>