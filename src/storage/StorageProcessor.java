package storage;

import java.io.IOException;

public interface StorageProcessor {
    User getUserInfo() throws IOException;
    void saveUserInfo() throws IOException;
}
