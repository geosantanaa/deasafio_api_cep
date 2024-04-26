package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
	
	private static final String url = "jdbc:mysql://localhost:3306/apiendereco";
	private static final String user = "root";
	private static final String password = "root";
	
	private static Connection conn;
	
	//configuracao para estabelecer conexao com o banco de dados
	public static Connection getConection() {
		try {
			if(conn == null){
				conn = DriverManager.getConnection(url, user, password);
				return conn;
			}else {
				return conn;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
