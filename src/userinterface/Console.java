package userinterface;

import java.util.Scanner;

public class Console implements UserInterface {
    @Override
    public void showInfo(String info) {
        System.out.println(info);
    }

    @Override
    public Object askInfo(String type) {
        Scanner scan = new Scanner(System.in);
        Object res = null;
        if(type == "int") {
            res = scan.nextInt();
        } else if(type == "string") {
            res = scan.nextLine();
        }
        scan.close();
        return res;
    }

    @Override
    public int showSuggestions() {
        System.out.println("""
                Choose what would you like to do:
                \tview planned incomes - press '1'
                \tview planned expenses - press '2'
                \tview current budget - press '3'
                \tadd expense - press '4'
                \tadd income - press '5'
                \tremove expense = press '6'
                \tremove income - press '7'
                \tmark expense as done - press '8'
                \tmark income as done - press '9'
                \tquick budget change - press '10'
                """);
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        scan.close();
        return choice;
    }

    @Override
    public void greet() {
        System.out.println("Hello there!");
    }

}
