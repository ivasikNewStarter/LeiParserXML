

public class LeiRecord {
    private String LEI;
    private String LegalName;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    private String City;

    public String getLEI() {
        return LEI;
    }

    public void setLEI(String LEI) {
        this.LEI = LEI;
    }

    public String getLegalName() {
        return LegalName;
    }

    public void setLegalName(String LegalName) {
        this.LegalName = LegalName;
    }


    @Override
    public String toString() {
        return "LeiRecord{" +
                "LEI='" + LEI + '\'' +
                ", LegalName='" + LegalName + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}

