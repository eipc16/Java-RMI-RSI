package Object.objects;

import Object.interfaces.CalcObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcObjectImpl extends UnicastRemoteObject implements CalcObject {

    private static final long serialVersionUID = 101L;

    public CalcObjectImpl() throws RemoteException {
        super();
    }

    @Override
    public double calc(double a, double b) throws RemoteException {
        return a + b;
    }
}
