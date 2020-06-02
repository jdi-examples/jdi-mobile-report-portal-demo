package reportportal;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import reportportal.pages.RPDashboardPage;
import reportportal.pages.RPLaunchesPage;
import reportportal.pages.RPLoginPage;
import reportportal.pages.RPProfilePage;

import static com.epam.jdi.light.common.CheckTypes.CONTAINS;

@JSite("https://dev.reportportal.io/ui")
public class RPSite {

    @Url("/#login")  @Title(value = "Report Portal", validate = CONTAINS)
    public static RPLoginPage loginPage;
    @Url("/#jdi-tests/dashboard") @Title("Report Portal")
    public static RPDashboardPage dashboardPage;
    @Url("/#jdi-tests/launches/all") @Title("Report Portal")
    public static RPLaunchesPage launchesPage;
    @Url("/#user-profile")  @Title("Report Portal")
    public static RPProfilePage profilePage;

}