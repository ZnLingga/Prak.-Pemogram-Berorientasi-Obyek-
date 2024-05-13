package com.main;

import books.*;
import data.Admin;
import data.Student;
import data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    // menyimpan semua object dalam satu array dengan teknik polymorphism
    public static Book daftarBuku[] = new Book[100]; // array satu dimensi untuk menyimpan buku
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int i = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarBuku[i++] = new StoryBook("SB32F", "Lima Sekawan", 17, "Story", "Enid Blyton");
        daftarBuku[i++] = new HistoryBook("HB324", "Sapiens", 2, "History", "Arthur Beiser");
        daftarBuku[i++] = new TextBook("TB323", "Pasutri", 4, "Text", "Eudora");

        // Mengisi daftar mahasiswa
        studentList.add(0, new Student("202310370311194", "Hamdan Hamidiy", "Teknik","Mesin"));
        studentList.add(1, new Student("202310370311195", "Zahratun Nida", "Teknik","Informatika"));
        studentList.add(2, new Student("202310370311196", "Tio Putra", "Teknik","Elektro"));

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student NIM: ");
                    String nimStudent = scanner.next();
                    scanner.nextLine();
                    while(true){
                        if (nimStudent.length() != 15 ) {
                            System.out.print("Nim Harus 15 Digit\n");
                            System.out.print("Enter student NIM: ");
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
                    System.out.println("Thank you. Exiting program");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
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
