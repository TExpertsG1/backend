package testes;

import java.sql.SQLException;

import dao.HospedeDAO;

public class DeleteHospede {

	public static void main(String[] args) throws SQLException {
		
		HospedeDAO hosp = new HospedeDAO();
		hosp.delete("32839634728");

		}

}
