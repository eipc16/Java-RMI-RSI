package Object.objects;

import Object.interfaces.DivCounterInterface;
import Object.types.DividerInputType;
import Object.types.DividerResultType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

public class DivCounter extends UnicastRemoteObject implements DivCounterInterface {

    private static final long serialVersionUID = 101L;

    private String name;

    public DivCounter(String name) throws RemoteException {
        super();

        this.name = name;
    }

    @Override
    public DividerResultType count(DividerInputType input) throws RemoteException {
        List<Integer> list = input.getList();
        Integer divider = input.getDivider();

        Integer counter = list
                            .stream()
                            .filter(i -> i % divider == 0)
                            .collect(Collectors.toList())
                            .size();

        return new DividerResultType(name, counter, divider);
    }
}
