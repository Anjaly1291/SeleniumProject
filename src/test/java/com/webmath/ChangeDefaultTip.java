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

public class ChangeDefaultTip {
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

			String tip = ws.getRow(13).getCell(1).getStringCellValue();

			String par1 = ws.getRow(14).getCell(1).getStringCellValue();
			String par1Val = ws.getRow(14).getCell(2).getStringCellValue();
			String par2 = ws.getRow(15).getCell(1).getStringCellValue();
			String par2Val = ws.getRow(15).getCell(2).getStringCellValue();
			String Submit = ws.getRow(16).getCell(1).getStringCellValue();

			driver.findElement(By.xpath(tip)).click();

			driver.findElement(By.xpath(par1)).clear();
			driver.findElement(By.xpath(par1)).sendKeys(par1Val);

			driver.findElement(By.xpath(par2)).sendKeys(par2Val);

			Thread.sleep(2000);
			driver.findElement(By.xpath(Submit)).click();
			Thread.sleep(2000);

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
