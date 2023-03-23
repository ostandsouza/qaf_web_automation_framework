package com.web.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudheerkumar.pola\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.findElement(By.xpath("//button[contains(@class,'multiselect ')]")).click();
        
        List<WebElement> values = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li//a//label"));
		for(int i=0;i<values.size();i++) {
		
			if(	values.get(i).getText().contains("jQuery")) {
				values.get(i).click();
				break;
			}
		} 
        
	}

}
