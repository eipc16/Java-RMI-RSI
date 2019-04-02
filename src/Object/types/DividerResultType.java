package Object.types;

import java.io.Serializable;

public class DividerResultType implements Serializable {

    private Integer result;
    private Integer divider;
    private String workerName;

    public DividerResultType(String workerName, Integer result, Integer divider) {
        this.result = result;
        this.divider = divider;
        this.workerName = workerName;
    }

    @Override
    public String toString() {
        if(result < 1) {
            return String.format("[%s] Nie ma w liście żadnych liczb podzielonych przez %d", workerName, divider);
        } else {
            return String.format("[%s] W liście znajduje się %d liczb podzielonych przez dzielnik %d", workerName, result, divider);
        }
    }

}
