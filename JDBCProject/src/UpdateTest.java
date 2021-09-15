import java.sql.*;
import java.util.*;

public class UpdateTest {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		System.out.println("connecting");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
		System.out.println("connected");
		PreparedStatement statement=conn.prepareStatement("update emp set job=?,sal=sal+? where empno=?");
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		Scanner sc3=new Scanner(System.in);

		System.out.println("enter the job :");
		String job=sc1.nextLine();
		System.out.println("enter the salary amount :");
		int sal=sc2.nextInt();
		System.out.println("enter the employee no :");
		int empno=sc3.nextInt();
		sc1.close();sc2.close();sc3.close();
		statement.setString(1, job);
		statement.setInt(2, sal);
		statement.setInt(3, empno);
		int rows=statement.executeUpdate();
		
		System.out.println(rows+ " created successfully");
		System.out.println("-----------------------------------------");	

		statement.close();
		conn.close();
		System.out.println("system closed....");
	}

}






/*
 *XE =
 *(DESCRIPTION =
 *  (ADDRESS = (PROTOCOL = TCP)(HOST = touchme7)(PORT = 1521))
 *  (CONNECT_DATA =
 *    (SERVER = DEDICATED)
 *    (SERVICE_NAME = XE)
 *  )
 *) 
 *
 *C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
 *
 *
 *C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN
*/
