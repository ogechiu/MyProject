import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signin {

    //Import the Selenium WebDriver
    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //Locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open Chrome browser
        driver = new ChromeDriver();

        //2. I asked selenium to open Page URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //Assertion @1
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
// I asked Selenium to rest for to avoid error
        Thread.sleep(1000);

        //3. Maximize the Chrome browser
        driver.manage().window().maximize();


    }

    @Test(priority = 0)
    public void Getpagetitle(){
        //5 I asked Chrome Driver to Get the Page title for Konga
        //Assertion @2
        String expectedTitle = "Buy Phones, Fashion, Electronics in Nigeria_Konga Online Shopping | Konga Online Shopping";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contains(actualTitle))
            //Pass
            System.out.println("Correct Webpage Title" + actualTitle);
        else
            //Fail
            System.out.println("Wrong Webpage Title");

    }
    @Test (priority = 1)
    public void clicklogin() throws InterruptedException {

        //6. I told Selenium to click login/Sign-up button to sign-in
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

        //Assertion @3 Verify that Users inputs the right url and his on the right Webpage
        String expectedUrl = "https://www.konga.com/account/login?return_url=/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage url");
        else
            //Fail
            System.out.println("Wrong Webpage url");

        //7. Wait global for page to fully loading
        Thread.sleep(5000);
    }



    @Test (priority = 2)
    public void signIn() throws InterruptedException {
        //8. Enter User Email and Password

        driver.findElement(By.id("username")).sendKeys("ogechimill@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Password@123");

        Thread.sleep(5000);
        //9. Click on the Login button to Sign-In
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();

        //Pass
        System.out.println("User logged in successfully");

        Thread.sleep(5000);

    }

    @Test (priority = 3)
    public void logout() throws InterruptedException {
        //10. Click on the My Account button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();

        Thread.sleep(2000);
        // Then Click on the Logout button to sign-up
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();

        //Pass
        System.out.println("User logged out successfully");
    }
    @AfterTest
    public void closeBrowser () {
        //Quit the browser
        driver.quit();

    }










}
