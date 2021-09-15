import java.sql.*;
import java.util.*;

public class DeleteTest {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		System.out.println("connecting");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
		System.out.println("connected");
		PreparedStatement statement=conn.prepareStatement("delete from emp where empno=?");
		Scanner sc1=new Scanner(System.in);
		System.out.println("enter the employee no :");
		int empno=sc1.nextInt();sc1.close();
		statement.setInt(1, empno);
		int rows=statement.executeUpdate();
		
		System.out.println(rows+ " deleted successfully");
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

