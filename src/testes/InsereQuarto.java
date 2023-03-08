package testes;

import java.sql.SQLException;

import dao.QuartoDAO;
import modelo.Quarto;

public class InsereQuarto {

	public static void main(String[] args) throws SQLException {
		Quarto quarto = new Quarto(
				"39792157000132",
				"Suite MEGA Premium",
				106,
				6,
				650.00
				);
		
		QuartoDAO quartoDAO = new QuartoDAO();
		quartoDAO.insere(quarto);
	}
}
