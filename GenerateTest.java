import java.awt.*;
import java.awt.event.*;
//import java.util.Random;
import java.util.*;

class GenerateTest extends Frame{
	Button bGenerateQues, bGenerateSol;
	Label lQuestionNo;
	TextField tQuestionNo;
	static String subjectName;
	GenerateTest g = this;
	static int nMcq; //= n[0][0];
	static int nFu; //= n[0][1];
	static int nTf; //= n[0][2];
	static int[] qMcq ; //= n[1];
	static int[] qFu; //= n[2];
	static int[] qTf; //= n[3];

	static int countMCQ=0;
	static int countFu = 0;
	static int countTf = 0;
	

	GenerateTest(String subjectName){
		super(subjectName+"Questions");
		this.subjectName = subjectName;
		bGenerateQues = new Button("Generate Questions");
		bGenerateSol = new Button("Generate Solutions");
		lQuestionNo = new Label("No. of Questions:");
		tQuestionNo = new TextField("15",15);
		
		add(lQuestionNo);
		add(tQuestionNo);
		add(bGenerateQues);
		add(bGenerateSol);

		lQuestionNo.setFont(new Font("SansSerif", Font.BOLD, 12));
		bGenerateQues.setFont(new Font("SansSerif", Font.BOLD, 12));
		bGenerateSol.setFont(new Font("SansSerif", Font.BOLD, 12));
		bGenerateSol.setBackground(Color.white);
		bGenerateQues.setBackground(Color.white);
		lQuestionNo.setBounds(38,15,120,30);
		tQuestionNo.setBounds(169,15,80,30);
		bGenerateQues.setBounds(70,65,160,30);
		bGenerateSol.setBounds(70,105,160,30);
		
		setBackground(Color.orange);
		setLayout(null);
		setSize(300,150);
		setVisible(true);
		setResizable(false);

		//int[][] n = new int[][]; //= randomNumber(tQuestionNo.getText());
		bGenerateQues.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				ArrayList al = randomNumber(tQuestionNo.getText());
				nMcq = (int)al.get(0);
				nFu = (int)al.get(1);
				nTf = (int)al.get(2);
				qMcq = (int[])al.get(3);
				qFu = (int[])al.get(4);
				qTf = (int[])al.get(5);

				new GenerateQuestionSet(nMcq,nFu, nTf, qMcq,qFu,qTf, subjectName);
			}
		}); 

		bGenerateSol.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.out.println(nMcq+" "+nFu+" "+nTf+" "+qMcq+" "+qFu+" "+qTf);
				new GenerateSolutionSet(nMcq,nFu, nTf, qMcq,qFu,qTf, subjectName);
			}
		}); 

		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				//System.exit(0);
				dispose();
			}			
		});

	}

	ArrayList randomNumber(String s){
		int n = Integer.parseInt(s);
		Random rand = new Random();

		new Count(subjectName,"MCQ");
		new Count(subjectName,"Fillup");
		new Count(subjectName,"True_False");
		System.out.println("count "+countMCQ+" "+countFu +" "+countTf);
		//System.out.println("static "+countMCQ);	
		int nMcq,nFu,nTf;	
		do{
			nMcq = rand.nextInt(n+1);
			System.out.println("nMcq "+nMcq);
		
			nFu = rand.nextInt((n-nMcq)+1);
			System.out.println("nFu "+nFu);

			nTf = n-(nMcq+nFu);
			System.out.println("nTf "+nTf);
		} while((nMcq>=countMCQ)&(nFu>=countFu)&(nTf>=countTf));

		System.out.println("n "+nMcq+" "+nFu +" "+nTf);
		//int ni[][] =randomQuestionGenerator(nMcq,nFu,nTf);
		return randomQuestionGenerator(nMcq,nFu,nTf);
	}

	ArrayList randomQuestionGenerator(int nMcq, int nFu, int nTf){
		Random rand = new Random();
			int qMcq[] = new int[nMcq];
		if(nMcq!=0){
outer:		for(int i=0;i<nMcq;){
				int temp = rand.nextInt(countMCQ+1);
				System.out.println("tempMCQ: "+temp);
				if(temp!=0){
					if(i==0){
						qMcq[i]=temp;
						System.out.println("qMcq i: "+i+" "+qMcq[i]);
						i++;
						continue;
					}
					for(int j=0;i!=0 & j<i;j++){
						if(qMcq[j]==temp){
							continue outer;
						}
						else if(j==i-1 && temp!=qMcq[j]){
							qMcq[i]=temp;
							System.out.println("qMcq i: "+i+" "+qMcq[i]);
							i++;
							continue outer;
						}
					}
				}
			}

		}

			int qFu[] = new int[nFu];
		if(nFu!=0){
outer:		for(int i=0;i<nFu;){
				int temp = rand.nextInt(countFu+1);
				System.out.println("tempFu: "+temp);
				if(temp!=0){
					if(i==0){
						qFu[i]=temp;
						System.out.println("qFu i: "+i+" "+qFu[i]);
						i++;
						continue;
					}
					for(int j=0;i!=0 & j<i;j++){
						if(qFu[j]==temp){
							continue outer;
						}
						else if(j==i-1 && temp!=qFu[j]){
							qFu[i]=temp;
							System.out.println("qFu i: "+i+" "+qFu[i]);
							i++;
							continue outer;
						}
					}
				}
			}

		}

			int qTf[] = new int[nTf];
		if(nTf!=0){
outer:		for(int i=0;i<nTf;){
				int temp = rand.nextInt(countTf+1);
				System.out.println("tempTf: "+temp);
				if(temp!=0){
					if(i==0){
						qTf[i]=temp;
						System.out.println("qTf i: "+i+" "+qTf[i]);
						i++;
						continue;
					}
					for(int j=0;i!=0 & j<i;j++){
						if(qTf[j]==temp){
							continue outer;
						}
						else if(j==i-1 && temp!=qTf[j]){
							qTf[i]=temp;
							System.out.println("qTf i: "+i+" "+qTf[i]);
							i++;
							continue outer;
						}
					}
				}
			}

		}


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

		ArrayList al = new ArrayList();
		al.add(nMcq);
		al.add(nFu);
		al.add(nTf);
		al.add(qMcq);
		al.add(qFu);
		al.add(qTf);

		//int[][] n = new int[][]{{nMcq,nFu,nTf},qMcq,qFu,qTf};
		return al;

	}

}