package Assignment1B;

import java.rmi.*;
import java.rmi.registry.*;

public class AddServer {

    public static void main(String[] args) {

        try {

            // Create remote object
            AddServerImpl addServerImpl = new AddServerImpl();

            // Create registry at port 1099
            LocateRegistry.createRegistry(1099);

            // Bind object with name
            Naming.rebind("AddServer", addServerImpl);

            System.out.println("RMI Server Started");

        } catch (Exception e) {

            System.out.println("Exception: " + e);
        }
    }
}
