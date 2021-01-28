package UserDefinedLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	public static File src;
	public static String exefilepath = "C:\\Users\\rajeswari\\eclipse-workspace\\NavigationCommands\\bin\\Datatables";
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String va11;
	public static int row;
	public static int cell;
	public static XSSFRow Row;
	public static String category1;
	public static String category2;
	public static String category3;
	public static String category4;

	// READING THE DATA FROM AN EXCEL FILE
	
	public static int readexcel() {
		try {
			src = new File(exefilepath);
			fileip = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileip);
			sheet = workbook.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				if (i == 1) {
					category1 = (sheet.getRow(i).getCell(0)).getStringCellValue();
					category2 = (sheet.getRow(i).getCell(1)).getStringCellValue();
					category3 = (sheet.getRow(i).getCell(2)).getStringCellValue();
					category4 = (sheet.getRow(i).getCell(3)).getStringCellValue();
					//System.out.println(category1);
					//System.out.println(category2);
					//System.out.println(category3);
					//System.out.println(category4);
					row = i;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return row;
	}

	// WRITING THE DATA TO AN EXCELFILE
	
	public static void writeexcel() {
		try {
			// CLOSE INPUT STREAM
			fileip.close();
			// CREATE AN OBJECT OF FILEOUTPUT STREAM AND TO WRITE DATA IN AN EXCEL FILE
			
			fileop = new FileOutputStream(new File(exefilepath));
			workbook.write(fileop);
			// CLOSE OUTPUT STREAM
			fileop.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}