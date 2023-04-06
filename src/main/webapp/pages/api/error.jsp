<!DOCTYPE html>
<html>
<head>
    <title>Redirect...</title>
    <jsp:useBean id="message" scope="request" class="java.lang.String"/>
</head>
<body>

<% if(!message.isEmpty()) %>
<p>ERRORE: ${message}</p>

<a href="${pageContext.request.contextPath}/">Torna alla homepage</a>
</body>
</html>