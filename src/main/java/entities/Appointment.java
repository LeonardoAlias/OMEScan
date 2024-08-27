package entities;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Appointment {
    private String service;
    private String status;
    private Long appointmentId;
    private Set<OME> omeList = new HashSet<>();

    public Appointment(Long appointmentId, Long ome) {
        this.appointmentId = appointmentId;
        this.omeList.add(new OME(ome, this));
    }

    public void addOme(Long ome) {
        this.omeList.add(new OME(ome, this));
    }

    public Set<OME> getOmeList() {
        return omeList;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setService(String service) {
        this.service = service.trim();
    }

    public String getService() {
        return service;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Boolean isServiceValid() {
        List<String> validServices = Arrays.asList("RESONANCIA MAGNÉTICA", "RAYOS X", "TOMOGRAFÍA", "DENSITOMETRÍA", "ECOGRAFÍA");
        return validServices.contains(this.service);
    }

    public Boolean isStatusValid() {
        return this.status.equals("REA");
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "service='" + service + '\'' +
                ", status='" + status + '\'' +
                ", appointmentId=" + appointmentId +
                ", omeList=" + omeList +
                '}';
    }
}
