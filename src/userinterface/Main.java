package userinterface;

import storage.FileStorageProcessor;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new Console();
        FileStorageProcessor fileStorageProcessor = new FileStorageProcessor(ui);

    }
}
