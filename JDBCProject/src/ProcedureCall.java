import java.sql.*;
import java.util.*;

public class ProcedureCall {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		System.out.println("connecting");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
		System.out.println("connected");
		CallableStatement statement=conn.prepareCall("{call fundtransfer(?,?,?)}");
		
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		Scanner sc3=new Scanner(System.in);
		
		System.out.println("enter the from account:");
		int fromacc=sc1.nextInt();
		System.out.println("enter the To account:");
		int Toacc=sc2.nextInt();
		System.out.println("enter the amount:");
		int amt=sc3.nextInt();sc1.close();sc2.close();sc3.close();
		
		
		statement.setInt(1, fromacc);
		statement.setInt(2, Toacc);
		statement.setInt(3, amt);
		int rows=statement.executeUpdate();
		
		System.out.println(rows+ "transaction run successfully");
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

