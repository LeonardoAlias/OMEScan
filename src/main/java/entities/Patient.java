package entities;
import java.util.HashSet;
import java.util.Set;

public class Patient {
    private String name;
    private Long affiliatenum;
    private Set<Long> omeList = new HashSet<>();

    public Patient(String name, Long affiliatednum, Long ome) {
        this.name = name;
        this.affiliatenum = affiliatednum;
        this.omeList.add(ome);
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

    public void addOme(Long ome) {
        this.omeList.add(ome);
    }

    public Set<Long> getOmeList() {
        return omeList;
    }

    public String affiliatenumToString() {
        String numberStr = Long.toString(this.affiliatenum);
        String mainPart = numberStr.substring(0, numberStr.length() - 2);
        String lastTwoDigits = numberStr.substring(numberStr.length() - 2);
        return mainPart + "-" + lastTwoDigits;
    }
}
