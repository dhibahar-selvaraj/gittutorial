import java.sql.*;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		System.out.println("connecting");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
		System.out.println("connected");
		PreparedStatement statement=conn.prepareStatement("select * from emp where job=?");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the job to search");
		String job=sc.nextLine();sc.close();
		statement.setString(1, job);
		ResultSet rs=statement.executeQuery();
		
		while(rs.next()) {
			System.out.print("empnumber-"+rs.getInt(1));
			System.out.print("\tempname-"+rs.getString(2));
			System.out.print("\tempjob-"+rs.getString(3));
			System.out.print(" EmpJoining-"+rs.getString(5));
			System.out.println("\tsalary-"+rs.getString(4));
		}
		System.out.println("-----------------------------------------");
		PreparedStatement statement2=conn.prepareStatement("select * from emp where hiredate between ? and ?");
		Scanner sc1=new Scanner(System.in);
		System.out.println("enter the starting date");
		String sd=sc1.nextLine();sc1.close();
		Scanner sc2=new Scanner(System.in);
		System.out.println("enter the ending date");
		String ed=sc2.nextLine();sc2.close();
		statement2.setString(1, sd);
		statement2.setString(2, ed);
		ResultSet daters=statement2.executeQuery();
		while(daters.next()) {
			System.out.print("empnumber-"+daters.getInt(1));
			System.out.print("\tempname-"+daters.getString(2));
			System.out.print("\tempjob-"+daters.getString(3));
			System.out.print(" EmpJoining-"+daters.getString(5));
			System.out.println("\tsalary-"+daters.getString(4));
		}
		daters.close();
		rs.close();
		statement2.close();
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
