package jdbc;
import java.sql.*;
public class Jdbcdemo 
{
	public static void main(String[] args) throws SQLException 
	{
//		readData();
		//		insertData();
		//      insertDataVar();
		//		insertPrepare();
		//		deleteRow();
//		updateRow();
//		commit();
		batch();
	}
	public static void readData() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="kavin";
		String query="select * from EMPLOYEE";
		Connection con=DriverManager.getConnection(url,username, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println("ID is "+rs.getInt(1));
			System.out.println("NAME is "+rs.getString(2));
			System.out.println("SALARY is "+rs.getInt(3));
		}
		con.close();	
	}
	public static void insertData() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="kavin";
		String query="INSERT INTO EMPLOYEE VALUES(7,'KaviPriya',55400)";
		Connection con=DriverManager.getConnection(url,username, password);
		Statement st=con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println("Number of rows affected: "+rows);
		con.close();
	}
	//insert statement using variable
	public static void insertDataVar() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="kavin";
		int id=8;
		String name="Ganesh";
		int salary=60600;
		//String query="INSERT INTO EMPLOYEE VALUES(7,'KaviPriya',55400)";
		String query="INSERT INTO EMPLOYEE VALUES(" + id + ",'" + name + "'," + salary + ");";
		Connection con=DriverManager.getConnection(url,username, password);
		Statement st=con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println("Number of rows affected: "+rows);
		con.close();
	}
	//insert data using prepare statement
	public static void insertPrepare() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="kavin";
		int id=9;
		String name="Prabhakaran";
		int salary=48000;
		String query="INSERT INTO EMPLOYEE VALUES(?,?,?)";
		Connection con=DriverManager.getConnection(url,username, password);
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, salary);
		int rows = pst.executeUpdate();
		System.out.println("Number of rows affected: "+rows);
		con.close();
	}
	//delete
	public static void deleteRow() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="kavin";
		int id=8;
		String query="DELETE FROM EMPLOYEE WHERE EMP_ID =" + id ;
		Connection con=DriverManager.getConnection(url,username, password);
		Statement st=con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println("Number of rows affected: "+rows);
		con.close();
	}
	//update
	public static void updateRow() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="kavin";
		String query="UPDATE EMPLOYEE SET ENAME ='Kavin' WHERE EMP_ID =1";
		Connection con=DriverManager.getConnection(url,username, password);
		Statement st=con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println("Number of rows affected: "+rows);
		con.close();
	}
	//commit and autocommit
	public static void commit() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="kavin";
		String query1="UPDATE EMPLOYEE SET SALARY=500000 WHERE EMP_ID =1";
		String query2="UPDATE EMPLOYEE SET SALARY=500000 WHERE EMP_ID =2";
		Connection con=DriverManager.getConnection(url, username, password);
		con.setAutoCommit(false);
		Statement st=con.createStatement();
		int row1 = st.executeUpdate(query1);
		System.out.println("Rows affected "+row1);
		int row2 = st.executeUpdate(query2);
		System.out.println("Rows affected "+row2);
		if(row1>0 && row2>0)
		{
			con.commit();
		}
		con.close();
	}
	public static void batch() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="kavin";
		String query1="UPDATE EMPLOYEE SET SALARY=400000 WHERE EMP_ID =1";
		String query2="UPDATE EMPLOYEE SET SALARY=400000 WHERE EMP_ID =2";
		String query3="UPDATE EMPLOYEE SET SALARY=400000 WHERE EMP_ID =3";
		String query4="UPDATE EMPLOYEE SET SALARY=400000 WHERE EMP_ID =4";
		Connection con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		st.addBatch(query3);
		st.addBatch(query4);
		int[] rows = st.executeBatch();
		for(int i:rows)
		{
			if(i>0)
			{
				continue;
			}
			else
			{
				con.rollback();
			}
			
		}
		con.commit();
		con.close();
	}
}
