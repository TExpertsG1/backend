package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infra.FabricaDeConexao;
import modelo.Quarto;

public class QuartoDAO {

	public void insere(Quarto quarto) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "insert into quarto(idquarto,hotel_cnpj,nomeQuarto,numero,capacidade,diaria) values(?,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, quarto.getIdquarto());
		st.setString(2, quarto.getHotel_cnpj());
		st.setString(3, quarto.getNomeQuarto());
		st.setInt(4, quarto.getNumero());
		st.setInt(5, quarto.getCapacidade());
		st.setDouble(6, quarto.getDiaria());
		
		System.out.println("Quarto " + quarto + " adicionado");
		st.close();
		conn.close();
	}

	public void update(Quarto quarto) throws SQLException  {
		Connection conn = FabricaDeConexao.CriaConexao();
				
		String sql = "update quarto set idquarto = ?, hotel_cnpj=?, nomeQuarto = ?, numero=?, capacidade = ?, diaria = ?  where idquarto = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, quarto.getIdquarto());
		st.setString(2, quarto.getHotel_cnpj());
		st.setString(3, quarto.getNomeQuarto());
		st.setInt(4, quarto.getNumero());
		st.setInt(5, quarto.getCapacidade());
		st.setDouble(6, quarto.getDiaria());
		st.setInt(7, quarto.getIdquarto());
		st.execute();
		System.out.println("Quarto Alterado com Sucesso");
		
		st.close();
		conn.close();
	}

	public List<Quarto> listagem() throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();
		System.out.println("Banco de Dados Conectado");

		String sql = "select * from quarto";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		List<Quarto> quartos = new ArrayList<>();

		while (rs.next()) {
			
			Quarto quarto = new Quarto(
				rs.getInt("idquarto"),
				rs.getString("hotel_cnpj"),
				rs.getString("nomeQuarto"),
				rs.getInt("numero"),
				rs.getInt("capacidade"),
				rs.getDouble("diaria")
				
				);

			quartos.add(quarto);
		}

		quartos.forEach(quarto -> System.out.println(quarto));

		rs.close();
		st.close();
		conn.close();
		return quartos;

	}

	public void delete(int idquarto) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "delete from quarto where idquarto = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, idquarto); // Posi  o e o atributo
		st.execute();

		System.out.println("Quarto de id: " + idquarto + " foi removido");

		st.close();
		conn.close();
	}

	public Quarto buscaPor(int idquarto) throws SQLException {
		Quarto quarto = null;

		Connection conn = FabricaDeConexao.CriaConexao();
		String sql = "select * from quarto where idquarto = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, idquarto);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			quarto = new Quarto(
					rs.getInt("idquarto"),
					rs.getString("hotel_cnpj"),
					rs.getString("nomeQuarto"),
					rs.getInt("numero"),
					rs.getInt("capacidade"),
					rs.getDouble("diaria")
					
					);
		}
		rs.close();
		st.close();
		conn.close();
		return quarto;

	}


}
