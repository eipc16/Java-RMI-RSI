package Object.interfaces;

import Object.types.DividerInputType;
import Object.types.DividerResultType;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DivCounterInterface extends Remote {
    public DividerResultType count(DividerInputType input) throws RemoteException;
}
