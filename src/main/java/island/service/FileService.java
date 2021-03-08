package island.service;

import island.service.impl.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService implements FileManager {
    private static final String ISLAND_FILE_NAME = "island.txt";

    @Override
    public void writerIsland(int[][] island) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                sb.append(island[i][j] + " ");
            }
            sb.append("\n");
        }

        try {
            Files.write(Paths.get(ISLAND_FILE_NAME), sb.toString().getBytes());
        } catch (IOException ioException) {
            throw new IOException("파일을 생성할 수 없습니다.");
        }
    }

    @Override
    public void readerIsland() throws IOException {
        Path path = Paths.get(ISLAND_FILE_NAME);

        try {
            Files.readString(Paths.get(ISLAND_FILE_NAME));
            Stream<String> lines = Files.lines(path);

            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            System.out.println(content);
            lines.close();
        } catch (IOException ioException) {
            throw new IOException("파일을 읽어올 수 없습니다.");
        }
    }
}