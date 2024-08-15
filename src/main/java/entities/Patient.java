package entities;

public class Patient {
    private String name;
    private Long affiliatenum;

    public Patient(String name, Long affiliatednum) {
        this.name = name;
        this.affiliatenum = affiliatednum;
    }

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAffiliatenum() {
        return affiliatenum;
    }

    public void setAffiliatenum(Long affiliatednum) {
        this.affiliatenum = affiliatednum;
    }

    public String affiliatenumToString() {
        String numberStr = Long.toString(this.affiliatenum);
        String mainPart = numberStr.substring(0, numberStr.length() - 2);
        String lastTwoDigits = numberStr.substring(numberStr.length() - 2);
        return mainPart + "-" + lastTwoDigits;
    }
}
