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
	<h3>Lista de Cargos</h3>
	<br />
	<br />
	<a href="/hotel1800/formCargo"> Cadastrar Cargo</a>
	<br />
	<br />
	<table>
		<c:forEach var="cargo" items="${cargo}">
			<tr>
				<td>${cargo.idcargos}</td>
				<td>${cargo.cargo}</td>
				<td>${cargo.salario}</td>
<%-- 				<td> <a href='/hotel1800/deletar?idcargos=" ${cargo.getIdcargos()} "'>Excluir</a></td> --%>
			</tr>
		</c:forEach>
	</table>

	<br />
	<br />
	<a href="/hotel1800/listaSistema.jsp">Voltar</a>

</body>
</html>