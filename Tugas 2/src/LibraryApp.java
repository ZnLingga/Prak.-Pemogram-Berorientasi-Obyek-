import java.util.Scanner;

class Student {
    public static String[] name = new String[10];
    public static String[] nim = new String[10];
    public static String[] faculty = new String[10];
    public static String[] programStudi = new String[10];
    private static String[] bukuTerpinjam = new String[10];

    public static void logout() {
        System.out.println("System logout...");
    }

    public void displayBook() {
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================================================================================================");
        System.out.println("|| No. || Id Buku\t\t\t || Nama Buku\t\t\t || Author\t\t || Category\t\t || Stock\t || ");
        for (int i = 0; i < 3; i++){
            System.out.printf("|| %d   || %s\t\t || %s\t\t\t || %s\t\t || %s\t\t || %d\t\t || \n", i, Main.idBuku[i], Main.namaBuku[i], Main.author[i], Main.category[i], Main.stock[i]);
        }
        System.out.println("=====================================================================================================");
        System.out.println("Input Id buku yang ingin dipinjam (input 99 untuk back)");
        System.out.print("Input: ");
        input = scanner.nextInt();

        if (input == 99) {
            System.out.println("Kembali ke menu awal...");
            Main.menuStudent();
        }
    }

    static void bukuTerpinjam(){
        System.out.println("Buku terpinjam: ");
        for (int i = 0; i < bukuTerpinjam.length; i++) {
            if (bukuTerpinjam[i] == null) {
                break;
            } else {
                System.out.printf("%d. %s", i+1, bukuTerpinjam[i]);
            }
        }
    }

    static void pinjamBuku(){
        Main main = new Main();
        Scanner scanString = new Scanner (System.in);
        System.out.print("Masukkan id buku yang ingin anda pinjam: ");
        String idBuku = scanString.nextLine();
        for (int i = 0; i < main.idBuku.length; i++) {
            if (idBuku.equals(main.idBuku[i])) {
                System.out.println("Buku id " + idBuku + " berhasil dipinjam");
                main.stock[i] -= 1;
                break;
            }
        }
        bukuTerpinjam();
    }
}

class Main {
    public static String[] idBuku = new String[] {"388c-e681-9152", "ed90-be30-5cdb", "d95e-0c4a-9523"};
    public static String[] namaBuku = new String[] {"title", "title", "title"};
    public static String[] author = new String[] {"author", "author", "author"};
    public static String[] category = new String[] {"Sejarah", "Sejarah", "Sejarah"};
    public static int[] stock = new int[] {4, 0, 2};
    private static  final int NIM_LENGTH = 15;

    static void Menu() {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("\n===== Library System");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    inputNim();
                    break;
                case 2:
                    Admin.checkAdmin();
                    break;
                case 3:
                    System.out.println("Thank you. Exiting program.");
                    isLoggedIn = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }

    public static void inputNim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your NIM (input 99 untuk back): ");
        String nim = scanner.nextLine();

        if (nim.equals("99")) {
            System.out.println("Kembali ke menu awal...");
            Menu();
            return;
        }

        checkNim();
    }

    public static void checkNim() {
        String nim = String.valueOf(15);
        if (nim.length() == NIM_LENGTH) {
            System.out.println("Successful Login as Student");
        } else {
            System.out.println("User Not Found");
        }

        menuStudent();
    }

    static int menuAdmin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Admin.addStudent();
                    break;
                case 2:
                    Admin.displayStudent();
                    break;
                case 3:
                    System.out.println("Logging out from admin account");
                    Menu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }

    public static void menuStudent() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Student Menu ====");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Student.bukuTerpinjam();
                    break;
                case 2:
                    Student.pinjamBuku();
                    break;
                case 3:
                    Student.logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }
}

class Admin {
    private static String adminUsername = "admin";
    private static String adminPassword = "12345";

    static void displayStudent(){
        System.out.println("List of Registered Students:");
        for (int i = 0; i < Student.name.length; i++) {
            if (Student.name[i] != null) {
                System.out.println("Name: " + Student.name[i]);
                System.out.println("Faculty: " + Student.faculty[i]);
                System.out.println("NIM: " + Student.nim[i]);
                System.out.println("Program: " + Student.programStudi[i]);
            }
        }
    }

    static int checkAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username (admin): ");
        String username = scanner.nextLine();
        System.out.print("Enter your password (admin): ");
        String password = scanner.nextLine();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return Main.menuAdmin();
        } else {
            System.out.println("Invalid credentials for admin.");
        }
        return 0;
    }

    static void addStudent(){
        Scanner scanString = new Scanner(System.in);
        System.out.print("Enter student name: ");
        for (int i = 0; i < Student.name.length; i++) {
            if (Student.name[i] == null) {
                Student.name[i] = scanString.nextLine();
                break;
            }
        }

        System.out.print("Enter student NIM: ");
        for (int i = 0; i < Student.nim.length; i++) {
            if (Student.nim[i] == null) {
                Student.nim[i] = scanString.nextLine();
                while (true) {
                    if (String.valueOf(Student.nim[i]).length() != 15) {
                        System.out.print("Nim Harus 15 Digit\n");
                        System.out.print("Enter student NIM: ");
                        Student.nim[i] = scanString.nextLine();
                    } else {
                        break;
                    }
                }
                break;
            }
        }

        System.out.print("Enter student faculty: ");
        for (int i = 0; i < Student.faculty.length; i++) {
            if (Student.faculty[i] == null) {
                Student.faculty[i] = scanString.nextLine();
                break;
            }
        }

        System.out.print("Enter student program: ");
        for (int i = 0; i < Student.programStudi.length; i++) {
            if (Student.programStudi[i] == null) {
                Student.programStudi[i] = scanString.nextLine();
                break;
            }
        }

        System.out.println("Student successfully registered.");
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Main main = new Main();
        main.Menu();
    }
}