<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Insert title here</title>
		</head>

		<body>
			<h3>Lista de Quartos</h3>
			<br />
			<a href="/hotel1800/formQuarto">Cadastrar Quartos</a>
			<br />
			<br />
			<table>
				<c:forEach var="quarto" items="${quarto}">
					<tr>
						<td><a href="/hotel1800/buscaQuarto?idquarto=${quarto.idquarto}">${quarto.idquarto}</a> -
							${quarto.hotel_cnpj} - ${quarto.nomeQuarto} </td>
						<td>
							<button onclick="excluirQuarto(${quarto.idquarto})">Excluir</button>
						</td>
						<td>
							<button onclick="editQuarto(${quarto.idquarto})">Alterar</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br />
			<a href="/hotel1800/listaSistema.jsp">Voltar</a>
			<script>
				function excluirQuarto(idquarto) {
					if (confirm("Tem certeza que deseja excluir este Quarto?")) {
						window.location.href = "/hotel1800/deletarquarto?idquarto=" + idquarto;
					}

				}
				function editQuarto(idquarto) {
					if (confirm("Tem certeza que deseja atualizar este Quarto?")) {
						window.location.href = "/hotel1800/atualizaquarto?idquarto=" + idquarto;
					}
				}
			</script>
		</body>

		</html>