<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BiMO - Remoções</title>
    <link rel="stylesheet" href="funcoes.css">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="inicio">
        <div class="iniciobimo">
            <h1>Remoção</h1>
			<br>
			<h2>Remova administradores, categorias e planos com rapidez e segurança. Simplifique a gestão do BiMO!</h2>
        </div>
        <div id="divimginicio">
            <img src="imagem.png" id="imginicio">
        </div>
        <div id="quadrado"></div>
    </div>
<!--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=CADASTRAR-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-->
	<div class="funcoes">
		<br>
		<div class="cardfuncao">
			<input type="checkbox" id="remover-adm" class="toggle">
			<label for="remover-adm" class="label-toggle">
			<h2>Administrador</h2>
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
				<h2>Plano</h2>
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
				<h2>Categoria de Curso</h2>
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
				<h2>Categoria de Produto</h2>
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
				<h2>Usuário</h2>
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
				<h2>Produto</h2>
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
			<h2>Curso</h2>
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
    <br><br><br>
</body>
</html>