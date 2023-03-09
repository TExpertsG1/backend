package testes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.FuncionarioDAO;
import modelo.Funcionario;

public class InsereFuncionario {

	public static void main(String[] args) throws SQLException {
				
		Funcionario func = new Funcionario(
				"32539752192",
				5,
				"39792157000132",
				"Jose",
				LocalDate.parse("15/10/1984", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				LocalDate.parse("10/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				"Rua Y",
				200,
				null,
				"Fundacao",
				"Sao Caetano do Sul",
				"SP","09520610");
		
			
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			funcDAO.insere(func);
			
		}

}
