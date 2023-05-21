package storage;

import java.io.IOException;

public interface StorageProcessor {
    public void getUserInfo() throws IOException;
    public void saveUserInfo() throws IOException;
}
