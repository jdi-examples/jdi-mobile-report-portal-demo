package reportportal;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static reportportal.RPSite.loginPage;

public class RPTestsInit {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initElements(RPSite.class);
        logger.toLog("Run Tests");
        login();
    }

    private void login() {
        loginPage.open();
        loginPage.loginField.sendKeys("test-user");
        loginPage.passwordField.sendKeys("Fqvq1s0S");
        loginPage.loginButton.click();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
