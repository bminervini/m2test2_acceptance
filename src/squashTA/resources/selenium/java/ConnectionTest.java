import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ConnectionTest {
    private HtmlUnitDriver driver;
    private String baseUrl;
    private String valX;
    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        baseUrl = "http://m2gl.deptinfo-st.univ-fcomte.fr";
    }
    @Test
    public void test2() throws Exception {
        driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("submit")).click();
    }
}
