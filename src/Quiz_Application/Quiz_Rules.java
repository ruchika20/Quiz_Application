package Quiz_Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz_Rules extends JFrame implements ActionListener{
    
    String username;
    JButton start_bttn, back_bttn;
    
    Quiz_Rules(String username){
        super("It's Quiz Time");
        this.username=username;
        
        setBounds(320,90,800,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel title= new JLabel("Welcome "+username+" to Quizzie Buzz");
        title.setBounds(180,10,700,40);
        title.setForeground(Color.MAGENTA);
        title.setFont(new Font("Viner Hand ITC",Font.BOLD, 28));
        add(title);
        
        JLabel text = new JLabel("");
        text.setFont(new Font("Tahoma", Font.PLAIN, 16));
        text.setBounds(20, 90, 600, 350);
        text.setText(
            "<html>"+ 
                "1. You Google in quiz, you are out of the quizzie" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. Quiz Master is always right" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. The maximum time for answering is 15 seconds" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. No yelling out answers it disrupts the game" + "<br><br>" +
            "</html>"
        );
        add(text);
        
        start_bttn= new JButton("Start");
        start_bttn.setBounds(250, 500, 100, 30);
        start_bttn.setBackground(Color.MAGENTA);
        start_bttn.setForeground(Color.WHITE);
        start_bttn.addActionListener(this);
        add(start_bttn);
        
        back_bttn = new JButton("Back");
        back_bttn.setBounds(400, 500, 100, 30);
        back_bttn.setBackground(Color.MAGENTA);
        back_bttn.setForeground(Color.WHITE);
        back_bttn.addActionListener(this);
        add(back_bttn);        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==start_bttn){            
            this.setVisible(false);
            new QuizGame(username).setVisible(true);
        }
        else if(ae.getSource()==back_bttn){
            this.setVisible(false);
            new Quizzie_Buzz().setVisible(true);
        }        
    }
    
    public static void main(String[] args){        
        new Quiz_Rules("").setVisible(true);
    }
    
}
