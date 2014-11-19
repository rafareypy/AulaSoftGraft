<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Fornecedor</title>
<link rel="stylesheet"  type="text/css" href="principal.css"  />
</head>
<body>

<div id="container" >
<div id="top" >
<h1>Cadastro de Fornecedor:</h1>
<h3>${mensagem}</h3>
</div>
<div id="leftSide" >
<fieldset>
<legend>Fornecedor</legend>
<form action="SoftgrafController" method="post" class="form" >	
<input type="hidden" name="cmd" value="cadastrarFornecedor"></input>
<label for="nome">Nome*</label>
<div class="div_texbox">
<input type="text" name="nome" id="nome" value="${fornecedor.nome}"/>
</div>
<label for="endereco">Endereço</label>
<div class="div_texbox">
<input type="text" name="endereco" id="endereco" value="${fornecedor.endereco}"/>
</div>
<label for="email">email</label>
<div class="div_texbox">
<input type="text" name="email" id="email" value="${fornecedor.email}"/>
</div>
<label for="bairro">Bairro</label>
<div class="div_texbox">
<input type="text" name="bairro" id="bairro" value="${fornecedor.bairro}"/>
</div>	
<div class="button_div">
<input name="cadastrar" type="submit" value="Cadastrar" class="buttons"/>
</div>	
</form>
</fieldset>	
</div>
<div id="rightSide" >
<c:import url="menu.jsp"></c:import>
</div>
</div>

</body>
</html>