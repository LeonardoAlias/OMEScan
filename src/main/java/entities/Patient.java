package entities;
import java.util.HashSet;
import java.util.Set;

public class Patient {
    private String name;
    private Long affiliatenum;
    private Set<OME> omeList = new HashSet<>();

    public Patient(String name, Long affiliatednum, Long ome) {
        this.name = name;
        this.affiliatenum = affiliatednum;
        this.omeList.add(new OME(ome, this));
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
        this.omeList.add(new OME(ome, this));
    }

    public Set<OME> getOmeList() {
        return omeList;
    }

    public String getOmeListToString() {
        StringBuilder omeListString = new StringBuilder();
        for (OME ome : this.omeList) {
            omeListString.append(ome.getOmeId()).append(", ");
        }
        return omeListString.toString();
    }

    public String affiliatenumToString() {
        String numberStr = Long.toString(this.affiliatenum);
        String mainPart = numberStr.substring(0, numberStr.length() - 2);
        String lastTwoDigits = numberStr.substring(numberStr.length() - 2);
        return mainPart + "-" + lastTwoDigits;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", affiliatenum=" + affiliatenum +
                ", omeList=" + omeList +
                '}';
    }
}
