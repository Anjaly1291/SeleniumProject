package com.webmath;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Electricity_Cost {
	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void Electricity() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String CostOfElectricity = ws.getRow(99).getCell(1).getStringCellValue();
			String Input = ws.getRow(100).getCell(1).getStringCellValue();
			String Input_val = ws.getRow(100).getCell(2).getStringCellValue();
			String Time = ws.getRow(101).getCell(1).getStringCellValue();
			String Time_Val = ws.getRow(101).getCell(2).getStringCellValue();
			String TimeUnit = ws.getRow(102).getCell(1).getStringCellValue();
			String TimeUnit_Val = ws.getRow(102).getCell(2).getStringCellValue();
			String Cost = ws.getRow(103).getCell(1).getStringCellValue();
			String Cost_Val = ws.getRow(103).getCell(2).getStringCellValue();
			String Submit = ws.getRow(104).getCell(1).getStringCellValue();

			driver.findElement(By.cssSelector(CostOfElectricity)).click();
			driver.findElement(By.xpath(Input)).sendKeys(Input_val);
			driver.findElement(By.xpath(Time)).sendKeys(Time_Val);

			WebElement Dp1 = driver.findElement(By.xpath(TimeUnit));
			Select obj1 = new Select(Dp1);
			obj1.selectByVisibleText(TimeUnit_Val);

			driver.findElement(By.xpath(Cost)).sendKeys(Cost_Val);
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
