public class BangunRuang {
    private String name;

    public BangunRuang() {
        this.name = name;
    }

    public boolean inputNilai() {
        System.out.println("Input nilai" +name);
        return false;
    }

    public boolean luasPermukaan() {
        System.out.println("Menghitung luas pemukaan bangun" + name);
        return false;
    }


    public boolean volume() {
        System.out.println("Menghitung volume bangun" + name);
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}