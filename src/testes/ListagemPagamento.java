package testes;

import java.sql.SQLException;

import dao.FormaDePagamentoDAO;

public class ListagemPagamento {

	public static void main(String[] args) throws SQLException {
		FormaDePagamentoDAO pagamentoDAO = new FormaDePagamentoDAO();
		pagamentoDAO.listagem();
		
	}

}
