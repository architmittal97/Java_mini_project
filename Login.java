import java.awt.*;
import java.awt.event.*;

class Login extends Frame{
	Label lUser, lPwd,lHead;
	TextField tUser,tPwd;
	Button bLogin;

	Login(String title){
		super(title);
		lUser = new Label("Username");
		lPwd = new Label("Password");
		lHead  = new Label("Welcome - Quiz Generator");
		
		tUser = new TextField("admin",15);
		tPwd = new TextField("admin",15);
		tPwd.setEchoChar('*');
		
		bLogin = new Button("Login");
		
		setLayout(null);
		
		add(lHead);
		lHead.setBounds(120,30,210,25);
		lHead.setFont(new Font("SansSerif", Font.BOLD, 14));
		add(lUser);
		lUser.setBounds(105,80,80,25);
		lUser.setFont(new Font("SansSerif", Font.PLAIN, 12));
		add(lPwd);
		lPwd.setBounds(105,120,80,25);
		lUser.setFont(new Font("SansSerif", Font.PLAIN, 12));
		add(tUser);
		tUser.setBounds(195,80,150,30);
		add(tPwd);
		tPwd.setBounds(195,120,150,30);
		add(bLogin);
		bLogin.setBounds(185,200,80,40);
		bLogin.setBackground(Color.white);
		bLogin.setFont(new Font("SansSerif", Font.BOLD, 12));
		setBackground(Color.orange);
		setSize(450,300);
		setVisible(true);
		setResizable(false);

		bLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String strUser = tUser.getText();
				String strPwd = tPwd.getText();
				if(strUser.equals("admin") & strPwd.equals("admin")){
					SelectSubject ss = new SelectSubject();
					dispose();
				}
				else{
					UserPwdCheck upw = new UserPwdCheck();
				}
			}
		});
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
				//dispose();
			}			
		});

	}

	public static void main(String args[]){
		
		Login main = new Login("WELCOME - Quiz Generator");
		//GenerateTest main = new GenerateTest("Subject");
	}
}

