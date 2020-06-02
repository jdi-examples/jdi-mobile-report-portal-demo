package reportportal;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static reportportal.RPSite.*;
import static org.testng.Assert.assertTrue;

public class RPTests extends RPTestsInit {

    private static final String FIRST_DASHBOARD_TEXT = "Add your first dashboard to analyse statistics";
    private static final String NO_DASHBOARD_TEXT = "You have no dashboards";

    @Test()
    public void labelTest() {
        dashboardPage.noDashboardsText.has().text(NO_DASHBOARD_TEXT);
        dashboardPage.addDashboardText.has().text(FIRST_DASHBOARD_TEXT);
    }

    @Test()
    public void addDashboardModalTest() throws InterruptedException {
        dashboardPage.addDashboardButton.click();
        // TODO: replace w/Wait
//        Thread.sleep(3000);
        dashboardPage.modalCancelButton.click();
        // TODO: replace w/Wait
//        Thread.sleep(3000);
        dashboardPage.siteLogo.is().displayed();
    }

    @Test()
    public void menuTest() {
        dashboardPage.hamburgerMenuButton.click();
        dashboardPage.launchesButton.click();
        launchesPage.noResultsFoundLabel.has().text("No results found");
    }

    @Test
    public void profileMenuTest() {
        profilePage.open();
        profilePage.loginText.is().text("TEST-USER");
    }

}
