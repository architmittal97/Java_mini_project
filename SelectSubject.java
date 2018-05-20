import java.awt.*;
import java.awt.event.*;

public class SelectSubject extends Frame{
	Label lSelSub, lHead;
	Button bGK, bMath;
	//static int countMCQ=0;
	SelectSubject(){
		
		super("Choose Subject");
		lSelSub = new Label("Choose the subject and explore more!");
		lHead  = new Label("Quiz Generator");
		bGK = new Button("General Knowledge");
		bMath = new Button("Mathematics");
		
	//new Count();
	//System.out.println("static "+countMCQ);
		
		add(lHead);
		lHead.setBounds(162,30,126,25);
		lHead.setFont(new Font("SansSerif", Font.BOLD, 14));
		add(lSelSub);
		lSelSub.setBounds(100,100,250,25);
		lSelSub.setFont(new Font("SansSerif", Font.PLAIN, 12));
		add(bGK);
		bGK.setBackground(Color.white);
		bGK.setBounds(50,150,151,40);
		bGK.setFont(new Font("SansSerif", Font.BOLD, 12));
		add(bMath);
		bMath.setBounds(250,150,150,40);
		bMath.setBackground(Color.white);
		bMath.setFont(new Font("SansSerif", Font.BOLD, 12));
		setBackground(Color.orange);
		setLayout(null);
		setSize(450,300);
		setVisible(true);
		setResizable(false);

		bGK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				GK gk = new GK();
				dispose();
			}
		});
		bMath.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Mathematics math = new Mathematics();
				dispose();

			}

		});
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
				//dispose();
			}			
		});

	}

}