package br.com.hotel1800.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import br.com.hotel1800.infra.JPAFactory;
import br.com.hotel1800.modelo.FormaDePagamento;

public class FormaDePagamentoDAO {

	public void insere(FormaDePagamento pagamento) throws SQLException {
		
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(pagamento);
		em.getTransaction().commit();
		em.close();

	}
////		Connection conn = FabricaDeConexao.CriaConexao();
////
////		String sql = "insert into forma_de_pagamento(idpagamento,forma_pagamento,idreserva) values(?,?,?)";
////		PreparedStatement st = conn.prepareStatement(sql);
////		st.setInt(1, pagamento.getIdpagamento());
////		st.setString(2, pagamento.getForma_pagamento());
////		st.setDouble(3, pagamento.getIdreserva());
////
////		st.execute();
////
////		System.out.println("Pagamento: " + pagamento + " adicionado");
////		st.close();
////		conn.close();
////	}
//
//	public void update(FormaDePagamento pagamento) throws SQLException {
//		Connection conn = FabricaDeConexao.CriaConexao();
//
//		String sql = "update forma_de_pagamento set forma_pagamento = ?, idreserva = ?  where idpagamento = ?";
//		PreparedStatement st = conn.prepareStatement(sql);
//		st.setString(1, pagamento.getForma_pagamento());
//		st.setDouble(2, pagamento.getIdreserva());
//		st.setInt(3, pagamento.getIdpagamento());
//		st.execute();
//		System.out.println("Pagamento Alterado com Sucesso");
//
//		st.close();
//		conn.close();
//	}
//
//	public List<FormaDePagamento> listagem() throws SQLException {
//		Connection conn = FabricaDeConexao.CriaConexao();
//		System.out.println("Banco de Dados Conectado");
//
//		String sql = "select * from forma_de_pagamento";
//		PreparedStatement st = conn.prepareStatement(sql);
//		ResultSet rs = st.executeQuery();
//
//		List<FormaDePagamento> pagamentos = new ArrayList<>();
//
//		while (rs.next()) {
//			FormaDePagamento pagamento = new FormaDePagamento(rs.getInt("idpagamento"), rs.getString("forma_pagamento"),
//					rs.getInt("idreserva"));
//
//			pagamentos.add(pagamento);
//		}
//
//		pagamentos.forEach(pagamento -> System.out.println(pagamento));
//
//		rs.close();
//		st.close();
//		conn.close();
//		return pagamentos;
//
//	}
//
//	public void delete(int idpagamento) throws SQLException {
//		Connection conn = FabricaDeConexao.CriaConexao();
//
//		String sql = "delete from forma_de_pagamento where idpagamento = ?";
//		PreparedStatement st = conn.prepareStatement(sql);
//		st.setInt(1, idpagamento);
//		st.execute();
//
//		System.out.println("Pagamento de id: " + idpagamento + " foi removido");
//
//		st.close();
//		conn.close();
//	}
//
//	public FormaDePagamento buscaPor(int idpagamento) throws SQLException {
//		FormaDePagamento pagamento = null;
//
//		Connection conn = FabricaDeConexao.CriaConexao();
//		String sql = "select * from forma_de_pagamento where idpagamento = ?";
//		PreparedStatement st = conn.prepareStatement(sql);
//		st.setInt(1, idpagamento);
//		ResultSet rs = st.executeQuery();
//
//		if (rs.next()) {
//			pagamento = new FormaDePagamento(
//					rs.getInt("idpagamento"), 
//					rs.getString("forma_pagamento"), 
//					rs.getInt("idreserva")
//
//			);
//		}
//		rs.close();
//		st.close();
//		conn.close();
//		return pagamento;
//
//	}

}
