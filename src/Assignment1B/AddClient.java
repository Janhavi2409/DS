package Assignment1B;

import java.rmi.*;

public class AddClient {

    public static void main(String[] args) {

        try {

            // Lookup remote object
            AddServerIntf addServerIntf =
                    (AddServerIntf) Naming.lookup("rmi://localhost/AddServer");

            double d1 = 10;
            double d2 = 20;

            // Invoke remote method
            double result = addServerIntf.add(d1, d2);

            System.out.println("First Number : " + d1);
            System.out.println("Second Number: " + d2);
            System.out.println("Sum is       : " + result);

        } catch (Exception e) {

            System.out.println("Exception: " + e);
        }
    }
}
