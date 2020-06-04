package reportportal.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.mobile.elements.common.Button;

public class RPLeftMenu extends Section {
    @XPath("//*[contains(text(), 'Launches')]")
    public Button launchesButton;
    @XPath("//*[contains(text(), 'Dashboard')]")
    public Button dashboardButton;
    @XPath("//*[contains(text(), 'Filters')]")
    public Button filtersButton;
    @XPath("//*[contains(text(), 'Debug')]")
    public Button debugButton;
}
