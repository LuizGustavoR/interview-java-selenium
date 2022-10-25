package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver webDriver;
    @FindBy(id = "number")
    private WebElement number;

    @FindBy(id = "getFactorial")
    private WebElement btnCalculate;

    @FindBy(id = "resultDiv")
    private WebElement result;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void search(String operation) {
        number.sendKeys(operation);
        btnCalculate.click();
    }

    public String getResult() {
        new WebDriverWait(webDriver, Duration.ofSeconds(6)).until(webDriver -> !result.getText().isEmpty());
        String[] resultTextArray = result.getText().split(" ");
        return resultTextArray[resultTextArray.length-1];
    }

}
