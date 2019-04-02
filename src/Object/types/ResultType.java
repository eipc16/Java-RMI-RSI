package Object.types;

import java.io.Serializable;

public class ResultType implements Serializable {
    private static final long serializableVersionUID = 102L;
    String result_description;
    public double result;

    public ResultType(String description, double result) {
        this.result_description = description;
        this.result = result;
    }


    @Override
    public String toString() {
        return this.result_description + "\nWynik: " + result;
    }
}
