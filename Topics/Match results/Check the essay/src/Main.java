import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class FindTheKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("the\\s*key\\s*is\\s*([0-9bcdfghjklmnprstvwxyz]+[\\s]+|[aeiou?#!]+[\\s]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            var words = matcher.group().trim().split("\\s");
            var key = words[words.length - 1];
            System.out.println(key);
        }

    }
}