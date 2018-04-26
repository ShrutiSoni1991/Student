package Example.One;


import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcurl = "jdbc:mysql://localhost:3306/student?useSSL=false";
		String user= "root";
		String password= "root";
		try{
			System.out.println("connecting to database"+jdbcurl);
		 Connection mycon = DriverManager.getConnection(jdbcurl,user,password);
		 System.out.println("Succesfull connection!");
		}
		catch (Exception e) {
			// TODO: handle exception
	e.printStackTrace();
		}

	}

}
