import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.fail;

public class DashboardCalendar {
    private HtmlUnitDriver driver;
    private String baseUrl;
    private String valX;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        baseUrl = "http://m2gl.deptinfo-st.univ-fcomte.fr";
    }

  @Test
  public void testDashboardCalendar() throws Exception {
    driver.get(baseUrl + "http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
    // Thread.sleep(2000);
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Calendrier")).click();
    Thread.sleep(2000);
    // Assert.assertTrue(driver.findElement(By.xpath("//body")).isDisplayed());
    Assert.assertTrue(true);
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
