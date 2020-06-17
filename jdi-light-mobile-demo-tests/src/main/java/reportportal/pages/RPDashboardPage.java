package reportportal.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.Icon;
import com.epam.jdi.light.mobile.elements.common.Text;

import java.util.List;

public class RPDashboardPage extends WebPage {
    @XPath("//*[contains(text(), 'You have no dashboards')]")
    public Text noDashboardsText;
    @XPath("//*[contains(text(), 'Add your first dashboard to analyse statistics')]")
    public Text addDashboardText;
    @XPath("//*[contains(@class, 'emptyDashboards__empty-dashboard-content')]//button")
    public Button addDashboardButton;
    @XPath("//*[contains(@class, 'mobileHeader__rp-logo')]")
    public Icon siteLogo;
    @XPath("//*[contains(text(), 'Cancel')]")
    public Button modalCancelButton;
    @XPath("//a[contains(@class, 'dashboardTable__name')]")
    public List<Text> dashboardsNames;
}
