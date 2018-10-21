package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class AddUser {
  private HtmlUnitDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddUser() throws Exception {
    driver.get("http://localhost/m2test2/static/login.php");
    driver.findElement(By.linkText("S'inscrire")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("brandon");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("chenu");
    driver.findElement(By.name("mailedu")).clear();
    driver.findElement(By.name("mailedu")).sendKeys("brandon.chenu");
    driver.findElement(By.name("gmail")).click();
    driver.findElement(By.name("gmail")).clear();
    driver.findElement(By.name("gmail")).sendKeys("brandon");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("brandon");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("brandon");
    driver.findElement(By.name("submit")).click();
    assertTrue(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='isAdmin'])[1]/following::div[1]")).isDisplayed());
    assertEquals("User successfully registered !", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='isAdmin'])[1]/following::div[1]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
