import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRecords 
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
	
	public void selectAll()
	{
		String sql = "SELECT * FROM employees";
		try 
		{
			Connection connect = this.connect();
			Statement state = connect.createStatement();
			ResultSet result = state.executeQuery(sql);
			
			while (result.next())
			{
				System.out.println(result.getInt("nid") +"\t" + result.getString("first_name") + "\t" + result.getString("last_name") + "\t" + result.getDouble("capacity"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)
	{
		SelectRecords app = new SelectRecords();
		app.selectAll();
	}
}
