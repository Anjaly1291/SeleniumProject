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

public class Weight_calc {
	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void Planet() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String WeightOnOtherPlanet = ws.getRow(105).getCell(1).getStringCellValue();
			String Weight = ws.getRow(106).getCell(1).getStringCellValue();
			String Weight_Val = ws.getRow(106).getCell(2).getStringCellValue();
			String Planet = ws.getRow(107).getCell(1).getStringCellValue();
			String Planet_val = ws.getRow(107).getCell(2).getStringCellValue();
			String Submit = ws.getRow(108).getCell(1).getStringCellValue();

			driver.findElement(By.cssSelector(WeightOnOtherPlanet)).click();
			driver.findElement(By.xpath(Weight)).sendKeys(Weight_Val);

			WebElement Dp1 = driver.findElement(By.xpath(Planet));
			Select obj1 = new Select(Dp1);
			obj1.selectByVisibleText(Planet_val);

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
