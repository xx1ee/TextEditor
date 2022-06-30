import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.matches(".*[A-Z].*") && str.matches(".*[a-z].*") && str.matches(".*\\d.*") && str.length() >= 12) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}