package StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "D:\\SoftUni\\Java-Advanced\\src\\StreamsFilesDirectories\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("03.CopyBytesOutput.txt");

            int read = inputStream.read();
            PrintWriter writer = new PrintWriter(outputStream);
            while (read != -1) {
                if (read == ' ') {
                    writer.print(' ');
                } else if (read == 10) {
                    writer.println();
                } else {
                    writer.print(read);
                }
                read = inputStream.read();
            }
            writer.close();
        } catch (IOException ignored){}
    }

}
