import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern javaPattern = Pattern.compile("\\bprogram[a-z]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(text);
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
            System.out.println(matcher.group());
        }
    }
}