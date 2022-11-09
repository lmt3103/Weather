import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.image.renderable.ParameterBlock;
import java.security.Key;

/*
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
 */

public class YourNickOnGitHubTest {

    //TC_11_01
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню Guide
    //3.  Подтвердить, что вы перешли на страницу со ссылкой
    // https://openweathermap.org/guide и что title этой страницы
    // OpenWeatherMap API guide - OpenWeatherMap
    @Test
    public void testGoToGuide() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";

        String expectedResultUrl = "https://openweathermap.org/guide";
        String expectedResultTitle = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement imgHamb = driver.findElement(
                By.xpath("//nav[@id='nav-website']//img[@src='/themes/openweathermap/assets/img/owm_icons/icon_hamburger.svg']")
        );
        imgHamb.click();

        WebElement searchLinkGuide = driver.findElement(
                By.xpath("//nav[@id='nav-website']//ul[@id = 'mobile-menu']//a[@href='/guide']")
        );

        searchLinkGuide.click();
        Thread.sleep(2000);

        WebElement title = driver.findElement(
                By.xpath("//head//title")
        );

        Thread.sleep(2000);

        String ActualResultUrl = driver.getCurrentUrl();
        //String ActualResultTitle = title.getText();
        String ActualResultTitle = driver.getTitle();


        Assert.assertEquals(ActualResultUrl, expectedResultUrl);
        Assert.assertEquals(ActualResultTitle, expectedResultTitle);


        driver.quit();

    }

