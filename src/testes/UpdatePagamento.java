package testes;

import java.sql.SQLException;

import dao.FormaDePagamentoDAO;
import modelo.FormaDePagamento;

public class UpdatePagamento {

	public static void main(String[] args) throws SQLException {
		FormaDePagamentoDAO dao = new FormaDePagamentoDAO();
		FormaDePagamento pagamento = dao.buscaPor(2);
		
		System.out.println(pagamento);
		
		pagamento.setForma_pagamento("Débito");
		dao.update(pagamento);
		
		FormaDePagamento pgtoAlterado = dao.buscaPor(2);
		System.out.println(pgtoAlterado);

	}

}
