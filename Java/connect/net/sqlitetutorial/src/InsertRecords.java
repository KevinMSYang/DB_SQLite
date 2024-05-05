import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords 
{
	private Connection connect()
	{
		String url = "jdbc:sqlite:/Users/kevinyang/Programming/SQLite/db/contacts.db";
		Connection connect = null;
		try
		{
			connect = DriverManager.getConnection(url);
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return connect;
	}
	
	public void insert (String first_name, String last_name, double capacity)
	{
		String sql = "INSERT INTO employees (first_name,last_name, capacity) VALUES (?,?,?)";
		
		try
		{
			Connection connect = this.connect();
			PreparedStatement prestate = connect.prepareStatement(sql);
			prestate.setString(1, first_name);
			prestate.setString(2, last_name);
			prestate.setDouble(3, capacity);
			prestate.executeUpdate();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void main (String[] args)
	{
		InsertRecords app = new InsertRecords();
		app.insert("Kevin", "Yang", 10000);
		app.insert("Sherry", "Lian", 15000);
		app.insert("Jay", "Han", 20000);
	}
}
