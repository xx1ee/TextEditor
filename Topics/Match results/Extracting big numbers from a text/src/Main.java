import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        Pattern javaPattern = Pattern.compile("\\d{10,}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(stringWithNumbers);
        int c = 0;
        String ch = "";
        while (matcher.find()) {
            ch = matcher.group();
            c = matcher.end() - matcher.start();
            System.out.println(ch + ":" + c);
        }
    }
}