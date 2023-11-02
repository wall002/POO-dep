package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	public static Connection getConexao(){
            
            try{
		String database = "jdbc:mysql://127.0.0.1:3306/POOTBL";
		String usuario = "root";
		String senha = "root";
                Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexao = DriverManager.getConnection(database, usuario, senha);
		return conexao;
            }catch(ClassNotFoundException e1){
                System.out.println(e1.toString());
            }catch(SQLException e2){
                System.out.println(e2.toString());
            }
            return null;
	}
}