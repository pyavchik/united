import io.trueautomation.client.driver.TrueAutomationDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

public class FlightStatusToggerTest {
    private WebDriver driver;
    private DesiredCapabilities cap;
    private HomePage homePage;

    @BeforeTest
    public void before() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X (11.4)");
        cap.setCapability(MobileCapabilityType.UDID, "1DA711FE-C66B-4538-9147-10852CF5F1ED");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
        driver = new TrueAutomationDriver(new URL("http://localhost:4723/wd/hub"), cap);

        homePage = new HomePage(driver);
    }

    @Test
    public void test()throws InterruptedException {
        homePage.goToHomePage();
        homePage.goToFlightStatusToggler();
        assertTrue(homePage.isFlightNumberFieldAvailable());
        assertTrue(homePage.isDatesDropdownAvailable());
        assertTrue(homePage.isFromInputAvailable());
        assertTrue(homePage.isToInputAvailable());
        assertTrue(homePage.isSearchButtonAvailable());
        sleep(3000);
    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}
