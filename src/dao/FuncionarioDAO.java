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
import modelo.Funcionario;

public class FuncionarioDAO {

	public void insere(Funcionario funcionario) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "insert into funcionario(cpf,idcargos,hotel_cnpj,nome,data_nascimento,data_admissao,data_demissao,logradouro,numero,complemento,bairro,cidade,uf,cep) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, funcionario.getCpf());
			st.setInt(2, funcionario.getIdcargos());
			st.setString(3, funcionario.getHotel_cnpj());
			st.setString(4, funcionario.getNome());
			st.setDate(5, Date.valueOf(funcionario.getData_nascimento()));
			st.setDate(6, Date.valueOf(funcionario.getData_admissao()));
			if (funcionario.getData_demissao() == LocalDate.of(0000, 01, 01)) {
				st.setDate(7, Date.valueOf(funcionario.getData_demissao()));}else
					st.setDate(7, null);
			st.setString(8, funcionario.getLogradouro());
			st.setInt(9, funcionario.getNumero());
			st.setString(10, funcionario.getComplemento());
			st.setString(11, funcionario.getBairro());
			st.setString(12, funcionario.getCidade());
			st.setString(13, funcionario.getUf());
			st.setString(14, funcionario.getCep());

			st.execute();
			
			System.out.println("Funcionário " + funcionario + " adicionado");
			st.close();
			conn.close();
		}


	public void update(Funcionario funcionario) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "update funcionario set idcargos=?, nome=?, data_admissao=?,data_demissao=?,logradouro=?,numero=?,complemento=?,bairro=?,cidade=?,uf=?,cep=?   where cpf = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, funcionario.getIdcargos());
		st.setString(2, funcionario.getNome());
		st.setDate(3, Date.valueOf(funcionario.getData_admissao()));
		st.setDate(4, Date.valueOf(funcionario.getData_demissao()));
		st.setString(5, funcionario.getLogradouro());
		st.setInt(6, funcionario.getNumero());
		st.setString(7, funcionario.getComplemento());
		st.setString(8, funcionario.getBairro());
		st.setString(9, funcionario.getCidade());
		st.setString(10, funcionario.getUf());
		st.setString(11, funcionario.getCep());
		st.setString(12, funcionario.getCpf());
		st.execute();
		System.out.println("Funcionário alteado com Sucesso");

		st.close();
		conn.close();
	}

	public List<Funcionario> listagem() throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();
		System.out.println("Banco de Dados Conectado");

		String sql = "select * from funcionario";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		List<Funcionario> funcionarios = new ArrayList<>();

		while (rs.next()) {
			
			LocalDate nascimento = rs.getDate("data_nascimento").toLocalDate();
			LocalDate dateAdmissao = rs.getDate("data_admissao").toLocalDate();			
			Date dataDemissaoSql = rs.getDate("data_demissao");
		    LocalDate dateDemissao = null;
		    if (dataDemissaoSql != null) {
		    	dateDemissao = dataDemissaoSql.toLocalDate();
		    }
			
			Funcionario func = new Funcionario(rs.getString("cpf"), rs.getInt("idcargos"), rs.getString("hotel_cnpj"),
					rs.getString("nome"), nascimento, dateAdmissao, dateDemissao,
					rs.getString("logradouro"), rs.getInt("numero"),
					rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("uf"),
					rs.getString("cep"));

			funcionarios.add(func);
		}

		funcionarios.forEach(quarto -> System.out.println(quarto));

		rs.close();
		st.close();
		conn.close();
		return funcionarios;

	}

	public void delete(String cpf) throws SQLException {
		Connection conn = FabricaDeConexao.CriaConexao();

		String sql = "delete from funcionario where cpf = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, cpf); // Posição e o atributo
		st.execute();

		System.out.println("Funcionario: " + cpf + " foi removido");

		st.close();
		conn.close();
	}

	public Funcionario buscaPor(String cpf) throws SQLException {
		Funcionario func = null;

		Connection conn = FabricaDeConexao.CriaConexao();
		String sql = "select * from funcionario where cpf = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, cpf);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			
			LocalDate nascimento = rs.getDate("data_nascimento").toLocalDate();
			LocalDate dateAdmissao = rs.getDate("data_admissao").toLocalDate();			
			Date dataDemissaoSql = rs.getDate("data_demissao");
		    LocalDate dateDemissao = null;
		    if (dataDemissaoSql != null) {
		    	dateDemissao = dataDemissaoSql.toLocalDate();
		    }

			func = new Funcionario(rs.getString("cpf"), rs.getInt("idcargos"), rs.getString("hotel_cnpj"),
					rs.getString("nome"), nascimento, dateAdmissao, dateDemissao,
					rs.getString("logradouro"), rs.getInt("numero"),
					rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("uf"),
					rs.getString("cep"));

		}
		rs.close();
		st.close();
		conn.close();
		return func;

	}

}