package innotech.com.sv.reportesXls;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import innotech.com.sv.modelos.Promocion;

 
public class PromocionExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Promocion> listUsers;
     
    public PromocionExcelExporter(List<Promocion> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Promociones");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "ID", style);      
        createCell(row, 1, "NOMBRE EMPRESA", style);       
        createCell(row, 2, "DESCRIPCION", style);    
        createCell(row, 3, "FECHA INICIO", style);
        createCell(row, 4, "FECHA FIN", style);
        createCell(row, 5, "DESCUENTO", style);
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
       for (Promocion user : listUsers) {
             Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, String.valueOf(user.getId()), style);
            createCell(row, columnCount++, user.getEmpresa().getNombre(), style);
            createCell(row, columnCount++, user.getDescripcion(), style);
            createCell(row, columnCount++, String.valueOf(user.getFechainicio()), style);
            createCell(row, columnCount++, String.valueOf(user.getFechafin()), style);
            createCell(row, columnCount++, user.getPorcdescuento(), style);
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        
    	//System.out.println("Dentro de empresaExcelController");
    	
    	writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}