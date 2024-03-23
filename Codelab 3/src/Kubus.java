import java.util.Scanner;

public class Kubus extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double sisi;

    public Kubus(String name, double sisi) {
        super();
        this.sisi = sisi;
    }

    public Kubus() {
        super();
    }

    @Override
    public boolean inputNilai() {
        super.inputNilai();
        sisi = scanner.nextDouble();
        System.out.println("Input sisi: " +sisi);
        return false;
    }

    @Override
    public boolean luasPermukaan() {
        super.luasPermukaan();
        double hasil = 6 * sisi * sisi;
        System.out.println("Hasil luas permukaan: " + hasil);
        return false;
    }

    @Override
    public boolean volume() {
        super.volume();
        double hasil = Math.pow(sisi, 3);
        System.out.println("Hasil volume: " + hasil);
        return false;
    }
}