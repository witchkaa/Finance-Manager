package storage;

import java.io.Serializable;

public class IntHolder implements Serializable {
    private Integer value;

    public IntHolder(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
