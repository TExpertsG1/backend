<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/hotel1800/cadastrafuncionario" method="post">
		<b>CPF: </b> <input	type="text" name="cpf"> <br /> 
		<b>Nome: </b> <input type="text" name="nome"><br />
		<b>Data de Nascimento: </b> <input type="text"name="data_nascimento"><br />
		<b>Data de Admissão: </b> <input type="text" name="data_admissao"><br />
		<b>Data de Demissão: </b> <input type="text"name="data_demissao"><br />
		<b>Logradouro: </b> <input type="text"name="logradouro"><br />
		<b>Número: </b> <input type="text"name="numero"><br />
		<b>Complemento: </b> <input type="text"name="complemento"><br />
		<b>CEP: </b> <input type="text"	name="cep"><br />
		<b>Bairro: </b> <input type="text"	name="bairro"><br />
		<b>Cidade: </b> <input type="text"	name="cidade"> <br />
		<b>UF: </b> <input type="text"	name="uf"><br />
			<input type="submit" value="Enviar">
	
	</form>
	<a href="/hotel1800/listaSistema.jsp">Voltar</a>
</body>
</html>