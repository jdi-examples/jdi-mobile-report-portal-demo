package reportportal;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.JDISettings;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_ANDROID;
import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_IOS;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.System.getProperty;
import static reportportal.RPSite.loginPage;
import static reportportal.RPSite.projectSelector;

public class RPTestsInit {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        String remoteUrl = getProperty("webdriver.remote.url");
        initPlatform();
        initElements(RPSite.class);
        setCaps();
        if(remoteUrl != null) {
            JDISettings.DRIVER.remoteUrl = remoteUrl;
        }
        logger.toLog("Run Tests");
        login();
    }

    @BeforeMethod
    public void selectJDIProject() {
        projectSelector.select("jdi-tests");
    }

    private void login() {
        String login = getProperty("report.portal.user");
        String password = getProperty("report.portal.password");

        loginPage.open();
        loginPage.loginField.sendKeys(login);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();
    }

    private void setCaps() {
        String cloudService = getProperty("mobile.cloud.type").toLowerCase();
        String platform = getProperty("mobile.platform.name").toLowerCase();
        if (platform.equals("ios")) {
            if(cloudService.equals("saucelabs")) {
                CAPABILITIES_FOR_IOS.put("deviceName", getProperty("mobile.device.name"));
                CAPABILITIES_FOR_IOS.put("platformVersion", getProperty("mobile.platform.version"));
            } else {
                CAPABILITIES_FOR_IOS.put("platformName", platform);
                CAPABILITIES_FOR_IOS.put("udid", getProperty("mobile.device.udid"));
                CAPABILITIES_FOR_IOS.put("browserName", "Safari");
            }
        } else {
            if(cloudService.equals("saucelabs")) {
            CAPABILITIES_FOR_ANDROID.put("deviceName", getProperty("mobile.device.name"));
            CAPABILITIES_FOR_ANDROID.put("platformVersion", getProperty("mobile.platform.version"));
            } else {
                CAPABILITIES_FOR_ANDROID.put("platformName", platform);
                CAPABILITIES_FOR_ANDROID.put("udid", getProperty("mobile.device.udid"));
                CAPABILITIES_FOR_ANDROID.put("browserName", getProperty("Chrome"));
            }
        }
    }

    private void initPlatform() {
        JDISettings.DRIVER.name = getProperty("mobile.platform.name").toLowerCase();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }
}
