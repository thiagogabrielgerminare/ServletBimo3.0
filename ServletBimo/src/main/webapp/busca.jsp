<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BiMO - Buscas</title>
    <link rel="stylesheet" href="funcoes.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=INICIO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
<div class="inicio">
    <div class="iniciobimo">
        <h1>Busca</h1>
        <br>
        <h2>Busque administradores, categorias e planos com agilidade. Encontre tudo o que precisa no BiMO!</h2>
    </div>
    <div id="divimginicio">
        <img src="imagem.png" id="imginicio">
    </div>
    <div id="quadrado"></div>
</div>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR ADM-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Administrador</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-id-adm" class="toggle">
    <label for="buscar-id-adm" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdAdm" method="post">
            <label for="id-adm"><h3>ID</h3></label>
            <input type="number" id="id-adm" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-nome-adm" class="toggle">
    <label for="buscar-nome-adm" class="label-toggle">
        <h2>Buscar Por Nome</h2>
    </label>
    <div class="form-content">
        <form action="buscarNomeAdm" method="post">
            <label for="nome-adm"><h3>Nome</h3></label>
            <input type="text" id="nome-adm" name="nome" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-email-adm" class="toggle">
    <label for="buscar-email-adm" class="label-toggle">
        <h2>Buscar Por Email</h2>
    </label>
    <div class="form-content">
        <form action="buscarEmailAdm" method="post">
            <label for="email-adm"><h3>Email</h3></label>
            <input type="email" id="email-adm" name="email" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR PLANO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Plano</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-id-plano" class="toggle">
    <label for="buscar-id-plano" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdPlano" method="post">
            <label for="id-plano"><h3>ID</h3></label>
            <input type="number" id="id-plano" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-nome-plano" class="toggle">
    <label for="buscar-nome-plano" class="label-toggle">
        <h2>Buscar Por Nome</h2>
    </label>
    <div class="form-content">
        <form action="buscarNomePlano" method="post">
            <label for="nome-plano"><h3>Nome</h3></label>
            <input type="text" id="nome-plano" name="nome" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-descricao-plano" class="toggle">
    <label for="buscar-descricao-plano" class="label-toggle">
        <h2>Buscar Por Descrição</h2>
    </label>
    <div class="form-content">
        <form action="buscarDescricaoPlano" method="post">
            <label for="descricao-plano"><h3>Descrição</h3></label>
            <input type="text" id="descricao-plano" name="descricao" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR CATEGORIA CURSO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Categoria Curso</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-id-categoria-curso" class="toggle">
    <label for="buscar-id-categoria-curso" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdCategoriaCurso" method="post">
            <label for="id-categoria-curso"><h3>ID</h3></label>
            <input type="number" id="id-categoria-curso" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-nome-categoria-curso" class="toggle">
    <label for="buscar-nome-categoria-curso" class="label-toggle">
        <h2>Buscar Por Nome</h2>
    </label>
    <div class="form-content">
        <form action="buscarNomeCategoriaCurso" method="post">
            <label for="nome-categoria-curso"><h3>Nome</h3></label>
            <input type="text" id="nome-categoria-curso" name="nome" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR CATEGORIA PRODUTO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Categoria Produto</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-id-categoria-produto" class="toggle">
    <label for="buscar-id-categoria-produto" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdCategoriaProduto" method="post">
            <label for="id-categoria-produto"><h3>ID</h3></label>
            <input type="number" id="id-categoria-produto" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-nome-categoria-produto" class="toggle">
    <label for="buscar-nome-categoria-produto" class="label-toggle">
        <h2>Buscar Por Nome</h2>
    </label>
    <div class="form-content">
        <form action="buscarNomeCategoriaProduto" method="post">
            <label for="nome-categoria-produto"><h3>Nome</h3></label>
            <input type="text" id="nome-categoria-produto" name="nome" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR MIDIA-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Mídia</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-id-midia" class="toggle">
    <label for="buscar-id-midia" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdMidia" method="post">
            <label for="id-midia"><h3>ID</h3></label>
            <input type="number" id="id-midia" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-url-midia" class="toggle">
    <label for="buscar-url-midia" class="label-toggle">
        <h2>Buscar Por URL</h2>
    </label>
    <div class="form-content">
        <form action="buscarUrlMidia" method="post">
            <label for="url-midia"><h3>URL</h3></label>
            <input type="text" id="url-midia" name="url" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR MIDIA CURSO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Mídia Curso</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-id-midia-curso" class="toggle">
    <label for="buscar-id-midia-curso" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdMidiaCurso" method="post">
            <label for="id-midia-curso"><h3>ID</h3></label>
            <input type="number" id="id-midia-curso" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-url-midia-curso" class="toggle">
    <label for="buscar-url-midia-curso" class="label-toggle">
        <h2>Buscar Por URL</h2>
    </label>
    <div class="form-content">
        <form action="buscarUrlMidiaCurso" method="post">
            <label for="url-midia-curso"><h3>URL</h3></label>
            <input type="text" id="url-midia-curso" name="url" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR USUARIO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Usuário</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-usuario" class="toggle">
    <label for="buscar-usuario" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdUsuario" method="post">
            <label for="id-usuario"><h3>ID</h3></label>
            <input type="number" id="id-usuario" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-nome-usuario" class="toggle">
    <label for="buscar-nome-usuario" class="label-toggle">
        <h2>Buscar Por Nome</h2>
    </label>
    <div class="form-content">
        <form action="buscarNomeUsuario" method="post">
            <label for="nome-usuario"><h3>Nome</h3></label>
            <input type="text" id="nome-usuario" name="nome" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>


