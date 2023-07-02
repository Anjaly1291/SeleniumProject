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

public class Speed_Conversion {
	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void kmph_milesperhr() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String Speed = ws.getRow(56).getCell(1).getStringCellValue();

			String par1 = ws.getRow(57).getCell(1).getStringCellValue();
			String par1Val = ws.getRow(57).getCell(2).getStringCellValue();
			String dropdown1 = ws.getRow(58).getCell(1).getStringCellValue();
			String dropdown1Val = ws.getRow(58).getCell(2).getStringCellValue();
			String dropdown2 = ws.getRow(59).getCell(1).getStringCellValue();
			String dropdown2Val = ws.getRow(59).getCell(2).getStringCellValue();
			String Convert = ws.getRow(60).getCell(1).getStringCellValue();

			driver.findElement(By.cssSelector(Speed)).click();

			driver.findElement(By.xpath(par1)).sendKeys(par1Val);

			WebElement Dp1 = driver.findElement(By.xpath(dropdown1));
			Select obj1 = new Select(Dp1);
			obj1.selectByVisibleText(dropdown1Val);

			WebElement Dp2 = driver.findElement(By.xpath(dropdown2));
			Select obj2 = new Select(Dp2);
			obj2.selectByVisibleText(dropdown2Val);

			Thread.sleep(2000);
			driver.findElement(By.xpath(Convert)).click();
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
