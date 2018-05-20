import java.awt.*;
import java.awt.event.*;

class Subject extends Frame{
	Button bInsert, bModify, bDelete, bQuestionBank, bBack, bSubmit, bSubmitd, bGenerateTest;
	Choice cBox;
	Label lInsertMCQ, lInsertFU, lInsertTF, lDelete, lSelect;
	CheckboxGroup cgModify;
	Checkbox cbQuestion, cbOptionA, cbOptionB, cbOptionC, cbAnswer; 
	Subject s = this;
	TextField tQuestion,tAnswer, tOptionA, tOptionB, tOptionC, tQuestionID;
	//Subject frame = this;

//Constructor calling and declaring buttons, labels, text fields	
	Subject(String subjectName){
		super(subjectName);
		bInsert= new Button("Insert");
		bModify= new Button("Modify");
		bDelete= new Button("Delete");
		bQuestionBank= new Button("Question Bank");
		bBack = new Button("<<");
		bSubmit = new Button("Submit");
		bSubmitd = new Button("Submit");
		bGenerateTest= new Button("Generate Test");

		cBox = new Choice();

		tQuestion = new TextField("question",300);
		tAnswer = new TextField("answer",105);
		tOptionA = new TextField("optionA",93);
		tOptionB = new TextField("optionB",93);
		tOptionC = new TextField("optionC",93);
		tQuestionID = new TextField("Ques. ID",200);
		
		lSelect = new Label("Select Type:");
		lInsertMCQ = new Label("Insert MCQ");
		lInsertFU = new Label("Insert Fillup");
		lInsertTF = new Label("Insert True_False");
		lDelete = new Label("Specify Question ID");
		 

		cgModify = new CheckboxGroup();

		cbQuestion = new Checkbox("Question",cgModify,false);
		cbOptionA = new Checkbox("Option_A",cgModify,false);
		cbOptionB = new Checkbox("Option_B",cgModify,false);
		cbOptionC = new Checkbox("Option_C",cgModify,false);
		cbAnswer = new Checkbox("Answer",cgModify,false);

		cBox.add("MCQ");
		cBox.add("Fillup");
		cBox.add("True_False");


		add(bBack);
		add(lSelect);
		add(cBox);
		add(bInsert);
		add(bModify);
		add(bDelete);
		add(bQuestionBank);
		add(bGenerateTest);

		bBack.setBackground(Color.white);
		cBox.setBackground(Color.white);
		bInsert.setBackground(Color.white);
		bModify.setBackground(Color.white);
		bDelete.setBackground(Color.white);
		bQuestionBank.setBackground(Color.white);
		bGenerateTest.setBackground(Color.white);
		bSubmit.setBackground(Color.white);
		bSubmitd.setBackground(Color.white);
		/*cbQuestion.setBackground(Color.white);
		cbAnswer.setBackground(Color.white);
		cbOptionC.setBackground(Color.white);
		cbOptionA.setBackground(Color.white);
		cbOptionB.setBackground(Color.white);*/

		//cbQuestion.setBackground();
        //cbQuestion.setOpaque(true);

		lSelect.setFont(new Font("SansSerif", Font.BOLD, 12));
		bBack.setFont(new Font("SansSerif", Font.BOLD, 12));
		bInsert.setFont(new Font("SansSerif", Font.BOLD, 12));
		bModify.setFont(new Font("SansSerif", Font.BOLD, 12));
		bDelete.setFont(new Font("SansSerif", Font.BOLD, 12));
		bSubmit.setFont(new Font("SansSerif", Font.BOLD, 12));
		bSubmitd.setFont(new Font("SansSerif", Font.BOLD, 12));
		bQuestionBank.setFont(new Font("SansSerif", Font.BOLD, 12));
		bGenerateTest.setFont(new Font("SansSerif", Font.BOLD, 12));
		cBox.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbAnswer.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbQuestion.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbOptionC.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbOptionB.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbOptionA.setFont(new Font("SansSerif", Font.BOLD, 12));

		bBack.setBounds(10,15,30,30);
		lSelect.setBounds(120,15,90,30);
		cBox.setBounds(210,15,100,30);
		bQuestionBank.setBounds(315,10,120,40);
		bInsert.setBounds(90,60,80,30);
		bModify.setBounds(185,60,80,30);
		bDelete.setBounds(280,60,80,30);
		bGenerateTest.setBounds(150,240,150,40);

		tQuestion.setBounds(15,120,300,30);
		tAnswer.setBounds(330,120,105,30);
		tOptionA.setBounds(15,155,93,30);
		tOptionB.setBounds(124,155,93,30);
		tOptionC.setBounds(233,155,93,30);
		bSubmit.setBounds(342,155,93,30);
		bSubmitd.setBounds(342,155,93,30);

		cbQuestion.setBounds(15,100,80,15);
		cbOptionA.setBounds(100,100,80,15);
		cbOptionB.setBounds(185,100,80,15);
		cbOptionC.setBounds(270,100,80,15);
		cbAnswer.setBounds(355,100,80,15);

		setBackground(Color.orange);
		setLayout(null);
		setSize(450,300);
		setVisible(true);
		setResizable(false);

	//Action after Close is pressed	
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
				//dispose();
			}			
		});

	//Action after Back button is pressed
		bBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				SelectSubject ss = new SelectSubject();
				ss.setVisible(true);	
				setVisible(false);
				
			}

		});


	//Action when Insert button is pressed
		bInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String questionType = cBox.getSelectedItem();
					remove(bSubmitd);
					remove(tQuestion);
					remove(tAnswer);
					remove(tQuestionID);
					remove(tOptionA);
					remove(tOptionB);
					remove(tOptionC);
					remove(bSubmit);
					remove(cbQuestion);
					remove(cbOptionA);
					remove(cbOptionB);
					remove(cbOptionC);
					remove(cbAnswer);
					remove(MyItemListener.tModify);
					remove(MyItemListener.tQuestionID);
					remove(MyItemListener.bSubmit);

				if(questionType.equals("MCQ")){

					add(tQuestion);
					add(tOptionA);
					add(tOptionB);
					add(tOptionC);
					add(tAnswer);
					add(bSubmit);

					revalidate();

					bSubmit.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){
							Insert in = new Insert(subjectName,questionType,tQuestion.getText(),tOptionA.getText(),tOptionB.getText(),tOptionC.getText(),tAnswer.getText());
							Success suc = new Success(s,subjectName);
						}
					});
				}
				else if(questionType.equals("Fillup")){
					add(lInsertFU);
					add(tQuestion);
					add(tAnswer);
					add(bSubmit);

					revalidate();
					
					bSubmit.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){
							Insert in = new Insert(subjectName,questionType,tQuestion.getText(),tAnswer.getText());
							Success suc = new Success(s,subjectName);
							
						}
					});
				}
				else if(questionType.equals("True_False")){
					add(lInsertTF);
					add(tQuestion);
					add(tAnswer);
					add(bSubmit);

					revalidate();

					bSubmit.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){
							Insert in = new Insert(subjectName,questionType,tQuestion.getText(),tAnswer.getText());
							Success suc = new Success(s,subjectName);
							
						}
					});
					

				}
			}
		});

	//Action when Modify button is presses
		bModify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String questionType = cBox.getSelectedItem();
				remove(bSubmitd);
				remove(bSubmit);
				remove(tQuestion);
				remove(tAnswer);
				remove(tQuestionID);
				remove(tOptionA);
				remove(tOptionB);
				remove(tOptionC);
				if(questionType.equals("MCQ")){
					
					//remove(bSubmit);
					
					add(cbQuestion);
					add(cbOptionA);
					add(cbOptionB);
					add(cbOptionC);
					add(cbAnswer);

					revalidate();
					//if(cbQuestion.getState()){
						cbQuestion.addItemListener(new MyItemListener(subjectName,questionType,"Question",s));
					//}
					//if(cbOptionA.getState()){
						cbOptionA.addItemListener(new MyItemListener(subjectName,questionType,"Option_A",s));
					//}
					//if(cbOptionB.getState()){
						cbOptionB.addItemListener(new MyItemListener(subjectName,questionType,"Option_B",s));
					//}
					//if(cbOptionC.getState()){
						cbOptionC.addItemListener(new MyItemListener(subjectName,questionType,"Option_C",s));
					//}
					//if(cbAnswer.getState()){
					cbAnswer.addItemListener(new MyItemListener(subjectName,questionType,"Answer",s));
					//}		
				}
				else if(questionType.equals("Fillup")){
					remove(cbOptionC);
					remove(cbOptionB);
					remove(cbOptionA);					
					add(cbQuestion);
					add(cbAnswer);					
					
					revalidate();
					//if(cbQuestion.getState()){
						cbQuestion.addItemListener(new MyItemListener(subjectName,questionType,"Question",s));
					//}
					//else{
						cbAnswer.addItemListener(new MyItemListener(subjectName,questionType,"Answer",s));
					//}
				}
				else if(questionType.equals("True_False")){
					remove(cbOptionC);
					remove(cbOptionB);
					remove(cbOptionA);					
					add(cbQuestion);
					add(cbAnswer);					
					
					revalidate();
					//if(cbQuestion.getState()){
						cbQuestion.addItemListener(new MyItemListener(subjectName,questionType,"Question",s));
					//}
					//else{
						cbAnswer.addItemListener(new MyItemListener(subjectName,questionType,"Answer",s));
					//}
				}
			}
		});



	//Action when Delete button is pressed		
		bDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				remove(bSubmitd);
				remove(tQuestion);
				remove(tAnswer);
				remove(tQuestionID);
				remove(tOptionA);
				remove(tOptionB);
				remove(tOptionC);
				remove(cbQuestion);
				remove(cbOptionA);
				remove(cbOptionB);
				remove(cbOptionC);
				remove(cbAnswer);
				remove(bSubmit);
				remove(MyItemListener.tModify);
				remove(MyItemListener.tQuestionID);
				remove(MyItemListener.bSubmit);

				String questionType = cBox.getSelectedItem();
				//add(lDelete);
				add(tQuestionID);
				add(bSubmitd);
				tQuestionID.setBounds(50,155,200,30);
				bSubmitd.setBounds(342,155,93,30);
				bSubmitd.setBackground(Color.white);
				bSubmitd.setFont(new Font("SansSerif", Font.BOLD, 12));
				revalidate();

				bSubmitd.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						Delete del = new Delete(subjectName,questionType,tQuestionID.getText());
						Success suc = new Success(s,subjectName);

					}
				});
			}
		});

	//Action when QuestionBack button is pressed	
		bQuestionBank.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String questionType = cBox.getSelectedItem();
				System.out.println(questionType);
				GetQuestionBank gqb = new GetQuestionBank(subjectName, questionType);
			}
		});

	//Action when GenerateTest button is clicked
		bGenerateTest.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				//String questionType = cBox.getSelectedItem();
				//System.out.println(questionType);
				GenerateTest gt = new GenerateTest(subjectName);
			}
		});		


	}
}

class MyItemListener implements ItemListener{
	String subjectName, questionType, cbLabel;
	Subject s;
	Label lModify = new Label("Specify Question ID");
	static TextField tModify = new TextField("Enter Modification",345);
	static TextField tQuestionID = new TextField("Ques. ID",60);
	static Button bSubmit = new Button("Submit");

	MyItemListener(String subjectName,String questionType,String cbLabel,Subject s){
		this.subjectName = subjectName;
		this.questionType = questionType;
		this.cbLabel = cbLabel;
		this.s = s;
	}

	public void itemStateChanged(ItemEvent ie){

		//s.add(lModify);
		s.add(tQuestionID);
		s.add(tModify);
		s.add(bSubmit);
		tQuestionID.setBounds(15,120,60,30);
		tModify.setBounds(90,120,345,30);
		bSubmit.setBounds(342,155,93,30);
		bSubmit.setBackground(Color.white);
		bSubmit.setFont(new Font("SansSerif", Font.BOLD, 12));

		s.revalidate();

		bSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Modify mo = new Modify(subjectName,questionType,tQuestionID.getText(),cbLabel,tModify.getText());
				Success suc = new Success(s,subjectName);
			}
		});
	}
	
}
