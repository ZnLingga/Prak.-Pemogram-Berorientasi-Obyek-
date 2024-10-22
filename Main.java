import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter a number : ");
            int number = scanner.nextInt();

            if (number == 1) {
                System.out.println("Sunday");
            } else if (number == 2) {
                System.out.println("Monday");
            } else if (number == 3) {
                System.out.println("Tuesday");
            } else if (number == 4) {
                System.out.println("Wednesday");
            } else if (number == 5) {
                System.out.println("Thursday");
            } else if (number == 6) {
                System.out.println("Friday");
            } else if (number == 7) {
                System.out.println("Saturday");
            } else {
                System.out.println("Enter the true number.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
        }

        System.out.println("Program berakhir.");
    }
}