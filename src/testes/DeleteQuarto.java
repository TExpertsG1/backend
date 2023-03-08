package testes;

import java.sql.SQLException;

import dao.QuartoDAO;

public class DeleteQuarto {

	public static void main(String[] args) throws SQLException {
		QuartoDAO quarto = new QuartoDAO();
		quarto.delete(4);

	}

}
