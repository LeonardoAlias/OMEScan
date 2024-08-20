package com.FUESMEN.OMEScan;

import entities.QrGenerator;
import entities.XlsxReader;
import repositories.PatientsRepo;


public class OMEScanApp {
    public static void main(String[] args) throws Exception {
        XlsxReader xr = new XlsxReader();
        xr.ListadoCupReader("/home/zhinon/Descargas/bandeja_transmision.xls");
        // xr.ListadoCajaReader("/home/zhinon/Descargas/Listado2059.xls");
        // xr.ListadoTurnosReader("/home/zhinon/Descargas/Turno-2545.xls");
        QrGenerator qrg = new QrGenerator();
        qrg.Generator();

        PatientsRepo patientsRepo = PatientsRepo.getInstance();
        patientsRepo.getPatients().forEach(patient -> {
            System.out.println("Nombre: " + patient.getName() + " - Afiliado: " + patient.affiliatenumToString() + " - OMEs: " + patient.getOmeList());
        });
        System.out.println(patientsRepo.getPatientByAffiliatenum(15061318020400L).getOmeList());
    }
}
