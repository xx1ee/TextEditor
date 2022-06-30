import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        Pattern javaPattern = Pattern.compile("\\b"+ part + "|"+ part + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher javaMatcher = javaPattern.matcher(line);
        if (javaMatcher.find()) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}