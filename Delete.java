import java.sql.*;

class Delete{
	Delete(String subjectName, String questionType, String questionID){
		try{
			String dbUrl = "jdbc:mysql://localhost:3306/"+subjectName;
			String username = "root";
			String password = "archit";

			Connection myConnection = DriverManager.getConnection(dbUrl,username,password);
			Statement myStatement = myConnection.createStatement();
			String sqlDelete = "delete from "+questionType+" where ID = "+questionID+";";
	System.out.println(sqlDelete);
			String idUpdate = "SET @num := 0;";
			String idUpdate2 = "UPDATE "+questionType+" SET ID = @num := (@num+1);";
			myStatement.executeUpdate(sqlDelete);
			myStatement.executeUpdate(idUpdate);
			myStatement.executeUpdate(idUpdate2);
		}
		catch(Exception e){
			System.out.println(e);
		}
	
	}
}