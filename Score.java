package QuizManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Score extends JFrame implements ActionListener{   
PreparedStatement ps;
Connection con;
ResultSet rs;
    Score(String username, int score){
        setBounds(100, 50, 1100, 572);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/qmsdatabase","root","Wertyufg345@");
            System.out.println("Connection created");
            ps = con.prepareStatement("insert into scores values(?,?);");
            ps.setString(1, username);
            ps.setInt(2, score);
            ps.executeUpdate();
            ps.close();
}
catch (Exception e1) {e1.printStackTrace();}
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem/icons/score2.png"));
        Image i2=i1.getImage().getScaledInstance(550, 572, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        l1.setBounds(0, 0, 550, 550);
        add(l1);
       if(score == 20) {
       JLabel l2= new JLabel("Excellent! " + username);
        l2.setBounds(650, 200, 300, 150);
        l2.setForeground(Color.black);
        l2.setFont(new Font("SCRIPT", Font.ITALIC, 30));
        add(l2);
        }
        else if(score >=10 && score <20)
        {
        	  JLabel l2= new JLabel("Well Done! " + username);
              l2.setBounds(650, 200, 300, 150);
              l2.setForeground(Color.black);
              l2.setFont(new Font("SCRIPT", Font.ITALIC, 30));
              add(l2);
        }
        else {
        	  JLabel l2= new JLabel("Need to work hard! " + username);
              l2.setBounds(650, 200, 300, 150);
              l2.setForeground(Color.black);
              l2.setFont(new Font("SCRIPT", Font.ITALIC, 25));
              add(l2);
        }
        JLabel l3= new JLabel("Your Score Is "+ score);
        l3.setBounds(720, 300, 200, 30);
        l3.setFont(new Font("SANS_SERIF",Font.BOLD, 25));
        l3.setForeground(Color.red);
        add(l3);
        JButton b1= new JButton("Check others scores");
        b1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
            String name = JOptionPane.showInputDialog(b1, "Enter username: ");
            ps = con.prepareStatement("select * from scores where username=?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()) {
            JOptionPane.showMessageDialog(b1, rs.getString(2));
            }
            else {
            JOptionPane.showMessageDialog(b1, "This username doesnot exists.");
            }
}
catch (Exception e1) {
e1.printStackTrace();
}
}});
       b1.setBackground(Color.cyan);
        b1.setForeground(Color.BLACK);
        b1.setBounds(750, 400, 200, 50);
        add(b1);
    }
   public static void main(String[] args){
        new Score("", 0).setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {     
        this.setVisible(false);
        new qms().setVisible(true);
}
}
