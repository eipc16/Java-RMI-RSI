package Object.objects;

import Object.interfaces.CalcObject2;
import Object.types.InputType;
import Object.types.ResultType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcObject2Impl extends UnicastRemoteObject implements CalcObject2 {
    private static final long serialVersionUID = 101L;

    public CalcObject2Impl() throws RemoteException {
        super();
    }

    @Override
    public ResultType calc(InputType param) throws RemoteException {
        double x, y;
        String operation;
        double result = 0.0;
        x = param.getX();
        y = param.getY();
        operation = param.getOperation();
        String desc;

        switch(operation) {
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            default:
                desc = "No such operator: " + operation;
                return new ResultType(desc, result);
        }
        desc = "Result for operation: " + x + " " + operation + " " + y;

        return new ResultType(desc, result);
    }
}