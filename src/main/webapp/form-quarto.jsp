<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/hotel1800/cadastraquarto" method="post">
		 
		<b>Hotel CNPJ </b> <input type="text"	name="hotel_cnpj"> 
		<br />
		<b>Nome do Quarto</b> <input type="text"	name="nomeQuarto"> 
		<br />
		<b>Número do Quarto </b> <input type="text" name="numero"> 
		<br />
		<b>Capacidade </b> <input type="text" name="capacidade"> 
		<br />
		<b>Valor da Diária </b> <input type="text" name="diaria"> 
		<br />
		
		
			<input type="submit" value="Enviar">
	
	</form>
	<a href="/hotel1800/listaSistema.jsp">Voltar</a>
</body>
</html>