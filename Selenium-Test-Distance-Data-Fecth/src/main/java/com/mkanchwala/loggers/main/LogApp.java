package com.mkanchwala.loggers.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogApp {
	static Logger log = LogManager.getLogger(LogApp.class.getName());

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		String baseURL = "http://www.kgm.gov.tr/Sayfalar/KGM/SiteTr/Uzakliklar/ilcedenIlceyeMesafe.aspx";
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);

		WebElement dropdown = driver.findElement(
				By.xpath("//select[@id='ctl00_ctl57_g_ebf705af_3ac3_4581_971f_9c4eb8392e30_ctl00_ddlCity1']"));
		Select select = new Select(dropdown);
		java.util.List<WebElement> options = select.getOptions();

		List<String> fromCityList = new ArrayList<String>();
		List<String> toCityList = new ArrayList<String>();

		for (WebElement item : options) {
			fromCityList.add(item.getText());
			toCityList.add(item.getText());
			// System.out.println("Dropdown values are " + item.getText());

		}
		java.util.List<WebElement> optionsIlce = null;
		for (String fromCity : fromCityList) {

			try {
				Select drpFromCity = new Select(
						driver.findElement(By.id("ctl00_ctl57_g_ebf705af_3ac3_4581_971f_9c4eb8392e30_ctl00_ddlCity1")));
				drpFromCity.selectByVisibleText(fromCity);

				WebElement dropdownTown = driver.findElement(
						By.xpath("//select[@id='ctl00_ctl57_g_ebf705af_3ac3_4581_971f_9c4eb8392e30_ctl00_ddlTown1']"));
				Select selectTown = new Select(dropdownTown);
				optionsIlce = selectTown.getOptions();
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getLocalizedMessage());
			}
			List<String> fromTownList = new ArrayList<String>();
			if (optionsIlce != null) {
				for (WebElement item : optionsIlce) {
					fromTownList.add(item.getText());
					// System.out.println("Ilce values are " + item.getText());
				}
			}

			for (String townItem : fromTownList) {

				try {
					Select drpIlce = new Select(driver
							.findElement(By.id("ctl00_ctl57_g_ebf705af_3ac3_4581_971f_9c4eb8392e30_ctl00_ddlTown1")));
					drpIlce.selectByVisibleText(townItem);
				} catch (Exception e) {
					e.printStackTrace();
				}
				java.util.List<WebElement> optionsToTown = null;
				for (String toCity : toCityList) {
					try {
						Select drpToCity = new Select(driver.findElement(
								By.id("ctl00_ctl57_g_ebf705af_3ac3_4581_971f_9c4eb8392e30_ctl00_ddlCity2")));
						drpToCity.selectByVisibleText(toCity);

						WebElement dropdownToTown = driver.findElement(By.xpath(
								"//select[@id='ctl00_ctl57_g_ebf705af_3ac3_4581_971f_9c4eb8392e30_ctl00_ddlTown2']"));
						Select selectTownTo = new Select(dropdownToTown);
						optionsToTown = selectTownTo.getOptions();
					} catch (Exception e) {
						e.printStackTrace();
						log.error(e.getMessage());
					}

					List<String> toTownList = new ArrayList<String>();
					if (optionsToTown != null) {
						for (WebElement item : optionsToTown) {
							toTownList.add(item.getText());
							// System.out.println("Ilce values are " + item.getText());
						}
					}

					for (String toTownItem : toTownList) {
						try {
							Select drpToTown = new Select(driver.findElement(
									By.id("ctl00_ctl57_g_ebf705af_3ac3_4581_971f_9c4eb8392e30_ctl00_ddlTown2")));
							drpToTown.selectByVisibleText(toTownItem);

							driver.findElement(By.xpath("//input[@value='Hesapla' and @type='submit']")).click();

							WebElement elementTo = driver.findElement(
									By.id("ctl00_ctl57_g_ebf705af_3ac3_4581_971f_9c4eb8392e30_ctl00_lblResult"));
							// System.out.println(elementTo.getText());

							log.info(elementTo.getText());
						} catch (Exception e) {
							e.printStackTrace();
							log.error(e.getMessage());
						}

					}

					System.out.println("-------------------");

				}

			}

			System.out.println("-------------------");

		}
		driver.get("http://jsbin.com/osebed/2");
	}

}