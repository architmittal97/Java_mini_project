import java.sql.*;

class Modify{
	Modify(String subjectName, String questionType, String questionID, String column, String modifiedText){
		try{
			String dbUrl = "jdbc:mysql://localhost:3306/"+subjectName;
			String username = "root";
			String password = "archit";

			Connection myConnection = DriverManager.getConnection(dbUrl,username,password);
			Statement myStatement = myConnection.createStatement();
			String sqlModify = "update "+questionType+" set "+column+" = '"+modifiedText+"' where ID = "+questionID+";";
			System.out.println(sqlModify);
			String idUpdate = "SET @num := 0;";
			String idUpdate2 = "UPDATE "+questionType+" SET ID = @num := (@num+1);";
			myStatement.executeUpdate(sqlModify);
			myStatement.executeUpdate(idUpdate);
			myStatement.executeUpdate(idUpdate2);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}