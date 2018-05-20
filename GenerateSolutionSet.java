import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.io.*;

class GenerateSolutionSet{
	JFrame frame;
	JTable tableMCQ, tableFillup, tableTF;
	Label lMCQ = new Label("Multiple Choice Questions");
	Label lFu = new Label("Fill in the Blanks");
	Label lTf = new Label("True False");
	String driverName, url, username, password;
	String id, question, optionA, optionB, optionC, answer;
	Button bFileOutput;

	GenerateSolutionSet(int nMcq, int nFu, int nTf, int[] qMcq, int[] qFu, int[] qTf, String subjectName){
		
		for(int i=0;i<nMcq;i++){
			System.out.println("qMcq["+i+"] : "+qMcq[i]);

		}

		for(int i=0;i<nFu;i++){
			System.out.println("qFu["+i+"] : "+qFu[i]);

		}

		for(int i=0;i<nTf;i++){
			System.out.println("qTf["+i+"] : "+qTf[i]);

		}
		System.out.println();


		driverName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/"+ subjectName;
		username = "root";
		password = "archit";
		String[] columnNamesMCQ, columnNamesFu, columnNamesTF;

		columnNamesMCQ = new String[]{"ID","Answer"};
		columnNamesFu = new String[]{"ID","Answer"};
		columnNamesTF = new String[]{"ID","Answer"};
//System.out.println(subjectName + " " + questionType);

		frame = new JFrame(subjectName/*+" - "+questionType*/);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		DefaultTableModel modelMCQ = new DefaultTableModel();
		DefaultTableModel modelFillup = new DefaultTableModel();
		DefaultTableModel modelTF = new DefaultTableModel();

		modelMCQ.setColumnIdentifiers(columnNamesMCQ);
		modelTF.setColumnIdentifiers(columnNamesTF);
		modelFillup.setColumnIdentifiers(columnNamesFu);

		tableMCQ = new JTable();
		tableFillup = new JTable();
		tableTF = new JTable();

		tableMCQ.setModel(modelMCQ);
		tableFillup.setModel(modelFillup);
		tableTF.setModel(modelTF);

		JScrollPane scrollMCQ = new JScrollPane(tableMCQ);
		JScrollPane scrollFu = new JScrollPane(tableFillup);
		JScrollPane scrollTF = new JScrollPane(tableTF);

		scrollMCQ.setPreferredSize(new Dimension(500, 180));
		scrollFu.setPreferredSize(new Dimension(500, 180));
		scrollTF.setPreferredSize(new Dimension(500, 180));

		/*switch(questionType){
			case "MCQ": 
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
*/
		
	try{
		for(int i=1, q=0;i<=qMcq.length;i++){
			
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url,username,password);
			//columnNames = new String[]{"ID","Question","Option_A","Option_B","Option_C"};
			//model.setColumnIdentifiers(columnNames);
			String sql = "select * from MCQ where ID = "+qMcq[q++];
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);

			if(rs.next()){
				//id = rs.getString("ID");
				//question = rs.getString("Question");
				//optionA= rs.getString("Option_A");
				//optionB= rs.getString("Option_B");
				//optionC= rs.getString("Option_C");
				answer= rs.getString("Answer");

				modelMCQ.addRow(new Object[]{i,answer});
				
			}
		}
		
		
		for(int i=1, q=0;i<=qFu.length;i++){
			
			Class.forName(driverName);
	//System.out.println("Before q: "+q);
			Connection con = DriverManager.getConnection(url,username,password);
			//columnNames = new String[]{"ID","Question","Answer"};
			//model.setColumnIdentifiers(columnNames);
			String sql = "select * from Fillup where ID = "+qFu[q++];
	//System.out.println("After q: "+q);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);

			if(rs.next()){
				//id = rs.getString("ID");
				//question = rs.getString("Question");
				//optionA= rs.getString("Option_A");
				//optionB= rs.getString("Option_B");
				//optionC= rs.getString("Option_C");
				answer= rs.getString("Answer");

				modelFillup.addRow(new Object[]{i,answer});
				
			}
		}
				
