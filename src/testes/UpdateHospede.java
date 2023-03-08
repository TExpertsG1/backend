package testes;

import java.sql.SQLException;

import dao.HospedeDAO;
import modelo.Hospede;

public class UpdateHospede {

	public static void main(String[] args) throws SQLException {
		HospedeDAO dao = new HospedeDAO();
		Hospede hosp = dao.buscaPor("32839634757");

		System.out.println(hosp);

		hosp.setTelefone("1125252525");
		dao.update(hosp);

		Hospede hospAlterado = dao.buscaPor("32839634757");
		System.out.println(hospAlterado);

	}
}
