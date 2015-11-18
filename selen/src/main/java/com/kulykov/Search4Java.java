package com.kulykov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search4Java {
	public static void main(String[] args){
		WebDriver webdriver = new FirefoxDriver();
	
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		webdriver.navigate().to("http://www.google.com.ua");
		
		webdriver.manage().window().maximize();
		
		webdriver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("java" , (Keys.ENTER));
		
		webdriver.findElements(By.xpath(".//*[@id='rso']/div/div/div/h3/a")).stream().filter(e -> e.getText().contains("Википедия")).findFirst().get().click();
		
		String homepage = webdriver.findElement(By.xpath(".//*[@id='mw-content-text']/table[1]/tbody/tr[13]/td/p/a")).getText().toString();
		
		if(homepage.equals("java.com")){
			System.out.println("This Wikipedia page is about Java computer programming language");
		}
		
		else{
			System.out.println("This Wikipedia page is not about Java computer programming language");
		}
			
	}
}
