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
	<h3>Lista de Funcionários</h3>
	<br />
	<a href="/hotel1800/formFuncionario">Cadastrar Funcionário</a>
	<br />
	<br />
	<table>
		<tr>
			<td colspan="1">CPF</td>
			<td>Nome</td>
		</tr>
		<c:forEach var="funcionario" items="${funcionario}">
			<tr>
				<td><a
					href="/hotel1800/buscaFuncionario?cpf=${funcionario.cpf}">${funcionario.cpf}</a></td>
				<td>${funcionario.nome}</td>
				<td>
					<button onclick="excluirFuncionario(${funcionario.getCpf()})">Excluir</button>
				</td>
								
			</tr>
		</c:forEach>
		<script>
    		function excluirFuncionario(cpf) {
     			  if (confirm("Tem certeza que deseja excluir este Funcionário?")) {
            	window.location.href = "/hotel1800/deletarfuncionario?cpf=" + cpf;
      			  }
     			  
  
   			 }
			</script>

	</table>
	<br />
	<a href="/hotel1800/listaSistema.jsp">Voltar</a>


</body>
</html>