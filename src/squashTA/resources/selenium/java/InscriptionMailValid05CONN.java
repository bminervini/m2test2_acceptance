import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class InscriptionMailValid05CONN
{
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
    public void testWrongmail() throws Exception {
        driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
        driver.findElement(By.xpath("//body")).click();
        driver.findElement(By.linkText("S'inscrire")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Octave");
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("Ergebel");
        driver.findElement(By.name("mailedu")).clear();
        driver.findElement(By.name("mailedu")).sendKeys("oct.erg");
        driver.findElement(By.name("gmail")).clear();
        driver.findElement(By.name("gmail")).sendKeys("oct");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("oct");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("oct");
        driver.findElement(By.name("submit")).click();
        assertEquals("User successfully registered !", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Administrateur'])[1]/following::div[1]")).getText());
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
