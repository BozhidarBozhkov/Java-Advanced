package StreamsFilesDirectories.Lab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
       String path = "D:\\SoftUni\\Java-Advanced\\src\\StreamsFilesDirectories\\input.txt";
        FileOutputStream outputStream = new FileOutputStream("05.WriteEveryThirdLineOutput.txt");
        BufferedReader in = new BufferedReader(new FileReader(path));
        PrintWriter writer = new PrintWriter(new FileWriter(String.valueOf(outputStream)));

        int counter = 1;
        String line;
        while ((line = in.readLine()) != null) {
            if (counter % 3 == 0) writer.println(line);
            counter++;
        }
        writer.close();
    }

}
