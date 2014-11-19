<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Fornecedor</title>
<link rel="stylesheet" type="text/css" href="principal.css">
</head>
<body>
<div id="container">
	<div id="top">
		<h1>Cadastro de Fornecedor</h1>
		<h4>${mensagem}</h4>
	</div>
	<div id="leftSide">
		<fieldset>
			<legend>Fornecedor</legend>
			<form action="SoftgrafController" method="post" class="form">
				<input type="hidden" id="cmd" name="cmd" value="cadastrarFornecedor" />
				<label for="nome">Nome*</label>
				<div class="div_texbox">
					<input type="text" name="nome" id="nome" value="${fornecedor.nome}"/>
				</div>
				<label for="endereco">Endereço</label>
				<div class="div_texbox">
					<input type="text" name="endereco" id="endereco" value="${fornecedor.endereco}"/>
				</div>
				<label for="bairro">Bairro</label>
				<div class="div_texbox">
					<input type="text" name="bairro" id="bairro" value="${fornecedor.bairro}"/>
				</div>
				<label for="cidade">Cidade</label>
				<div class="div_texbox">
					<input type="text" name="cidade" id="cidade" value="${fornecedor.cidade}"/>
				</div>
				<label for="estado">Estado</label>
				<div class="div_texbox">
					<input type="text" name="estado" id="estado" value="${fornecedor.estado}"/>
				</div>
				<label for="cep">CEP</label>
				<div class="div_texbox">
					<input type="text" name="cep" id="cep" value="${fornecedor.cep}"/>
				</div>
				<label for="fone">Telefone*</label>
				<div class="div_texbox">
					<input type="text" name="fone" id="fone" value="${fornecedor.fone}"/>
				</div>
				<label for="celular">Celular</label>
				<div class="div_texbox">
					<input type="text" name="celular" id="celular" value="${fornecedor.celular}"/>
				</div>
				<label for="cpf">CPF</label>
				<div class="div_texbox">
					<input type="text" name="cpf" id="cpf" value="${fornecedor.cpf}"/>
				</div>
				<label for="obs">Obs.</label>
				<div class="div_texbox">
					<input type="text" name="obs" id="obs" value="${fornecedor.obs}"/>
				</div>
				<label for="rg">RG</label>
				<div class="div_texbox">
					<input type="text" name="rg" id="rg" value="${fornecedor.rg}"/>
				</div>
				<label for="orgaorg">Orgão RG</label>
				<div class="div_texbox">
					<input type="text" name="orgaorg" id="orgaorg" value="${fornecedor.orgaorg}"/>
				</div>
				<label for="desdeString">Cliente desde:</label>
				<div class="div_texbox">
					<input type="text" name="desdeString" id="desdeString" value="${fornecedor.desde}"/>
				</div>
				<label for="cnpj">CNPJ</label>
				<div class="div_texbox">
					<input type="text" name="cnpj" id="cnpj" value="${fornecedor.cnpj}"/>
				</div>
				<label for="insest">Ins. Estadual</label>
				<div class="div_texbox">
					<input type="text" name="insest" id="insest" value="${fornecedor.insest}"/>
				</div>
				<label for="fax">Fax</label>
				<div class="div_texbox">
					<input type="text" name="fax" id="fax" value="${fornecedor.fax}"/>
				</div>
				<label for="contato">Contato</label>
				<div class="div_texbox">
					<input type="text" name="contato" id="contato" value="${fornecedor.contato}"/>
				</div>
				<label for="email">email</label>
				<div class="div_texbox">
					<input type="text" name="email" id="email" value="${fornecedor.email}"/>
				</div>
				<div class="button_div">
					<input name="cadastrar" type="submit" value="Cadastrar" class="buttons"/>
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