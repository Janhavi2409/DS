package Assignment7;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CalculatorInterface {

    @WebMethod
    int add(int a, int b);

    @WebMethod
    int subtract(int a, int b);
}