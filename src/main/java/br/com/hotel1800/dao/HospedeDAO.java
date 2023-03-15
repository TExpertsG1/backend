package br.com.hotel1800.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.hotel1800.infra.JPAFactory;
import br.com.hotel1800.modelo.Hospede;

public class HospedeDAO {

	public void insere(Hospede hospede) throws SQLException {

		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(hospede);
		em.getTransaction().commit();
		em.close();

	}

	public List<Hospede> listagem() {
		EntityManager em = JPAFactory.getEntityManager();
		return em.createQuery("select c from Hospede c", Hospede.class).getResultList();
	}

	public Hospede buscaPor(String cpf) {
		EntityManager em = JPAFactory.getEntityManager();
		return em.find(Hospede.class, cpf);

	}
}

////	public void update(Hospede hospede) throws SQLException  {
////		Connection conn = FabricaDeConexao.CriaConexao();
////				
////		String sql = "update hospede set nome = ?, data_nascimento=?, telefone=?, email=?  where cpf = ?";
////		PreparedStatement st = conn.prepareStatement(sql);
////		st.setString(1, hospede.getNome());
////		st.setDate(2, Date.valueOf(hospede.getData_nascimento()));
////		st.setString(3, hospede.getTelefone());
////		st.setString(4, hospede.getEmail());
////		st.setString(5, hospede.getCpf());
////		st.execute();
////		System.out.println("Hospede Alterado com Sucesso");
////		
////		st.close();
////		conn.close();
////	}
////
////	public List<Hospede> listagem() throws SQLException {
////		Connection conn = FabricaDeConexao.CriaConexao();
////		System.out.println("Banco de Dados Conectado");
////
////		String sql = "select * from hospede";
////		PreparedStatement st = conn.prepareStatement(sql);
////		ResultSet rs = st.executeQuery();
////
////		List<Hospede> hospedes = new ArrayList<>();
////
////		while (rs.next()) {
////			LocalDate nascimento = rs.getDate("data_nascimento").toLocalDate();
////			Hospede hosp = new Hospede(
////					rs.getString("cpf"), 
////					rs.getString("nome"), 
////					nascimento,
////					rs.getString("telefone"),
////					rs.getString("email")
////					);
////			hospedes.add(hosp);
////		}
////
////		hospedes.forEach(hospede -> System.out.println(hospede));
////
////		rs.close();
////		st.close();
////		conn.close();
////		return hospedes;
////
////	}
////
////	public void delete(String cpf) throws SQLException {
////		Connection conn = FabricaDeConexao.CriaConexao();
////
////		String sql = "delete from hospede where cpf = ?";
////		PreparedStatement st = conn.prepareStatement(sql);
////		st.setString(1, cpf); // Posição e o atributo
////		st.execute();
////
////		System.out.println("Cargo de id: " + cpf + " foi removido");
////
////		st.close();
////		conn.close();
////	}
////
////	public Hospede buscaPor(String cpf) throws SQLException {
////		Hospede hosp = null;
////
////		Connection conn = FabricaDeConexao.CriaConexao();
////		String sql = "select * from hospede where cpf = ?";
////		PreparedStatement st = conn.prepareStatement(sql);
////		st.setString(1, cpf);
////		ResultSet rs = st.executeQuery();
////
////		if (rs.next()) {
////			LocalDate nascimento = rs.getDate("data_nascimento").toLocalDate();
////			hosp = new Hospede(rs.getString("cpf"), 
////							   rs.getString("nome"),
////							   nascimento,
////							   rs.getString("telefone"),
////							   rs.getString("email")
////
////			);
////		}
////		rs.close();
////		st.close();
////		conn.close();
////		return hosp;
//
//	}


