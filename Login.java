package QuizManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener  {
	   JButton b1, b2;
	    String username;
	    Login(String username){
	        this.username= username;
	        setBounds(100, 50, 1100, 572 );
	        getContentPane().setBackground(Color.cyan);
	        setLayout(null);
	        JLabel l1 = new JLabel("Welcome "+username + " to Quiz Application");
	        l1.setForeground(Color.black);
	        l1.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
	        l1.setBounds(320, 20, 700, 30);
	        add(l1);
	        JLabel l2 = new JLabel("");
	        l2.setForeground(Color.black);
	        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        l2.setBounds(350, 0, 400, 550);
	        l2.setText(
	                "<html>"+
	                        "1. All questions are compulsory."+ "<br><br>"+
	                        "2. There are only 15 seconds for each question."+ "<br><br>"+
	                        "3. There is no negative marking."+ "<br><br>"+
	                        "4. There are total 10 questions for 2 marks each."+ "<br><br>"+
	                "</html>"
	               );
	        add(l2);
	        b1 = new JButton("Back");
	        b1.setBounds(350, 400, 100, 30);
	        b1.setBackground(Color.lightGray);
	        b1.setForeground(Color.black);
	        b1.addActionListener(this);
	        add(b1);
	        b2 = new JButton("Start Quiz");
	        b2.setBounds(575, 400, 100, 30);
	        b2.setBackground(Color.green);
	        b2.setForeground(Color.black);
	        b2.addActionListener(this);
	        add(b2);
	         setVisible(true);
	     }
	    public static void main(String[] args){

	        new Login("");

	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			   if(e.getSource() == b1){

		            this.setVisible(false);

		            new qms().setVisible(true);

		        }else if(e.getSource() == b2){

		            new Quiz(username).setVisible(true);
		}
}
}

