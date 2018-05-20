import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class SqlCheck extends Frame{
	JTable jt;
	String columnHeaders[] = {"Id","Username","Password"};
	//String teamStats[][]={{"ManUtd","45","25"},{}};
	String dbUrl = "jdbc:mysql://localhost:3306/student";
	String username = "root";
	String password = "archit";
	SqlCheck(){
		run();
	}
	void run(){
		try{

			Connection myConnection = DriverManager.getConnection(dbUrl,username,password);
			System.out.println("1");
			setSize(300,400);
			setVisible(true);
			
			Statement myStatement = myConnection.createStatement();
			System.out.println("2");

			ResultSet myResultSet = myStatement.executeQuery("select * from students");
			System.out.println("3");

			String data[] = {myResultSet.getString("id"), myResultSet.getString("firstname"), myResultSet.getString("lastname")};
			System.out.println("4");
			
			//jt = new JTable(data,columnHeaders);
			//jt.setBounds(50,50,200,230);
			JScrollPane js = new JScrollPane(jt);
			add(jt);
			add(js);
		}catch(Exception e){System.out.println("5");}
	}
}

class QuestionBank{
	public static void main(String args[]){
		SqlCheck s = new SqlCheck();

	}
}