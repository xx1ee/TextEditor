import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> list = new ArrayList<>(List.of(array));
        ListIterator<String> iter = list.listIterator();
        while (iter.hasNext()) {
            String current = iter.next();
            if (current.charAt(0) != 'J') {
                iter.remove();
            } else {
                iter.set(current.substring(1));
            }
        }
        while (iter.hasPrevious()) {
            System.out.println(iter.previous());
        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}