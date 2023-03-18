<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<b>ID Reserva:</b> ${reserva.idreserva}</td><br />
		<b>ID Quarto:</b> ${reserva.idquarto}</td><br />
		<b>CPF Hospede: </b> ${reserva.hospede_cpf}</td><br />
		<b>Quantidade Adultos</b> ${reserva.quantidade_adulto}</td><br />
		<b>Quantidade Crianças</b> ${reserva.quantidade_crianca}</td><br />
		<b>Data Check-IN</b> ${reserva.data_check_in}</td><br />
		<b>Data Check-OUT </b>${reserva.data_check_out}</td><br />
		
		<br />
		<br />
	
	<a href ="/hotel1800/listaReserva"> Voltar </a>
</body>
</html>