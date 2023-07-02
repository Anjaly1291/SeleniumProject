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

public class compoundInterest_calc {

	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void Compound_Interest() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String CompoundInterest = ws.getRow(78).getCell(1).getStringCellValue();
			String Principal = ws.getRow(79).getCell(1).getStringCellValue();
			String Principal_val = ws.getRow(79).getCell(2).getStringCellValue();
			String RateofInterest = ws.getRow(80).getCell(1).getStringCellValue();
			String RateofInterest_Val = ws.getRow(80).getCell(2).getStringCellValue();
			String Compounded_Money = ws.getRow(81).getCell(1).getStringCellValue();
			String Compounded_Money_Val = ws.getRow(81).getCell(2).getStringCellValue();
			String DesiredTime = ws.getRow(82).getCell(1).getStringCellValue();
			String DesiredTime_Val = ws.getRow(82).getCell(2).getStringCellValue();

			String Submit = ws.getRow(83).getCell(1).getStringCellValue();

			driver.findElement(By.cssSelector(CompoundInterest)).click();
			driver.findElement(By.xpath(Principal)).sendKeys(Principal_val);
			driver.findElement(By.xpath(RateofInterest)).sendKeys(RateofInterest_Val);

			driver.findElement(By.xpath(Compounded_Money)).sendKeys(Compounded_Money_Val);

			driver.findElement(By.xpath(DesiredTime)).sendKeys(DesiredTime_Val);

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
