package entities;

import java.util.Objects;

public class OME {
    private Long omeId;
    private Patient patient;
    private Appointment appointment;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public OME(Long omeId, Patient patient, Appointment appointment) {
        this.omeId = omeId;
        this.patient = patient;
        this.appointment = appointment;
    }

    public OME(Long omeId, Patient patient) {
        this.omeId = omeId;
        this.patient = patient;
    }

    public OME(Long omeId, Appointment appointment) {
        this.omeId = omeId;
        this.appointment = appointment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OME ome_ob = (OME) o;
        return omeId.equals(ome_ob.omeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(omeId);
    }

    public Long getOmeId() {
        return omeId;
    }

    @Override
    public String toString() {
        return String.valueOf(omeId);
    }
}
