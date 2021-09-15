import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		System.out.println("connecting");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
		System.out.println("connected");
		Statement statement=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the job to search");
		String sv=sc.nextLine();
		
		ResultSet rs=statement.executeQuery("select * from emp where job='"+sv+"'");
		while(rs.next()) {
			System.out.print("empnumber-"+rs.getInt(1));	
			System.out.print("\tempname-"+rs.getString(2));
			System.out.print("\tempjob-"+rs.getString(3));
			System.out.print(" EmpJoining-"+rs.getString(5));
			System.out.println("\tsalary-"+rs.getString(4));
		}
		System.out.println("-----------------------------------------");
		Scanner sc1=new Scanner(System.in);
		System.out.println("enter the starting date");
		String sd=sc1.nextLine();
		Scanner sc2=new Scanner(System.in);
		System.out.println("enter the ending date");
		String ed=sc2.nextLine();
		ResultSet daters=statement.executeQuery("select * from emp where hiredate between '"+sd+"' and '"+ed+"'");
		while(daters.next()) {
			System.out.print("empnumber-"+daters.getInt(1));
			System.out.print("\tempname-"+daters.getString(2));
			System.out.print("\tempjob-"+daters.getString(3));
			System.out.print(" EmpJoining-"+daters.getString(5));
			System.out.println("\tsalary-"+daters.getString(4));
		}
		daters.close();
		rs.close();
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
