package com.FUESMEN.OMEScan;

import entities.QrGenerator;
import entities.XlsxReader;
import repositories.PatientsRepo;


public class OMEScanApp {
    public static void main(String[] args) throws Exception {
        XlsxReader xr = new XlsxReader();
        xr.TurnosFileReader("/home/zhinon/Descargas/bandeja_transmision.xls");
        QrGenerator qrg = new QrGenerator();
        qrg.Generator();

        PatientsRepo patientsRepo = PatientsRepo.getInstance();
        patientsRepo.getPatients().forEach(patient -> {
            System.out.println("Nombre: " + patient.getName() + " - Afiliado: " + patient.affiliatenumToString());
        });
        System.out.println(patientsRepo.getPatientByAffiliatenum(15059137480900L));
    }
}
