<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Página de Login</title>
    <link rel="shortcut icon" href="logo.png" type="image/x-icon">
    <link rel="stylesheet" href="login.css">
</head>
<body>

<div id="pagelogin">
    <div class="login">
        <form method="POST" class="formLogin" action="login">
            <div id="img">
                <img src="login.png" id="imglogin">
            </div>
            <div class="clogin">
                <h1>Faça login</h1>
                <input type="email" name="email" class="input" placeholder="Digite seu e-mail" required/>

                <input type="password" name="senha" class="input" placeholder="Digite sua senha" required/>
                <input type="submit" value="Entrar" id="butentrar" />
            </div>
        </form>
    </div>
</div>

</body>
</html>
