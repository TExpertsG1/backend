package testes;

import java.sql.SQLException;

import dao.FuncionarioDAO;

public class DeleteFuncionario {

		public static void main(String[] args) throws SQLException {
			
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			funcDAO.delete("32539752193");

			}

}
