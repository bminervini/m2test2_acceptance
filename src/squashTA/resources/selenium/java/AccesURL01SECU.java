package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AccesURL01SECU {
  private HtmlUnitDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
     driver = new HtmlUnitDriver();
  }

  @Test
  public void testAccesURL01SECU() throws Exception {
    driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("yan");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("yan");
    driver.findElement(By.name("submit")).click();
    driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/GestionUser.php");
    Assert.assertEquals("Dashboard Croissant Show", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='yan'])[1]/following::h1[1]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}