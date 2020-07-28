package base;

import com.sun.org.apache.bcel.internal.generic.InstructionListObserver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver = null;

    @Parameters({"url"})
    @BeforeMethod
    public void setUp(@Optional String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jesse\\IdeaProjects\\TestProject\\Generic\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    public void clickOnElement(String locator) {
        driver.findElement(By.cssSelector(locator)).click();

    }

    public void typeOnElement(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public List<WebElement> getListOfWebElements(String locator) {
        List<WebElement> elementList = driver.findElements(By.cssSelector(locator));

        return elementList;
    }
    public List<String> getListOfString(List<WebElement>elementList){
        List< String> listOfString = new ArrayList<String>();
        for(WebElement element:elementList){
            listOfString.add(element.getText());
        }
        return listOfString;
    }

}
