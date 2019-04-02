package Object.types;

import java.io.Serializable;

public class InputType implements Serializable {
    private static final long serialVersionUID = 101L;

    private String operation;
    private double x;
    private double y;

    public InputType(double x, double y, String operation) {
        this.x = x;
        this.y = y;
        this.operation = operation;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getOperation() {
        return this.operation;
    }
}
