import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("password\\s*:?\\s*(\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        String[] words = null;
        while (matcher.find()) {
            words = matcher.group().trim().split("\\s");
            String key = words[words.length - 1];
            String p = key.toLowerCase();
            if (p.contains("password:")) {
                key = key.substring(9, key.length());
            }
            System.out.println(key);
        }
        if (words == null) {
            System.out.println("No passwords found.");
        }
    }
}