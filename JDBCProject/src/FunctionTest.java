import java.sql.*;
import java.util.*;

public class FunctionTest {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		System.out.println("connecting");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
		System.out.println("connected");
		CallableStatement statement=conn.prepareCall("{? = call calc_sal(?)}");
		
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("enter the empno:");
		int empno=sc1.nextInt();		
		
		statement.setInt(2, empno);
		statement.registerOutParameter(1, Types.INTEGER);
		statement.execute();
		int Totsal=statement.getInt(1);
		
		System.out.println("Tot sal is :"+Totsal);
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

