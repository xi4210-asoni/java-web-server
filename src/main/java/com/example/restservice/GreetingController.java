package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@RestController
public class GreetingController {

	// private static final String template = "Hello, %s!";
	// private final AtomicLong counter = new AtomicLong();
	

	@GetMapping("/status")
	public ConnStatus greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		// ...

		// Set the connection string for the database
		System.out.println(System.getenv("CONN"));
		String connectionString = System.getenv("CONN");

		// Create a connection object
		Connection conn = null;
		boolean isOK = false;

		// Try to establish a connection
		try {
		conn = DriverManager.getConnection(connectionString);
		isOK = true;
		// If the connection was successful, print a message
		System.out.println("Connection to database successful!");
		} catch (SQLException e) {
		// If there was an error establishing the connection, print an error message
		System.out.println("Error connecting to database: " + e.getMessage());
		isOK = false;
		} finally {
		// Make sure to close the connection when you're finished with it
		if (conn != null) {
			try {
			conn.close();
			} catch (SQLException e) {
			// If there was an error closing the connection, log the error
			System.out.println("Error closing connection: " + e.getMessage());
			}
		}
		}

		return new ConnStatus(isOK, "");
	}
}
