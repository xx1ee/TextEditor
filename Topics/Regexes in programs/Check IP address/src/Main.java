import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Regex = "^(([0-1]?[0-9]?[0-9]?|2[0-4][0-9]|25[0-5])\\.){3}([0-1]?[0-9]?[0-9]?|2[0-4][0-9]|25[0-5]){1}$";
        String str = scanner.nextLine();
        if (str.matches(Regex)) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}