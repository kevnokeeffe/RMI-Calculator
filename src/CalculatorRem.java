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

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorRem extends Remote {
    public int addNum(int a, int b) throws RemoteException;
    public int subtractNum (int a, int b) throws RemoteException;
    public int divideNum (int a, int b) throws RemoteException;
    public int multiplyNum (int a, int b) throws RemoteException;
}
