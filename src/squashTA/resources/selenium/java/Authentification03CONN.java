import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.fail;

public class Authentification03CONN {
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
  public void test03CONN() throws Exception {
    driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
    driver.findElement(By.linkText("S'inscrire")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("Yannis");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Beaux");
    driver.findElement(By.name("mailedu")).clear();
    driver.findElement(By.name("mailedu")).sendKeys("yannis.beaux");
    driver.findElement(By.name("gmail")).clear();
    driver.findElement(By.name("gmail")).sendKeys("yannis.beaux");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("ybeaux");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("ybeaux");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Back to Login")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Utilisateurs")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='yannis.beaux@gmail.com'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Je ne participe pas'])[1]/following::i[1]")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("ybeaux");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("ybeaux");
    driver.findElement(By.name("submit")).click();
    Assert.assertTrue(driver.findElement(By.id("dropdownMenu1")).isDisplayed());
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
