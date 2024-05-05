import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable 
{
	public static void createNewTable()
	{
		String url = "jdbc:sqlite:/Users/kevinyang/Programming/SQLite/db/contacts.db";
		
		String sql = "CREATE TABLE IF NOT EXISTS employees (\n"
					+ "id INTEGER PRIMARY KEY, \n"
					+ "first_name TEXT NOT NULL, \n"
					+ "last_name TEXT NOT NULL, \n"
					+ "capacity REAL \n"
					+");";
		
		try
		{
			Connection connect = DriverManager.getConnection(url);
			Statement state = connect.createStatement();
			state.execute(sql);
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args)
	{
		createNewTable();
	}
}
