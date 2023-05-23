package storage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
    private String name;
    private IntHolder budget;
    private HashMap<String, Integer> incomes;
    private HashMap<String, Integer> expends;
    private List<Integer> history;
    public List<Integer> getHistory() {
        return history;
    }
    public void setHistory(List<Integer> history) {
        this.history = history;
    }
    public String getName() {
        return name;
    }
    public IntHolder getBudget() {
        return budget;
    }
    public Map<String, Integer> getIncomes() {
        return incomes;
    }
    public Map<String, Integer> getExpends() {
        return expends;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIncomes(Map<String, Integer> incomes) {
        this.incomes = (HashMap<String, Integer>) incomes;
    }
    public void setExpends(Map<String, Integer> expends) {
        this.expends = (HashMap<String, Integer>) expends;
    }
    public User(String name, IntHolder budget, Map<String, Integer> incomes, Map<String, Integer> expends) {
        this.name = name;
        this.budget = budget;
        this.incomes = (HashMap<String, Integer>) incomes;
        this.expends = (HashMap<String, Integer>) expends;
    }
    public User() {}
    public void setBudget(IntHolder budget) {
        this.budget = budget;
    }
}
