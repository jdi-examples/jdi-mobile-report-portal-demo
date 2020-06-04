package reportportal.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class RPDebugPage extends WebPage {
    @XPath("//input[@placeholder='Enter name']")
    public TextField launchNameInput;
    @XPath("//div[contains(@class, 'itemInfo__main-info')]")
    public Label launchName;
    @XPath("//div[contains(@class, 'actionPanel')]/button[contains(@class, 'ghostButton')]")
    public Button reloadButton;
}
