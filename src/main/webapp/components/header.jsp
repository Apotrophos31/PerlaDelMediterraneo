<jsp:useBean id="username" scope="session" type="java.lang.String" />

<header>
    <a href="/">
        <div id="logo"></div>
    </a>
    <nav>
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/prodotti">Prodotti</a>
        <a href="${pageContext.request.contextPath}/chisiamo">Chi siamo</a>
        <a href="${pageContext.request.contextPath}/contatti">Contatti</a>

        <section id="account">

        <%if (!username.isEmpty()) { %>
        <p>Bentornato/a, ${username}!</p>
        <a href="${pageContext.request.contextPath}/api/logout" style="color:red">Esci</a>
        <% } else { %>
        <button onclick="toggleLoginRegisterBox()">Login</button>
        <% } %>

        </section>
    </nav>
</header>


<div id="login-register-box">

    <div id="login">
        <h2>Login</h2>
        <form action="api/login" method="post">
            <label>Nome utente</label>
            <input name="username" type="text" placeholder="Username...">

            <label>Password</label>
            <input name="password" type="password" placeholder="********">
            <input type="submit" value="Login">
        </form>
        <p>oppure</p>
        <button onclick="toggleRegister()">Registrati</button>
    </div>

    <div id="register">
        <h2>Registrati</h2>
        <form action="api/register" method="post">
            <label>Nome utente</label>
            <input name="username" type="text" placeholder="Username...">

            <label>Password</label>
            <input name="password" type="password" placeholder="********">
            <input type="submit" value="Registrati">
        </form>
        <p>oppure</p>
        <button onclick="toggleRegister()">Torna al login</button>
    </div>

    <button class="close" onclick="toggleLoginRegisterBox()">X</button>
</div>

<script type="text/javascript">
    function toggleLoginRegisterBox() {
        var x = document.getElementById("login-register-box");
        if (x.style.visibility === "hidden" || x.style.visibility === "") {
            x.style.visibility = "visible";
        } else {
            x.style.visibility = "hidden";
        }
    }

    function toggleRegister(){
        var lg = document.getElementById("login");
        var rg = document.getElementById("register");

        if(lg.style.visibility === "inherit" || lg.style.visibility === ""){
            lg.style.visibility = "hidden";
            rg.style.visibility = "inherit";
        }else{
            lg.style.visibility = "inherit";
            rg.style.visibility = "hidden";
        }
    }


</script>

