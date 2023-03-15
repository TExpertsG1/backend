<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Lista de Pagamentos</h3>

	<a href="/hotel1800/formaPgto">Cadastrar novo Pagamento </a>

	<ul>
		<c:forEach var="pagamento" items="${pagamento}">
			<li>${pagamento.idpagamento}-${pagamento.forma_pagamento}-
				${pagamento.idreserva}</li>
		</c:forEach>
		<br />
		<br />

	</ul>
	<a href="/hotel1800/listaSistema.jsp"> Voltar </a>
</body>
</html>