import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginMethod {
    public static void login() {
        WebDriver driver = Util.getDriver();
        WebElement email = driver.findElement(By.xpath("//*[@class=\"indpl_text indpl_email\"]"));
        email.sendKeys("nagy.kristof1994@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@class=\"indpl_text indpl_passwd\"]"));
        password.sendKeys("teszt123");
        WebElement login_button = driver.findElement(By.xpath("//*[contains(@class,'indpl_submit')]"));
        login_button.click();

    }
}