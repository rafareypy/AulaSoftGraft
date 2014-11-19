<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.softgraf.model.bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Fornecedor</title>
<link rel="stylesheet" type="text/css" href="principal.css">
<script type="text/javascript">
	function mostrarProdutos(codigo)
	{
		document.getElementById("produto"+codigo).style.display="block";
	}
	function esconderProdutos(codigo)
	{
		document.getElementById("produto"+codigo).style.display="none";
	}
</script>
</head>
<body>
<div id="container">
	<div id="top">
		<h1>Pesquisa de Fornecedor</h1>
			<div id="leftSide">
			<fieldset>
				<legend>Fornecedor</legend>
			
				<form action="SoftgrafController" method="post" class="form">
					<input type="hidden" id="cmd" name="cmd" value="pesquisarFornecedor" />
					<label for="nome">Nome</label>
					<div class="div_texbox">
						<input type="text" name="nome" id="nome" value="${fornecedor.nome}"/>
					</div>
					<label for="cidade">Cidade</label>
					<div class="div_texbox">
						<input type="text" name="cidade" id="cidade" value="${fornecedor.cidade}"/>
					</div>
					<label for="estado">Estado</label>
					<div class="div_texbox">
						<input type="text" name="estado" id="estado" value="${fornecedor.estado}"/>
					</div>
	
					<div class="button_div">
						<input name="pesquisar" type="submit" value="Pesquisar" class="buttons"/>
					</div>				
				</form>
				<form action="SoftgrafController" method="post" class="form">
					<input type="hidden" id="cmd" name="cmd" value="pesquisarFornecedor" />	
					<input type="hidden" id="hql" name="hql" value="hql" />
					<div class="button_div">
						<input name="pesquisar" type="submit" value="Fornecedor sem Produto" class="buttons"/>
					</div>				
				</form>
				<form action="SoftgrafController" method="post" class="form">
					<input type="hidden" id="cmd" name="cmd" value="pesquisarFornecedor" />	
					<input type="hidden" id="criteria" name="criteria" value="criteria" />
					<div class="button_div">
						<input name="pesquisar" type="submit" value="Fornecedor sem UF" class="buttons"/>
					</div>				
				</form>
				
			</fieldset>
			</div>
	</div>
	<div id="rightSide">
		<c:import url="menu.jsp"></c:import>
	</div>
	
	<div id="leftSide">
	<h1>Consulta Fornecedor</h1>
	<h3>${mensagem }</h3>
	
		<table>
			<thead>
				<tr>
					<td>Nome</td>
					<td>Telefone</td>
					<td>Cidade</td>
					<td>Estado</td>
					<td colspan="2">Opções</td>
				</tr>
			</thead>
			<c:forEach var="fornecedor" items="${fornecedores}">
				<tr onmouseover="mostrarProdutos(${fornecedor.codigo });"
				onmouseout="esconderProdutos(${fornecedor.codigo });">
						<td>${fornecedor.nome}</td>					
						<td><a href="SoftgrafController?cmd=atualizarFornecedor&codigo=${fornecedor.codigo}">Atualizar</a></td>
						<td><a href="SoftgrafController?cmd=excluirFornecedor&codigo=${fornecedor.codigo}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach var="fornecedor" items="${fornecedores}">
			<div class="rightSideProdutos" style="display: none;" id="produto${fornecedor.codigo}">
				<table>
					<thead>
						<tr><td>${fornecedor.nome }</td></tr>
					</thead>
					<c:forEach var="produto" items="${fornecedor.produtos}">
					<tr>
						<td>${produto.descricao }</td>
					</tr>
					</c:forEach>
					<c:if test="${fornecedor.produtosSize == 0}">
						<tr><td>Não há produtos.</td></tr>
					</c:if>
				</table>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>