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

public class SimpleInterestCalc {

	public WebDriver driver;

	@BeforeMethod

	public void initialize_driver() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
	}

	@Test
	public void SimpleInterest() {
		try {
			driver.get("https://www.webmath.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			FileInputStream f = new FileInputStream("C:\\Users\\Shiva\\Desktop\\WebMathLocators.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFSheet ws = wb.getSheetAt(0);
			String MathforEveryone = ws.getRow(3).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(MathforEveryone)).click();

			String SimpleInterest = ws.getRow(71).getCell(1).getStringCellValue();
			String Principal = ws.getRow(72).getCell(1).getStringCellValue();
			String Principal_val = ws.getRow(72).getCell(2).getStringCellValue();
			String Interest = ws.getRow(73).getCell(1).getStringCellValue();
			String Interest_Val = ws.getRow(73).getCell(2).getStringCellValue();
			String InterestMode = ws.getRow(74).getCell(1).getStringCellValue();
			String InterestMode_Val = ws.getRow(74).getCell(2).getStringCellValue();
			String DesiredTime = ws.getRow(75).getCell(1).getStringCellValue();
			String DesiredTime_Val = ws.getRow(75).getCell(2).getStringCellValue();
			String DesiredTime_Unit = ws.getRow(76).getCell(1).getStringCellValue();
			String DesiredTime_Unit_Val = ws.getRow(76).getCell(2).getStringCellValue();
			String Submit = ws.getRow(77).getCell(1).getStringCellValue();

			driver.findElement(By.cssSelector(SimpleInterest)).click();
			driver.findElement(By.xpath(Principal)).sendKeys(Principal_val);
			driver.findElement(By.xpath(Interest)).sendKeys(Interest_Val);

			WebElement Dp1 = driver.findElement(By.xpath(InterestMode));
			Select obj1 = new Select(Dp1);
			obj1.selectByVisibleText(InterestMode_Val);

			driver.findElement(By.xpath(DesiredTime)).sendKeys(DesiredTime_Val);

			WebElement Dp2 = driver.findElement(By.xpath(DesiredTime_Unit));
			Select obj2 = new Select(Dp2);
			obj2.selectByVisibleText(DesiredTime_Unit_Val);

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