		for(int i=1, q=0;i<=qTf.length;i++){
			
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url,username,password);
			//columnNames = new String[]{"ID","Question","Answer"};
			//model.setColumnIdentifiers(columnNames);
			String sql = "select * from True_False where ID = "+qTf[q++];
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);

			if(rs.next()){
				//id = rs.getString("ID");
				//question = rs.getString("Question");
				//optionA= rs.getString("Option_A");
				//optionB= rs.getString("Option_B");
				//optionC= rs.getString("Option_C");
				answer= rs.getString("Answer");

				modelTF.addRow(new Object[]{i,answer});
				
			}
		}

		bFileOutput = new Button("Get .txt file");
		bFileOutput.setFont(new Font("SansSerif", Font.BOLD, 12));
		bFileOutput.setBackground(Color.white);
		bFileOutput.setPreferredSize(new Dimension(120,30));
		bFileOutput.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try(FileWriter f0 = new FileWriter(subjectName+" Solutions.txt");FileWriter f1 = new FileWriter(subjectName+" Solutions.txt",true)){
						
					Class.forName(driverName);
					Connection con = DriverManager.getConnection(url,username,password);
					String toWriteTitle = subjectName+" Solution Set";
					char bufferTitle[] = new char[toWriteTitle.length()];
					toWriteTitle.getChars(0,toWriteTitle.length(),bufferTitle,0);

					f1.write(bufferTitle);
					if(nMcq>0){
						String toWriteSubTitle = "\n\nMultiple Choice Questions\n";
						char bufferSubTitle[] = new char[toWriteSubTitle.length()];
						toWriteSubTitle.getChars(0,toWriteSubTitle.length(),bufferSubTitle,0);
						f1.write(bufferSubTitle);
					}

					for(int i=1, q=0;i<=qMcq.length;i++){
						//Class.forName(driverName);
						//Connection con = DriverManager.getConnection(url,username,password);
						//columnNames = new String[]{"ID","Question","Option_A","Option_B","Option_C"};
						//model.setColumnIdentifiers(columnNames);
						String sql = "select * from MCQ where ID = "+qMcq[q++];
						PreparedStatement ps = con.prepareStatement(sql);
						ResultSet rs = ps.executeQuery(sql);

						if(rs.next()){
							//id = rs.getString("ID");
							//question = rs.getString("Question");
							//optionA= rs.getString("Option_A");
							//optionB= rs.getString("Option_B");
							//optionC= rs.getString("Option_C");
							answer= rs.getString("Answer");

							String toWrite = i+". "+answer+"\n";
							char buffer[] = new char[toWrite.length()];
							toWrite.getChars(0,toWrite.length(),buffer,0);

							f1.write(buffer);
							//modelMCQ.addRow(new Object[]{i,question,optionA,optionB,optionC});
					
						}
					}

					if(nFu>0){
						String toWriteSubTitle = "\n\nFill in the Blanks\n";
						char bufferSubTitle[] = new char[toWriteSubTitle.length()];
						toWriteSubTitle.getChars(0,toWriteSubTitle.length(),bufferSubTitle,0);
						f1.write(bufferSubTitle);
					}
					for(int i=1, q=0;i<=qFu.length;i++){
			
						//Class.forName(driverName);
				//System.out.println("Before q: "+q);
						//Connection con = DriverManager.getConnection(url,username,password);
						//columnNames = new String[]{"ID","Question","Answer"};
						//model.setColumnIdentifiers(columnNames);
						String sql = "select * from Fillup where ID = "+qFu[q++];
				//System.out.println("After q: "+q);
						PreparedStatement ps = con.prepareStatement(sql);
						ResultSet rs = ps.executeQuery(sql);


						if(rs.next()){
							//id = rs.getString("ID");
							//question = rs.getString("Question");
							//optionA= rs.getString("Option_A");
							//optionB= rs.getString("Option_B");
							//optionC= rs.getString("Option_C");
							answer= rs.getString("Answer");

							String toWrite = i+". "+answer+"\n";
							char buffer[] = new char[toWrite.length()];
							toWrite.getChars(0,toWrite.length(),buffer,0);							
							f1.write(buffer);
							//modelFillup.addRow(new Object[]{i,question});
							
						}
					}

					if(nTf>0){
						String toWriteSubTitle = "\n\nTrue/False\n";
						char bufferSubTitle[] = new char[toWriteSubTitle.length()];
						toWriteSubTitle.getChars(0,toWriteSubTitle.length(),bufferSubTitle,0);
						f1.write(bufferSubTitle);
					}
					for(int i=1, q=0;i<=qTf.length;i++){
			
						//Class.forName(driverName);
						//Connection con = DriverManager.getConnection(url,username,password);
						//columnNames = new String[]{"ID","Question","Answer"};
						//model.setColumnIdentifiers(columnNames);
						String sql = "select * from True_False where ID = "+qTf[q++];
						PreparedStatement ps = con.prepareStatement(sql);
						ResultSet rs = ps.executeQuery(sql);

						if(rs.next()){
							//id = rs.getString("ID");
							//question = rs.getString("Question");
							//optionA= rs.getString("Option_A");
							//optionB= rs.getString("Option_B");
							//optionC= rs.getString("Option_C");
							answer= rs.getString("Answer");

							String toWrite = i+". "+answer+"\n";
							char buffer[] = new char[toWrite.length()];
							toWrite.getChars(0,toWrite.length(),buffer,0);							
							f1.write(buffer);
							//modelTF.addRow(new Object[]{i,question});
							
						}
					}
				}
				catch(Exception e){
					System.out.println(e);
				}	
				Success s = new Success("check");

			}


			
		});
		

	frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				//System.exit(0);
				frame.dispose();
			}			
		});

	}
	catch(Exception ex){
		System.out.println(ex);
	}
	if(nMcq>0){
		frame.add(lMCQ);
		frame.add(scrollMCQ);
	}
	if(nFu>0){	
		frame.add(lFu);
		frame.add(scrollFu);
	}
	if(nTf>0){	
		frame.add(lTf);
		frame.add(scrollTF);
	}
		frame.add(bFileOutput);
		frame.setVisible(true);
		frame.setSize(550,700);
		frame.setResizable(false);
	
	}
	
}