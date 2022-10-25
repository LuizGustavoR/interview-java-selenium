package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SetupMyWebDriver {

    private WebDriver webDriver;

    public SetupMyWebDriver() {
        String osName = System.getProperty("os.name").toLowerCase();
        String webdriversPath = "src/test/resources/webdrivers/";
        if(osName.contains("windows")){
            System.setProperty("webdriver.chrome.driver", webdriversPath + "chromedriver.exe");
        }else if(osName.contains("macos")){
            System.setProperty("webdriver.chrome.driver", webdriversPath + "chromedriver");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("disable-infobars");
        options.setHeadless(false);
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
