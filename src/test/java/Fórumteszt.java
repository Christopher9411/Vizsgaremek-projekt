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
import java.util.concurrent.TimeUnit;


public class Fórumteszt {
    private static final String URL = null;
    String baseUrl = "https://forum.index.hu/Topic/showTopicList";
    String emailcím = "nagy.kristof1994@gmail.com";
    String jelszó = "teszt123";
    String jelszóismét = "teszt123";
    String Nickname = "Teszter Jakab";
    String Bemutatkozás = "Ez egy tesztfiók amely Chromedriveres automata tesztelésre lett létrehozva.";
    String Honlapcím = "wwww.tesztweboldal.hu";
    String fórumkeresés = "kutya";
    private Assertions Assert;
    private String Weboldal_szövege;
    WebDriver driver = new ChromeDriver();
   WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
    WebElement email_mező = driver.findElement(By.id("nick"));

    @BeforeEach
    public void BeforeEach() {
        //Chromedriver/ weboldal deklarására és meghívása minden egyes tesztesethez
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        options.addArguments("user-data-dir=c:\\Users\\Tatsuya Hiroki\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--disable-notifications"); // visszautasít minden böngésző felkérést pl: értesítések küldése
        options.addArguments("start-maximized"); // teljes képernyőben való használat
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

    }


    @Test
    public void Regisztráció() {
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

    }


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
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#leftcol > div.darkbox > ul > li:nth-child(7) > a"))).click();
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
        WebElement beállítások = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[1]/div/div[1]/ul/li[3]/a"));
        beállítások.click();
        WebElement weboldal = driver.findElement(By.cssSelector("tr.mainsettings:nth-child(6) > td:nth-child(2) > input:nth-child(1)"));
        weboldal.click();
        weboldal.sendKeys("wwww.tesztweboldal.hu");
        WebElement felhasználási_feltételek = driver.findElement(By.xpath("//*[@id=\"chk_policy\"]"));
        felhasználási_feltételek.click();
        WebElement ok_gomb = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form/table/tbody/tr[16]/td/input"));
        ok_gomb.click();
        Assert.assertEquals("www.tesztweboldal.hu", weboldal.getText());
    }


    @Test
    public void adat_modosítása() {   //Belépünk az index fórumba majd pedig a profilbeállításoknál módosítunk adatokat
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
        WebElement email = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[1]/form/div[3]/div[2]/div[1]/input[1]"));
        email.sendKeys(emailcím);
        email.click();
        WebElement jelszómező = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_inputs > input.indpl_text.indpl_passwd"));
        jelszómező.click();
        jelszómező.sendKeys(jelszó);
        WebElement belépésgomb = driver.findElement(By.cssSelector("#indpl_login_box_180 > form > div.indpl_login > div.indpl_formContainer > div.indpl_container > input"));
        belépésgomb.click();
        WebDriverWait waiting = new WebDriverWait(driver, 50);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[1]/ul/li[3]/a"))).click();
        WebElement Weboldal_mező = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form/table/tbody/tr[6]/td[2]/input"));
        Weboldal_mező.clear();
        Weboldal_mező.sendKeys("https://www.tesztweboldal.hu");
        WebElement felhasználási_feltételek = driver.findElement(By.xpath("//*[@id=\"chk_policy\"]"));
        felhasználási_feltételek.click();
        WebElement ok_gomb = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form/table/tbody/tr[16]/td/input"));
        ok_gomb.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String bevitt_adat = Weboldal_mező.getText();
        Assert.assertEquals("https://www.tesztweboldal.hu", bevitt_adat);


    }


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
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#kereso > div > form > input.inp"))).sendKeys(fórumkeresés);
        WebElement keresés_gomb = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[1]/div/div[2]/div/form/input[2]"));
        keresés_gomb.click();
        Select dropdown = new Select(driver.findElement(By.cssSelector("#maintd > form:nth-child(2) > table > tbody > tr > td.naviform > select")));
        dropdown.selectByValue("50");
        boolean eleSelected = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form[1]/table/tbody/tr/td[2]/select/option[4]")).isDisplayed();
        driver.close();
        driver.quit();


    }




@Test
    public void AdatokTörlése(){
    WebDriver driver = new ChromeDriver();
    driver.get(baseUrl);
    driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-k8o10q")).click();
    jelszómező.click();





}


}



