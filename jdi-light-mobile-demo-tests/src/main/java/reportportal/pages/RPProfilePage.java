package reportportal.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.mobile.elements.common.Text;

public class RPProfilePage extends WebPage {
    @XPath("//div[contains(@class, 'userInfo__login')]")
    public Text loginText;
}
