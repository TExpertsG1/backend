package testes;

import java.sql.SQLException;

import dao.FuncionarioDAO;
import modelo.Funcionario;

public class UpdateFuncionario {

	public static void main(String[] args) throws SQLException {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario func = dao.buscaPor("32539752194");
		
		System.out.println(func);
		
		func.setCidade("Rio de Janeiro");
		func.setUf("RJ");
		dao.update(func);
		
		Funcionario funcAlterado = dao.buscaPor("32539752194");
		System.out.println(funcAlterado);

	}

}
