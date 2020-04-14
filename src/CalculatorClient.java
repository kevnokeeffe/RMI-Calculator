/**
 * Assignment 3 Distributed Systems 14/04/2020
 * Author Kevin O'Keeffe
 * Software Systems Development
 * School of Computing and Science
 * Waterford Institute of Technology

 To run program in console type:
 1) javac *.java
 2) start rmiregistry
 3) java CalculatorServer
 4) java CalculatorClient
**/

import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CalculatorClient extends JFrame implements CalculatorRem{

    private JPanel panel;
    private JTextField jtfAnswer;
    private JTextArea jtaConsoleLog;

    // Declare Buttons
    private JButton b7 = new JButton("7");
    private JButton b4 = new JButton("4");
    private JButton btnDiv = new JButton("/");
    private JButton btnMlt = new JButton("*");
    private JButton btnMns = new JButton("-");
    private JButton btnPls = new JButton("+");
    private JButton btnSubmit = new JButton("=");
    private JButton b1 = new JButton("1");
    private JButton b0 = new JButton("0");
    private JButton b8 = new JButton("8");
    private JButton b5 = new JButton("5");
    private JButton b2 = new JButton("2");
    private JButton b9 = new JButton("9");
    private JButton b6 = new JButton("6");
    private JButton b3 = new JButton("3");
    private JButton btnClear = new JButton("CE");

public CalculatorClient(){

    // Create the Calculator screen
    setTitle("Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Initialise GUI with JTextFields and JButtons
    setBounds(100, 100, 220, 300);

    panel = new JPanel();
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(panel);
    panel.setLayout(null);

    jtfAnswer = new JTextField();
    jtfAnswer.setBounds(5, 5, 215, 40);
    jtfAnswer.setHorizontalAlignment(SwingConstants.CENTER);
    jtfAnswer.setEditable(false);
    panel.add(jtfAnswer);
    jtfAnswer.setColumns(10);

    // Creating action listeners for buttons
    b7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "7";
            jtfAnswer.setText(answer);
        }
    });
    b4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "4";
            jtfAnswer.setText(answer);
        }
    });
    b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "1";
            jtfAnswer.setText(answer);
        }
    });
    b0.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "0";
            jtfAnswer.setText(answer);
        }
    });
    b8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "8";
            jtfAnswer.setText(answer);
        }
    });
    b5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "5";
            jtfAnswer.setText(answer);
        }
    });
    b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "2";
            jtfAnswer.setText(answer);
        }
    });
    b9.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "9";
            jtfAnswer.setText(answer);
        }
    });
    b6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "6";
            jtfAnswer.setText(answer);
        }
    });
    b3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "3";
            jtfAnswer.setText(answer);
        }
    });
    btnDiv.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "/";
            jtfAnswer.setText(answer);
        }
    });
    btnMlt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "*";
            jtfAnswer.setText(answer);
        }
    });
    btnMns.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "-";
            jtfAnswer.setText(answer);
        }
    });
    btnPls.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
            answer = answer + "+";
            jtfAnswer.setText(answer);
        }
    });
    btnClear.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String answer = jtfAnswer.getText();
                    answer = "";
            jtaConsoleLog.setText("");
            jtfAnswer.setText(answer);
        }
    });

    //textArea for "console"
    jtaConsoleLog = new JTextArea();
    jtaConsoleLog.setEditable(false);
    jtaConsoleLog.setBounds(5, 270, 215, 100);
    panel.add(jtaConsoleLog);
    //jtaConsoleLog.setColumns(10);


    btnSubmit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //parse text area here
            //fixing up if you try to divide by zero

            String answer = jtfAnswer.getText();
            for(int x = 0;x<answer.length();x++){
                char operator = answer.charAt(x);
                if(operator == 'C'){
                    String old = jtfAnswer.getText();
                    for(int k = 0;k<old.length();k++){
                        char exMat = old.charAt(k);
                        if(exMat == '!'){
                            String newString = old.substring(k+1);
                            jtfAnswer.setText(""+newString);
                            x = 0;
                        }
                    }
                }
                if(operator == '+'){
                    int i = Integer.parseInt(answer.substring(0, x));
                    int j = Integer.parseInt(answer.substring(x+1, answer.length()));
                    String str = " Sending " + i + "+" + j;
                    jtaConsoleLog.append("\n" + str);
                    int val = addNum(i,j);
                    str = " Answer " + i + "/" + j + " = " + val;
                    jtaConsoleLog.append("\n" + str);
                    jtfAnswer.setText("" + val);
                }
                if(operator == '-'){
                    int i = Integer.parseInt(answer.substring(0, x));
                    int j = Integer.parseInt(answer.substring(x+1, answer.length()));
                    String str = " Sending " + i + "-" + j;
                    jtaConsoleLog.append("\n" + str);
                    int val = subtractNum(i,j);
                    str = " Answer " + i + "/" + j + " = " + val;
                    jtaConsoleLog.append("\n" + str);
                    jtfAnswer.setText("" + val);
                }
                if(operator == '*'){
                    int i = Integer.parseInt(answer.substring(0, x));
                    int j = Integer.parseInt(answer.substring(x+1, answer.length()));
                    String str = " Sending " + i + "*" + j;
                    jtaConsoleLog.append("\n" + str);
                    int val = multiplyNum(i,j);
                    str = " Answer " + i + "/" + j + " = " + val;;
                    jtaConsoleLog.append("\n" + str);
                    jtfAnswer.setText("" + val);
                }
                if(operator == '/'){
                    int i = Integer.parseInt(answer.substring(0, x));
                    int j = Integer.parseInt(answer.substring(x+1, answer.length()));
                    String str;
                    int val = 0;
                    str = " Sending " + i + "/" + j;
                    jtaConsoleLog.append("\n" + str);
                    if(i == 0 || j == 0){
                        jtaConsoleLog.append(" Cannot divide by zero!");
                        jtfAnswer.setText(" Cannot divide by zero!");

                    }
                    else{
                        val = divideNum(i,j);
                        jtfAnswer.setText("" + val);
                        str = " Answer " + i + "/" + j + " = " + val;
                        jtaConsoleLog.append("\n" + str);

                    }


                }

            }
        }
    });
    // Setting buttons positions
    b0.setBounds(5, 215, 50, 50);
    b1.setBounds(5, 160, 50, 50);
    b2.setBounds(60, 160, 50, 50);
    b3.setBounds(115, 160, 50, 50);
    b4.setBounds(5, 105, 50, 50);
    b5.setBounds(60, 105, 50, 50);
    b6.setBounds(115, 105, 50, 50);
    b7.setBounds(5, 50, 50, 50);
    b8.setBounds(60, 50, 50, 50);
    b9.setBounds(115, 50, 50, 50);
    btnSubmit.setBounds(115, 215, 50, 50);
    btnDiv.setBounds(170, 50, 50, 50);
    btnMlt.setBounds(170, 105, 50, 50);
    btnMns.setBounds(170, 160, 50, 50);
    btnPls.setBounds(170, 215, 50, 50);
    btnClear.setBounds(60, 215, 50, 50);

    // Adding buttons to panel
    panel.add(b0);
    panel.add(b1);
    panel.add(b2);
    panel.add(b3);
    panel.add(b4);
    panel.add(b5);
    panel.add(b6);
    panel.add(b7);
    panel.add(b8);
    panel.add(b9);
    panel.add(btnSubmit);
    panel.add(btnDiv);
    panel.add(btnMns);
    panel.add(btnMlt);
    panel.add(btnPls);
    panel.add(btnClear);



}

    /**
     Calls add method from calcServer via interface
     Passes i, j, and the clientNumber to the server
     **/
    public int addNum(int i, int j)
    {
        int val = 0;
        try
        {
            String ServerURL="CalculatorServer";
            CalculatorRem CI=(CalculatorRem)Naming.lookup(ServerURL);
            val=CI.addNum(i,j);
            return val;
        }
        catch(Exception ex)
        {
            System.out.println("Exception:"+ex);
        }
        return val;
    }
    /**
     Calls subt method from calcServer via interface
     Passes i, j, and the clientNumber to the server
     **/

    public int subtractNum(int i, int j)
    {
        int val = 0;
        try
        {
            String ServerURL="CalculatorServer";
            CalculatorRem CI=(CalculatorRem)Naming.lookup(ServerURL);
            val=CI.subtractNum(i,j);
            return val;
        }
        catch(Exception ex)
        {
            System.out.println("Exception:"+ex);
        }
        return val;

    }
    /**
     Calls mult method from calcServer via interface
     Passes i, j, and the clientNumber to the server
     **/

    public int multiplyNum(int i, int j)
    {
        int val = 0;
        try
        {
            String ServerURL="CalculatorServer";
            CalculatorRem CI=(CalculatorRem)Naming.lookup(ServerURL);
            val=CI.multiplyNum(i,j);
            return val;
        }
        catch(Exception ex)
        {
            System.out.println("Exception:"+ex);
        }
        return val;

    }
    /**
     Calls div method from calcServer via interface
     Passes i, j, and the clientNumber to the server
     **/

    public int divideNum(int i, int j)
    {
        int val = 0;
        try
        {
            String ServerURL="CalculatorServer";
            CalculatorRem CI=(CalculatorRem)Naming.lookup(ServerURL);
            val=CI.divideNum(i,j);
            return val;
        }
        catch(Exception ex)
        {
            System.out.println("Exception:"+ex);
        }
        return val;

    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    CalculatorClient cc=new CalculatorClient();
                    cc.setVisible(true);
                    cc.setSize(241,420);

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
