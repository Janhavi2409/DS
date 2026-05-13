package Assignment7;

import javax.xml.ws.Endpoint;

public class Publisher {

    public static void main(String[] args) {

        Endpoint.publish(
                "http://localhost:8080/calculator",
                new CalculatorService()
        );

        System.out.println(
                "Web Service Started..."
        );
    }
}