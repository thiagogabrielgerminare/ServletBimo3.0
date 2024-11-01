<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BiMO - Cadastros</title>
    <link rel="stylesheet" href="funcoes.css">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=INICIO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
	<div class="inicio">
        <div class="iniciobimo">
            <h1>Cadastro</h1>
			<br>
			<h2>Cadastre novos admins, categorias e planos de forma rápida e prática. Gerencie tudo em um só lugar!</h2>
        </div>
        <div id="divimginicio">
            <img src="imagem.png" id="imginicio">
        </div>
        <div id="quadrado"></div>
    </div>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=CADASTRAR-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
    <div class="cardfuncao">
        <input type="checkbox" id="cadastrar-adm" class="toggle">
        <label for="cadastrar-adm" class="label-toggle">
            <h2>Novo Administrador</h2>
        </label>
        <div class="form-content">
            <form action="cadastrarAdm" method="post">
                <label for="nome-adm"><h3>Nome</h3></label>
                <input type="text" id="nome-adm" name="nome-adm" required>

                <label for="email-adm"><h3>Email</h3></label>
                <input type="email" id="email-adm" name="email-adm" required>

                <label for="senha-adm"><h3>Senha</h3></label>
                <input type="password" id="senha-adm" name="senha-adm" minlength="8" required>

                <p>${resultado}</p>

                <button type="submit"><h3>Cadastrar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="cadastrar-plano" class="toggle">
        <label for="cadastrar-plano" class="label-toggle">
            <h2>Novo Plano</h2>
        </label>
        <div class="form-content">
            <form action="cadastrarPlano" method="post">
            <label for="nome-plano"><h3>Nome</h3></label>
                <input type="text" id="nome-plano" name="nome" required>
                    
                <label for="valor-plano"><h3>Valor</h3></label>
                <input type="number" id="valor-plano" name="valor" step="0.01" required>
                    
                <label for="descricao-plano"><h3>Descrição</h3></label>
                <input type="text" id="descricao-plano" name="descricao" required>
                    
                <button type="submit"><h3>Cadastrar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="cadastrar-categoria-curso" class="toggle">
        <label for="cadastrar-categoria-curso" class="label-toggle">
            <h2>Nova Categoria de Curso</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-categoria-curso"><h3>Nome</h3></label>
                <input type="text" id="nome-categoria-curso" name="nome" required>

                <button type="submit"><h3>Cadastrar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="cadastrar-categoria-produto" class="toggle">
        <label for="cadastrar-categoria-produto" class="label-toggle">
            <h2>Nova Categoria de Produto</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-categoria-produto"><h3>Nome</h3></label>
                <input type="text" id="nome-categoria-produto" name="nome" required>

                <button type="submit"><h3>Cadastrar</h3></button>
            </form>
        </div>
    </div>

	<br><br><br>
</body>
</html>