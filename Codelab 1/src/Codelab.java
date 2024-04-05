import java.time.LocalDate;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Period;

public class Codelab{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nama : ");
        String nama = sc.next();

        Scanner input = new Scanner(System.in);
        System.out.print("Jenis Kelamin (L/P) : ");
        char jenisKelamin = input.next().charAt(0);

        System.out.print("Tanggal Lahir (yyyy-mm-dd) : ");
        String tanggalLahir = input.next();
        LocalDate tanggal = LocalDate.parse(tanggalLahir);
        LocalDate sekarang = LocalDate.now();
        Period umur = Period.between(tanggal, sekarang);

        System.out.println("\n");
        System.out.println("Nama : " +nama);
        switch (jenisKelamin) {
            case 'L' :
                System.out.println("Jenis Kelamin : laki - laki");
                break;
            case 'P' :
                System.out.println("Jenis Kelamin : perempuan");
                break;
            default :
                System.out.println("Masukan data dengan benar");
                break;
        }
        System.out.println("Umur Anda : " +umur.getYears() + " tahun" + " " +umur.getMonths() + " bulan");
    }
}
