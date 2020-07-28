package home;

import base.CommonAPI;
import org.testng.annotations.Test;

public class HomePage extends CommonAPI {

    @Test

    public void homePage(){
        clickOnElement("nav-link position-relative size-16 lineHeight-h3 display-inlineBlock weight-medium active");
    }
}
