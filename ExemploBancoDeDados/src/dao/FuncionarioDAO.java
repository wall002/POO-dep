package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioDAO {
    public static boolean adicionarFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO Funcionario (nome, cargo, salario) VALUES(?, ?, ?)";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.execute();
            conexao.close();
            return true;
        }catch (SQLException ex){
            System.out.println(ex.toString());            
        }
        return false;
    }

    //Criar os métodos para atualizar, deletar, listar por atributos
 
    public static List<Funcionario> listarFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT codigo, nome, cargo, salario "
                + "FROM Funcionario";
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
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                double salario = rs.getDouble("salario");
                Funcionario funcionario = new Funcionario(codigo, nome, cargo, salario);
                funcionarios.add(funcionario);
                System.out.println(funcionario.toString());
            }
            conexao.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return funcionarios;
    }
    
    public static List<Funcionario> listarFuncionariosPorNome(String nomeDePesquisa){
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT codigo, nome, cargo, salario "
                + "FROM Funcionario "
                + "WHERE nome like CONCAT(?,'%')";
        try{
            Connection conexao = FabricaDeConexao.getConexao();
            if (conexao == null){
                System.out.println("Sem conexao");
                System.exit(0);
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeDePesquisa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                double salario = rs.getDouble("salario");
                Funcionario funcionario = new Funcionario(codigo, nome, cargo, salario);
                funcionarios.add(funcionario);
            }
            conexao.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return funcionarios;
    }       
    
}