//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Подтвердить, что температура для города показана в Фарингейтах
    @Test
    public void testUnitsTemp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";

        String expectedResult = "F";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchImperial = driver.findElement(
                By.xpath("//div[text() = 'Imperial: °F, mph']")
        );
        searchImperial.click();

        WebElement tempF = driver.findElement(
                By.xpath("//div[@class = 'current-temp']/span[@class = 'heading']")
        );
        String f = tempF.getText();
        f = f.substring(f.length() - 1, f.length());

        String actualResult = f;

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

    //TC_11_03
    //1.  Открыть базовую ссылку
    //2. Подтвердить, что внизу страницы есть панель с текстом
    // “We use cookies which are essential for the site to work.
    // We also use non-essential cookies to help us improve our services.
    // Any data collected is anonymised. You can allow all cookies or manage
    // them individually.”
    //3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и
    // “Manage cookies”
    @Test
    public void testPanelCookies() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";

        String expectedResultPanel = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. " +
                "Any data collected is anonymised. " +
                "You can allow all cookies or manage them individually.";

        String expectedResultButton1 = "Allow all";
        String expectedResultButton2 = "Manage cookies";

        driver.get(url);
        Thread.sleep(5000);

        WebElement panel = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//p[@class = 'stick-footer-panel__description']")
        );
        WebElement button1 = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//button[@class = 'stick-footer-panel__link']")
        );
        WebElement button2 = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//a[@href = '/cookies-settings']")
        );

        String actualResultPanel = panel.getText();
        String actualResultButton1 = button1.getText();
        String actualResultButton2 = button2.getText();

        Assert.assertEquals(actualResultPanel,expectedResultPanel);
        Assert.assertEquals(actualResultButton1,expectedResultButton1);
        Assert.assertEquals(actualResultButton2,expectedResultButton2);

        driver.quit();

    }

    //TC_11_04
    //1.  Открыть базовую ссылку
    //2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”,
    // “How to start” и “Ask a question”
    @Test
    public void testMenuSupport() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResultF = "FAQ";
        String expectedResultH = "How to start";
        String expectedResultA = "Ask a question";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);

        WebElement menuSupport = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        menuSupport.click();

        WebElement linkFaq = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[@href ='/faq']")
        );
        WebElement linkHow = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[@href ='/appid']")
        );
        WebElement linkAsk = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[@href ='https://home.openweathermap.org/questions']")
        );


        String actualResultF = linkFaq.getText();
        String actualResultH = linkHow.getText();
        String actualResultA = linkAsk.getText();

        Assert.assertEquals(actualResultF,expectedResultF);
        Assert.assertEquals(actualResultH,expectedResultH);
        Assert.assertEquals(actualResultA,expectedResultA);


        driver.quit();

    }
    //TC_11_05
    //1. Открыть базовую ссылку
    //2. Нажать пункт меню Support → Ask a question
    //3. Заполнить поля Email, Subject, Message
    //4. Не подтвердив CAPTCHA, нажать кнопку Submit
    //5. Подтвердить, что пользователю будет показана ошибка
    // “reCAPTCHA verification failed, please try again.”
    @Test
    public void testMistakeCaptcha() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String email = "tester@test.com";
        String subject = "Other";
        String message = "test";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);
        WebElement menuSupport = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        menuSupport.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(3000);

        WebElement linkAsk = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[@href ='https://home.openweathermap.org/questions']")
        );
        linkAsk.click();

        //driver.switchTo().window(driver.getWindowHandle());

        WebElement emailField = driver.findElement(By.id("question_form_email"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement subjectField = driver.findElement(By.id("question_form_subject"));
        subjectField.click();
        subjectField.sendKeys(subject);

        WebElement messageField = driver.findElement(By.id("question_form_message"));
        messageField.click();
        messageField.sendKeys(message);

        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-default']"));
        submitButton.click();

        //String actualResult = driver.getWindowHandle();

        //Assert.assertEquals(actualResult,expectedResult);

        driver.quit();

    }
    //TC_11_06
    //1.  Открыть базовую ссылку
    //2.  Нажать пункт меню Support → Ask a question
    //3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
    //4. Оставить пустым поле Email
    //5. Заполнить поля  Subject, Message
    //6. Подтвердить CAPTCHA
    //7. Нажать кнопку Submit
    //8. Подтвердить, что в поле Email пользователю будет показана
    // ошибка “can't be blank”
    @Test
    public void testMistakeEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String subject = "Other";
        String message = "test";
        String expectedResult = "can't be blank";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);
        WebElement menuSupport = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        menuSupport.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(3000);

        WebElement linkAsk = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[@href ='https://home.openweathermap.org/questions']")
        );
        linkAsk.click();

        //driver.switchTo().window(driver.getWindowHandle());

        WebElement subjectField = driver.findElement(By.id("question_form_subject"));
        subjectField.click();
        subjectField.sendKeys(subject);

        WebElement messageField = driver.findElement(By.id("question_form_message"));
        messageField.click();
        messageField.sendKeys(message);

        //Подтвердить CAPTCHA
        WebElement captchaField = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        captchaField.click();


        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-default']"));
        submitButton.click();

        //String actualResult = driver.getWindowHandle();

        //Assert.assertEquals(actualResult,expectedResult);

        driver.quit();

    }




    //TC_11_07
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //
    //3.  Нажать на единицы измерения Metric: °C, m/s
    //4.  Подтвердить, что в результате этих действий,
    // единицы измерения температуры изменились с F на С
    @Test
    public void testChangeTemp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResultTempF = "F";
        String expectedResultTempC = "C";

        driver.get(url);
        Thread.sleep(5000);

        WebElement linkImp = driver.findElement(
                By.xpath("//div[text() = 'Imperial: °F, mph']")
        );
        linkImp.click();
        Thread.sleep(2000);
        WebElement showUnit = driver.findElement(
                By.xpath("//div[@class = 'current-temp']/span[@class = 'heading']")
        );

        String f = showUnit.getText();
        String actualResultF = f.substring(f.length() - 1, f.length());


        WebElement linkMetr = driver.findElement(
                By.xpath("//div[text() = 'Metric: °C, m/s']")
        );
        linkMetr.click();
        Thread.sleep(2000);

        String c = showUnit.getText();
        String actualResultC = c.substring(c.length() - 1, c.length());

        Assert.assertEquals(actualResultF,expectedResultTempF);
        Assert.assertEquals(actualResultC,expectedResultTempC);

        driver.quit();

    }

    //TC_11_08
    //1.  Открыть базовую ссылку
    //2.  Нажать на лого компании
    //
    //3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить,
    // что текущая ссылка не изменилась
    @Test
    public void testLogo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);

        WebElement logo = driver.findElement(
                By.xpath("//ul[@id='first-level-nav']//img")
        );
        logo.click();

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult,expectedResult);


        driver.quit();
    }

    //TC_11_09
    //1.  Открыть базовую ссылку
    //2.  В строке поиска в навигационной панели набрать “Rome”
    //
    //3.  Нажать клавишу Enter
    //4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся
    // слова “find” и “Rome”
    //5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”
    @Test
    public void testSearchRome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String cityName = "Rome";
        String expectedResultStr = "Rome";

        driver.get(url);
        Thread.sleep(5000);

        WebElement imgHamb = driver.findElement(
                By.xpath("//nav[@id='nav-website']//img[@src='/themes/openweathermap/assets/img/owm_icons/icon_hamburger.svg']")
        );
        imgHamb.click();

        WebElement search = driver.findElement(
                By.xpath("//ul[@id='mobile-menu']//input[@type = 'text']")
        );
        search.click();
        search.sendKeys(cityName);
        search.sendKeys(Keys.RETURN);

        WebElement findRome = driver.findElement(
                By.xpath("//input[@id = 'search_str']")
        );

        String actualResultStr = findRome.getText();

        Assert.assertEquals(actualResultStr,expectedResultStr);

        driver.quit();

    }
//TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь
// видит 30 оранжевых кнопок
    @Test
    public void testMenuApiButtons() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oper\\Desktop\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        int expectedResult = 30;

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);

        WebElement menuApi = driver.findElement(
                By.xpath("//div[@id='desktop-menu']//a[@href='/api']")
        );
        menuApi.click();

//        int countButtons = driver.findElement(
//                By.xpath("//a[contains(@class, 'btn_block orange round') " +
//                        "or contains(@class, 'ow-btn round btn-orange') ]")).getSize();
        WebElement countButtons = driver.findElement(
                By.xpath("//a[contains(@class, 'btn_block orange round') " +
                        "or contains(@class, 'ow-btn round btn-orange') ]"));
        //int actualResult = countButtons.getSize();

        //Assert.assertEquals(actualResult,expectedResult);

        driver.quit();

    }

}
