package Assignment7;

import javax.jws.WebService;

@WebService(endpointInterface =
        "Assignment7.CalculatorInterface")
public class CalculatorService
        implements CalculatorInterface {

    public int add(int a, int b) {

        return a + b;
    }

    public int subtract(int a, int b) {

        return a - b;
    }
}