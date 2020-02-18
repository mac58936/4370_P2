import java.sql.*;

public class Main {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://YOUR-SQL-SERVER/employees"; //Ex: localhost:3306

	// database credentials
	static final String USERNAME = "YOUR-USERNAME";
	static final String PASSWORD = "YOUR-PASSWORD";

	public static void main(String[] args) {
		System.out.println("\nDriver loaded successfully...");

		Connection connection = null;
		Statement statement = null;
		
		try {
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			System.out.println("Creating statement...");
			statement = connection.createStatement();
			String sql;
			sql = "SELECT first_name, last_name FROM employees LIMIT 20";
			ResultSet response = statement.executeQuery(sql);
			System.out.println("\n" + sql + "\n");

			// extract data from response
			System.out.println("first_name\tlast_name");
			while (response.next()) {
				// retrieve by column name
				String first = response.getString("first_name");
				String last = response.getString("last_name");

				// display values
				System.out.println(first + "    \t" + last);
			}
			System.out.println();

			// clean-up
			response.close();
			statement.close();
			connection.close();
		} catch (SQLException se) {
			// handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // finally
		} // try
	} //main

} //class