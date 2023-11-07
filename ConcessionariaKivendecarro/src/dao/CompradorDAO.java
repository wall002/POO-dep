package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Carro;
import model.Comprador;

public class CompradorDAO {
	public static boolean adicionarComprador(Comprador comprador) {
		String sql = "INSERT INTO Comprador (nome,cpf,placa_Carro) VALUES(?,?,?)";
		try {
			Connection conexao = FabricaDeConexao.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, comprador.getNome());
			stmt.setString(2, comprador.getCpf());
			stmt.setString(3, comprador.getPlaca_Carro());
			stmt.execute();
			conexao.close();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		return false;
	}
	
	public static boolean atualizarComprador(Comprador comprador){
        String sql = "UPDATE Comprador SET nome = ?, cpf = ?, placa_Carro = ? WHERE id = ?";
        try{
        	Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, comprador.getNome());
            stmt.setString(2, comprador.getCpf());
            stmt.setString(3, comprador.getPlaca_Carro());
            stmt.setInt(4, comprador.getId());
            int rowsAffected = stmt.executeUpdate();
            conexao.close();
            if (rowsAffected > 0) {
                return true;
            } else {
                System.out.println("O id não existe.");
                return false;
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());            
        }
        return false;
    }
    
    public static boolean apagarComprador(Comprador comprador){
        String sql = "DELETE FROM Comprador WHERE id = ?";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, comprador.getId());
            int rowsAffected = stmt.executeUpdate();
            conexao.close();
            if (rowsAffected > 0) {
                return true;
            } else {
                System.out.println("O id não existe.");
                return false;
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());            
        }
        return false;
    }

	public static List<Comprador> listarCompradores() {
		List<Comprador> compradores = new ArrayList<>();
		String sql = "SELECT id, nome, cpf, placa_Carro " + "FROM Comprador";
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
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String placa_Carro = rs.getString("placa_Carro");
				Comprador comprador = new Comprador(id, nome, cpf, placa_Carro);
				compradores.add(comprador);
				System.out.println(comprador.toString());
			}
			conexao.close();
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		return compradores;
	}

	public static List<Comprador> listarCompradoresPorNome(String nomeDePesquisa) {
		List<Comprador> compradores = new ArrayList<>();
		String sql = "SELECT id, nome, cpf, placa_Carro " + "FROM Comprador " + "WHERE nome like CONCAT(?,'%')";
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
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String placa_Carro = rs.getString("placa_Carro");
				Comprador comprador = new Comprador(id,nome,cpf,placa_Carro);
				compradores.add(comprador);
			}
			conexao.close();
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		return compradores;
	}

}
