import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String currentURL = "";
        while (!line.equals("Home")) {
            switch (line){
                case "back":
                    if (browserHistory.size() > 1){
                        forwardHistory.addFirst(currentURL);
                        System.out.println(currentURL = browserHistory.pop());
                    }
                    else {
                        System.out.println("no previous URLs");
                    }
                    break;
                case "forward":
                    if (forwardHistory.size() > 0) {
                        browserHistory.push(currentURL);
                        System.out.println(currentURL = forwardHistory.pop());
                    } else {
                        System.out.println("no next URLs");
                    }
                    break;
                default:
                    browserHistory.push(currentURL);
                    currentURL = line;
                    forwardHistory.clear();
                    System.out.println(currentURL);
                    break;

            }

            line = scanner.nextLine();
        }
    }

}
