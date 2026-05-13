package Assignment7;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {

    public static void main(String[] args) throws Exception {

        URL url = new URL(
                "http://localhost:8080/calculator?wsdl"
        );

        QName qname =
                new QName(
                        "http://Assignment7/",
                        "CalculatorServiceService"
                );

        Service service =
                Service.create(url, qname);

        CalculatorInterface calc =
                service.getPort(
                        CalculatorInterface.class
                );

        int result1 = calc.add(10, 20);

        int result2 = calc.subtract(50, 10);

        System.out.println(
                "Addition = " + result1
        );

        System.out.println(
                "Subtraction = " + result2
        );
    }
}