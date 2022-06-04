package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "D:\\SoftUni\\Java-Advanced\\src\\StreamsFilesDirectories\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("02.WriteToFileOutput.txt");

            Set<Character> punctuation = Set.of(',', '.', '!', '?');
            int read = inputStream.read();
            while (read != -1) {

                if (!punctuation.contains((char) read)) {
                    outputStream.write(read);
                }
                read = inputStream.read();
            }

        } catch (IOException ignored) {

        }
    }


}
