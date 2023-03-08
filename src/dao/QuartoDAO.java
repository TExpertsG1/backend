package dao;

import java.sql.Connection;
import java.sql.Date;
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

		String sql = "insert into quarto(hotel_cnpj,nomeQuarto,numero,capacidade,diaria) values(?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);

		st.setString(1, quarto.getHotel_cnpj());
		st.setString(2, quarto.getNomeQuarto());
		st.setInt(3, quarto.getNumero());
		st.setInt(4, quarto.getCapacidade());
		st.setDouble(5, quarto.getDiaria());
		
		System.out.println("Quarto " + quarto + " adicionado");
		st.close();
		conn.close();
	}

	public void update(Quarto quarto) throws SQLException  {
		Connection conn = FabricaDeConexao.CriaConexao();
				
		String sql = "update quarto set idquarto = ?, idquarto = ?, quantidade_adulto = ?, quantidade_crianca=?, data_check_in = ?, data_check_out = ?  where idquarto = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, quarto.getIdquarto());
		st.setInt(2, quarto.getIdquarto());
		st.setString(3, quarto.getHospede_cpf());
		st.setInt(4, quarto.getQuantidade_adulto());
		st.setInt(5, quarto.getQuantidade_crianca());
		st.setDate(6, Date.valueOf(quarto.getData_check_in()));
		st.setDate(7, Date.valueOf(quarto.getData_check_out()));
		st.execute();
		System.out.println("Quarto Alterada com Sucesso");
		
		st.close();
		conn.close();
	}

	public List<Quarto> listagem() throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();
		System.out.println("Banco de Dados Conectado");

		String sql = "select * from quarto";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		List<quarto> quartos = new ArrayList<>();

		while (rs.next()) {
			LocalDate dataCheckIn = rs.getDate("data_check_in").toLocalDate();
			LocalDate dataCheckOut = rs.getDate("data_check_out").toLocalDate();

			Quarto quarto = new Quarto(
				rs.getInt("idquarto"),
				rs.getInt("idquarto"),
				rs.getrsring("hospede_cpf"),
				rs.getInt("quantidade_adulto"),
				rs.getInt("quantidade_crianca"),
				dataCheckIn,
				dataCheckOut
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
			quarto = new quarto(rs.getInt("idquarto"), rs.getInt("idquarto"),rs.getStrint("cpf"),
			);
		}
		rs.close();
		st.close();
		conn.close();
		return quarto;

	}


}
