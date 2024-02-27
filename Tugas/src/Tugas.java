import java.util.Scanner;

public class Tugas {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "adm";
    private static final int NIM_LENGTH = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("\n===== Library System");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    loginAsStudent(scanner);
                    break;
                case 2:
                    loginAsAdmin(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    isLoggedIn = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }

        scanner.close();
    }

    private static void loginAsStudent(Scanner scanner) {
        System.out.print("Enter your NIM: ");
        String nim = scanner.nextLine();

        if (nim.length() == NIM_LENGTH) {
            System.out.println("Successful Login as Student");
        } else {
            System.out.println("User Not Found");
        }
    }

    private static void loginAsAdmin(Scanner scanner) {
        System.out.print("Enter your username (admin): ");
        String username = scanner.nextLine();
        System.out.print("Enter your password (admin): ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Successful Login as Admin");
        } else {
            System.out.println("Admin User Not Found");
        }
    }
}