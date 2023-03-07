package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import infra.FabricaDeConexao;
import modelo.Cargo;
import modelo.Hospede;

public class HospedeDAO {

	public void insere(Hospede hospede) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();
		
		String sql = "insert into hospede(cpf,nome,data_nascimento,telefone,email) values(?,?,?,?,?)";
		
		PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, hospede.getCpf());
			st.setString(2, hospede.getNome());
			st.setDate(3, Date.valueOf(hospede.getData_nascimento()));
			st.setString(4, hospede.getTelefone());
			st.setString(5, hospede.getEmail());

			st.execute();
		
			System.out.println("Hospede: " + hospede + " adicionado");
			st.close();
			conn.close();
		}
	
	public void update(Hospede hospede) throws SQLException  {
		Connection conn = FabricaDeConexao.CriaConexao();
				
		String sql = "update hospede set nome = ?, data_nascimento=?, tefone=?, email=?  where cpf = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, hospede.getNome());
		st.setDate(2, Date.valueOf(hospede.getData_nascimento()));
		st.setString(3, hospede.getTelefone());
		st.setString(4, hospede.getEmail());
		st.execute();
		System.out.println("Hospede Alterado com Sucesso");
		
		st.close();
		conn.close();
	}

	public List<Hospede> listagem() throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();
		System.out.println("Banco de Dados Conectado");

		String sql = "select * from hospede";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		List<Hospede> hospede = new ArrayList<>();

		while (rs.next()) {
			LocalDate nascimento = rs.getDate("data_nascimento").toLocalDate();
			Hospede hosp = new Hospede(
					rs.getString("cpf"), 
					rs.getString("nome"), 
					nascimento,
					rs.getString("telefone"),
					rs.getString("email")
					);
			hospede.add(hosp);
		}

		hospede.forEach(hospede1 -> System.out.println(hospede1));

		rs.close();
		st.close();
		conn.close();
		return hospede;

	}

	public void delete(String cpf) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "delete from hospede where cpf = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, cpf); // Posição e o atributo
		st.execute();

		System.out.println("Cargo de id: " + cpf + " foi removido");

		st.close();
		conn.close();
	}

	public Hospede buscaPor(int cpf) throws SQLException {
		Hospede hosp = null;

		Connection conn = FabricaDeConexao.CriaConexao();
		String sql = "select * from hospede where cpf = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, cpf);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			LocalDate nascimento = rs.getDate("data_nascimento").toLocalDate();
			hosp = new Hospede(rs.getString("cpf"), 
							   rs.getString("nome"),
							   nascimento,
							   rs.getString("telefone"),
							   rs.getString("email")

			);
		}
		rs.close();
		st.close();
		conn.close();
		return hosp;

	}

}


