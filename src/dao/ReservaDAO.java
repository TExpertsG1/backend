package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infra.FabricaDeConexao;
import modelo.Cargo;
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

	public void update(Reserva reserva) throws SQLException  {
		Connection conn = FabricaDeConexao.CriaConexao();
				
		String sql = "update reserva set idquarto = ?, quantidade_adulto = ?, quantidade_crianca=?, data_check_in = ?, data_check_out = ?  where idreserva = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, reserva.getIdquarto());
		st.setInt(2, reserva.getQuantidade_adulto());
		st.setInt(3, reserva.getQuantidade_crianca());
		st.setDate(5, Date.valueOf(reserva.getData_check_in()));
		st.setDate(6, Date.valueOf(reserva.getData_check_out()));
		st.execute();
		System.out.println("Reserva Alterada com Sucesso");
		
		st.close();
		conn.close();
	}

	public List<Cargo> listagem() throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();
		System.out.println("Banco de Dados Conectado");

		String sql = "select * from cargo";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		List<Cargo> cargos = new ArrayList<>();

		while (rs.next()) {
			Cargo cargo = new Cargo(rs.getInt("idcargos"), rs.getString("cargo"), rs.getDouble("salario"));

			cargos.add(cargo);
		}

		cargos.forEach(cargo1 -> System.out.println(cargo1));

		rs.close();
		st.close();
		conn.close();
		return cargos;

	}

	public void delete(int idcargos) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "delete from cargo where idcargos = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, idcargos); // Posição e o atributo
		st.execute();

		System.out.println("Cargo de id: " + idcargos + " foi removido");

		st.close();
		conn.close();
	}

	public Cargo buscaPor(int idreserva) throws SQLException {
		Reserva reserva = null;

		Connection conn = FabricaDeConexao.CriaConexao();
		String sql = "select * from reserva where idreserva = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, idreserva);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			reserva = new Reserva(rs.getInt("idreserva"), rs.getInt("idquarto"),rs.getStrint("cpf"),
			);
		}
		rs.close();
		st.close();
		conn.close();
		return cargo;

	}


}
