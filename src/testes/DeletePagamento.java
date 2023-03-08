package testes;

import java.sql.SQLException;

import dao.FormaDePagamentoDAO;

public class DeletePagamento {

	public static void main(String[] args) throws SQLException {
		FormaDePagamentoDAO pagamento = new FormaDePagamentoDAO();
		pagamento.delete(3);

	}

}
