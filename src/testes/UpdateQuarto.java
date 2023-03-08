package testes;

import java.sql.SQLException;

import dao.QuartoDAO;
import modelo.Quarto;

public class UpdateQuarto {

		public static void main(String[] args) throws SQLException {
			QuartoDAO dao = new QuartoDAO();
			Quarto quarto = dao.buscaPor(1);

			System.out.println(quarto);

			quarto.setDiaria(350);
			dao.update(quarto);

			Quarto quartAlterado = dao.buscaPor(1);
			System.out.println(quartAlterado);

	}

}
