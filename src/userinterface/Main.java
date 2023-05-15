package userinterface;

import storage.StorageProcessor;
import storage.User;

public class Main {
    public static void main(String[] args) {
        UserInterface UI = new Console();
        StorageProcessor storageProcessor = new StorageProcessor(UI);

    }
}
