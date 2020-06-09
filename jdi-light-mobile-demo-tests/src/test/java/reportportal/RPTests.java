package reportportal;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static reportportal.RPSite.*;

public class RPTests extends RPTestsInit {

    private static final String FIRST_DASHBOARD_TEXT = "Add your first dashboard to analyse statistics";
    private static final String NO_DASHBOARD_TEXT = "You have no dashboards";
    private static final String NO_RESULTS_TEXT = "No results found";

    @Test()
    public void dashboardPageTest() {
        dashboardPage.open();
        dashboardPage.noDashboardsText.has().text(NO_DASHBOARD_TEXT);
        dashboardPage.addDashboardText.has().text(FIRST_DASHBOARD_TEXT);
    }

    @Test()
    public void addDashboardModalTest() {
        menuButton.click();
        leftMenu.dashboardButton.click();
        dashboardPage.addDashboardButton.click();
        dashboardPage.modalCancelButton.click();
        dashboardPage.siteLogo.is().displayed();
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
        menuButton.click();
        leftMenu.launchesButton.click();
        launchesPage.noResultsFoundLabel.is().displayed();
        launchesPage.noResultsFoundLabel.has().text(NO_RESULTS_TEXT);
    }

    @Test
    public void debugPageTest() {
        menuButton.click();
        leftMenu.debugButton.click();
        debugPage.launchNameInput.setText("JDI");
        debugPage.reloadButton.click();
        debugPage.launchName.has().text(Matchers.containsString("JDI"));
    }

    @Test
    public void settingsPageTest() {
        settingsButton.click();
        settingsPage.settingsDropdown.expand();
        settingsPage.settingsDropdown.select("Billing");
        settingsPage.billingPlan.has().text(Matchers.containsString("Test"));
    }

    @Test
    public void membersPageTest() {
        membersButton.click();
        membersPage.usernameLabel.is().displayed();
    }
}
