import java.sql.*;

class Insert{
	Insert(String subjectName, String questionType, String question, String optionA, String optionB, String optionC, String answer){
		try{
			String dbUrl = "jdbc:mysql://localhost:3306/"+subjectName;
			String username = "root";
			String password = "archit";

			Connection myConnection = DriverManager.getConnection(dbUrl,username,password);
			Statement myStatement = myConnection.createStatement();

			String sqlInsert = "insert into "+questionType+" (ID,Question,Option_A, Option_B,Option_C, Answer) values ('0','"+question+"','"+optionA+"','"+optionB+"','"+optionC+"','"+answer+"');";
		System.out.println(sqlInsert);
			String idUpdate = "SET @num := 0;";
			String idUpdate2 = "UPDATE "+questionType+" SET ID = @num := (@num+1);";
			myStatement.executeUpdate(sqlInsert);
			myStatement.executeUpdate(idUpdate);
			myStatement.executeUpdate(idUpdate2);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	Insert(String subjectName, String questionType, String question, String answer){
		try{
			String dbUrl = "jdbc:mysql://localhost:3306/"+subjectName;
			String username = "root";
			String password = "archit";

			Connection myConnection = DriverManager.getConnection(dbUrl,username,password);
			Statement myStatement = myConnection.createStatement();

			String sqlInsert = "insert into "+questionType+" (ID,Question,Answer) values ('0','"+question+"','"+answer+"');";
		System.out.println(sqlInsert);
			String idUpdate = "SET @num := 0;";
			String idUpdate2 = "UPDATE "+questionType+" SET ID = @num := (@num+1);";
			myStatement.executeUpdate(sqlInsert);
			myStatement.executeUpdate(idUpdate);
			myStatement.executeUpdate(idUpdate2);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

class Count{
	Count(String subjectName, String questionType){
		try{
				String driverName = "com.mysql.jdbc.Driver";
				String dbUrl = "jdbc:mysql://localhost:3306/"+subjectName;
				String username = "root";
				String password = "archit";
				Class.forName(driverName);
				Connection con = DriverManager.getConnection(dbUrl,username,password);
				String sqlInsert = "select count(*) from "+questionType;
				PreparedStatement ps = con.prepareStatement(sqlInsert);

			System.out.println(sqlInsert);
				//String idUpdate = "SET @num := 0;";
				//String idUpdate2 = "UPDATE "+questionType+" SET ID = @num := (@num+1);";
				ResultSet rs = ps.executeQuery(sqlInsert);
				String count= "0";
			if(rs.next()){
					count = rs.getString("count(*)");
			}
			if(questionType=="MCQ"){
				GenerateTest.countMCQ = Integer.parseInt(count);
				System.out.println("countMCQ " +GenerateTest.countMCQ);
			}
			else if(questionType=="Fillup"){
				GenerateTest.countFu = Integer.parseInt(count);
				System.out.println("countFu " +GenerateTest.countFu);
			}
			else if(questionType=="True_False"){
				GenerateTest.countTf = Integer.parseInt(count);
				System.out.println("countTf " +GenerateTest.countTf);
			}
				//myStatement.executeUpdate(idUpdate);
				//myStatement.executeUpdate(idUpdate2);
			}
		catch(Exception e){
				System.out.println(e);
			}
	}
}