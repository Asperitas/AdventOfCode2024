package twentytwentyfour.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputReader {
    public static void read(String filename, LineHandler lineHandler) {
        InputStream inputStream = InputReader.class.getClassLoader().getResourceAsStream(filename);

        try (
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lineHandler.handleLine(line);
            }

        } catch (IOException e) {
            throw new FileReadError("Error reading file '%s'".formatted(filename));
        }
    }

    public static class FileReadError extends RuntimeException {
        public FileReadError(String message) {
            super(message);
        }
    }
}
