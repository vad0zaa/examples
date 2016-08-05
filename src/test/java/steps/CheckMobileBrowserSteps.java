package steps;
/**
 * Created by vsinchuk on 01-Aug-16.
 */
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CheckMobileBrowserSteps {

    private WebDriver driver;
    private String device = "Android emulator Nexus5";
    private String webPageToOpen = "http://www.google.com";
    private String expectedTitle = "Google";
    private String title = "";

    @Before
    public void getAndroidDriver() throws MalformedURLException {

        // Create object of  DesiredCapabilities class and specify android platform
        DesiredCapabilities capabilities=DesiredCapabilities.android();

        // set the capability to execute test in chrome browser
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

        // set the capability to execute test in default browser
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "BROWSER");

        // set the capability to execute our test in Android Platform
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

        // we need to define platform name
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        //android avd 4.4.4 api19 , default browser
        capabilities.setCapability(MobileCapabilityType.VERSION,"4.4.4");

        // for single device
        // Create object of URL class and specify the appium server address
        //URL url= new URL("http://127.0.0.1:4723/wd/hub");

        // for single device
        // Create object of  AndroidDriver class and pass the url and capability that we created
        //driver = new AndroidDriver(url, capabilities);

        // set device name
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        // Create object of  AndroidDriver class and pass url of Selenium Grid server
        driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub/"), capabilities);

        // set timeouts
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);

        Assert.assertTrue(driver != null);
    }

    @Given("^user otkryvaet browser$")
    public void getWebPage(){

        driver.get(webPageToOpen);

        // always true :))
        Assert.assertTrue(true);
    }

    @When("^on proverjaet sait$")
    public void checkElement(){

        //get website element
        title = driver.getTitle();

        // fail if did not get title element
        Assert.assertTrue(! title.equals(""));
        // enter text into search window
        //driver.findElement(By.name("q")).sendKeys("fob solutions tallinn");

        // click on google otsing button
        //driver.findElement(By.name("btnG")).click();
    }

    @Then("^website title dolzen byt Google$")
    public void checkTitleIsCorrect(){

        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println(" device = " + device);
        System.out.println(" tested web page = " + webPageToOpen);
        System.out.println(" webpage title = "+ title);
        System.out.println("-------------------------------");
        System.out.println("");

        Assert.assertTrue(title.equalsIgnoreCase(expectedTitle));
    }

    @After
    public void closeBrowser(){

        driver.quit();

    }
}