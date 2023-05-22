package storage;

import java.io.IOException;

public interface StorageProcessor {
    public User getUserInfo() throws IOException;
    public void saveUserInfo() throws IOException;
}
