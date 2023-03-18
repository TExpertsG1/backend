package br.com.hotel1800.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.hotel1800.infra.JPAFactory;
import br.com.hotel1800.modelo.Cargo;

public class CargoDAO {

	public void insere(Cargo cargo) throws SQLException {
		
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(cargo);
		em.getTransaction().commit();
		em.close();
	}

	public List<Cargo> listagem() {
		EntityManager em = JPAFactory.getEntityManager();
	    return em.createQuery("select c from Cargo c", Cargo.class).getResultList();
	}
	

	public void deletar(Integer id) {
	    EntityManager em = JPAFactory.getEntityManager();
	    em.getTransaction().begin();
	    Cargo cargo = em.find(Cargo.class, id);
	    em.remove(cargo);
	    em.getTransaction().commit();
	    em.close();
	}

}



	
//	Connection conn = FabricaDeConexao.CriaConexao();
//
//	String sql = "insert into cargo(cargo,salario) values(?,?)";
//	PreparedStatement st = conn.prepareStatement(sql);
//
//	st.setString(1, cargo.getCargo());
//	st.setDouble(2, cargo.getSalario());
//
//	st.execute();
//
//	System.out.println("Cargo " + cargo + " adicionado");
//	st.close();
//	conn.close();
//}

//	public void update(Cargo cargo) throws SQLException  {
//		Connection conn = FabricaDeConexao.CriaConexao();
//				
//		String sql = "update cargo set cargo = ?, salario = ?  where idcargos = ?";
//		PreparedStatement st = conn.prepareStatement(sql);
//		st.setString(1, cargo.getCargo());
//		st.setDouble(2, cargo.getSalario());
//		st.setInt(3, cargo.getIdcargos());
//		st.execute();
//		System.out.println("Cargo Alterado com Sucesso");
//		
//		st.close();
//		conn.close();
//	}
//
//	public List<Cargo> listagem() throws SQLException {
//		
//		EntityManager em = JPAFactory.getEntityManager();
//	    return em.createQuery("select c from cargo c", Cargo.class).getResultList();
//		em.close();
//		
//		Connection conn = FabricaDeConexao.CriaConexao();
//		System.out.println("Banco de Dados Conectado");
//
//		String sql = "select * from cargo";
//		PreparedStatement st = conn.prepareStatement(sql);
//		ResultSet rs = st.executeQuery();

//		List<Cargo> cargos = new ArrayList<>();
//
//		while (rs.next()) {
//			Cargo cargo = new Cargo(rs.getInt("idcargos"), rs.getString("cargo"), rs.getDouble("salario"));
//
//			cargos.add(cargo);
//		}
//
//		cargos.forEach(cargo1 -> System.out.println(cargo1));
//
//		rs.close();
//		st.close();
//		conn.close();
//		return cargos;
//
//	}
//
//	public void delete(int idcargos) throws SQLException {
//		Connection conn = FabricaDeConexao.CriaConexao();
//
//		String sql = "delete from cargo where idcargos = ?";
//		PreparedStatement st = conn.prepareStatement(sql);
//		st.setInt(1, idcargos); // Posição e o atributo
//		st.execute();
//
//		System.out.println("Cargo de id: " + idcargos + " foi removido");
//
//		st.close();
//		conn.close();
//	}
//
//	public Cargo buscaPor(int idcargos) throws SQLException {
//		Cargo cargo = null;
//
//		Connection conn = FabricaDeConexao.CriaConexao();
//		String sql = "select * from cargo where idcargos = ?";
//		PreparedStatement st = conn.prepareStatement(sql);
//		st.setInt(1, idcargos);
//		ResultSet rs = st.executeQuery();
//
//		if (rs.next()) {
//			cargo = new Cargo(rs.getInt("idcargos"), rs.getString("cargo"), rs.getDouble("salario")
//
//			);
//		}
//		rs.close();
//		st.close();
//		conn.close();
//		return cargo;
//
//	}

//}
