package entities;
import repositories.AppointmentsRepo;
import repositories.PatientsRepo;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public class XlsxReader {
    public void ListadoCupReader(String fileName) throws Exception {
        Workbook wb = null;
        try {
            wb = new Workbook(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Obtener todas las hojas de trabajo
        WorksheetCollection collection = wb.getWorksheets();

        // Obtener hoja de trabajo usando su índice
        Worksheet worksheet = collection.get(0);

        PatientsRepo patientsRepo = PatientsRepo.getInstance();

        int rows = worksheet.getCells().getMaxDataRow();
        for (int i = 1; i <= rows; i++) {
            // Casteamos el valor de la celda a un valor numérico
            String raw_aff_number = worksheet.getCells().get(i, 2).getValue().toString();
            long aff_number = (long) Double.parseDouble(raw_aff_number);

            String raw_ome = worksheet.getCells().get(i, 0).getValue().toString();
            long ome_number = (long) Double.parseDouble(raw_ome);

            patientsRepo.addPatient(worksheet.getCells().get(i, 3).getValue().toString(), aff_number, ome_number);
        }
        // patientsRepo.getPatients().forEach(System.out::println);
    }

    public void ListadoCajaReader(String fileName) throws Exception {
        Workbook wb = null;
        try {
            wb = new Workbook(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Obtener todas las hojas de trabajo
        WorksheetCollection collection = wb.getWorksheets();

        AppointmentsRepo appointmentRepo = AppointmentsRepo.getInstance();

        Worksheet worksheet = collection.get(0);
        int rows = worksheet.getCells().getMaxDataRow();

        // Bucle que recorre todas las filas
        for (int i = 1; i <= rows; i++) {
            // Casteamos el valor de la celda a un valor numérico
            String raw_app_number = worksheet.getCells().get(i, 3).getValue().toString();
            long app_number = (long) Double.parseDouble(raw_app_number);

            String raw_ome = worksheet.getCells().get(i, 8).getValue().toString();
            long ome_number;
            if (!raw_ome.isEmpty()) {
                try {
                    ome_number = (long) Double.parseDouble(raw_ome);
                } catch (NumberFormatException e) {
                    System.out.println("Error al parsear el número de OME: " + raw_ome);
                    continue;
                }
            } else {
                continue;
            }
            appointmentRepo.addAppointment(app_number, ome_number);
        }
        // appointmentRepo.getAppointments().forEach(System.out::println);

    }

    public void ListadoTurnosReader(String fileName) throws Exception {
        Workbook wb = null;
        try {
            wb = new Workbook(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        WorksheetCollection collection = wb.getWorksheets();

        AppointmentsRepo appointmentsRepo = AppointmentsRepo.getInstance();

        Worksheet worksheet = collection.get(0);

        int rows = worksheet.getCells().getMaxDataRow();

        for (int i = 1; i <= rows; i++) {
            // Casteamos el valor de la celda a un valor numérico
            String raw_app_number = worksheet.getCells().get(i, 0).getValue().toString();
            long app_number = (long) Double.parseDouble(raw_app_number);

            String service = worksheet.getCells().get(i, 11).getValue().toString();

            String status = worksheet.getCells().get(i, 17).getValue().toString();

            Appointment appObject = appointmentsRepo.getAppointmentById(app_number);
            if (appObject != null) {
                appObject.setService(service);
                appObject.setStatus(status);
            }
        }
        // appointmentsRepo.getAppointments().forEach(System.out::println);

    }

}
