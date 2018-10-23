import org.junit.Before;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class RefusDuParticpant021PART {
    private HtmlUnitDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        baseUrl = "http://m2gl.deptinfo-st.univ-fcomte.fr";
    }


  @Test
  public void test021PART() throws Exception {
    driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("bapt");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("bapt");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.name("statut")).click();
    Assert.assertEquals("Je participe de nouveau", driver.findElement(By.name("statut")).getText());
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
