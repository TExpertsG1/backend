package testes;

import java.sql.SQLException;

import dao.QuartoDAO;

public class ListagemQuarto {

	public static void main(String[] args) throws SQLException {

		QuartoDAO quartoDAO = new QuartoDAO();
		quartoDAO.listagem();

	}

}
