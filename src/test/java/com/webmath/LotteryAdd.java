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

public class LotteryAdd {

	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void Lottery() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String LotteryOdd = ws.getRow(31).getCell(1).getStringCellValue();
			String CorrectNo = ws.getRow(32).getCell(1).getStringCellValue();
			String CorrectNoval = ws.getRow(32).getCell(2).getStringCellValue();
			String LowestNo = ws.getRow(33).getCell(1).getStringCellValue();
			String LowestNoVal = ws.getRow(33).getCell(2).getStringCellValue();
			String HighestNo = ws.getRow(34).getCell(1).getStringCellValue();
			String HighestNoVal = ws.getRow(34).getCell(2).getStringCellValue();

			String Odds = ws.getRow(35).getCell(1).getStringCellValue();

			driver.findElement(By.xpath(LotteryOdd)).click();
			driver.findElement(By.xpath(CorrectNo)).sendKeys(CorrectNoval);
			driver.findElement(By.xpath(LowestNo)).sendKeys(LowestNoVal);
			driver.findElement(By.xpath(HighestNo)).sendKeys(HighestNoVal);

			driver.findElement(By.xpath(Odds)).click();
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
