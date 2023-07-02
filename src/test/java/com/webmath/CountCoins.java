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

public class CountCoins {

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

			String CountCoin = ws.getRow(25).getCell(1).getStringCellValue();
			String Quarter = ws.getRow(26).getCell(1).getStringCellValue();
			String Quarterval = ws.getRow(26).getCell(2).getStringCellValue();
			String Dimes = ws.getRow(27).getCell(1).getStringCellValue();
			String DimesVal = ws.getRow(27).getCell(2).getStringCellValue();
			String Nickel = ws.getRow(28).getCell(1).getStringCellValue();
			String NickelVal = ws.getRow(28).getCell(2).getStringCellValue();
			String Pennies = ws.getRow(29).getCell(1).getStringCellValue();
			String PenniesVal = ws.getRow(29).getCell(2).getStringCellValue();

			String Count = ws.getRow(30).getCell(1).getStringCellValue();

			driver.findElement(By.xpath(CountCoin)).click();
			driver.findElement(By.xpath(Quarter)).sendKeys(Quarterval);
			driver.findElement(By.xpath(Dimes)).sendKeys(DimesVal);
			driver.findElement(By.xpath(Nickel)).sendKeys(NickelVal);
			driver.findElement(By.xpath(Pennies)).sendKeys(PenniesVal);

			driver.findElement(By.xpath(Count)).click();
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
