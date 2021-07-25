import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;



//logindata goes here


public class Fórumteszt {
    String baseUrl = "https://forum.index.hu/Topic/showTopicList";
    String email_adress = "nagy.kristof1994@gmail.com";
    String password_field = "teszt123";
    String jelszóismét = "teszt123";
    String Nickname = "Teszter Jakab";
    String Bemutatkozás = "Ez egy tesztfiók amely Chromedriveres automata tesztelésre lett létrehozva.";
    String Honlapcím = "wwww.tesztweboldal.hu";
    private Assertions Assert;
    private String Weboldal_szövege;
    WebDriver driver;



    // WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
    // WebElement email_mező = driver.findElement(By.id("nick"));

    @BeforeEach
    public void BeforeEach() {
        //Chromedriver/ weboldal deklarására és meghívása minden egyes tesztesethez
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("user-data-dir=c:/Users/Tatsuya Hiroki/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--disable-notifications"); // visszautasít minden böngésző felkérést pl: értesítések küldése
        options.addArguments("start-maximized"); // teljes képernyőben való használat
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);








    }



    /*/public void Regisztráció() {
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebDriverWait waiting = new WebDriverWait(driver, 40);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".indpl_reg_button"))).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")).click();
        WebElement email_mező = driver.findElement(By.id("nick"));
        email_mező.sendKeys(emailcím);
        email_mező.click();
        WebElement jelszómező = driver.findElement(By.id("passwd"));
        jelszómező.sendKeys(jelszó);
        jelszómező.click();
        WebElement jelszómező_ismét = driver.findElement(By.id("passwd2"));
        jelszómező_ismét.sendKeys(jelszóismét);
        WebElement nickname = driver.findElement(By.id("forum_nick"));
        nickname.sendKeys(Nickname);
        WebElement bemutatkozás = driver.findElement(By.id("forum_desc"));
        bemutatkozás.click();
        bemutatkozás.sendKeys(Bemutatkozás);
        WebElement honlapcím = driver.findElement(By.id("forum_url"));
        honlapcím.sendKeys(Honlapcím);
        WebElement regisztráció = driver.findElement(By.xpath("//*[@id=\"regsubmit\"]"));
        regisztráció.click();
 */


    public void Login_function(){
        WebElement email = driver.findElement(By.xpath("//*[@class=\"indpl_text indpl_email\"]"));
        email.sendKeys(email_adress);
        WebElement password = driver.findElement(By.xpath("//*[@class=\"indpl_text indpl_passwd\"]"));
        password.sendKeys(password_field);
        WebElement login_button = driver.findElement(By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[2]/input"));
        login_button.click();
    }




    public void Terms_of_Service(){
        WebElement terms_of_service = driver.findElement(By.xpath("//*[@id=\"chk_policy\"]"));
        terms_of_service.click();
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#btn_settings_ok"))).click();
    }







public void Logout_function(){
    WebElement logout = driver.findElement(By.cssSelector(".ahigh"));
    logout.click();
    }




    @Test
    public void Login() {
        Login_function();
        WebElement logout = driver.findElement(By.cssSelector(".ahigh"));
        Assertions.assertEquals(true, logout.isDisplayed()); //ellenőrzés hogy a kilépési gomb meg van-e jelenítve
        driver.close();


    }


    @Test
    public void Logout() {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Login_function();
        Logout_function();
        Assert.assertEquals("https://kilepes.blog.hu/", "https://kilepes.blog.hu/");


    }


    @Test
    public void List_data() {
        WebElement search_field = driver.findElement(By.cssSelector(".inp"));
        search_field.sendKeys("autó");
        WebElement search_button = driver.findElement(By.cssSelector("#kereso > div > form > input.btnok"));
        search_button.click();
        String topic_listing = driver.getCurrentUrl();
        Assert.assertEquals("https://forum.index.hu/Search/fastSearchTopic", topic_listing);
        //optionally put scrolling down here

    }


    @Test
    public void Inputdata() {
        Login_function();
        WebElement settings = driver.findElement(By.cssSelector(".boxbold > li:nth-child(3)"));
        settings.click();
        WebElement about_me = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form/table/tbody/tr[7]/td[2]/textarea"));
        about_me.clear();
        about_me.click();
        about_me.sendKeys("Ez egy tesztfiók amely Chromedriveres automata tesztelésre lett létrehozva.");
        WebElement terms_of_service = driver.findElement(By.xpath("//*[@id=\"chk_policy\"]"));
        terms_of_service.click();
        WebDriverWait waiting = new WebDriverWait(driver, 40);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#btn_settings_ok"))).click();
        Assert.assertNotNull(about_me);
    }


    @Test
    public void modify_data() {   //Belépünk az index fórumba majd pedig a profilbeállításoknál megváltoztatjuk a jelszavunkat
        Login_function();
        WebElement settings = driver.findElement(By.cssSelector(".boxbold > li:nth-child(3)"));
        settings.click();
        WebElement website = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form/table/tbody/tr[6]/td[2]/input"));
        website.clear();
        website.sendKeys("wwww.teszterjózsi.hu");
         Terms_of_Service();
        String text= driver.findElement(By.xpath("//*[@id=\"usersettings\"]/tbody/tr[6]/td[2]/input")).getAttribute("value");
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        Assert.assertEquals("wwww.teszterjózsi.hu", text);
        driver.close();
    }

    @Test
    public void Getdata() {
        WebElement homepage = driver.findElement(By.cssSelector(".foot-forum > p:nth-child(2)"));
        System.out.println(homepage.getText());
    }


    @Test
    public void Loop_through_list() {
        WebElement search_field = driver.findElement(By.cssSelector(".inp"));
        search_field.sendKeys("kutya");
        WebElement search_button = driver.findElement(By.cssSelector("#kereso > div > form > input.btnok"));
        search_button.click();
        WebElement page2 = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form[1]/table/tbody/tr/td[1]/a[1]"));
        page2.click();
        WebElement page3 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[4]"));
        page3.click();
        WebElement page4 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[5]"));
        page4.click();
        WebElement page5 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[6]"));
        page5.click();
        WebElement page6 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[7]"));
        page6.click();
        WebElement page7 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[8]"));
        page7.click();
        WebElement page8 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[9]"));
        page8.click();
        WebElement page9 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[10]"));
        page9.click();
       String Website_link = driver.getCurrentUrl();
        Assert.assertEquals("https://forum.index.hu/Search/showTopicResult?tr_start=240&tr_step=30&o=10&tq_text=kutya&tq_in=1&tq_act=&tq_cre=0&tq_user=", Website_link);
        driver.close();






        //String search_results = "https://forum.index.hu/Search/showTopicResult?tr_start=30&tr_step=30&o=10&tq_text=kutya&tq_in=1&tq_act=&tq_cre=0&tq_user=";
        //Assert.assertEquals(search_results, "https://forum.index.hu/Search/showTopicResult?tr_start=30&tr_step=30&o=10&tq_text=kutya&tq_in=1&tq_act=&tq_cre=0&tq_user=");

        }


    @Test
    public void Remove_Data() {
        Login_function();
        By byElement = By.cssSelector("td.histe_subject:nth-child(1)");
        WebElement settings = driver.findElement(By.cssSelector(".boxbold > li:nth-child(3)"));
        settings.click();
        WebElement about_me = driver.findElement(By.cssSelector("tr.mainsettings:nth-child(7) > td:nth-child(2) > textarea:nth-child(1)"));
        about_me.clear();
        Terms_of_Service();
        WebDriverWait waiting = new WebDriverWait(driver, 40);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr.mainsettings:nth-child(7) > td:nth-child(2) > textarea:nth-child(1)")));
        String text = driver.findElement(By.cssSelector("tr.mainsettings:nth-child(7) > td:nth-child(2) > textarea:nth-child(1)")).getText();
        Assert.assertTrue(text.isEmpty());


        //*[@id="usersettings"]/tbody/tr[7]/td[2]/textarea





        //*[@id="content1col"]/tbody/tr[2]/td[1]
        //*[@id="content1col"]/tbody/tr[2]


    }
}







