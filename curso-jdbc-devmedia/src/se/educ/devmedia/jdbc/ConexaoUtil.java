package se.educ.devmedia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoUtil {
	
	private static ConexaoUtil conexaoUtil;
	
	// Instantiate the config file
	private static ResourceBundle config;	
	
	
	
	private ConexaoUtil() {
		//Recovers the entire config file.
		config = ResourceBundle.getBundle("config");
	}
	
	
	//Connection Singleton..
	public static ConexaoUtil getInstance(){
		
		if(conexaoUtil==null){
			conexaoUtil = new ConexaoUtil();
		}
		return conexaoUtil;
		
	}
	
	// Connection with SQL using: java.sql.Connection!
	public Connection getConnection() throws ClassNotFoundException, SQLException{ 
		
		Class.forName(config.getString("jdbc_mysql_drive")); 		
		return DriverManager.getConnection(config.getString("url_connection"), config.getString("username"), config.getString("password"));		
		
	}
	
	public static void main(String[] args) {
		
		try {
			System.out.println(getInstance().getConnection()); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
