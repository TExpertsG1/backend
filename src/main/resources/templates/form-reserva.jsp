<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<form action="/hotel1800/cadastrareserva" method="post">
		 
		<b>ID Quarto </b> <input type="text"	name="idquarto"> 
		<br />
		<b>CPF Hospede</b> <input type="text"	name="hospede_cpf"> 
		<br />
		<b>Quantidade de Adultos </b> <input type="text" name="quantidade_adulto"> 
		<br />
		<b>Quantidade de Crianças </b> <input type="text" name="quantidade_crianca"> 
		<br />
		<b>Data Check-IN </b> <input type="text" name="data_check_in"> 
		<br />
		<b>Data Check-Out </b> <input type="text" name="data_check_out"> 
		
			<input type="submit" value="Enviar">
	
	</form>
	<a href="/hotel1800/listaSistema.jsp">Voltar</a>
</body>
</body>
</html>