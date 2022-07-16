package QuizManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Quiz extends JFrame implements ActionListener{
	JButton next,submit,help;
	public static int count = 0;
	JLabel qno,qname;
	String q[][]= new String [10][5];
	JRadioButton op1,op2,op3,op4;
	ButtonGroup options;
	public static int timer =  15;
	String  pa [][]=new String [10][1];
	public static int given_answer = 0;
	String qa [][] = new String [10][2];
	public static int score = 0;
	
	String username;
	Quiz(String username)
	{
		this.username = username;
	setBounds(250,50,868,572);
	getContentPane().setBackground(Color.white);
	setLayout(null);
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem/icons/quiztime3.png"));
	JLabel l1 = new JLabel(i1);
	l1.setBounds(00,00,858,285);
	add(l1);
	
	qno = new JLabel("");
	qno.setBounds(100,300,40,20);
	qno.setFont(new Font("Tahoma",Font.PLAIN,18));
	add(qno);
	
	qname = new JLabel("");
	qname.setBounds(150,300,858,30);
	qname.setFont(new Font("Tahoma",Font.PLAIN,18));
	add(qname);
	
	q[0][0] = "Automatic type conversion is possible in which of the possible cases?";
	q[0][1] = "Int to long";
	q[0][2] = "Byte to int";
	q[0][3] = "Long to int";
	q[0][4] = "Short to int";
	
	q[1][0] = "Select the valid statement.";
	q[1][1] = "char[] ch = new char(5)";
	q[1][2] = "char[] ch = new char[5]";
	q[1][3] = "char[] ch = new char()";
	q[1][4] = "char[] ch = new char[]";
	
	q[2][0] = "Arrays in java are-";
	q[2][1] = "Objects";
	q[2][2] = "object reference";
	q[2][3] = "Primitve data type";
	q[2][4] = "None";
	
	q[3][0] = "When is the object created with new keyword?";
	q[3][1] = "Depends on the code";
	q[3][2] = "At compile time";
	q[3][3] = "At run time";
	q[3][4] = "None";
	
	q[4][0] = "Identify the corrected definition of a package.";
	q[4][1] = "A package is a collection of editing tool";
	q[4][2] = "A package is a collection of interfaces.";
	q[4][3] = "A package is a collection of classes.";
	q[4][4] = "A package is a collection of classes&interfaces.";
	
	q[5][0] = "Identify the keyword among the following that makes a variable belong to a class.";
	q[5][1] = "final";
	q[5][2] = "static";
	q[5][3] = "Volatile";
	q[5][4] = "abstract";
	
	q[6][0] = "In which of the following is toString() method defined?";
	q[6][1] = "java.lang.Object";
	q[6][2] = "java.lang.String";
	q[6][3] = "java.lang.Util";
	q[6][4] = "None";
	
	q[7][0] = "compareTo() returns?";
	q[7][1] = "True";
	q[7][2] = "False";
	q[7][3] = "An int value";
	q[7][4] = "None";
	
	q[8][0] = "Total constructor string class have?";
	q[8][1] = "3";
	q[8][2] = "7";
	q[8][3] = "20";
	q[8][4] = "13";
	
	q[9][0] = "Where does the system stores parameters and local variables whenever a method is invoked?";
	q[9][1] = "Heap";
	q[9][2] = "Stack";
	q[9][3] = "Array";
	q[9][4] = "Tree";
	
	
	//and their answers
	qa[0][1] = "Int to long";
	qa[1][1] = "char[] ch = new char[5]";
	qa[2][1] = "Objects";
	qa[3][1] = "At run time";
	qa[4][1] = "A package is a collection of classes&interfaces."; 
	qa[5][1] = "static";
	qa[6][1] = "java.lang.Object";
	qa[7][1] = "An int value";
	qa[8][1] = "13";
	qa[9][1] = "Stack";
	
	op1 = new JRadioButton("");
	op1.setFont(new Font("Dialog",Font.PLAIN,18));
	op1.setBounds(150,340,400,18);
	op1.setBackground(Color.white);
	add(op1);
	
	op2 = new JRadioButton("");
	op2.setFont(new Font("Dialog",Font.PLAIN,18));
	op2.setBounds(150,370,400,18);
	op2.setBackground(Color.white);
	add(op2);
	
	op3 = new JRadioButton("");
	op3.setFont(new Font("Dialog",Font.PLAIN,18));
	op3.setBounds(150,400,400,18);
	op3.setBackground(Color.white);
	add(op3);
	
	op4 = new JRadioButton("");
	op4.setFont(new Font("Dialog",Font.PLAIN,18));
	op4.setBounds(150,430,400,18);
	op4.setBackground(Color.white);
	add(op4);
	
	options = new ButtonGroup();
	options.add(op1);
	options.add(op2);
	options.add(op3);
	options.add(op4);
	
	next = new JButton("NEXT");
	next.setFont(new Font("Tahoma",Font.PLAIN,22));
	next.setBackground(Color.cyan);
	next.setForeground(Color.black);
	next.addActionListener(this);
	next.setBounds(650,430,150,30);
	add(next);
	
	help = new JButton("HINT");
	help.setFont(new Font("Tahoma",Font.PLAIN,22));
	help.setBackground(Color.yellow);
	help.setForeground(Color.black);
	help.addActionListener(this);
	help.setBounds(650,380,150,30);
	add(help);
	
	submit = new JButton("SUBMIT");
	submit.setFont(new Font("Tahoma",Font.PLAIN,22));
	submit.setEnabled(false);
	submit.setBackground(Color.red);
	submit.setForeground(Color.black);
	submit.addActionListener(this);
	submit.setBounds(650,480,150,30);
	add(submit);
	
	start(0);
}
public void start (int count)
	{
		qno.setText(""+ (count+1)+". ");
		qname.setText(q[count][0]);
		op1.setLabel(q[count][1]);
		op1.setActionCommand(q[count][1]);
		op2.setLabel(q[count][2]);
		op2.setActionCommand(q[count][2]);
		op3.setLabel(q[count][3]);
		op3.setActionCommand(q[count][3]);
		op4.setLabel(q[count][4]);
		op4.setActionCommand(q[count][4]);	
		System.out.println(op4.getActionCommand());
		options.clearSelection();
	}
public void actionPerformed(ActionEvent e)
 {
		if(e.getSource()==next)
		{
			repaint();
			op1.setEnabled(true);
			op2.setEnabled(true);
			op3.setEnabled(true);
			op4.setEnabled(true);
			given_answer = 1;
			if(options.getSelection()==null) {
				pa[count][0] = "";
			} else {
				pa[count][0] = options.getSelection().getActionCommand();
			}
			if(count == 8)
			{
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			count++;
			start(count);
		}
		else if(e.getSource()==submit)
		{
			given_answer= 1;
			if(options.getSelection()==null) {
				pa[count][0] = "";
			} else {
				pa[count][0] = options.getSelection().getActionCommand();
			}
			for(int i=0;i<pa.length;i++)
			{
				if(pa[i][0].equals(qa[i][1]))
					score +=2 ;
				else score +=0;
			}
			this.setVisible(false);
			new Score(username,score).setVisible(true);
		}
		else if(e.getSource() == help)
		{
			if(count==0||count==2||count==4||count==6||count==8)
			{
				op2.setEnabled(false);
				op3.setEnabled(false);
			}
			else
			{
				op1.setEnabled(false);
				op4.setEnabled(false);
			}
			help.setEnabled(false);
		}		
}
public void paint(Graphics g)
{
	super.paint(g);
	String time = "Time left : "+ timer;
	g.setColor(Color.red);
	g.setFont(new Font("Tahoma",Font.BOLD,14));
	g.drawString(time,740,330);
	if(timer > 0)
	{
		g.drawString(time, 740, 330);
	}
	else
	{
		g.drawString("Times Up!",740,330);
	}
	timer--;
	try
	{
		Thread.sleep(1000);
		repaint();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	if(given_answer == 1)
	{
		given_answer = 0;
		timer = 15;
	}
	if(timer < 0)
	{
		timer = 15;
		op1.setEnabled(true);
		op2.setEnabled(true);
		op3.setEnabled(true);
		op4.setEnabled(true);
		if(count==8)
		{
			next.setEnabled(false);
			submit.setEnabled(true);
		}
		if(count==9)
		{
			if(options.getSelection()==null)
			{
				pa[count][0] = "";
			}
			else 
			{
				pa[count][0] = options.getSelection().getActionCommand();
			}
		for(int i=0;i<pa.length;i++)
		{
			if(pa[i][0].equals(qa[i][1]))
			{
				score+=2;
			}
			else score +=0;
		}
		this.setVisible(false);
		new Score(username,score).setVisible(true);
		}
		else {
			if(options.getSelection()==null)
			{
				pa[count][0] = "";
			}
			else 
			{
				pa[count][0] = options.getSelection().getActionCommand();
			}
			count++;
			start(count);
			}
		}
	}
public static void main(String[]args)
{
	new Quiz("").setVisible(true);
}
}
