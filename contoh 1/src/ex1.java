//memanggil class bawaan java
import java.util.Scanner;

public class ex1
{
    public static void main(String[] args)
    {

        //objek dari class scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukan nama jurusan di UMM : ");
        //panggil method next
        String jurusan = sc.next();
        System.out.println("Nama Jurusan : "+jurusan);

        //deklarasi variable
        int population = 100000;
        String nama ="Informatika";
        char kar = 'a';

        //output
        System.out.println("populasinya : "+population);
        System.out.println("jurusan : "+nama+ "\n"+"karakter : "+kar);
        System.out.println();
    }
}
