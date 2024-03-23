import java.util.Scanner;

public class Tabung extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double tinggi;
    private double jari_jari;

    public Tabung(String name, double tinggi, double jari_jari) {
        super();
        this.tinggi = tinggi;
        this.jari_jari = jari_jari;
    }

    public Tabung() {
        super();
    }

    @Override
    public boolean inputNilai() {
        super.luasPermukaan();
        System.out.println("Input tinggi: ");
        tinggi = scanner.nextDouble();
        System.out.println("Input jari-jari: ");
        jari_jari = scanner.nextDouble();
        return false;
    }

    @Override
    public boolean luasPermukaan() {
        super.luasPermukaan();
        double hasil = 2 * Math.PI * jari_jari * (jari_jari + tinggi);
        System.out.println("Hasil luas permukaan: " + hasil);
        return false;
    }

    @Override
    public boolean volume() {
        super.volume();
        double hasil = Math.PI * Math.pow(jari_jari, 2) * tinggi;
        System.out.println("Hasil volume: " + hasil);
        return false;
    }
}