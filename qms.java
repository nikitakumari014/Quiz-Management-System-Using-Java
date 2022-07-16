package QuizManagementSystem;
// importing necessary packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class qms extends JFrame implements ActionListener{
JButton b1,b2;
JTextField t1;
qms()
{
	setBounds(100,50,1100,572);
	getContentPane().setBackground(Color.WHITE);
	setLayout(null);
	ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem/icons/quiz.png"));
	JLabel l1 = new JLabel(i);
	l1.setBounds(0,0,550,572);
	add(l1);
	
	JLabel l2 = new JLabel("    Quiz Application  ");
	l2.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
	l2.setForeground(Color.red);
	l2.setBounds(700,30,300,40);
	add(l2);
	
	JLabel l3 = new JLabel("Enter Your Name");
	l3.setFont(new Font("Mongolian Baiti", Font.BOLD,18));
	l3.setForeground(Color.black);
	l3.setBounds(800,175,300,20);
	add(l3);
	
	t1 = new JTextField();
	t1.setFont(new Font("Times New Roman" , Font.BOLD, 20));
	t1.setBounds(720,200,300,25);
	add(t1);
	
	b1 = new JButton("Login");
	b1.setBounds(720,300,120,25);
	b1.setBackground(Color.blue);
	b1.setForeground(Color.white);
	b1.addActionListener(this);
	add(b1);
	
	b2 = new JButton("Exit");
	b2.setBounds(900,300,120,25);
	b2.setBackground(Color.blue);
	b2.setForeground(Color.white);
	b2.addActionListener(this);
	add(b2); 
	setVisible(true); 
}
public static void main(String[]args)
{
	new qms();
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()== b1)
	{
		String name = t1.getText();
		this.setVisible(false);
		new Login(name);
	}
	else
	{
		System.exit(0);
	}
}
}