<div class="cardfuncao">
    <input type="checkbox" id="buscar-email-usuario" class="toggle">
    <label for="buscar-email-usuario" class="label-toggle">
        <h2>Buscar Por Email</h2>
    </label>
    <div class="form-content">
        <form action="buscarEmailUsuario" method="post">
            <label for="email-usuario"><h3>Email</h3></label>
            <input type="email" id="email-usuario" name="email" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-cpf-usuario" class="toggle">
    <label for="buscar-cpf-usuario" class="label-toggle">
        <h2>Buscar Por CPF</h2>
    </label>
    <div class="form-content">
        <form action="buscarCpfUsuario" method="post">
            <label for="cpf-usuario"><h3>CPF</h3></label>
            <input type="number" id="cpf-usuario" name="cpf" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-cnpj-usuario" class="toggle">
    <label for="buscar-cnpj-usuario" class="label-toggle">
        <h2>Buscar Por CNPJ</h2>
    </label>
    <div class="form-content">
        <form action="buscarCnpjUsuario" method="post">
            <label for="cnpj-usuario"><h3>CNPJ</h3></label>
            <input type="number" id="cnpj-usuario" name="cnpj" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR PRODUTO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Produto</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-produto" class="toggle">
    <label for="buscar-produto" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdProduto" method="post">
            <label for="id-produto"><h3>ID</h3></label>
            <input type="number" id="id-produto" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-nome-produto" class="toggle">
    <label for="buscar-nome-produto" class="label-toggle">
        <h2>Buscar Por Nome</h2>
    </label>
    <div class="form-content">
        <form action="buscarNomeProduto" method="post">
            <label for="nome-produto"><h3>Nome</h3></label>
            <input type="text" id="nome-produto" name="nome" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>


<div class="cardfuncao">
    <input type="checkbox" id="buscar-estado-produto" class="toggle">
    <label for="buscar-estado-produto" class="label-toggle">
        <h2>Buscar Por Estado</h2>
    </label>
    <div class="form-content">
        <form action="buscarEstadoProduto" method="post">
            <label for="estado-produto"><h3>Estado</h3></label>
            <input type="text" id="estado-produto" name="estado" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=BUSCAR CURSO-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->

<div class="funcao-hr">
    <h1 class="funcao-title">Curso</h1>
</div>
<br>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-id-curso" class="toggle">
    <label for="buscar-id-curso" class="label-toggle">
        <h2>Buscar Por ID</h2>
    </label>
    <div class="form-content">
        <form action="buscarIdCurso" method="post">
            <label for="id-curso"><h3>ID</h3></label>
            <input type="number" id="id-curso" name="id" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>

<div class="cardfuncao">
    <input type="checkbox" id="buscar-nome-curso" class="toggle">
    <label for="buscar-nome-curso" class="label-toggle">
        <h2>Buscar Por Nome</h2>
    </label>
    <div class="form-content">
        <form action="buscarNomeCurso" method="post">
            <label for="nome-curso"><h3>Nome</h3></label>
            <input type="text" id="nome-curso" name="nome" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>


<div class="cardfuncao">
    <input type="checkbox" id="buscar-certificacao-curso" class="toggle">
    <label for="buscar-certificacao-curso" class="label-toggle">
        <h2>Buscar Por Certificação</h2>
    </label>
    <div class="form-content">
        <form action="buscarCertificacaoCurso" method="post">
            <label for="certificacao-curso"><h3>Email</h3></label>
            <input type="text" id="certificacao-curso" name="certificacao" required>

            <button type="submit"><h3>Buscar</h3></button>
        </form>
    </div>
</div>
<br>

<br><br><br><br><br><br><br>
</body>
</html>