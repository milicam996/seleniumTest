package Mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mmusulin\\Downloads\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //Maximize the browser window
        driver.manage().window().maximize();

        //Navigate to “https://demo.guru99.com/test/newtours/”.
        driver.get("https://demo.guru99.com/test/newtours/");

        //Login with created user.
        WebElement username = driver.findElement(By.name("userName"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.name("submit"));
        username.sendKeys("milica996");
        password.sendKeys("milica996");
        login.click();
        String actualUrl = "https://demo.guru99.com/test/newtours/login_sucess.php";
        String expectedUrl = driver.getCurrentUrl();

        if (actualUrl.contentEquals(expectedUrl)) {
            System.out.println("User is Logged in!");
        } else {
            System.out.println("User in not Logged in.");
        }

    //Navigate to Home page
        driver.get("https://demo.guru99.com/test/newtours/");

    //Check that tour Tips are displayed.
        WebElement i = driver.findElement
                (By.xpath("//img[@src=\"images/hdr_tips.gif\"]"));

        Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

        if (p) {
            System.out.println("Tour Tips is displayed!");
        } else {
            System.out.println("Tour Tips is not displayed.");
        }

    //Navigate to the 'Destinations' link
        String url = "https://demo.guru99.com/test/newtours/support.php";

    //Print the URL of the current page.
        driver.get(url);
        String strUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:" + strUrl);

    //Navigate back to the Homepage.
        driver.get("https://demo.guru99.com/test/newtours/index.php");

    //Sign out.
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement signout = driver.findElement(By.linkText("SIGN-OFF"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", signout);

        System.out.println("User is Logged out!");

    //Thread.sleep(4000);

        driver.quit();

    }

}







