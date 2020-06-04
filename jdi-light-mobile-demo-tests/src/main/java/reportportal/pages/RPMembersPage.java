package reportportal.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;

public class RPMembersPage extends WebPage {
    @XPath("//span[contains(text(), 'test-user')]")
    public Label usernameLabel;
}
