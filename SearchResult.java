import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchResult implements ActionListener{
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button;
	JPanel panel;
	/*static*/ JTable table;

	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/student";
	String username = "root";
	String password = "archit";
	String[] columnNames = {"id","firstname","lastname"};

	public void createUI(){
		frame = new JFrame("Databases Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		textbox= new JTextField();
		textbox.setBounds(120,30,150,20);
		label = new JLabel("Enter Roll no.");
		label.setBounds(10,30,100,20);
		button = new JButton("search");
		button.setBounds(120,130,150,20);
		button.addActionListener(this);

		frame.add(textbox);
		frame.add(label);
		frame.add(button);
		frame.setVisible(true);
		frame.setSize(500,400);
	}

	public void actionPerformed(ActionEvent ae){
		button = (JButton)ae.getSource();
		System.out.println("Showing Table Data.......");
		showTableData();

	}

	public void showTableData(){
		frame1 = new JFrame("Database");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		table.setFillsViewPortHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//String textvalue = textbox.getText();
		String id = "";
		String firstname = "";
		String lastname = "";
		try{
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url,username,password);
			String sql = "select * from students";// where id = "+textvalue;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			int i=0;
			while(rs.next()){
				id = rs.getString("id");
				firstname = rs.getString("firstname");
				lastname= rs.getString("lastname");

				model.addRow(new Object[]{id,firstname,lastname});
				i++;
			}

		}
		catch (Exception ex){

		}
		frame1.add(scroll);
		frame1.setVisible(true);
		frame1.setSize(400,300);

	}

	public static void main(String args[]){
		SearchResult sr = new SearchResult();
		sr.createUI();
	}


}