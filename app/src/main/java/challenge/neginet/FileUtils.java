package challenge.neginet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileUtils {

    /**
     * Read a file in memory and run a consumer function for each line
     * @deprecated
     * This method is not intended to be used with large files
     * <p> Use {@link FileUtils#process(String, Consumer)} instead.
     */
    @Deprecated
    public static void processLegacy(String fileName, Consumer<String> consumer){
        try (Stream<String> fileStream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
            fileStream.forEach(consumer::accept);

        } catch (IOException | URISyntaxException e) {
            //File stream auto-closes
            e.printStackTrace();
        }
    }

    public static void process(String fileName, Consumer<String> consumer) {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(String.valueOf(Paths.get(ClassLoader.getSystemResource(fileName).toURI())));
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                consumer.accept(sc.nextLine());
            }

            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
    public static boolean isValid(String line) {
        return line.matches("^\\w[a-zA-Z]+,\\s[a-zA-Z]+.*");
    }
}
