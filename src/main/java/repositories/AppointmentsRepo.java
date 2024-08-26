package repositories;

import entities.Appointment;

import java.util.ArrayList;

public class AppointmentsRepo {
    private static AppointmentsRepo instance = null;
    private ArrayList<Appointment> appointments;

    // Private constructor to prevent instantiation from other classes
    private AppointmentsRepo() {
        appointments = new ArrayList<>();
    }

    // Public method to provide access to the single instance
    public static AppointmentsRepo getInstance() {
        if (instance == null) {
            synchronized (AppointmentsRepo.class) {
                if (instance == null) {
                    instance = new AppointmentsRepo();
                }
            }
        }
        return instance;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Long appointmentId, Long ome) {
        Appointment app = getAppointmentById(appointmentId);
        if (app != null) {
            app.addOme(ome);
            return;
        } else {
            app = new Appointment(appointmentId, ome);
            appointments.add(app);
        }
    }

    public Appointment getAppointmentById(Long appointmentId) {
        for (Appointment app : appointments) {
            if (appointmentId.equals(app.getAppointmentId())) {
                return app;
            }
        }
        return null;
    }

    public ArrayList<Appointment> getValidAppointments() {
        ArrayList<Appointment> validAppointments = new ArrayList<>();
        for (Appointment app : appointments) {
            if (app.isServiceValid() && app.isStatusValid()){
                validAppointments.add(app);
            }
        }
        return validAppointments;
    }

}
