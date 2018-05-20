/*Here GetQuestionBank class is used to fetch data from database on clicking "Question Bank" button in subject class*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class GetQuestionBank{
	JFrame frame;
	JTable table;
	String driverName, url, username, password;
	String id, question, optionA, optionB, optionC, answer;
	
	GetQuestionBank(String subjectName,String questionType){
System.out.println(subjectName + " " + questionType);
		driverName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/"+ subjectName;
		username = "root";
		password = "archit";
		String columnNames[];
System.out.println(subjectName + " " + questionType);


		switch(questionType){
			case "MCQ": 
				columnNames = new String[]{"ID","Question","Option_A","Option_B","Option_C","Answer"};
				break;
			case "Fillup": 
				columnNames = new String[]{"ID","Question","Answer"};
				break;
			case "True_False": 
				columnNames = new String[]{"ID","Question","Answer"};
				break;
			default:
				columnNames = new String[]{"error","error","error"};
		}
System.out.println(columnNames);

		//void showTableData(){
			frame = new JFrame(subjectName+" - "+questionType);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new FlowLayout());
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			table = new JTable();
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setPreferredSize(new Dimension(350, 190));
			try{
				Class.forName(driverName);
				Connection con = DriverManager.getConnection(url,username,password);
		System.out.println(questionType+"-3");
				String sql = "select * from " + questionType;
		System.out.println(questionType+"-2");
		System.out.println(sql);
				PreparedStatement ps = con.prepareStatement(sql);
		System.out.println(questionType+"-1");
				ResultSet rs = ps.executeQuery(sql);
		System.out.println(questionType+"0");
				int i=0;
		System.out.println(questionType+"1");
				if(questionType.equals("MCQ")){
					while(rs.next()){
						id = rs.getString("ID");
						question = rs.getString("Question");
						optionA= rs.getString("Option_A");
						optionB= rs.getString("Option_B");
						optionC= rs.getString("Option_C");
						answer= rs.getString("Answer");

						model.addRow(new Object[]{id,question,optionA,optionB,optionC,answer});
						i++;
					}
				}
				else if(questionType.equals("Fillup")){
					while(rs.next()){
						id = rs.getString("ID");
						question = rs.getString("Question");
						answer= rs.getString("Answer");

						model.addRow(new Object[]{id,question,answer});
						i++;
					}
				}
		//System.out.println(questionType+"1");
				else if(questionType.equals("True_False")){
		System.out.println(questionType+"2");
					while(rs.next()){
		System.out.println(questionType+"3");
						id = rs.getString("ID");
						question = rs.getString("Question");
						answer= rs.getString("Answer");
		System.out.println(questionType+"4");
						model.addRow(new Object[]{id,question,answer});
						i++;
		System.out.println(questionType+"5");
					}
				}
			}
			catch(Exception ex){
				System.out.println(ex);
			}
			frame.add(scroll);
			frame.setVisible(true);
			frame.setSize(1000,600);
		//}
	}
}