package com.FUESMEN.OMEScan;

import entities.QrGenerator;
import entities.XlsxReader;


public class OMEScanApp {
    public static void main(String[] args) throws Exception {
        XlsxReader xr = new XlsxReader();
        xr.ListadoCupReader("/home/zhinon/Descargas/bandeja_transmision (2).xls");
        xr.ListadoCajaReader("/home/zhinon/Descargas/Listado5371.xls");
        xr.ListadoTurnosReader("/home/zhinon/Descargas/Turno-1651.xls");
        QrGenerator qrg = new QrGenerator();
        qrg.Generator();
    }
}
