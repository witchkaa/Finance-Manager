package storage;

import java.io.Serializable;

public class IntHolder implements Serializable {
    private final Integer value;
    public IntHolder(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
