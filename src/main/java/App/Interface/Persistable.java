package App.Interface;

import java.io.IOException;

public interface Persistable {
    void save(String filePath) throws IOException;
    void load(String filePath) throws IOException, ClassNotFoundException;
}
