<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Produto</title>
<link rel="stylesheet" type="text/css" href="principal.css">
</head>
<body>
<div id="container">
	<div id="top">
		<h1>Atualização de Produto</h1>
		<h4>${mensagem}</h4>
	</div>
	<div id="leftSide">
		<fieldset>
			<legend>Produto</legend>
			<form action="SoftgrafController" method="post" class="form">
				<input type="hidden" id="cmd" name="cmd" value="atualizarProduto" />
				<input type="hidden" id="codigo" name="codigo" value="${param.codigo }" />
				<label for="descricao">Descrição*</label>
				<div class="div_texbox">
					<input type="text" name="descricao" id="descricao" value="${produto.descricao}"/>
				</div>
				<label for="estoque">Estoque</label>
				<div class="div_texbox">
					<input type="text" name="estoque" id="estoque" value="${produto.estoque}"/>
				</div>
				<label for="critico">Crítico</label>
				<div class="div_texbox">
					<input type="text" name="critico" id="critico" value="${produto.critico}"/>
				</div>
				<label for="vlrcompra">Valor compra</label>
				<div class="div_texbox">
					<input type="text" name="vlrcompra" id="vlrcompra" value="${produto.vlrcompra}"/>
				</div>
				<label for="vlrvenda">Valor venda</label>
				<div class="div_texbox">
					<input type="text" name="vlrvenda" id="vlrvenda" value="${produto.vlrvenda}"/>
				</div>
				<label for="unidade_codigo">Unidade</label>
				<div class="div_texbox">
					<select name="unidade_codigo">
						<c:forEach var="unidade" items="${unidades}">
							<option value="${unidade.codigo}" ${unidade.codigo eq produto.unidade.codigo ? "SELECTED" : ""}>${unidade.descricao }</option>
						</c:forEach>
					</select>					
				</div>
				<label for="fornecedor_codigo">Fornecedor</label>
				<div class="div_texbox">
					<select name="fornecedor_codigo">
						<c:forEach var="fornecedor" items="${fornecedores}">
							<option value="${fornecedor.codigo}" ${fornecedor.codigo eq produto.fornecedor.codigo ? "SELECTED" : ""}>${fornecedor.nome}</option>
						</c:forEach>
					</select>					
				</div>
				<div class="button_div">
					<input name="atualizar" type="submit" value="Atualizar" class="buttons"/>
				</div>				
			</form>
		</fieldset>
	</div>
	<div id="rightSide">
		<c:import url="menu.jsp"></c:import>		
	</div>
</div>
</body>
</html>