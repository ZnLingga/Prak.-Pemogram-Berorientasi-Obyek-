import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String id;
    String title;
    String author;
    String category;
    int stock;

    public Book(String id, String title, String author, String category, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("| %10s | %15s | %10s | %10s | %5d |", id, title, author, category, stock);
    }
}

class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class Student extends User {
    private String nim;
    private String name;
    private String faculty;
    private String programStudy;

    public Student(String nim, String name, String faculty, String programStudy) {
        super(nim, ""); // NIM is used as username and no password needed
        this.nim = nim;
        this.name = name;
        this.faculty = faculty;
        this.programStudy = programStudy;
    }

    public boolean login(String nim) {
        return this.nim.equals(nim) && nim.length() == 15;
    }

    public void displayBooks(ArrayList<Book> bookList) {
        System.out.println("| No. |    Id buku   |    Nama Buku    |    Author    |  Category  | Stock |");
        System.out.println("|-----|--------------|-----------------|--------------|------------|-------|");
        int no = 1;
        for (Book book : bookList) {
            System.out.printf("| %3d | %s\n", no++, book);
        }
    }

    public void logout() {
        System.out.println("System logout...");
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nFaculty: %s\nNIM: %s\nProgram: %s", name, faculty, nim, programStudy);
    }
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void addStudent(ArrayList<Student> userStudent, Scanner scanner) {
        System.out.print("Masukkan nama mahasiswa: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("NIM Harus 15 Digit!!!");
            return;
        }
        System.out.print("Masukkan fakultas mahasiswa: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan jurusan mahasiswa: ");
        String programStudy = scanner.nextLine();
        userStudent.add(new Student(nim, name, faculty, programStudy));
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    public void displayStudents(ArrayList<Student> userStudent) {
        System.out.println("List of Registered Students:");
        for (Student student : userStudent) {
            System.out.println(student);
            System.out.println();
        }
    }
}

public class LibraryLoginSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<Student> userStudent = new ArrayList<>();
    private static Admin[] admins = {
            new Admin("admin", "admin123")
    };

    public static void main(String[] args) {
        bookList.add(new Book("3868-6B81-9152", "title1", "author1", "Sejarah", 4));
        bookList.add(new Book("e09b-0b4a-5cdb", "title2", "author2", "Sejarah", 0));
        bookList.add(new Book("d596-0c4a-9523", "title3", "author3", "Sejarah", 2));

        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    loginAsStudent();
                    break;
                case 2:
                    loginAsAdmin();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void loginAsStudent() {
        System.out.print("Enter your NIM (input 99 untuk back): ");
        String nim = scanner.nextLine();
        if (nim.equals("99")) {
            return;
        }
        boolean found = false;
        for (Student student : userStudent) {
            if (student.login(nim)) {
                found = true;
                studentMenu(student);
                break;
            }
        }
        if (!found) {
            System.out.println("User Not Found or NIM length is not 15");
        }
    }

    private static void loginAsAdmin() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        boolean found = false;
        for (Admin admin : admins) {
            if (admin.login(username, password)) {
                found = true;
                adminMenu(admin);
                break;
            }
        }
        if (!found) {
            System.out.println("Admin User Not Found!!");
        }
    }

    private static void studentMenu(Student student) {
        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam buku atau Logout");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    student.displayBooks(bookList);
                    break;
                case 2:
                    System.out.println("Functionality not implemented yet.");
                    break;
                case 3:
                    student.logout();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void adminMenu(Admin admin) {
        while (true) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    admin.addStudent(userStudent, scanner);
                    break;
                case 2:
                    admin.displayStudents(userStudent);
                    break;
                case 3:
                    System.out.println("Logging out from admin account.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
