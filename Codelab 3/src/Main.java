import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Tabung tabung = new Tabung();
        Kubus kubus = new Kubus();
        Balok balok = new Balok();

        tabung.setName("tabung");
        kubus.setName("kubus");
        balok.setName("balok");

        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();

        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}