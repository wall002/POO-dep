package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Carro;

public class CarroDAO {
    public static boolean adicionarCarro(Carro carro){
        String sql = "INSERT INTO Carro (placa, modelo, ano, cor) VALUES(?, ?, ?, ?)";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getAno());
            stmt.setString(4, carro.getCor());
            
            stmt.execute();
            conexao.close();
            return true;
        }catch (SQLException ex){
            System.out.println(ex.toString());            
        }
        return false;
    }
    
    public static boolean atualizarCarro(Carro carro){
        String sql = "UPDATE Carro SET modelo = ?, ano = ?, cor = ? WHERE placa = ?";
        try{
        	Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, carro.getModelo());
            stmt.setInt(2, carro.getAno());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getPlaca());
            int rowsAffected = stmt.executeUpdate();
            conexao.close();
            if (rowsAffected > 0) {
                return true;
            } else {
                System.out.println("A placa não existe.");
                return false;
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());            
        }
        return false;
    }
    
    public static boolean apagarCarro(Carro carro){
        String sql = "DELETE FROM Carro WHERE placa = ?";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, carro.getPlaca());
            int rowsAffected = stmt.executeUpdate();
            conexao.close();
            if (rowsAffected > 0) {
                return true;
            } else {
                System.out.println("A placa não existe.");
                return false;
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());            
        }
        return false;
    }

    //Criar os métodos para atualizar, deletar, listar por atributos
 
    public static List<Carro> listarCarros(){
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT placa, modelo, ano, cor "
                + "FROM Carro";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            if (conexao == null){
                System.out.println("Sem conexao");
                System.exit(0);
            }            
            Statement stmt = conexao.createStatement();
            System.out.println("Statement criada!");
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Query executada!");
            while (rs.next()){
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                String cor = rs.getString("cor");
                Carro carro = new Carro(placa, modelo, ano, cor);
                carros.add(carro);
                System.out.println(carro.toString());
            }
            conexao.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return carros;
    }
    
    public static List<Carro> listarCarrosPorModelo(String modeloDePesquisa){
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT placa, modelo, ano, cor "
                + "FROM Carro "
                + "WHERE modelo like CONCAT(?,'%')";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            if (conexao == null){
                System.out.println("Sem conexao");
                System.exit(0);
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, modeloDePesquisa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                String cor = rs.getString("cor");
                Carro carro = new Carro(placa, modelo, ano, cor);
                carros.add(carro);
            }
            conexao.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return carros;
    }       
    
}
