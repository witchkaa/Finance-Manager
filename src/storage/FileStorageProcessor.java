package storage;

import userinterface.UserInterface;
import java.io.*;
import java.util.HashMap;

public class FileStorageProcessor implements StorageProcessor{
    User user;
    UserInterface userInterface;
    private static final String PATH  = "C:\\Users\\User\\IdeaProjects\\Finance-Manager\\src\\storage\\user.ser";
    public FileStorageProcessor(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void serialize(User user) {
        try (FileOutputStream outputStream = new FileOutputStream(PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new StorageRuntimeException("Something went wrong!");
        }
    }
    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }
    public User deserialize(String path) {
        File file = new File(path);
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
    public User createNewUser() {
        user = new User();
        userInterface.showInfo("Seems like you're new to our app! Let's create a user!\n" +
                "Please enter your name: ");
        String name = (String)userInterface.askInfo("string");
        user.setName(name);
        userInterface.showInfo("Nice to meet you, " + name + "! Now enter your start budget: ");
        Integer budgetInt = (Integer)userInterface.askInfo("int");
        IntHolder budget = new IntHolder(budgetInt);
        user.setBudget(budget);
        user.setExpends(new HashMap<>());
        user.setIncomes(new HashMap<>());
        return user;
    }

    @Override
    public User getUserInfo(){
        User user = deserialize(PATH);
        return user;
    }

    @Override
    public void saveUserInfo(){
        serialize(user);
    }
}
