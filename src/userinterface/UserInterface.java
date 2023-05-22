package userinterface;

public interface UserInterface {
    void showInfo(String info);
    Object askInfo(String type);
    int showSuggestions();
    void greet();
    int askToStop();
}
