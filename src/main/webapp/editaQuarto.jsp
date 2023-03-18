<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Quarto</title>
</head>
<body>
	<form action="/hotel1800/atualizaquarto" method="post">
		 
		<b>ID do Quarto</b> <input type="text" name="id" value="${quarto.id}" readonly> 
		<br />
		<b>Hotel CNPJ </b> <input type="text"	name="hotel_cnpj" value="${quarto.hotelCnpj}"> 
		<br />
		<b>Nome do Quarto</b> <input type="text"	name="nomeQuarto" value="${quarto.nome}"> 
		<br />
		<b>Número do Quarto </b> <input type="text" name="numero" value="${quarto.numero}"> 
		<br />
		<b>Capacidade </b> <input type="text" name="capacidade" value="${quarto.capacidade}"> 
		<br />
		<b>Valor da Diária </b> <input type="text" name="diaria" value="${quarto.diaria}"> 
		<br />
		
		<input type="submit" value="Atualizar">
	
	</form>
	<a href="/hotel1800/listaSistema.jsp">Voltar</a>
</body>
</html>