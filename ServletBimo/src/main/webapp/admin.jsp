
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Object logado = request.getSession().getAttribute("logado");

    if (logado == null) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, width=device-width">
    <title>Página de Admin</title>
    <link rel="stylesheet" href="admin.css">
    <link rel="shortcut icon" href="logo.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=INICIO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="inicio">
    <div class="iniciobimo">
        <h1>Bem Vindo(a)!</h1>
        <br>
        <h2>Controle e gerencie tudo para promover uma experiência única ao usuário.</h2>
    </div>
    <div id="divimginicio">
        <img src="imagem.png" id="imginicio">
    </div>
    <div id="quadrado"></div>
</div>

<br><br>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=CADASTRAR-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="funcoes-cadastrar">
    <div class="funcao-hr">
        <h2 class="funcao-title">Cadastrar</h2>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="cadastrar-adm" class="toggle">
        <label for="cadastrar-adm" class="label-toggle">
            <h2>Cadastrar Novo Administrador</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-adm"><h3>Nome</h3></label>
                <input type="text" id="nome-adm" name="nome" required>

                <label for="email-adm"><h3>Email</h3></label>
                <input type="email" id="email-adm" name="email" required>

                <label for="senha-adm"><h3>Senha</h3></label>
                <input type="password" id="senha-adm" name="senha" required>

                <button type="submit"><h3>Cadastrar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="cadastrar-plano" class="toggle">
        <label for="cadastrar-plano" class="label-toggle">
            <h2>Cadastrar Novo Plano</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-plano"><h3>Nome</h3></label>
                <input type="text" id="nome-plano" name="nome" required>

                <label for="valor-plano"><h3>Valor</h3></label>
                <input type="number" id="valor-plano" name="valor" required>

                <label for="descricao-plano"><h3>Descrição</h3></label>
                <input type="text" id="descricao-plano" name="descricao" required>

                <button type="submit"><h3>Cadastrar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="cadastrar-categoria-curso" class="toggle">
        <label for="cadastrar-categoria-curso" class="label-toggle">
            <h2>Cadastrar Nova Categoria de Curso</h2>
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
            <h2>Cadastrar Nova Categoria de Produto</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-categoria-produto"><h3>Nome</h3></label>
                <input type="text" id="nome-categoria-produto" name="nome" required>

                <button type="submit"><h3>Cadastrar</h3></button>
            </form>
        </div>
    </div>
</div>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=REMOVER-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="funcoes-remover">
    <div class="funcao-hr">
        <h2 class="funcao-title">Remover</h2>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="remover-adm" class="toggle">
        <label for="remover-adm" class="label-toggle">
            <h2>Remover Administrador</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-adm"><h3>Nome</h3></label>
                <input type="text" id="nome-adm" name="nome" required>

                <button type="submit"><h3>Remover</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="remover-plano" class="toggle">
        <label for="remover-plano" class="label-toggle">
            <h2>Remover Plano</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-plano"><h3>Nome</h3></label>
                <input type="text" id="nome-plano" name="nome" required>

                <button type="submit"><h3>Remover</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="remover-categoria-curso" class="toggle">
        <label for="remover-categoria-curso" class="label-toggle">
            <h2>Remover Categoria de Curso</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-categoria-curso"><h3>Nome</h3></label>
                <input type="text" id="nome-categoria-curso" name="nome" required>

                <button type="submit"><h3>Remover</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="remover-categoria-produto" class="toggle">
        <label for="remover-categoria-produto" class="label-toggle">
            <h2>Remover Categoria de Produto</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-categoria-produto"><h3>Nome</h3></label>
                <input type="text" id="nome-categoria-produto" name="nome" required>

                <button type="submit"><h3>Remover</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="remover-usuario" class="toggle">
        <label for="remover-usuario" class="label-toggle">
            <h2>Remover Usuário</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="nome-usuario"><h3>Nome</h3></label>
                <input type="text" id="nome-usuario" name="nome" required>

                <button type="submit"><h3>Remover</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="remover-produto" class="toggle">
        <label for="remover-produto" class="label-toggle">
            <h2>Remover Produto</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="id-produto"><h3>Nome</h3></label>
                <input type="number" id="id-produto" name="id" required>

                <button type="submit"><h3>Remover</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="remover-curso" class="toggle">
        <label for="remover-curso" class="label-toggle">
            <h2>Remover Curso</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="id-curso"><h3>Nome</h3></label>
                <input type="number" id="id-curso" name="id" required>

                <button type="submit"><h3>Remover</h3></button>
            </form>
        </div>
    </div>
</div>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=ALTERAR-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="funcoes-alterar">
    <div class="funcao-hr">
        <h2 class="funcao-title">Alterar</h2>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-adm" class="toggle">
        <label for="alterar-adm" class="label-toggle">
            <h2>Alterar Administrador</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="id-adm"><h3>ID</h3></label>
                <input type="number" id="id-adm" name="id" required>

                <label for="nome-adm"><h3>Nome</h3></label>
                <input type="text" id="nome-adm" name="nome">

                <label for="email-adm"><h3>Email</h3></label>
                <input type="email" id="email-adm" name="email">

                <label for="senha-adm"><h3>Senha</h3></label>
                <input type="password" id="senha-adm" name="senha">

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-plano" class="toggle">
        <label for="alterar-plano" class="label-toggle">
            <h2>Alterar Plano</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="id-plano"><h3>ID</h3></label>
                <input type="number" id="id-plano" name="id" required>

                <label for="nome-plano"><h3>Nome</h3></label>
                <input type="text" id="nome-plano" name="nome">

                <label for="valor-plano"><h3>Valor</h3></label>
                <input type="number" id="valor-plano" name="valor">

                <label for="descricao-plano"><h3>Descrição</h3></label>
                <input type="text" id="descricao-plano" name="descricao">

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-categoria-curso" class="toggle">
        <label for="alterar-categoria-curso" class="label-toggle">
            <h2>Alterar Categoria de Curso</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="id-categoria-curso"><h3>ID</h3></label>
                <input type="number" id="id-categoria-curso" name="id" required>

                <label for="nome-categoria-curso"><h3>Nome</h3></label>
                <input type="text" id="nome-categoria-curso" name="nome">

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>

    <div class="cardfuncao">
        <input type="checkbox" id="alterar-categoria-produto" class="toggle">
        <label for="alterar-categoria-produto" class="label-toggle">
            <h2>Alterar Categoria de Produto</h2>
        </label>
        <div class="form-content">
            <form>
                <label for="id-categoria-produto"><h3>ID</h3></label>
                <input type="number" id="id-categoria-produto" name="id" required>

                <label for="nome-categoria-produto"><h3>Nome</h3></label>
                <input type="text" id="id-categoria-produto" name="nome">

                <button type="submit"><h3>Alterar</h3></button>
            </form>
        </div>
    </div>
</div>


<br><br><br><br><br>

</body>
</html>
