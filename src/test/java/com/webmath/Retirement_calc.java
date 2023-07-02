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

public class Retirement_calc {

	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void Retirement() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String Retirement = ws.getRow(84).getCell(1).getStringCellValue();
			String Salary = ws.getRow(85).getCell(1).getStringCellValue();
			String Salary_val = ws.getRow(85).getCell(2).getStringCellValue();
			String StartAMount = ws.getRow(86).getCell(1).getStringCellValue();
			String StartAmount_Val = ws.getRow(86).getCell(2).getStringCellValue();
			String Contribution = ws.getRow(87).getCell(1).getStringCellValue();
			String Contribution_Val = ws.getRow(87).getCell(2).getStringCellValue();
			String SalaryRaise = ws.getRow(88).getCell(1).getStringCellValue();
			String SalaryRaise_Val = ws.getRow(88).getCell(2).getStringCellValue();
			String Return = ws.getRow(89).getCell(1).getStringCellValue();
			String Return_Val = ws.getRow(89).getCell(2).getStringCellValue();
			String RetireAge = ws.getRow(90).getCell(1).getStringCellValue();
			String RetireAge_Val = ws.getRow(90).getCell(2).getStringCellValue();

			String Submit = ws.getRow(91).getCell(1).getStringCellValue();

			driver.findElement(By.cssSelector(Retirement)).click();
			driver.findElement(By.xpath(Salary)).sendKeys(Salary_val);
			driver.findElement(By.xpath(StartAMount)).sendKeys(StartAmount_Val);
			driver.findElement(By.xpath(Contribution)).sendKeys(Contribution_Val);
			driver.findElement(By.xpath(SalaryRaise)).sendKeys(SalaryRaise_Val);
			driver.findElement(By.xpath(Return)).sendKeys(Return_Val);
			driver.findElement(By.xpath(RetireAge)).sendKeys(RetireAge_Val);
			Thread.sleep(3000);
			driver.findElement(By.xpath(Submit)).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
