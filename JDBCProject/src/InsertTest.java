import java.sql.*;
import java.sql.Date;
import java.util.*;

public class InsertTest {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		System.out.println("connecting");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
		System.out.println("connected");
		PreparedStatement statement=conn.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		Scanner sc3=new Scanner(System.in);
		Scanner sc4=new Scanner(System.in);
		Scanner sc5=new Scanner(System.in);
		Scanner sc6=new Scanner(System.in);
		Scanner sc7=new Scanner(System.in);
		Scanner sc8=new Scanner(System.in);
		System.out.println("enter the employee number :");
		int empno=sc1.nextInt();
		System.out.println("enter the employee name :");
		String empname=sc2.nextLine();
		System.out.println("enter the employee job :");
		String empjob=sc3.nextLine();
		System.out.println("enter the employee manager :");
		int empmgr=sc4.nextInt();
		System.out.println("enter the employee hireyear :");
		int year=sc4.nextInt();
		System.out.println("enter the employee hiremonth :");
		int month=sc4.nextInt();
		System.out.println("enter the employee hireday :");
		int day=sc5.nextInt();
		
		Date hiredate=new Date(year,month,day);
		System.out.println("enter the employee sal :");
		int empsal=sc6.nextInt();
		System.out.println("enter the employee comm :");
		int empcomm=sc7.nextInt();
		System.out.println("enter the employee dept :");
		int empdept=sc8.nextInt();
		sc1.close();sc2.close();sc3.close();sc4.close();sc5.close();sc6.close();sc7.close();sc8.close();
		statement.setInt(1,empno );
		statement.setString(2, empname);
		statement.setString(3, empjob);
		statement.setInt(4, empmgr);
		statement.setDate(5, hiredate);
		statement.setInt(6, empsal);
		statement.setInt(7, empcomm);
		statement.setInt(8, empdept);
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
