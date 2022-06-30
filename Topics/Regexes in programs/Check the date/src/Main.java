import java.util.*;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        String dateRegex = "(0?[1-9]|[12][0-9]|3[01])[-/.](0?[1-9]|1[012])[-/.]((19|20)\\d\\d)";
        String dateR = "((19|20)\\d\\d)[-/.](0?[1-9]|1[012])[-/.](0?[1-9]|[12][0-9]|3[01])";
        if (date.matches(dateRegex) || date.matches(dateR)) {
            System.out.println("Yes");
        } else System.out.println("No");
    }
}