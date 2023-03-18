<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<b>CPF: </b>${funcionario.cpf } <br />
	<b>Nome: </b>${funcionario.nome } <br />
	<b>Id Cargo: </b> ${funcionario.idcargos }
	<b>Hotel CNPJ: </b> ${funcionario.hotel_cnpj }
	<b>Data de Nascimento </b>${funcionario.data_nascimento } <br />
	<b>Data de Admissão </b>${funcionario.data_admissao } <br />
	<b>Data de Demissão: </b>${funcionario.data_demissao } <br />
	<b>Logradouro</b>${funcionario.logradouro } <br />
	<b>Numero: </b>${funcionario.numero } <br />
	<b>Complemento: </b>${funcionario.complemento } <br />
	<b>Bairro: </b>${funcionario.bairro } <br />
	<b>Cidade: </b>${funcionario.cidade } <br />
	<b>UF: </b>${funcionario.uf } <br />
	<b>CEP: </b>${funcionario.cep } <br />
	
	
	<br />
	<br />
	<button onclick="updateFuncionario(${funcionario.getCpf()})">Atualizar</button>
	<a href ="/hotel1800/listaFuncionario"> Voltar </a>
	
	<script>
     			 function updateFuncionario(cpf) {
        			  if (confirm("Tem certeza que deseja excluir este Funcionário?")) {
               	window.location.href = "/hotel1800/deletarfuncionario?cpf=" + cpf;
         			  }
   			 }
			</script>
	
</body>


</html>