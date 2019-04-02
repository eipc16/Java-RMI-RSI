package Object.types;

import java.io.Serializable;
import java.util.List;

public class DividerInputType implements Serializable {

    private List<Integer> inputList;
    private Integer divider;

    public DividerInputType(List<Integer> inputList, Integer divider) {
        this.inputList = inputList;
        this.divider = divider;
    }

    public List<Integer> getList() { return this.inputList; }

    public Integer getDivider() { return this.divider; }

}
