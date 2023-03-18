<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/hotel1800/cadastracargo" method="post">
		<b>CNPJ Hotel: </b> <input	type="text" name="hotel_cnpj"> 
		 <br /> 
		 <b>Nome do Quarto: </b> <input	type="text" name="nomeQuarto"> 
		 <br /> 
		 <b>Numero: </b> <input	type="text" name="numero"> 
		 <br /> 
		 <b>Capacidade: </b> <input	type="text" name="capacidade"> 
		 <br /> 
		 <b>Diária: </b> <input type="text"	name="diaria"> 
		<br /> 
			<input type="submit" value="Enviar">
	</form>
	<br />
	<br />
	<a href="/hotel1800/listaQuarto">Voltar</a>
	
</body>
</html>