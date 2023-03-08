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
import modelo.Funcionario;
import modelo.Reserva;

public class ReservaDAO {

	public void insere(Reserva reserva) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "insert into reserva(idquarto,hospede_cpf,quantidade_adulto,quantidade_crianca,data_check_in,data_check_out) values(?,?,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, reserva.getIdquarto());
		st.setString(2, reserva.getHospede_cpf());
		st.setInt(3, reserva.getQuantidade_adulto());
		st.setInt(4, reserva.getQuantidade_crianca());
		st.setDate(5, Date.valueOf(reserva.getData_check_in()));
		st.setDate(6, Date.valueOf(reserva.getData_check_out()));
		st.execute();

		System.out.println("Reserva " + reserva + " adicionado");
		st.close();
		conn.close();
	}

	public void update(Reserva reserva) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "update reserva set idquarto = ?, quantidade_adulto = ?, quantidade_crianca=?, data_check_in = ?, data_check_out = ?  where idreserva = ?";
		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, reserva.getIdquarto());
		st.setInt(2, reserva.getQuantidade_adulto());
		st.setInt(3, reserva.getQuantidade_crianca());
		st.setDate(5, Date.valueOf(reserva.getData_check_in()));
		st.setDate(6, Date.valueOf(reserva.getData_check_out()));
		st.setInt(7, reserva.getIdreserva());
		st.execute();
		System.out.println("Reserva Alterada com Sucesso");

		st.close();
		conn.close();
	}

	public List<Reserva> listagem() throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();
		System.out.println("Banco de Dados Conectado");

		String sql = "select * from reserva";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		List<Reserva> reservas = new ArrayList<>();

		while (rs.next()) {
			LocalDate dataCheckIn = rs.getDate("data_check_in").toLocalDate();
			LocalDate dataCheckOut = rs.getDate("data_check_out").toLocalDate();

			Reserva reserva = new Reserva(
				rs.getInt("idreserva"),
				rs.getInt("idquarto"),
				rs.getString("hospede_cpf"),
				rs.getInt("quantidade_adulto"),
				rs.getInt("quantidade_crianca"),
				dataCheckIn,
				dataCheckOut
				);

			reservas.add(reserva);
		}

		reservas.forEach(reserva -> System.out.println(reserva));

		rs.close();
		st.close();
		conn.close();
		return reservas;

	}
	public void delete(int idreserva) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "delete from reserva where idreserva = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, idreserva); 
		st.execute();

		System.out.println("Reserva de id: " + idreserva + " foi removido");

		st.close();
		conn.close();
	}


	public Reserva buscaPor(int idreserva) throws SQLException {
		Reserva reserva = null;

		Connection conn = FabricaDeConexao.CriaConexao();
		String sql = "select * from reserva where idreserva = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		st.setInt(1,reserva.getIdquarto());
		st.setString(2, reserva.getHospede_cpf());
		st.setInt(3, reserva.getQuantidade_adulto());
		st.setInt(4, reserva.getQuantidade_crianca());
		st.setDate(5, Date.valueOf(reserva.getData_check_in()));
		st.setDate(6, Date.valueOf(reserva.getData_check_out()));

				
		if (rs.next()) {
			
			LocalDate checkIn = rs.getDate("data_check_in").toLocalDate();
			LocalDate checkOut = rs.getDate("data_check_out").toLocalDate();
			
			reserva = new Reserva(
					rs.getInt("idreserva"), 
					rs.getInt("idquarto"),
					rs.getString("hospede_cpf"),
					rs.getInt("quantidade_adulto"),
					rs.getInt("quantidade_crianca"),
					checkIn,
					checkOut
			);
		}
		rs.close();
		st.close();
		conn.close();
		return reserva;

	}

}
