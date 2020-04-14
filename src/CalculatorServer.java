/**
 * Distributed Systems Assignment 3 14/04/2020
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

import javax.swing.*;
import java.rmi.*;
import java.net.*;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements CalculatorRem {

    public JFrame jFrame = new JFrame("Calculator Server GUI");
    private JTextArea jta = new JTextArea();

    public CalculatorServer() throws RemoteException{
        jFrame.setVisible(true);//makes gui visable
        jFrame.setSize(300,300);//set size
        jta.setBounds(30,240,250,110);
        jta.setEditable(false);//uneditable text area
        jFrame.add(new JScrollPane(jta));
        jta.append("\n Starting Server...");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int addNum(int a, int b) {
        jta.append("\n Calculate value of: "+ a + "+" + b);
        int result = (a+b);
        jta.append("\n Processing....");
        jta.append("\n Result: "+ result);
        jta.append("\n Result sent to client!");
        return result;
    }

    public int subtractNum(int a, int b) {
        jta.append("\n Calculate value of: "+ a + "-" + b);
        int result = (a-b);
        jta.append("\n Processing....");
        jta.append("\n Result: "+ result);
        jta.append("\n Result sent to client!");
        return result;
    }

    public int divideNum(int a, int b) {
        jta.append("\n Calculate value of: "+ a + "/" + b);
        int result = (a/b);
        jta.append("\n Processing....");
        jta.append("\n Result: "+ result);
        jta.append("\n Result sent to client!");
        return result;
    }

    public int multiplyNum(int a, int b) {
        jta.append("\n Calculate value of: "+ a + "*" + b);
        int result = (a*b);
        jta.append("\n Processing....");
        jta.append("\n Result: "+ result);
        jta.append("\n Result sent to client!");
        return result;
    }

    public static void main(String args[])
    {
        try
        {
            CalculatorServer cs = new CalculatorServer();
            java.rmi.Naming.rebind("CalculatorServer",cs);
            System.out.println("Calculation Server Ready");
        }
        catch(RemoteException RE)
        {
            System.out.println("Remote Server Error:"+ RE.getMessage());
            System.exit(0);
        }
        catch(MalformedURLException ME)
        {
            System.out.println("Invalid URL!!");
        }
    }
}