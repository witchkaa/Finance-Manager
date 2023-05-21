package storage;

import userinterface.UserInterface;

import java.io.*;
import java.util.HashMap;

public class FileStorageProcessor implements StorageProcessor{
    User user;
    UserInterface userInterface;

    public FileStorageProcessor(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void serialize(User user) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream("/user.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(user);
        } catch (IOException e) {
            throw new StorageRuntimeException("Something went wrong!");
        }
    }
    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }
    public User deserialize(String path) throws IOException {
        File file = new File("/user.ser");
        if (isFileEmpty(file)) {
            createNewUser();
        }
        else {
            try (FileInputStream fileInputStream = new FileInputStream(path);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                User user = (User) objectInputStream.readObject();
                this.user = user;
                return user;
            } catch (IOException | ClassNotFoundException e) {
                throw new StorageRuntimeException("Something went wrong...");
            }
        }
        return user;
    }
    public void createNewUser() {
        user = new User();
        userInterface.showInfo("Seems like you're new to our app! Let's create a user!\n" +
                "Please enter your name: ");
        String name = (String)userInterface.askInfo();
        user.setName(name);
        userInterface.showInfo("Nice to meet you, " + name + "! Now enter your start budget: ");
        int budget = (int)userInterface.askInfo();
        user.setBudget(budget);
        user.setExpends(new HashMap<String, Integer>());
        user.setIncomes(new HashMap<String, Integer>());
    }

    @Override
    public void getUserInfo() throws IOException {
        serialize(user);
    }

    @Override
    public void saveUserInfo() throws IOException {
        deserialize("/user.ser");
    }
}
