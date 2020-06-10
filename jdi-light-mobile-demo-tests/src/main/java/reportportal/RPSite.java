package reportportal;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import reportportal.pages.*;

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
    @Url("/#jdi-tests/userdebug/all") @Title("Report Portal")
    public static RPDebugPage debugPage;
    @Url("/#jdi-tests/settings/general")
    public static RPSettingsPage settingsPage;
    @Url("/#jdi-tests/members")
    public static RPMembersPage membersPage;

    @XPath("//*[@class='sidebar__sidebar--1J7aD']")
    public static RPLeftMenu leftMenu;

    @JDropdown(root = "//div[contains(@class, 'projectSelector__project-selector')]",
            expand = "//div[contains(@class, 'projectSelector__show')]",
            list = "//a[contains(@class, 'projectSelector__project-list-item')]",
            value = "//div[contains(@class, 'projectSelector__current-project-name')]")
    public static Dropdown projectSelector;

    @XPath("//*[@class='mobileHeader__hamburger--95j4J']")
    public static Button menuButton;
    @XPath("//a[@href='#jdi-tests/settings']")
    public static Link settingsButton;
    @XPath("//a[@href='#jdi-tests/members']")
    public static Link membersButton;

}