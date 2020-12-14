/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author guilh
 */
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    
	public static java.sql.Connection conectar(){
		
		try {
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria?user=root&password=");
			
		} catch (SQLException error) {
			
			throw new RuntimeException(error);
		}
		
	}

    
}
