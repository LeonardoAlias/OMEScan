package entities;

public class Patient {
    private String name;
    private String lastname;
    private Long affiliatenum;

    public Patient(String name, String lastname, Long affiliatednum) {
        this.name = name;
        this.lastname = lastname;
        this.affiliatednum = affiliatednum;
    }

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
