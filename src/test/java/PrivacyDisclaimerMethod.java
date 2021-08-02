import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PrivacyDisclaimerMethod {
    static WebDriver driver = Util.getDriver();

    public static void privacy_save_into_file() {
        WebElement privacy_policy = driver.findElement(By.xpath("//*[@href='/adatkezeles/']"));
        privacy_policy.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navilast")));
       String privacy_text = driver.findElement(By.cssSelector("#navilast")).getText();
        FileUtil utils = new FileUtil();
        utils.writeToFile(privacy_text);


    }


}
