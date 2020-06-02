package reportportal.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.mobile.elements.common.Text;

public class RPLaunchesPage extends WebPage {

    @XPath("//*[@class='noItemMessage__message--2ydYP']")
    public Text noResultsFoundLabel;

}
