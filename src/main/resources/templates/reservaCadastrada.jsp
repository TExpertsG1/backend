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
	<h3>Lista de Reservas</h3>
	<br />
	<a href="/hotel1800/formReserva">Cadastrar Reserva</a>
	<br />
	<br />
	<table>
		<tr>
			<td colspan="1">ID Reserva</td>
			<td>Nome</td>
		</tr>
		<c:forEach var="reserva" items="${reserva}">
			<tr>
				<td><a
					href="/hotel1800/buscaReserva?idreserva=${reserva.idreserva}">${reserva.idreserva}</a></td>
				<td>${reserva.hospede_cpf}</td>
				<td>
					<button onclick="excluirReserva(${reserva.getIdreserva()})">Excluir</button>
				</td>
								
			</tr>
		</c:forEach>
		<script>
    		function excluirReserva(idreserva) {
     			  if (confirm("Tem certeza que deseja excluir esta Reserva?")) {
            	window.location.href = "/hotel1800/deletareserva?idreserva=" + idreserva;
      			  }
     			  
  
   			 }
			</script>

	</table>
	<br />
	<a href="/hotel1800/listaSistema.jsp">Voltar</a>
	</body>
</html>