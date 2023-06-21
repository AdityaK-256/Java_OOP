//My highest achievement on 19/06/2023

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

//import java.util.Scanner;
//import java.util.Collections;
//import java.awt.FlowLayout;
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;

public class passwordMaker4 implements DocumentListener /* put into effect the interaction withDocumentListener*/{
    JFrame F1;
    JPanel P1,P2,containerPanel;
    JLabel L1,L2,L3,L4,L5;
    JPasswordField t1 ;
    JTextField t2;
    JButton button, button2, Rbutton, Ebutton, CEbutton;
    boolean x = false;
    char ch;
    int uc,lc,space,spc,dig,l;
    String S,Str2,msg,msg2;
    
    passwordMaker4(){
        ch = ' ';
        S=""; msg= "";
        l = 0;
        
        F1 = new JFrame("Password refiner");
        //F1.setLayout((new GridBagLayout ()));
        //F1.setLayout(new FlowLayout(FlowLayout.CENTER, 0/*vertical spacing*/,0/*Horizontal spacing*/));
        F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F1.setSize(400,600);
        F1.setLayout(null);//
        
        L1 = new JLabel("Enter password: ");
        L1.setFont(new Font("Arial", Font.BOLD, 11));
        L2 = new JLabel("");
        //L2.setHorizontalAlignment(L2.CENTER);
        L3 = new JLabel("Confirm Your Password: ");
        L3.setFont(new Font("Arial", Font.BOLD, 11));
        L4 = new JLabel();
        L5 = new JLabel();
        
        t1 = new JPasswordField(20);
        t1.setEchoChar('\u2022');
        t2 = new JTextField(20);
        t1.getDocument().addDocumentListener(this);
        t2.getDocument().addDocumentListener(this);
        
        button = new JButton("Next");
        button2 = new JButton("Confirm");
        Rbutton = new JButton("Repeat");
        Ebutton = new JButton("Exit");
        CEbutton = new JButton("Copy & Exit");
        
        P1 = new JPanel();
        P1.setLayout(null);
        P1. setBackground (Color. lightGray);
        P1.setBounds(0, 0, 400, 280);
        //P1.setSize(400, 480);
        
        P2 = new JPanel();
        P2.setLayout(null);
        P2.setBounds(0, 290,400, 280);
        
        //setBounds(int x-coordinate, int y-coordinate, int width, int height)
        L1.setBounds(0, 0, 120, 20);
        t1.setBounds(0,20,200,20);
        L2.setBounds(0,40,200,200);
        //L2.setPreferredSize(new Dimension(200,200));
        button.setBounds(0,250,50,20);
        L3.setBounds(0, 0, 200, 20);
        t2.setBounds(0,20,200,20);
        L4.setBounds(0,60,300,40);
        button2.setBounds(0,100,60,20);
        L5.setBounds(0,140,500,40);
        Rbutton.setBounds(0, 180, 60, 20);
        Ebutton.setBounds(70, 180, 60, 20);
        CEbutton.setBounds(140, 180, 100, 20);
        
        //PANEL 1 COMPONENTS ADDITION
        P1.add(L1);
        P1.add(t1);
        P1.add(L2);
        P1.add(button);
        button.setEnabled(false);
        button.setVisible(false);
        
        //PANEL 2 COMPONENTS ADDITION
        P2.add(L3);
        P2.add(t2);
        P2.add(L4);
        P2.add(button2);
        button2.setEnabled(false);
        button2.setVisible(false);
        P2.add(L5);
        L5.setVisible(false);
        P2.add(Rbutton);
        Rbutton.setVisible(false);
        P2.add(Ebutton);
        Ebutton.setVisible(false);
        P2.add(CEbutton);
        CEbutton.setVisible(false);
        
        P2.setVisible(false);
        //F1.add(P1);//
        //F1.add(P2);//as we have added containerPanel in F1 
        containerPanel = new JPanel();
        containerPanel.setLayout(null);
        containerPanel.add(P1);
        containerPanel.add(P2);
        F1.setContentPane(containerPanel);
        
        F1.setVisible(true);
        F1.setResizable(false);
        
    }
    public void button_1(){
        //ActionListener AL = new ActionListener();//java.awt.event.Action Listener is abstract; cannot be instantiated
        button.setVisible(true);
        button.setEnabled(true);        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // action to be perform on clicking the 'next' button
                t1.setEditable(false);
                x= true;
                P2.setVisible(true);
                //ConfirmPassword();

            }
        });
    }
    public void button_2(){
        button2.setEnabled(true);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t2.setEditable(false);
                CopyCmd();
            }
        });
    }
    /*public void ConfirmPassword(){
        P2.setVisible(true);
    }*/
    public void CopyCmd(){
        L5.setVisible(true);
        L5.setText("<html>"+"<font color = 'black'>Do you want to repeat the program or<br> exit the program or copy and exit the program?</font>"+"</html>");
        L5.setFont(new Font("Arial", Font.BOLD, 11));
        Rbutton.setVisible(true);
        Ebutton.setVisible(true);
        CEbutton.setVisible(true);
        
        Rbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                F1.dispose();
            }
        });
        Ebutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        CEbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //to.........
                StringSelection stringSelection = new StringSelection(t2.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                //.....copy
                JOptionPane.showMessageDialog(null, "Password copied to clipboard:","Successful", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
    }
    @Override
    public void insertUpdate(DocumentEvent e){
        if(x==false){
            Suggestions();
        }
        else{
            confirmation();
        }
        
    }
    @Override
    public void removeUpdate(DocumentEvent e){
        if(x==false){
            Suggestions();
        }
        else{
            confirmation();
        }
    } 
    @Override
    public void changedUpdate(DocumentEvent e){
        if(x==false){
            Suggestions();
        }
        else{
            confirmation();
        }
    }
    
    public void Suggestions(){
        S = t1.getText();
        l = S.length();
        uc=0;lc=0;space=0;dig=0;spc=0;
        for(int i = 0; i<= S.length()-1; i++){
            ch = S.charAt(i);
            if(Character.isUpperCase(ch)){
                uc++;
            }
            else if(Character.isLowerCase(ch)){
                lc++;
            }
            else if(Character.isWhitespace(ch)){
                space++;
            }
            else if(Character.isDigit(ch)){
                dig++;
            }
            else{
                spc++;
            }
        }
        if(uc>=1&&lc>=1&&space==0&&dig>=1&&spc>=1&&l>=8){
            //L2.setText("You have made a perfect password. ");
            msg = "<br><h4><font color = 'green'>It is a Strong password . </font></h1>"+"<br>Click 'Next' to confirm password.";
            button_1();            
                    }
        else{
            button.setEnabled(false);
            if(lc<1){
                msg += "<br><font color = 'red'>There should be at least one lower case letter. </font>";
            }
            else{
                msg += "<br>✔"+"<font color = 'green'>There should be at least one lower case letter. </font>";
            }
            if(uc<1){
                msg += "<br><font color = 'red'>There should be at least one upper case letter. </font>";
            }
            else{
                msg += "<br>✔"+"<font color = 'green'>There should be at least one upper case letter. </font>";
            }
            if(space!=0){
                msg += "<br><font color = 'red'>There should be no space(s). </font>";
            }
            else{
                msg += "<br>✔"+"<font color = 'green'>There should be no space(s). </font>";
            }
            if(dig<1){
                msg += "<br><font color = 'red'>There should be at least one digit.</font> ";
            }
            else{
                msg += "<br>✔"+"<font color = 'green'>There should be at least one digit.</font> ";
            }
            
            if(spc<1){
                msg += "<br><font color = 'red'>There should be at least one special letter. </font>";
            }
            else{
                msg += "<br>✔"+"<font color = 'green'>There should be at least one special letter. </font>";
            }
            if(l<8){
                msg += "<br><font color = 'red'>The password should contain atleast 8 characters.</font>";
            }
            else{
                msg += "<br>✔"+"<font color = 'green'>The password should contain atleast 8 characters.</font>";
            }
        }
        L2.setText("<html>"+msg+"</html>");
        msg="";
        
    }
    public void confirmation(){
        Str2 = t2.getText();
        button2.setVisible(true);
        if(S.equals(Str2)){
            msg2 = "<font color = 'green'>✅Your confirmation password matches with the password</font>";
            button_2();
        }
        else{
            msg2 = "<font color = 'red'>⚠️Your confirmation password does not matches with the password</font>";
            button2.setEnabled(false);
        }
        L4.setText("<html>"+msg2+"</html>");
    }
    public static void main(String [] args){
        passwordMaker4 obj = new passwordMaker4();
    }
}