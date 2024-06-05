package modul4.tugas.com.main;

import modul4.tugas.books.*;
import modul4.tugas.data.Admin;
import modul4.tugas.data.Student;
import modul4.tugas.data.User;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    // menyimpan semua object dalam satu array dengan teknik polymorphism
    //public static Book daftarBuku[] = new Book[100]; // array satu dimensi untuk menyimpan buku
    public static ArrayList <Book> daftarBuku = new ArrayList <>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int i = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarBuku.add(new StoryBook("AH11S", "Atomic Habits", 11, "Self-improvement", "James Clear"));
        daftarBuku.add(new HistoryBook("CT69G", "Crypto Tranding Guide", 9, "Text", "Akademi Crypto")) ;
        daftarBuku.add(new TextBook("DS36M", "Dongeng Si Kancing", 6, "Story", "Mulasih Tary")) ;

        // Mengisi daftar mahasiswa
        studentList.add(0, new Student("202310370311173", "Andika Candra Kurniawan", "Teknik","Industri"));
        studentList.add(1, new Student("202310370311153", "Faza Abdillah", "Teknik","Informatika"));
        studentList.add(2, new Student("202310370311196", "Tio Putra", "Teknik","Sipil"));

        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("===== Library System =====");
                System.out.println("1. Login sebagai Mahasiswa");
                System.out.println("2. Login sebagai Admin");
                System.out.println("3. Keluar");
                System.out.print("Pilih antara (1-3): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan NIM : ");
                        String nimStudent = scanner.next();
                        scanner.nextLine();
                        while(true){
                            if (nimStudent.length() != 15 ) {
                                System.out.print("Nim Harus 15 Digit!!!\n");
                                System.out.print("Masukkan NIM : ");
                                nimStudent = scanner.nextLine();

                            } else if (checkNim(nimStudent)){
                                Student student = new Student(nimStudent);
                                student.login();
                                break;
                            } else {
                                System.out.println("Nim tidak terdaftar!");
                                break;
                            }
                        }
                        break;
                    case 2:
                        Admin admin = new Admin();
                        admin.login();
                        break;
                    case 3:
                        System.out.println("Terima kasih semoga puas dengan pelayanan kami");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        } catch (Exception e){
            System.err.println(e);
        }

    }
    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
