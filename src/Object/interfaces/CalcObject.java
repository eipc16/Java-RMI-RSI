package Object.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcObject extends Remote {
    public double calc(double a, double b) throws RemoteException;
}
