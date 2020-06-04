package reportportal.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;

public class RPSettingsPage extends WebPage {
    @JDropdown(
            root = "(//div[contains(@class, 'inputDropdown__dropdown-container')])[1]",
            list = "//div[contains(@class, 'inputDropdownOption')]/a",
            value = "(//span[contains(@class, 'inputDropdown__value')])[1]",
            expand = "(//span[contains(@class, 'inputDropdown__arrow')])[1]"
    )
    public Dropdown settingsDropdown;
    @XPath("//div[contains(text(), 'Billing Plan:')]/span")
    public Label billingPlan;
}
