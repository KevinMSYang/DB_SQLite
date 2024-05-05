import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase 
{
	public static void createNewDatabase(String filename)
	{
		String url = "jdbc:sqlite:/Users/kevinyang/Programming/SQLite/db/" + filename;
		
		try
		{
			Connection connect = DriverManager.getConnection(url);
			if (connect != null)
			{
				DatabaseMetaData meta = connect.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created");
			}
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args)
	{
		createNewDatabase("test.db");
	}
}
