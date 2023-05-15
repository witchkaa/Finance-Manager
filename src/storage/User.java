package storage;

import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {
    private String name;
    private int budget;
    private HashMap<String, Integer> incomes;
    private HashMap<String, Integer> expends;

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setIncomes(HashMap<String, Integer> incomes) {
        this.incomes = incomes;
    }

    public void setExpends(HashMap<String, Integer> expends) {
        this.expends = expends;
    }

    public User(String name, int budget, HashMap<String, Integer> incomes, HashMap<String, Integer> expends) {
        this.name = name;
        this.budget = budget;
        this.incomes = incomes;
        this.expends = expends;
    }
    public User() {}
}
