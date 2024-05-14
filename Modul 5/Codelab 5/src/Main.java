import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> mahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int i = 1;

        while (true) {
            System.out.print("Masukkan nama ke-" + i + ": ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("selesai")) {
                break;
            }

            try {
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong!");
                }
                mahasiswa.add(input);
                i++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nDaftar mahasiswa yang diinputkan:");
        for (String nama : mahasiswa) {
            System.out.println(" - " + nama);
        }
    }
}
