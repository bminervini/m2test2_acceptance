import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.fail;

public class AuthenticationConnexionAdminValide {
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
  public void testAuthenticationConnexionAdminValide() throws Exception {
    driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    assertTrue(driver.findElement(By.xpath("//nav")).isDisplayed());
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
