package controllers;
import entities.OME;
import entities.Patient;
import repositories.AppointmentsRepo;
import repositories.PatientsRepo;
import java.util.Set;
import java.util.ArrayList;

public class PatientFilterController {

    public ArrayList<Patient> filterPatients() {
        PatientsRepo patientsRepo = PatientsRepo.getInstance();
        AppointmentsRepo appointmentsRepo = AppointmentsRepo.getInstance();
        ArrayList<Patient> curated_patients = new ArrayList<>();
        try {
            appointmentsRepo.getValidAppointments().forEach(appointment -> {
                Set<OME> omeList = appointment.getOmeList();
                for (OME ome : omeList) {
                    Patient patient = patientsRepo.getPatientByOmeId(ome.getOmeId());
                    if (patient == null) {
                        System.out.println("Patient not found for OME: " + ome.getOmeId());
                        continue;
                    }
                    curated_patients.add(patient);
                }
            });
            return curated_patients;
        } catch (Exception e) {
            e.printStackTrace();
            return curated_patients;
        }
    }


}
