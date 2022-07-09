package Mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testCase {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mmusulin\\Downloads\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //Maximize the browser window
        driver.manage().window().maximize();

        //Title
        driver.get("https://demo.guru99.com/test/newtours/");
        String title = driver.getTitle();
        System.out.println("Title is " + title);
        String expectedTitle = "Welcome: Mercury Tours";

        if (title.contentEquals(expectedTitle)) {
            System.out.println("Title is the same!");
        } else {
            System.out.println("Wrong title is " + title);
        }

        //testing if you can log in without credentials
        driver.get("https://demo.guru99.com/test/newtours/");

        WebElement username = driver.findElement(By.name("userName"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.name("submit"));
        username.sendKeys("");
        password.sendKeys("");
        login.click();
        String actualUrl = "https://demo.guru99.com/test/newtours/login_sucess.php";
        String expectedUrl = driver.getCurrentUrl();

        if (actualUrl.contentEquals(expectedUrl)) {
            System.out.println("Test failed. User is Logged in.");
        } else {
            System.out.println("Test passed. User in not Logged in.");
        }

        driver.quit();
    }
}
