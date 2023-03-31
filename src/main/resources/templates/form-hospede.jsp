<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/hotel1800/cadastrahospede" method="post">
		<b>CPF: </b> <input	type="text" name="cpf"> 
		 <br /> 
		<b>Nome: </b> <input type="text"	name="nome"> 
		<br />
		<b>Data de Nascimento: </b> <input type="text"	name="data_nascimento"> 
		<br />
		<b>Telefone: </b> <input type="text" name="telefone"> 
		<br />
		<b>Email: </b> <input type="text"	name="email"> 
		<br /> 
			<input type="submit" value="Enviar">
	
	</form>
	<a href="/hotel1800/listaSistema.jsp">Voltar</a>
</body>
</html>