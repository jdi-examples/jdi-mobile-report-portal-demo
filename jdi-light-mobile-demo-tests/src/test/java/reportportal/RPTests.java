package reportportal;

import org.testng.annotations.Test;

import static reportportal.RPSite.*;

public class RPTests extends RPTestsInit {

    private static final String FIRST_DASHBOARD_TEXT = "Add your first dashboard to analyse statistics";
    private static final String NO_DASHBOARD_TEXT = "You have no dashboards";
    private static final String NO_RESULTS_TEXT = "No results found";

    @Test()
    public void labelTest() {
        dashboardPage.noDashboardsText.has().text(NO_DASHBOARD_TEXT);
        dashboardPage.addDashboardText.has().text(FIRST_DASHBOARD_TEXT);
    }

    @Test()
    public void addDashboardModalTest() {
        dashboardPage.addDashboardButton.click();
        dashboardPage.modalCancelButton.click();
        dashboardPage.siteLogo.is().displayed();
    }

    @Test()
    public void menuTest() {
        dashboardPage.hamburgerMenuButton.click();
        dashboardPage.launchesButton.click();
        launchesPage.noResultsFoundLabel.has().text(NO_RESULTS_TEXT);
    }

    @Test
    public void profileMenuTest() {
        profilePage.open();
        profilePage.loginText.is().text("TEST-USER");
    }

}
