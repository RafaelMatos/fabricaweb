package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
