package storage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    private String name;
    private int budget;
    private HashMap<String, Integer> incomes;
    private HashMap<String, Integer> expends;

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }

    public HashMap<String, Integer> getIncomes() {
        return incomes;
    }

    public HashMap<String, Integer> getExpends() {
        return expends;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setIncomes(Map<String, Integer> incomes) {
        this.incomes = (HashMap<String, Integer>) incomes;
    }

    public void setExpends(Map<String, Integer> expends) {
        this.expends = (HashMap<String, Integer>) expends;
    }

    public User(String name, int budget, Map<String, Integer> incomes, Map<String, Integer> expends) {
        this.name = name;
        this.budget = budget;
        this.incomes = (HashMap<String, Integer>) incomes;
        this.expends = (HashMap<String, Integer>) expends;
    }
    public User() {}
}
