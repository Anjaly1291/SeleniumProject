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

public class Loan_calc {

	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void loan() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String loan = ws.getRow(92).getCell(1).getStringCellValue();
			String LoanAmount = ws.getRow(93).getCell(1).getStringCellValue();
			String LoanAmount_val = ws.getRow(93).getCell(2).getStringCellValue();
			String Duration = ws.getRow(94).getCell(1).getStringCellValue();
			String Duration_Val = ws.getRow(94).getCell(2).getStringCellValue();
			String Period = ws.getRow(95).getCell(1).getStringCellValue();
			String Period_Val = ws.getRow(95).getCell(2).getStringCellValue();
			String Interest = ws.getRow(96).getCell(1).getStringCellValue();
			String Interest_Val = ws.getRow(96).getCell(2).getStringCellValue();
			String ExtraAmount = ws.getRow(97).getCell(1).getStringCellValue();
			String ExtraAmount_Val = ws.getRow(97).getCell(2).getStringCellValue();

			String Submit = ws.getRow(98).getCell(1).getStringCellValue();

			driver.findElement(By.cssSelector(loan)).click();
			driver.findElement(By.xpath(LoanAmount)).sendKeys(LoanAmount_val);
			driver.findElement(By.xpath(Duration)).sendKeys(Duration_Val);
			driver.findElement(By.xpath(Period)).sendKeys(Period_Val);
			driver.findElement(By.xpath(Interest)).sendKeys(Interest_Val);
			driver.findElement(By.xpath(ExtraAmount)).sendKeys(ExtraAmount_Val);

			Thread.sleep(2000);
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
