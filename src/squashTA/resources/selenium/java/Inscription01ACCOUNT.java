import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Inscription01ACCOUNT {
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
  public void testAddUser() throws Exception {
    driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
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
    Assert.assertTrue(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='isAdmin'])[1]/following::div[1]")).isDisplayed());
    Assert.assertEquals("User successfully registered !", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='isAdmin'])[1]/following::div[1]")).getText());
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
