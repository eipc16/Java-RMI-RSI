package Object.interfaces;

import Object.types.InputType;
import Object.types.ResultType;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcObject2 extends Remote {
    public ResultType calc(InputType param) throws RemoteException;
}
