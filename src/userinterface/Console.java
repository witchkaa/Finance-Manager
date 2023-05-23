package userinterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console implements UserInterface {
    public static final Scanner scan = new Scanner(System.in);
    @Override
    public void showInfo(String info) {
        System.out.println(info);
    }
    @Override
    public Object askInfo(String type) {
        Object res = null;
        if(type.equals("int")) {
            res = scan.nextInt();
            scan.nextLine();
        } else if(type.equals("string")) {
            scan.nextLine();
            res = scan.nextLine();
        } else if(type.equals("word")) {
            res = scan.next();
        }
        return res;
    }
    @Override
    public int showSuggestions() {
        System.out.println("""
                Choose what would you like to do:
                \tview current budget - press '0'
                \tchange budget - press '1'
                \tview planned expenses - press '2'
                \tview planned incomes - press '3'
                \tadd expense - press '4'
                \tadd income - press '5'
                \tmark expense as done - press '6'
                \tmark income as done - press '7'
                \tremove expense without completing - press '8'
                \tremove income without completing - press '9'
                \tcompare financial plans(incomes and expends) - press '10'
                \tcompare all finance(incomes, expends and current budget) - press '11'
                \tshow history stats - press '12'
                """);
        return scan.nextInt();
    }

    @Override
    public void greet() {
        System.out.println("Hello there!");
    }

    @Override
    public int askToStop() {
        System.out.println("Press 0 to continue, any other number to save and quit");
        int choice = 0;
        try {
            choice =  scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, try again!");
        }
        return choice;
    }

}
