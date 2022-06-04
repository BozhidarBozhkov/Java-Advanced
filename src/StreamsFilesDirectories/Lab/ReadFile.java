package StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "D:\\SoftUni\\Java-Advanced\\src\\StreamsFilesDirectiories\\input.txt";

        try  {
            FileInputStream fileStream = new FileInputStream(path);
            int oneByte = fileStream.read();
            while (oneByte != -1) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileStream.read();

            }

        } catch (IOException ignored) {
        }

    }

}
