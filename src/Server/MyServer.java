package Server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Object.objects.DivCounter;

public class MyServer {

    private static Integer WORKER_COUNT = 4;

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "src/srv.policy");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(args.length < 1) {
	        System.out.println("You have to enter RMI Object addresses in the form: //host_address/service_name");
	        return;
        }

	    if(System.getSecurityManager() == null) {
	        System.setSecurityManager(new SecurityManager());
        }

	    try {
            Registry reg = LocateRegistry.createRegistry(1099);
            for(int i = 0; i < WORKER_COUNT; i++) {
                java.rmi.Naming.rebind(args[0] + "_" + i, new DivCounter("Worker_" + i));
            }
            System.out.println("Server registered successfully... (Ctrl+C to stop)");
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Server can't be registered");
            e.printStackTrace();
            return;
        }
    }
}
