<!DOCTYPE html>
<html lang="pt-br">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Object logado = request.getSession().getAttribute("logado");

	if (logado == null) {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}%>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1, width=device-width">
	<title>Admin BiMO</title>
	<link rel="stylesheet" href="./BiMO_Site/styles/admin.css">
	<link rel="stylesheet" href="./BiMO_Site/styles/BI.css">
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
		<img src="./BiMO_Site/image/imagem.png" id="imginicio">
	</div>
	<div id="quadrado"></div>
</div>

<div class="container">
	<h1>O que você fará hoje?</h1>

	<div class="opcoes">
		<a href="./BiMO_Site/index/cadastro.jsp">Cadastrar</a>
		<a href="./BiMO_Site/index/remocao.jsp">Remover</a>
		<a href="./BiMO_Site/index/alteracao.jsp">Alterar</a>
		<a href="./BiMO_Site/index/busca.jsp">Buscar</a>
	</div>
</div>



<br><br><br><br><br>

<div class="links-bi">
	<h2>Dashboards de BI</h2>

	<iframe
			src="https://app.powerbi.com/view?r=eyJrIjoiMGQ4Zjg5OTgtNmM0Yi00MGE2LWI5YzUtZWFiMWViMWY5YTYyIiwidCI6ImIxNDhmMTRjLTIzOTctNDAyYy1hYjZhLTFiNDcxMTE3N2FjMCJ9"
			width="100%"
			height="600"
			frameborder="0"
			allowFullScreen="true">
	</iframe>

	<iframe
			src="https://app.powerbi.com/view?r=eyJrIjoiNzJjZGI5YTgtMjIzYi00NDRmLWJjZWUtNzE5ZmVhZmY2OWM4IiwidCI6ImIxNDhmMTRjLTIzOTctNDAyYy1hYjZhLTFiNDcxMTE3N2FjMCJ9"
			width="100%"
			height="600"
			frameborder="0"
			allowFullScreen="true">
	</iframe>
</div>
</body>
</html>
