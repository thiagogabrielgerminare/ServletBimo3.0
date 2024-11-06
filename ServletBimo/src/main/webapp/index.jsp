<!-- PAGINA DE LOGIN DA AREA RESTRITA-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Página de Login</title>
    <link rel="shortcut icon" href="BiMO_Site/image/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="BiMO_Site/styles/login.css">
</head>
<body>

<div id="pagelogin">
    <a href="landingPage.html" id="seta"><p>⬅️</p></a>
    <div class="login">
        <form method="post" class="formLogin" action="${pageContext.request.contextPath}/loginjsp">
            <div id="img">
                <img src="./BiMO_Site/image/login.png" id="imglogin">
            </div>
            <div class="clogin">
                <h1>Faça login</h1>
                <input type="email" name="email" class="input" placeholder="Digite seu e-mail" required/>
                <div class="olho-senha">
                    <input type="password" name="senha" class="input" id="password" placeholder="Digite sua senha">
                    <img src="./BiMO_Site/image/olho-cortado.png" alt="Mostrar/Esconder Senha" id="olhinho" onclick="togglePassword()" style="cursor: pointer;">
                </div>
                <a href="./BiMO_Site/index/admin.jsp"><input type="submit" value="Entrar" id="butentrar" /></a>
            </div>
        </form>
    </div>
</div>

<script>
    function togglePassword() {
        const passwordInput = document.getElementById("password");
        const eyeIcon = document.getElementById("olhinho");

        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            eyeIcon.src = './BiMO_Site/image/olho.png'; // Altera o ícone para olho fechado
        } else {
            passwordInput.type = "password";
            eyeIcon.src = './BiMO_Site/image/olho-cortado.png'; // Altera o ícone para olho aberto
        }
    }
</script>

</body>
</html>
