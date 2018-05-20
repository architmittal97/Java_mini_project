import java.awt.*;
import java.awt.event.*;

public class UserPwdCheck extends Frame{
	Label lCheck;
	Button bCheck;

	UserPwdCheck(){
		super("Incorrect Details");
		lCheck = new Label("Check Username and Password");
		bCheck = new Button("OK"); 
	
		add(lCheck);
		lCheck.setBounds(50,40,250,25);
		lCheck.setFont(new Font("SansSerif", Font.PLAIN, 12));
		add(bCheck);
		bCheck.setBounds(110,85,80,30);
		bCheck.setBackground(Color.white);
		bCheck.setFont(new Font("SansSerif", Font.BOLD, 12));
		setLayout(null);
		setBackground(Color.orange);
		setSize(300,150);
		setVisible(true);
		setResizable(false);

		
		bCheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
			}
		
		});
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				//System.exit(0);
				dispose();
			}			
		});
	
	}
}


