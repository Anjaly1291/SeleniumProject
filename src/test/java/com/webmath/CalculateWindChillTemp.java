package com.webmath;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculateWindChillTemp {
	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void WindchillTemp() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String WT = ws.getRow(21).getCell(1).getStringCellValue();
			String Faren = ws.getRow(22).getCell(1).getStringCellValue();
			String Farenval = ws.getRow(22).getCell(2).getStringCellValue();
			String Speed = ws.getRow(23).getCell(1).getStringCellValue();
			String SpeedVal = ws.getRow(23).getCell(2).getStringCellValue();
			String Submit = ws.getRow(24).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(WT)).click();
			driver.findElement(By.xpath(Faren)).sendKeys(Farenval);
			driver.findElement(By.xpath(Speed)).sendKeys(SpeedVal);

			driver.findElement(By.xpath(Submit)).click();
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void close()

	{
		driver.quit();
	}
}
