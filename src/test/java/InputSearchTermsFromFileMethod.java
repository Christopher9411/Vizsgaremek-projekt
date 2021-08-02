import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputSearchTermsFromFileMethod {
    static WebDriver driver = Util.getDriver();


public static void readfromfile() {
    FileUtil utils = new FileUtil();
    String[] credential = utils.readCredential();
    WebElement search_field = driver.findElement(By.cssSelector(".inp"));
    search_field.sendKeys(credential[0]);
}
}


