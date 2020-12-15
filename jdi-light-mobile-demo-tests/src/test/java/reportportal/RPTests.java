package reportportal;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static org.assertj.core.api.Assertions.assertThat;
import static reportportal.RPSite.*;

public class RPTests extends RPTestsInit {

    private static final String FIRST_DASHBOARD_TEXT = "Add your first dashboard to analyse statistics";
    private static final String NO_DASHBOARD_TEXT = "You have no dashboards";
    private static final String NO_RESULTS_TEXT = "No results found";

    @Test()
    public void dashboardPageTest() {
        dashboardPage.open();
        dashboardPage.noDashboardsText.is().displayed();
        dashboardPage.noDashboardsText.has().text(NO_DASHBOARD_TEXT);
    }

    @Test()
    public void addDashboardModalTest() {
        menuButton.click();
        leftMenu.dashboardButton.click();
        projectSelector.select("test-user_personal");
        dashboardPage.noDashboardsText.has().text(NO_DASHBOARD_TEXT);
        dashboardPage.addDashboardText.has().text(FIRST_DASHBOARD_TEXT);
        dashboardPage.addDashboardButton.click();
        dashboardPage.modalCancelButton.click();
        dashboardPage.siteLogo.is().displayed();
    }

    @Test
    public void addDashboardFailTest() {
        dashboardPage.open();
        dashboardPage.checkOpened();
        logger.info("Fail because there are no dashboards");
        assertThat(dashboardPage.dashboardsNames).isNotEmpty(); //will fail because there are no dashboards
    }

    @Test()
    public void menuTest() {
        menuButton.click();
        leftMenu.launchesButton.click();
        launchesPage.checkOpened();
        menuButton.click();
        leftMenu.dashboardButton.click();
        dashboardPage.checkOpened();
        menuButton.click();
        leftMenu.debugButton.click();
        debugPage.checkOpened();
    }

    @Test
    public void profileMenuTest() {
        profilePage.open();
        profilePage.loginText.is().text("TEST-USER");
    }

    @Test()
    public void launchesTest() {
        projectSelector.select("test-user_personal");
        menuButton.click();
        leftMenu.launchesButton.click();
        assertThat(launchesPage.launchNames)
                .as("There are not any launches")
                .hasSizeLessThan(1);
        launchesPage.noResultsFoundLabel.is().displayed();
        launchesPage.noResultsFoundLabel.has().text(NO_RESULTS_TEXT);
    }

    @Test
    public void debugPageTest() {
        menuButton.click();
        leftMenu.debugButton.click();
        debugPage.launchNameInput.setText("JDI");
        debugPage.reloadButton.click();
        debugPage.noItemMessage.is().displayed();
        debugPage.noItemMessage.has().text(Matchers.containsString("No results found"));
    }

    @Test
    public void settingsPageTest() {
        settingsButton.click();
        settingsPage.settingsDropdown.expand();
        settingsPage.settingsDropdown.select("Demo data");
        settingsPage.generateDemoData.has().text(Matchers.containsString("Generate demo data"));
    }

    @Test
    public void membersPageTest() {
        membersButton.click();
        membersPage.usernameLabel.is().displayed();
    }
}
