package id.ac.poliban.e020320049.listindemo.model;

public class Flag {
    private int flag;
    private String countryName;

    public Flag(int flag, String countryName) {
        this.flag = flag;
        this.countryName = countryName;
    }

    public int getFlag() {
        return flag;
    }

    public String getCountryName() {
        return countryName;
    }
}
