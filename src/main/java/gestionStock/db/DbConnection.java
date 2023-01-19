package gestionStock.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/stock";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	private String message="mysql jdbc";
	private Connection connection;
	private String sqlQuery;
	private PreparedStatement prepareStatement;
	
	public Connection myConnect() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            this.message = "Driver ok";
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			this.message = "Driver invisible";
		}
		
		try {
			this.connection = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
			this.message = this.message+"Auth ok";
		}catch(SQLException e) {
			this.message = this.message+"Auth echoué";
			e.printStackTrace();
		}
		
		if(this.connection != null) {
			this.message = this.message+"Connexion possible";
		}else {
			this.message = this.message+"Connexion echouée";
		}
		
		return this.connection;
	}
	
	
	
	/**
	 * @param obj
	 */
	/*public void create(Object obj, String table) {
	
	
		sqlQuery = "INSERT INTO "+ table+ " VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			prepareStatement = myConnect().prepareStatement(sqlQuery);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public String getDbMessage() {
		return this.message;
	}
}
