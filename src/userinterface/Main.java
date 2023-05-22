package userinterface;

import logic.Command;
import logic.CommandFactory;
import storage.FileStorageProcessor;
import storage.StorageProcessor;
import storage.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new Console();
        StorageProcessor fileStorageProcessor = new FileStorageProcessor(ui);
        try {
            User user = fileStorageProcessor.getUserInfo();
            CommandFactory commandFactory = new CommandFactory(ui, user);
            do {
                int choice = ui.showSuggestions();
                Command command = commandFactory.createCommand(choice);
                command.execute();
            } while (ui.askToStop() == 0);
            try {
                fileStorageProcessor.saveUserInfo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Console.scan.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
