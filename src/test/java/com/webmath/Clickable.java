package com.webmath;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// Test caseS=TC003,TC004,TC005

public class Clickable {

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
			Set<String> window = driver.getWindowHandles();
			ArrayList<String> al = new ArrayList<String>(window);
			System.out.println(al);
			driver.switchTo().window(al.get(0));
			String WindChill = ws.getRow(21).getCell(1).getStringCellValue();
			String CountCoins = ws.getRow(25).getCell(1).getStringCellValue();
			String LotteryOdds = ws.getRow(31).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(WindChill)).click();
			Thread.sleep(2000);
			driver.navigate().back();
			driver.findElement(By.xpath(CountCoins)).click();
			Thread.sleep(2000);
			driver.navigate().back();
			driver.findElement(By.xpath(LotteryOdds)).click();
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
