package com.FUESMEN.OMEScan;

import entities.QrGenerator;
import entities.XlsxReader;


public class OMEScanApp {
    public static void main(String[] args) throws Exception {
        XlsxReader xr = new XlsxReader();
        xr.ListadoCupReader("/home/zhinon/Descargas/bandeja_transmision_1.xlsx");
        xr.ListadoCajaReader("/home/zhinon/Descargas/Listado1.xlsx");
        xr.ListadoTurnosReader("/home/zhinon/Descargas/Turno1.xlsx");

    }
}
