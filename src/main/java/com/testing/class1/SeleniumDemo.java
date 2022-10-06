package com.testing.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class SeleniumDemo {
    public static void main(String[] args) throws  InterruptedException{
        System.setProperty("webdriver.chrome.driver","DriverExe\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver","DriverExe\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

//        System.setProperty("webdriver.ie.driver","DriverExe\\IEDriverServer.exe");
//        WebDriver driver = new InternetExplorerDriver();

//        System.setProperty("webdriver.edge.driver","msedgeDriver.exe");
//        WebDriver driver = new EdgeDriver();








        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.baidu.com");
//        Thread.sleep(3000);
//        driver.get("http://music.163.com");
//        driver.navigate().back();

        WebElement searchInput  = driver.findElement(By.cssSelector("#kw"));
        searchInput.sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("title is"+title);
        if(title.startsWith("selenium")){
            System.out.println("test successful");
        }else{
            System.out.println("test failed");
        }

        WebElement input2 = driver.findElement(By.cssSelector("#kw"));

        String value = input2.getAttribute("value");
        System.out.println("The obtained input box value attribute is "+value);

        String text = driver.findElement(By.xpath("//div[@id='content_left']/div[2]//h3//a")).getText();
        System.out.println("First text element is" +text);
        try{
            driver.findElement(By.xpath("//a[contains(string(),'信息科技有限公司 - 企查查')]"));
                    System.out.println("test successful");
        }catch (Exception e){
            System.out.println("test failed");
        }

 //       System.out.println(driver.getPageSource());
        input2.clear();
        input2.sendKeys("特斯汀");
        input2.submit();

        try{
            driver.findElement(By.xpath("//a[contains(string(),'信息科技有限公司 - 企查查')]"));
            System.out.println("test successful");
        }catch (Exception e){
            System.out.println("test failed");
        }

        driver.quit();

//        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");



    }
}
