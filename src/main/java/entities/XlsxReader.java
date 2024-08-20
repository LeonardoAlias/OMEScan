package entities;
import repositories.PatientsRepo;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.Cells;
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

        PatientsRepo patientsRepo = PatientsRepo.getInstance();

        // Recorra todas las hojas de trabajo
        for (int worksheetIndex = 0; worksheetIndex < collection.getCount(); worksheetIndex++) {

            // Obtener hoja de trabajo usando su índice
            Worksheet worksheet = collection.get(worksheetIndex);

            // Imprimir el nombre de la hoja de trabajo
            System.out.print("Worksheet: " + worksheet.getName());

            // Obtener el número de filas
            int rows = worksheet.getCells().getMaxDataRow();

            // Bucle que recorre todas las filas
            for (int i = 1; i < rows; i++) {
                // Casteamos el valor de la celda a un valor numérico
                String raw_aff_number = worksheet.getCells().get(i, 2).getValue().toString();
                long aff_number = (long) Double.parseDouble(raw_aff_number);

                String raw_ome = worksheet.getCells().get(i, 0).getValue().toString();
                long ome_number = (long) Double.parseDouble(raw_ome);

                patientsRepo.addPatient(worksheet.getCells().get(i, 3).getValue().toString(), aff_number, ome_number);
                // Salto de línea de impresión
                System.out.println(" ");
            }
        }

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

        PatientsRepo patientsRepo = PatientsRepo.getInstance();

        // Recorra todas las hojas de trabajo
        for (int worksheetIndex = 0; worksheetIndex < collection.getCount(); worksheetIndex++) {

            // Obtener hoja de trabajo usando su índice
            Worksheet worksheet = collection.get(worksheetIndex);

            // Imprimir el nombre de la hoja de trabajo
            System.out.print("Worksheet: " + worksheet.getName());

            // Obtener el número de filas
            int rows = worksheet.getCells().getMaxDataRow();

            // Bucle que recorre todas las filas
            for (int i = 1; i < rows; i++) {
                // Casteamos el valor de la celda a un valor numérico
                String raw_aff_number = worksheet.getCells().get(i, 2).getValue().toString();
                long aff_number = (long) Double.parseDouble(raw_aff_number);

                String raw_ome = worksheet.getCells().get(i, 0).getValue().toString();
                long ome_number = (long) Double.parseDouble(raw_ome);

                patientsRepo.addPatient(worksheet.getCells().get(i, 3).getValue().toString(), aff_number, ome_number);

                // Salto de línea de impresión
                System.out.println(" ");
            }
        }
    }

    public void ListadoTurnosReader(String fileName) throws Exception {
        Workbook wb = null;
        try {
            wb = new Workbook(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Obtener todas las hojas de trabajo
        WorksheetCollection collection = wb.getWorksheets();

        PatientsRepo patientsRepo = PatientsRepo.getInstance();

        // Recorra todas las hojas de trabajo
        for (int worksheetIndex = 0; worksheetIndex < collection.getCount(); worksheetIndex++) {

            // Obtener hoja de trabajo usando su índice
            Worksheet worksheet = collection.get(worksheetIndex);

            // Imprimir el nombre de la hoja de trabajo
            System.out.print("Worksheet: " + worksheet.getName());

            // Obtener el número de filas
            int rows = worksheet.getCells().getMaxDataRow();

            // Bucle que recorre todas las filas
            for (int i = 1; i < rows; i++) {
                // Casteamos el valor de la celda a un valor numérico
                String raw_aff_number = worksheet.getCells().get(i, 2).getValue().toString();
                long aff_number = (long) Double.parseDouble(raw_aff_number);

                String raw_ome = worksheet.getCells().get(i, 0).getValue().toString();
                long ome_number = (long) Double.parseDouble(raw_ome);

                patientsRepo.addPatient(worksheet.getCells().get(i, 3).getValue().toString(), aff_number, ome_number);

                // Salto de línea de impresión
                System.out.println(" ");
            }
        }
    }

}
