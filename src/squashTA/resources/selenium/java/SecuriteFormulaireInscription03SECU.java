import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SecuriteFormulaireInscription03SECU
{
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
    public void testSQL() throws Exception {
        driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin' or 1=1 --");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("zazdqsdqs");
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
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
