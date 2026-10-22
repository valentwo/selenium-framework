package expression;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String excelPath = "/home/valente/Documents/FRAMEWORK/HEROKU_Login.xlsx";
		String sheetName = "TestPlan";
		String url = "";
		
		try (FileInputStream fis = new FileInputStream(new File(excelPath))) {
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			DataFormatter formatter = new DataFormatter();
//			int totalRows = sheet.getLastRowNum();
//			
//			for (int i = 0; i <= totalRows; i++) {
//				String testI
//			}
			
			Row row = sheet.getRow(2);
			Cell cell = row.getCell(1);
			url = formatter.formatCellValue(cell);
			
			System.out.println(url);
//			
		}catch(IOException e) {
			e.printStackTrace();
		}
		String driverpath = "/home/valente/webdrivers/geckodriver";
		System.setProperty("webdriver.gecko.driver", driverpath);
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		System.out.println("Title: " + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
		
	}

}
