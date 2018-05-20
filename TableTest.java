import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

class TableTest extends JFrame{

	JTable table1, table2, table3;
	String driverName, url, username, password;
	String id, question, optionA, optionB, optionC, answer;
	
	TableTest(){
		//table1 = new JTable();
		JScrollPane scroll1 = new JScrollPane();
		
		scroll1.setPreferredSize(new Dimension(350, 190));
		//table2 = new JTable();
		//table3 = new JTable();
		//table1.setBounds(30,40);

		//JScrollPane scroll2= new JScrollPane(table2);
		//JScrollPane scroll3 = new JScrollPane(table3);

		add(scroll1);
		//add(table2);
		//add(table3);

		//table1.setColumnIdentifiers(column);
		setSize(300,400);
		setLayout(new FlowLayout());
		setVisible(true);

	}
	public static void main(String args[]){
		new TableTest();
	}

}