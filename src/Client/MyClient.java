package Client;

import Object.interfaces.CalcObject;
import Object.interfaces.CalcObject2;
import Object.interfaces.DivCounterInterface;
import Object.objects.DivCounter;
import Object.types.DividerInputType;
import Object.types.DividerResultType;
import Object.types.InputType;
import Object.types.ResultType;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyClient {

    private static Integer WORKER_COUNT = 4;

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "../srv.policy");

        DividerResultType result;
        DivCounterInterface[] divCounter = new DivCounterInterface[WORKER_COUNT];

        Integer[] num_array = {4, 4, 5, 3, 2, 2, 5, 2, 8, 3, 4, 2 , 3, 3 ,3 , 3, 32,5,3,5,2,3,77,5,4,4,444,4,6,4,2,4,56,3,2,34,66,2,1,3,2,0,5,3,2,4,5};
        Integer[] div_array = {2, 3, 7, 10, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23};

        List<Integer> list = Arrays.asList(num_array);
        List<Integer> dividers = Arrays.asList(div_array);


        if(args.length < 1) {
            System.out.println("You have to enter RMI Object addresses in the form: //host_address/service_name");
            return;
        }

        String address;

        for(int i = 0; i < WORKER_COUNT; i++) {
            address = "//127.0.0.1/" + args[0] + "_" + i;
            try {
                divCounter[i] = (DivCounterInterface) java.rmi.Naming.lookup(address);
            } catch (RemoteException | NotBoundException | MalformedURLException e) {
                System.out.println("Couldn't resolve reference to " + address);
                e.printStackTrace();
                return;
            }
        }

        for(int i = 0; i < dividers.size(); i += WORKER_COUNT) {
            for(int w = 0; w < WORKER_COUNT && i + w < dividers.size(); w++) {
                start(divCounter[w], list, dividers.get(i + w));
            }
        }
    }

    public static void start(DivCounterInterface worker, List<Integer> list, Integer divider) {
        DividerResultType result;
        try {
            result = worker.count(new DividerInputType(list, divider));
        } catch (RemoteException e) {
            System.out.println("Remote call error");
            e.printStackTrace();
            return;
        }

        System.out.println("Wynik: " + result);
    }
}
