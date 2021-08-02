import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Terms_of_ServiceMethod {
    static WebDriver driver = Util.getDriver();

    public static void TermsOfService() {
        WebElement terms_of_service = driver.findElement(By.xpath("//*[@id=\"chk_policy\"]"));
        terms_of_service.click();
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#btn_settings_ok"))).click();
    }


}
