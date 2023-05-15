package userinterface;

import java.util.Scanner;

public class Console implements UserInterface {
    @Override
    public void showInfo(String info) {
        System.out.println(info);
    }

    @Override
    public Object askInfo() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
