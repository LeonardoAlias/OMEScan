package com.FUESMEN.OMEScan;

import entities.QrGenerator;
import entities.XlsxReader;


public class OMEScanApp {
    public static void main(String[] args) throws Exception {
        XlsxReader xr = new XlsxReader();
        xr.TurnosFileReader("C:\\Users\\leoal\\Downloads\\bandeja_transmision.xls");
        QrGenerator qrg = new QrGenerator();
        qrg.Generator();



    }
}