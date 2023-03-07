package testes;

import java.sql.SQLException;

import dao.FuncionarioDAO;

public class ListagemFuncionario {

	public static void main(String[] args) throws SQLException {

		FuncionarioDAO funcDAO = new FuncionarioDAO();
		funcDAO.listagem();
	}
}