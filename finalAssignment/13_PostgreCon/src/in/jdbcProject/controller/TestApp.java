package in.jdbcProject.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestApp {
	public static void main(String[] args) {
		// PostgreSQL database connection details
		String url = "jdbc:postgresql:///mydatabase";
		String username = "root";
		String password = "1234";

		// Input file path
		String filePath = "input.txt";

		// JDBC objects
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// Establish the connection
			connection = DriverManager.getConnection(url, username, password);

			// Create a prepared statement with batch updates
			String sql = "Insert into Student (`name`,`age`,`address`) values(?,?,?)";
			statement = connection.prepareStatement(sql);

			// Read data from the file and add batch updates
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				statement.setString(1, data[0]);
				statement.setString(2, data[1]);
				statement.setString(3, data[2]);
				statement.addBatch();
			}

			// Execute the batch updates
			int[] updateCounts = statement.executeBatch();

			// Print the number of rows affected
			System.out.println("Rows affected: " + updateCounts.length);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close JDBC objects
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
