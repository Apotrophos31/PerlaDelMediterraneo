<header>
    <a href="/">
        <div id="logo"></div>
    </a>
    <nav>
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/prodotti">Prodotti</a>
        <a href="${pageContext.request.contextPath}/chisiamo">Chi siamo</a>
        <a href="${pageContext.request.contextPath}/contatti">Contatti</a>
        <button onclick="toggleLogin()">Login</button>
    </nav>
</header>

<div id="login">
    <h2>Login</h2>
    <form action="api/login" method="post">
        <label>Nome utente</label>
        <input name="username" type="text" placeholder="Username...">

        <label>Password</label>
        <input name="password" type="password" placeholder="********">
        <input type="submit" value="Login">
    </form>
    <button class="close" onclick="toggleLogin()">X</button>
</div>

<script type="text/javascript">
    function toggleLogin() {
        var x = document.getElementById("login");
        if (x.style.visibility === "hidden" || x.style.visibility === "") {
            x.style.visibility = "visible";
        } else {
            x.style.visibility = "hidden";
        }
    }
</script>

