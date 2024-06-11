package entities;

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

// Recorra todas las hojas de trabajo
        for (int worksheetIndex = 0; worksheetIndex < collection.getCount(); worksheetIndex++) {

            // Obtener hoja de trabajo usando su índice
            Worksheet worksheet = collection.get(worksheetIndex);

            // Imprimir el nombre de la hoja de trabajo
            System.out.print("Worksheet: " + worksheet.getName());

            // Obtener el número de filas y columnas
            int rows = worksheet.getCells().getMaxDataRow();
            int cols = worksheet.getCells().getMaxDataColumn();

            // Bucle a través de filas
            for (int i = 0; i < rows; i++) {

                // Recorra cada columna en la fila seleccionada
                for (int j = 0; j < cols; j++) {
                    // Valor de la celda de impresión
                    System.out.print(worksheet.getCells().get(i, j).getValue() + " | ");
                }
                // Salto de línea de impresión
                System.out.println(" ");
            }
        }

    }
}
