import java.util.Locale;
import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        String str = scanner.nextLine();
        while (str != "\n") {
            if (str == (str.toUpperCase())) {
                System.out.println("FINISHED");
            } else System.out.println(str.toUpperCase());
            str = scanner.nextLine();
        }

    }
}