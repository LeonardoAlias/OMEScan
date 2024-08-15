package entities;
import repositories.PatientsRepo;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.Cells;
import com.aspose.cells.WorksheetCollection;

public class XlsxReader {
    public void TurnosFileReader(String fileName) throws Exception {

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

            // Obtener el número de filas y columnas
            int rows = worksheet.getCells().getMaxDataRow();
            int cols = worksheet.getCells().getMaxDataColumn();

            // Bucle que recorre todas las filas
            for (int i = 1; i < rows; i++) {

                String value = worksheet.getCells().get(i, 2).getValue().toString();
                long parsedValue = (long) Double.parseDouble(value);
                patientsRepo.addPatient(worksheet.getCells().get(i, 3).getValue().toString(), parsedValue);

                // Salto de línea de impresión
                System.out.println(" ");
            }
        }

    }
}
