package Quiz_Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quizzie_Buzz extends JFrame implements ActionListener{
    
    JButton rule_bttn, exit_bttn;
    JTextField txt1;
    String name;

    Quizzie_Buzz()
    {
        super("It's Quiz time!");
        setBounds(200,130,1000,440);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //---------Adding Image to the Frame--------------------
        ImageIcon front_img= new ImageIcon(ClassLoader.getSystemResource("icon/quiz-img.jpg"));
        Image img1= front_img.getImage().getScaledInstance(500,440,Image.SCALE_DEFAULT);
        ImageIcon img2= new ImageIcon(img1);
        JLabel img_label= new JLabel(img2);
        img_label.setBounds(0,0,500,440);
        add(img_label);
        
        //----------Adding Labels-----------------------------
        
        JLabel title= new JLabel("QUIZZIE BUZZ");
        title.setBounds(600,60,300,45);
        title.setFont(new Font("Viner Hand ITC", Font.BOLD, 35));
        title.setForeground(Color.BLUE);
        add(title);
        
        JLabel name= new JLabel("Enter Your Name");
        name.setBounds(670,150,300,20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        add(name);
        
        txt1 = new JTextField();
        txt1.setBounds(610, 200, 300, 25);
        txt1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(txt1);
        
        rule_bttn = new JButton("Rules");
        rule_bttn.setBounds(640, 270, 120, 25);
        rule_bttn.setBackground(new Color(30, 144, 254));
        rule_bttn.setForeground(Color.WHITE);
        rule_bttn.addActionListener(this);
        add(rule_bttn);
        
        exit_bttn = new JButton("Exit");
        exit_bttn.setBounds(800, 270, 120, 25);
        exit_bttn.setBackground(new Color(30, 144, 254));
        exit_bttn.setForeground(Color.WHITE);
        exit_bttn.addActionListener(this);
        add(exit_bttn);        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== rule_bttn){
            
            name = txt1.getText();
            this.setVisible(false);
            new Quiz_Rules(name);
        }
        else{
            System.exit(0);
        }        
    }
    
    public static void main(String[] args) {    
        new Quizzie_Buzz().setVisible(true);    
    }
        
    
}
