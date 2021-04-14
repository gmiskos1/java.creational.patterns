package creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

	// this is eager loading because is created even we use it or not.
	//private static DbSingleton instance = new DbSingleton();
	
	// this is lazy loading because is created even we use it or not.
	private static volatile DbSingleton instance = null; // volatile keep it thread safe
	private static volatile Connection conn = null;
			
	private DbSingleton() {
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(conn!=null) { // again protect from reflection
			throw new RuntimeException("Use getConnection() method to create");
		}
		
		if(instance!=null) {
			throw new RuntimeException("Use get Instance() method to create"); // here we are not allowing reflection
		}
	}
	
	public static DbSingleton getInstance() {
		if(instance == null) {//lazy loading
			synchronized(DbSingleton.class) {//thread safe. think of two threads running.
				if(instance == null) {
					instance = new DbSingleton();
				}				
			}			
		}
		
		return instance;
	}
	
	public Connection getConnection() {
		if(conn ==  null) {
			synchronized(DbSingleton.class) {
				if(conn == null) {
					try {
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
						conn = DriverManager.getConnection(dbUrl);
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}
	
}
