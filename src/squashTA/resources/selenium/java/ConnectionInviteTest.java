import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.fail;

public class ConnectionInviteTest {
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
    public void test2() throws Exception {
        driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/dashboard.php");
        assertEquals(driver.getCurrentUrl(), "http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/login.php");
        driver.get("http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/calendar.php");
        assertEquals(driver.getCurrentUrl(), "http://m2gl.deptinfo-st.univ-fcomte.fr/~m2test2/preprod/static/dashboard.php");
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
