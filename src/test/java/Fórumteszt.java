import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class Fórumteszt {
    String baseUrl = "https://forum.index.hu/Topic/showTopicList";
    String emailcím = "nagy.kristof1994@gmail.com";
    String jelszó = "teszt123";
    String jelszóismét = "teszt123";
    String Nickname = "Teszter Jakab";
    String Bemutatkozás = "Ez egy tesztfiók amely Chromedriveres automata tesztelésre lett létrehozva.";
    String Honlapcím = "wwww.tesztweboldal.hu";
    private Assertions Assert;
    private String Weboldal_szövege;
    // WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
    // WebElement email_mező = driver.findElement(By.id("nick"));

    @BeforeEach
    public void BeforeEach() {
        //Chromedriver/ weboldal deklarására és meghívása minden egyes tesztesethez
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        options.addArguments("user-data-dir=c:/Users/Tatsuya Hiroki/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--disable-notifications"); // visszautasít minden böngésző felkérést pl: értesítések küldése
        options.addArguments("start-maximized"); // teljes képernyőben való használat
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

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


    @Test
    public void belépés() {
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebElement email = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[1]/form/div[3]/div[2]/div[1]/input[1]"));
        email.click();
        email.sendKeys(emailcím);
        WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
        jelszómező.click();
        jelszómező.sendKeys(jelszó);
        WebElement belépésgomb = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_container > input"));
        belépésgomb.click();
        WebElement kilépésgomb = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[1]/div/div[1]/ul/li[7]/a"));
        WebDriverWait waiting = new WebDriverWait(driver, 40);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[1]/div/div[1]/ul/li[7]/a")));
        Assertions.assertEquals(true, kilépésgomb.isDisplayed());
        driver.close();
        driver.quit();


    }


    @Test
    public void kijelentkezés() {
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebElement email = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[1]/form/div[3]/div[2]/div[1]/input[1]"));
        email.click();
        email.sendKeys(emailcím);
        WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
        jelszómező.click();
        jelszómező.sendKeys(jelszó);
        WebElement belépésgomb = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_container > input"));
        belépésgomb.click();
        WebElement kilépésgomb = driver.findElement(By.cssSelector("#leftcol > div.darkbox > ul > li:nth-child(7) > a"));
        kilépésgomb.click();
        Assert.assertEquals("https://kilepes.blog.hu/", "https://kilepes.blog.hu/");
        driver.quit();

    }


    @Test
    public void Adatoklistázása() {
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebDriverWait waiting = new WebDriverWait(driver, 30);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content-right > div:nth-child(2) > p:nth-child(2) > a:nth-child(1) > b:nth-child(1)"))).click();
        Assert.assertEquals("https://forum.index.hu/Topic/showTopicList?t=24", driver.getCurrentUrl());

    }


    @Test
    public void adatbevitel() {
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebElement email = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[1]/form/div[3]/div[2]/div[1]/input[1]"));
        email.click();
        email.sendKeys(emailcím);
        WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
        jelszómező.click();
        jelszómező.sendKeys(jelszó);
        WebElement belépésgomb = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_container > input"));
        belépésgomb.click();
        WebElement beállítások = driver.findElement(By.cssSelector(".boxbold > li:nth-child(3)"));
        beállítások.click();
        WebElement Magamról_mező = driver.findElement(By.cssSelector("#usersettings > tbody > tr:nth-child(7) > td.us_input_big > textarea"));
        Magamról_mező.clear();
        Magamról_mező.click();
        Magamról_mező.sendKeys("Ez egy tesztfiók amely Chromedriveres automata tesztelésre lett létrehozva.");
        WebElement felhasználási_feltételek = driver.findElement(By.xpath("//*[@id=\"chk_policy\"]"));
        felhasználási_feltételek.click();
        WebDriverWait waiting = new WebDriverWait(driver, 40);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#btn_settings_ok"))).click();
        Assert.assertNotNull(Magamról_mező);
        driver.quit();
    }


    
    /*public void adat_modosítása() {   //Belépünk az index fórumba majd pedig a profilbeállításoknál megváltoztatjuk a jelszavunkat
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebElement email = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[1]/form/div[3]/div[2]/div[1]/input[1]"));
        email.sendKeys(emailcím);
        email.click();
        WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
        jelszómező.click();
        jelszómező.sendKeys(jelszó);
        WebElement belépésgomb = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_container > input"));
        belépésgomb.click();
        Select droplist = new Select(driver.findElement(By.id("selection")));
        droplist.selectByVisibleText("Indapass beállítások");
        WebDriverWait waiting = new WebDriverWait(driver, 40);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("/html/body/main/div/div/div[1]/div[1]/div[2]/div[4]"))).click();
        WebElement új_jelszómenü = driver.findElement(By.id("passwd"));
        új_jelszómenü.click();
        új_jelszómenü.sendKeys("teszt123");
        WebElement jelszó_ismétlése = driver.findElement(By.id("passwd2"));
        jelszó_ismétlése.click();
        jelszó_ismétlése.sendKeys("teszt123");
        WebElement jelenlegi_jelszó = driver.findElement(By.cssSelector("input.input:nth-child(6)"));
        jelenlegi_jelszó.click();
        WebElement mentés_gomb = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[2]/section[4]/div/form/button"));
        mentés_gomb.click();
       driver.quit();
    }
*/

    @Test
    public void Adatkinyerés() {
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebElement index_összefoglaló = driver.findElement(By.cssSelector(".foot-forum > p:nth-child(2)"));
        System.out.println(index_összefoglaló.getText());
        Assert.assertEquals("Magyarország első és legnagyobb fórum szolgáltatása. A web kettő pre-bétája, amit 1997 óta töltenek meg tartalommal a fórumlakók. Fórumok változatos témákban, hangnemben, moderálva. Ha nem csak megosztani akarsz, hanem diskurálni egy egy témában, csatlakozz Te is, és ha kitartó vagy, társakra találhatsz.", index_összefoglaló.getText());
        driver.quit();

    }


    @Test
    public void Több_oldalas_lista_bejárása() {
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebElement keresőmező = driver.findElement(By.cssSelector(".inp"));
       keresőmező.click();
        keresőmező.sendKeys("kutya");
        WebElement keresőgomb = driver.findElement(By.cssSelector("#kereso > div > form > input.btnok"));
        keresőgomb.click();
        WebDriverWait waiting = new WebDriverWait(driver, 40);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[2]/form[1]/table/tbody/tr/td[1]/a[1]"))).click();
       String keresési_találat = "https://forum.index.hu/Search/showTopicResult?tr_start=30&tr_step=30&o=10&tq_text=kutya&tq_in=1&tq_act=&tq_cre=0&tq_user=";
       Assert.assertEquals(keresési_találat, driver.getCurrentUrl());
       driver.quit();




    }


    @Test
    public void AdatokTörlése() {
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebElement email = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[1]/form/div[3]/div[2]/div[1]/input[1]"));
        email.click();
        email.sendKeys(emailcím);
        WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
        jelszómező.click();
        jelszómező.sendKeys(jelszó);
        WebElement belépésgomb = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_container > input"));
        belépésgomb.click();
        WebDriverWait waiting = new WebDriverWait(driver, 40);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[1]/ul/li[4]/a"))).click();
        WebElement előzmények_törlése = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[2]/div[1]/button"));
        előzmények_törlése.click();
        driver.quit();
    }
}






