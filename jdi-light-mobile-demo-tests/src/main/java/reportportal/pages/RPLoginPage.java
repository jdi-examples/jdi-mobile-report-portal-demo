package reportportal.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class RPLoginPage extends WebPage {

    @XPath("//*[@placeholder='Login']") public TextField loginField;
    @XPath("//*[@placeholder='Password']") public TextField passwordField;
    @XPath("//*[@type='submit']") public Button loginButton;

}
