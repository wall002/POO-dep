package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Dependente;

public class DependenteDAO {
	public static boolean adicionarDependente(Dependente dependente) {
		String sql = "INSERT INTO Dependente (codigoDoFuncionario,nome,mesada) VALUES(?,?,?)";
		try {
			Connection conexao = FabricaDeConexao.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, dependente.getCodigoDoFuncionario());
			stmt.setString(2, dependente.getNome());
			stmt.setDouble(3, dependente.getMesada());
			stmt.execute();
			conexao.close();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		return false;
	}

	public static List<Dependente> listarDependentes() {
		List<Dependente> dependentes = new ArrayList<>();
		String sql = "SELECT codigo, codigoDoFuncionario, nome, mesada " + "FROM Dependente";
		try {
			Connection conexao = FabricaDeConexao.getConexao();
			if (conexao == null) {
				System.out.println("Sem conexao");
				System.exit(0);
			}
			Statement stmt = conexao.createStatement();
			System.out.println("Statement criada!");
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Query executada!");
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				int codigoDoFuncionario = rs.getInt("codigoDoFuncionario");
				String nome = rs.getString("nome");
				double mesada = rs.getDouble("mesada");
				Dependente dependente = new Dependente(codigo, codigoDoFuncionario, nome, mesada);
				dependentes.add(dependente);
				System.out.println(dependente.toString());
			}
			conexao.close();
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		return dependentes;
	}

	public static List<Dependente> listarDependentesPorNome(String nomeDePesquisa) {
		List<Dependente> dependentes = new ArrayList<>();
		String sql = "SELECT codigo, codigoDoFuncionario, nome, mesada " + "FROM Dependente " + "WHERE nome like CONCAT(?,'%')";
		try {
			Connection conexao = FabricaDeConexao.getConexao();
			if (conexao == null) {
				System.out.println("Sem conexao");
				System.exit(0);
			}
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nomeDePesquisa);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				int codigoDoFuncionario = rs.getInt("codigoDoFuncionario");
				String nome = rs.getString("nome");
				double mesada = rs.getDouble("mesada");
				Dependente dependente = new Dependente(codigo, codigoDoFuncionario, nome, mesada);
				dependentes.add(dependente);
			}
			conexao.close();
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		return dependentes;
	}

}
