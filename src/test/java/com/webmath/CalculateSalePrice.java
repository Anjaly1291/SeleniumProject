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

public class CalculateSalePrice {
	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void dropdown() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();
			String SP = ws.getRow(17).getCell(1).getStringCellValue();
			String Cost = ws.getRow(18).getCell(1).getStringCellValue();
			String CostVal = ws.getRow(18).getCell(2).getStringCellValue();
			String Perc = ws.getRow(19).getCell(1).getStringCellValue();
			String PercVal = ws.getRow(19).getCell(2).getStringCellValue();
			String CalculateCost = ws.getRow(20).getCell(1).getStringCellValue();
			driver.findElement(By.cssSelector(SP)).click();
			driver.findElement(By.xpath(Cost)).sendKeys(CostVal);
			driver.findElement(By.xpath(Perc)).sendKeys(PercVal);

			driver.findElement(By.xpath(CalculateCost)).click();
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
