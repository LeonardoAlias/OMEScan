package entities;

import net.glxn.qrgen.javase.QRCode;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import repositories.AppointmentsRepo;
import repositories.PatientsRepo;

public class QrGenerator {
    public void Generator(){
        PatientsRepo patientsRepo = PatientsRepo.getInstance();
        AppointmentsRepo appointmentsRepo = AppointmentsRepo.getInstance();
        try {
            appointmentsRepo.getValidAppointments().forEach(appointment -> {
                Set<OME> omeList = appointment.getOmeList();
                for (OME ome : omeList) {
                    Patient patient = patientsRepo.getPatientByOmeId(ome.getOmeId());
                    if (patient == null) {
                        System.out.println("Patient not found for OME: " + ome.getOmeId());
                        continue;
                    }
                    Path outputPath = Paths.get("/home/zhinon/Descargas/qrs/" + patient.affiliatenumToString() + ".png");
                    File qrCodeFile = QRCode.from(patient.affiliatenumToString()).file();
                    File outputFile = outputPath.toFile();

                    if (outputFile.exists()) {
                        outputFile.delete();
                    }

                    qrCodeFile.renameTo(outputFile);
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
