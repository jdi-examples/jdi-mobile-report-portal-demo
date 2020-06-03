package reportportal;

import com.epam.jdi.light.settings.JDISettings;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.System.getProperty;
import static reportportal.RPSite.loginPage;

public class RPTestsInit {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        String remoteUrl = getProperty("webdriver.remote.url");
        initElements(RPSite.class);
        if(remoteUrl != null) {
            JDISettings.DRIVER.remoteUrl = remoteUrl;
        }
        logger.toLog("Run Tests");
        login();
    }

    private void login() {
        String login = getProperty("report.portal.user");
        String password = getProperty("report.portal.password");

        loginPage.open();
        loginPage.loginField.sendKeys(login);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
