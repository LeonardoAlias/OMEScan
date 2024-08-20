package repositories;

import entities.Patient;

import java.util.ArrayList;

public class PatientsRepo {
    private static PatientsRepo instance = null;
    private ArrayList<Patient> patients;

    // Private constructor to prevent instantiation from other classes
    private PatientsRepo() {
        patients = new ArrayList<>();
    }

    // Public method to provide access to the single instance
    public static PatientsRepo getInstance() {
        if (instance == null) {
            synchronized (PatientsRepo.class) {
                if (instance == null) {
                    instance = new PatientsRepo();
                }
            }
        }
        return instance;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void addPatient(String name, Long affiliatenum, Long ome) {
        Patient pat = getPatientByAffiliatenum(affiliatenum);
        if (pat != null) {
            pat.addOme(ome);
            return;
        } else {
            pat = new Patient(name, affiliatenum, ome);
            patients.add(pat);
        }
    }

    public Patient getPatientByAffiliatenum(Long affiliatenum) {
        for (Patient pat : patients) {
            if (affiliatenum.equals(pat.getAffiliatenum())) {
                return pat;
            }
        }
        return null;
    }
}
