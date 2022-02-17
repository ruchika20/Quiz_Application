package Quiz_Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizGame extends JFrame implements ActionListener{
    
    JLabel ques_no, question;
    JButton next_bttn, submit_bttn, lifeline_bttn;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;   
    public static int count=0;
    public static int timer=15;
    public static int ans_given=0;
    public static int score=0;
    
    String ques[][]= new String[10][5];
    String ques_ans[][]= new String[10][2];
    String user_ans[][]= new String[10][1];
    String username;
    
    QuizGame(String username){
        
        super("It's Quiz Game");
        setBounds(100,50,1200,640);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon bck_img= new ImageIcon(ClassLoader.getSystemResource("icon/quiz.jpg"));
        Image img1= bck_img.getImage().getScaledInstance(1200,250,Image.SCALE_DEFAULT);
        ImageIcon img2= new ImageIcon(img1);
        JLabel img= new JLabel(img2);
        img.setBounds(0,0,1200,250);
        add(img);
        
        ques_no= new JLabel("");
        ques_no.setBounds(80,300,50,30);
        ques_no.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(ques_no);
        
        question= new JLabel("");
        question.setBounds(110,300,900,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(question);
        
        //================QUESTIONS WITH OPTIONS====================================================
        ques[0][0] = "In which memory a String is stored, when we create a string using new operator?";
        ques[0][1] = "Stack";
        ques[0][2] = "String memory";
        ques[0][3] = "Random storage space";
        ques[0][4] = "Heap memory";
        
        ques[1][0] = "In java, jar stands for?";
        ques[1][1] = "Java Archive Runner";
        ques[1][2] = "Java Archive";
        ques[1][3] = "Java Application Resource";
        ques[1][4] = "Java Application Runner";
        
        ques[2][0] = "Which keyword is used for accessing the features of a package?";
        ques[2][1] = "import";
        ques[2][2] = "package";
        ques[2][3] = "extends";
        ques[2][4] = "export";
        
        ques[3][0] = "Which of the following is a mutable class in java?";
        ques[3][1] = "java.lang.StringBuilder";
        ques[3][2] = "java.lang.Short";
        ques[3][3] = "java.lang.Byte";
        ques[3][4] = "java.lang.String";
        
        ques[4][0] = "Which is used to find and fix bugs in the Java programs.?";
        ques[4][1] = "JVM";
        ques[4][2] = "JDB";
        ques[4][3] = "JDK";
        ques[4][4] = "JRE";
        
        ques[5][0] = "Which package contains the Random class?";
        ques[5][1] = "java.util package";
        ques[5][2] = "java.lang package";
        ques[5][3] = "java.awt package";
        ques[5][4] = "java.io package";
        
        ques[6][0] = "An interface with no fields or methods is known as?";
        ques[6][1] = "Runnable Interface";
        ques[6][2] = "Abstract Interface";
        ques[6][3] = "Marker Interface";
        ques[6][4] = "CharSequence Interface";
        
        ques[7][0] = "Which of the following option leads to the portability and security of Java?";
        ques[7][1] = "Bytecode is executed by JVM";
        ques[7][2] = "The applet makes the Java code secure and portable";
        ques[7][3] = "Use of exception handling";
        ques[7][4] = "Dynamic binding between objects";
        
        ques[8][0] = "Which of the following is a marker interface?";
        ques[8][1] = "Runnable interface";
        ques[8][2] = "Remote interface";
        ques[8][3] = "Readable interface";
        ques[8][4] = "Result interface";
        
        ques[9][0] = "What is the return type of the hashCode() method in the Object class?";
        ques[9][1] = "int";
        ques[9][2] = "Object";
        ques[9][3] = "long";
        ques[9][4] = "void";
        
        //=================================ANSWERS============================================
        ques_ans[0][1] = "Heap memory";
        ques_ans[1][1] = "Java Archive";
        ques_ans[2][1] = "import";
        ques_ans[3][1] = "java.lang.StringBuilder";
        ques_ans[4][1] = "JDB";
        ques_ans[5][1] = "java.util package";
        ques_ans[6][1] = "Marker Interface";
        ques_ans[7][1] = "Bytecode is executed by JVM";
        ques_ans[8][1] = "Remote interface";
        ques_ans[9][1] = "int";
        
        opt1= new JRadioButton("");
        opt1.setBounds(100,350,700,30);
        opt1.setFont(new Font("Dialog", Font.BOLD, 16));
        opt1.setBackground(Color.WHITE);
        add(opt1);
        
        opt2= new JRadioButton("");
        opt2.setBounds(100,390,700,30);
        opt2.setFont(new Font("Dialog", Font.BOLD, 16));
        opt2.setBackground(Color.WHITE);
        add(opt2);
        
        opt3= new JRadioButton("");
        opt3.setBounds(100,430,700,30);
        opt3.setFont(new Font("Dialog", Font.BOLD, 16));
        opt3.setBackground(Color.WHITE);
        add(opt3);
        
        opt4= new JRadioButton("");
        opt4.setBounds(100,470,700,30);
        opt4.setFont(new Font("Dialog", Font.BOLD, 16));
        opt4.setBackground(Color.WHITE);
        add(opt4);
        
        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        next_bttn = new JButton("Next");
        next_bttn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next_bttn.setBackground(new Color(30, 144, 255));
        next_bttn.setForeground(Color.WHITE);
        next_bttn.addActionListener(this);
        next_bttn.setBounds(950, 350, 150, 25);
        add(next_bttn);
        
        lifeline_bttn = new JButton("50-50 Lifeline");
        lifeline_bttn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline_bttn.setBackground(new Color(30, 144, 255));
        lifeline_bttn.setForeground(Color.WHITE);
        lifeline_bttn.setBounds(950, 400, 150, 25);
        lifeline_bttn.addActionListener(this);
        add(lifeline_bttn);
        
        submit_bttn = new JButton("Submit");
        submit_bttn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit_bttn.setEnabled(false);
        submit_bttn.setBackground(new Color(30, 144, 255));
        submit_bttn.setForeground(Color.WHITE);
        submit_bttn.addActionListener(this);
        submit_bttn.setBounds(950, 450, 150, 25);
        add(submit_bttn);
        
        start(0);
    }
    
    public void start(int count){
        
        ques_no.setText(""+ (count+1)+". ");
        question.setText(ques[count][0]);
        opt1.setLabel(ques[count][1]);
        opt1.setActionCommand(ques[count][1]);
        opt2.setLabel(ques[count][2]);
        opt2.setActionCommand(ques[count][2]);
        opt3.setLabel(ques[count][3]);
        opt3.setActionCommand(ques[count][3]);
        opt4.setLabel(ques[count][4]);
        opt4.setActionCommand(ques[count][4]);
        options.clearSelection();
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== next_bttn){
            
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if(options.getSelection()== null){                
                user_ans[count][0]="";
            }
            else{          
             user_ans[count][0]= options.getSelection().getActionCommand();
            }
            
            if(count==8){
                next_bttn.setEnabled(false);
                submit_bttn.setEnabled(true);
            }
            
            count ++;
            start(count);
        }
        else if(ae.getSource()== lifeline_bttn){
            
            if(count==1 || count==4 || count==6){
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            else{
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }
            lifeline_bttn.setEnabled(false);
                
        }
        else if(ae.getSource()== submit_bttn){
            
            ans_given=1;
            if(options.getSelection()==null){
                user_ans[count][0]="";
            }
            else{
                user_ans[count][0]= options.getSelection().getActionCommand();
            }
            
            for(int i=0;i<user_ans.length;i++){
                
                if(user_ans[i][0].equals(ques_ans[i][1])){
                    score+=10;
                }
                else{
                    score+=0;
                }
            }
            this.setVisible(false);
            new Score(username,score).setVisible(true);
        }
        
    }
    
    public void paint(Graphics g){
        
        super.paint(g);
        String time= "Time Left - "+ timer;
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,18));
        if(timer > 0) {
            g.drawString(time, 950, 330);
        }else {
            g.drawString("Times Up!!", 950, 330);
        }        
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given==1){
            
            ans_given=0;
            timer=15;
        }else if(timer<0){
            timer=15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count==8){
                
                next_bttn.setEnabled(false);
                submit_bttn.setEnabled(true);
            }
            if(count==9){                
                if(options.getSelection() == null){
                    user_ans[count][0] = "";
                }else {
                    user_ans[count][0] = options.getSelection().getActionCommand();
                }
                
                for(int i=0;i<user_ans.length;i++){
                    if(user_ans[i][0].equals(ques_ans[i][1])){
                        score+=10;
                    }
                    else{
                        score+=0;
                    }
                }
                this.setVisible(false);
                new Score(username,score).setVisible(true);
            }
            else{
                if(options.getSelection() == null){
                    user_ans[count][0] = "";
                }else {
                    user_ans[count][0] = options.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
            
        }
    }
    
    public static void main(String[] args){
        
        new QuizGame("").setVisible(true);
    }
}
