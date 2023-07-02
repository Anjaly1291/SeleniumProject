package com.webmath;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
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

//TEST CASE=TC001
public class WebmathDropdown {
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

			XSSFWorkbook workbook = new XSSFWorkbook(f);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowcount = sheet.getLastRowNum();
			System.out.println(rowcount);
			XSSFRow currentrow = sheet.getRow(4);
			String dropdown = currentrow.getCell(1).getStringCellValue();
			WebElement Dp = driver.findElement(By.xpath(dropdown));
			Select obj1 = new Select(Dp);
			XSSFRow Dprow = sheet.getRow(5);
			obj1.selectByVisibleText(Dprow.getCell(2).getStringCellValue());

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void close()

	{
		driver.quit();
	}
}
