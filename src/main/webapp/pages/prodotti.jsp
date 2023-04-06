<%@ page import="com.example.perladelmediterraneo.model.Prodotto" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Perla del Mediterraneo: Prodotti</title>
    <link rel="icon" type="image/x-icon" href="../assets/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../assets/styles/main.css">
    <link rel="stylesheet" type="text/css" href="../assets/styles/prodotti.css">
    <jsp:useBean id="lista_prodotti" scope="request" type="java.util.List<com.example.perladelmediterraneo.model.Prodotto>" />
</head>
<body>
<div class="container">
    <%@include file="../components/header.jsp" %>
    <div class="content">
        <h1>Prodotti - size(${lista_prodotti.size()}):</h1>

        <!-- Lista prodotti -->
        <table>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>PREZZO/KG</th>
                <th>QTA</th>
                <th>ARRIVO</th>
                <th>SCADENZA</th>
            </tr>

            <% DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy - HH:mm"); %>
            <% for (Prodotto p : lista_prodotti) { %>
            <tr>
                <th><%=p.getId()%>
                </th>
                <th><%=p.getNome()%>
                </th>
                <th><%=p.getPrezzo_kg()%>
                </th>
                <th><%=p.getQuantita()%>
                </th>
                <th><%=dateFormat.format(p.getArrivo())%>
                </th>
                <th><%=dateFormat.format(p.getScadenza())%>
                </th>
            </tr>
            <%}%>

        </table>
        <hr>

        <!-- FORM ADD -->
        <h2>Aggiunti prodotti</h2>
        <form method="post" action="${pageContext.request.contextPath}/api/aggPrd">
            <label>
                Nome:
                <input name="nome" type="text" placeholder="Nome..." />
            </label>
            <br>
            <label>
                Prezzo al kg
                <input name="prezzo_kg" type="text" placeholder="Prezzo al kg..." />
            </label>
            <br>
            <label>
                Quantit&agrave;
                <input name="quantita" type="number" placeholder="Quantit&agrave;..." />
            </label>
            <br>
            <input type="submit" value="Aggiungi" />
        </form>
        <hr>

        <!-- FORM REMOVE -->
        <h2>Rimuovi prodotti</h2>
        <form method="post" action="${pageContext.request.contextPath}/api/rmvPrd">
            <label>
                ID
                <input name="id" type="number" placeholder="ID..." />
            </label>
            <br>
            <input type="submit" value="Rimuovi" />
        </form>
        <hr>
    </div>
    <%@include file="../components/footer.jsp" %>
</div>
</body>
</html>