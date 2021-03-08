package island.service.impl;

import java.io.IOException;
import java.io.Serializable;

public interface FileManager {
    void writerIsland(int[][] area) throws IOException;
    void readerIsland() throws IOException;
}
