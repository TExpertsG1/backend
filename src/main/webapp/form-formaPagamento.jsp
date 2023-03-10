<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/hotel1800/cadastrapagamento" method="post">
		<b> Forma de Pagamento: </b> <input type="text" name="forma_pagamento">
		<br /> <b>Id Reserva:</b> <input type="text" name="idreserva">
		<br /> <input type="submit" value="Enviar">
	</form>
</body>
</html>