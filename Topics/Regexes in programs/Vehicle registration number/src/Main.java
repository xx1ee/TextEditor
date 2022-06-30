import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number

        String loginRegex = "[0-9]";
        String loginRegex1 = "[ABEKMHOPCTYX]";
        int p = 0;
        if (regNum.length() == 6) {
            if (String.valueOf(regNum.charAt(0)).matches(loginRegex1)) {
                p++;
            }
            for (int i = 1 ; i <= 3 ; i++) {
                //System.out.println(String.valueOf(regNum.charAt(i)));
                if (String.valueOf(regNum.charAt(i)).matches(loginRegex)) {
                    p++;
                }
            }
            for (int i = 4 ; i < 6 ; i++) {
                //System.out.println(String.valueOf(regNum.charAt(i)));
                if (String.valueOf(regNum.charAt(i)).matches(loginRegex1)) {
                    p++;
                }
            }
        }
        if (p == 6) {
            System.out.println("true");
        } else System.out.println("false");
    }
}