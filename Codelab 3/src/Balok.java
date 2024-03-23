import java.util.Scanner;

public class Balok extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double panjang;
    private double lebar;
    private double tinggi;

    public Balok(String name) {
        super();
    }

    public Balok() {
        super();
    }

    public void Balok(String name, double panjang, double lebar, double tinggi) {
        super(name);
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    @Override
    public void inputNilai() {
        super.inputNilai();
        System.out.println("Input panjang: ");
        panjang = scanner.nextDouble();
        System.out.println("Input lebar: ");
        lebar = scanner.nextDouble();
        System.out.println("Input tinggi: ");
        tinggi = scanner.nextDouble();
        return;
    }

    @Override
    public void luasPermukaan() {
        super.luasPermukaan();
        double hasil = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume() {
        super.volume();
        double hasil = panjang * lebar * tinggi;
        System.out.println("Hasil volume: " + hasil);
    }
}