<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro</title>
    <link rel="shortcut icon" href="logo.png" type="image/x-icon">
    <link rel="stylesheet" href="login.css">
</head>
<body>

<div id="pagelogin">
    <div class = "login">
    <form method="POST" action="login" class="formLogin">
        <div id="img">
            <img src="login.png" id="imglogin">
        </div>
        <div class="clogin">
            <h1>Faça login</h1>
            <input type="email" name="email" class="input" placeholder="Digite seu e-mail" required/>
            <input type="password" name="senha" class="input" placeholder="Digite sua senha" required/>
            <input type="submit" value="Entrar" id="butentrar" />

            <!-- Exibe mensagem de erro se necessário -->
            <p id="erro" style="color:red; margin-top: 8%">
                <% String erro = request.getParameter("erro");
                    if ("true".equals(erro)) { %>
                E-mail ou senha inválido. Tente novamente.
                <% } %>
            </p>
        </div>
    </form>
    </div>
</div>

</body>
</html>