import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumTests {



    //import the selenium WebDriver
    private WebDriver driver;

    @Test (priority = 0)
    public void setUp() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        //1. Open your Chrome browser
         driver = new ChromeDriver(options);

        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");

        //TEST 1. Verify that the URL leads to the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Invalid Webpage");

        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void SignUpButtonTest() throws InterruptedException {
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

        //TEST 2. Verify that signup button leads to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
        //pass
        System.out.println("SignUp button leads to SignUp page");
        else
        //fail
        System.out.println("Invalid SignUP button");

        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void PositiveSignUpTest() throws InterruptedException {
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("francistestimony199");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("testimonydefact599@gmail.com");
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("Password@199");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();

        //TEST 3. Verify that user can sign up successfully when they input valid details
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //pass
            System.out.println("SignUp Successful");
        else
            //fail
            System.out.println("SignUp Failed");

        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void ClickUser1Item() throws InterruptedException {
        //9. Click on the User1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);


        //TEST 4. Verify that User1 item is present on the item list page
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/2";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Item User1 present");
        else
            //fail
            System.out.println("Item User1 not present");

    }


    @Test (priority = 4)
       public void verifyitem() throws InterruptedException {
        //10. Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //TEST 5. Verify that the item searched for on the User1 page is present
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users";
        String actualPageUrl = driver.getCurrentUrl();

        if (expectedPageUrl.contains(actualPageUrl))
            //pass
            System.out.println("Item present");
        else
            //fail
            System.out.println("Item not present");


    }

    @Test (priority = 5)
    public void LogoutTest() throws InterruptedException {
        //11. Click on Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(5000);

        //TEST 6. Verify that user is directed back to home page when they log out
        String expectedUrl = "https://selenium-blog.herokuapp.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("LogOut button leads user back to home page");
        else
            //fail
            System.out.println("LogOut button does not lead user back to home page");

    }

    @Test (priority = 6)
    public void UserNameLessThan3Characters() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Input username of less than 3 characters on the username field
        driver.findElement(By.id("user_username")).sendKeys("fr");



    }

    @Test (priority = 7)
    public void InvalidEmailTest() throws InterruptedException {
        //Input an invalid email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("");

    }

    @Test (priority = 8)
    public void EmptyFieldTest() throws InterruptedException {
        //Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("1");
    Thread.sleep(3000);
        //Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);

        //TEST 7. Verify that user cannot signup with username less than 3 characters
        String expectedUrl = "https://selenium-blog.herokuapp.com/users";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("User cannot sign up with username less than 3 characters");
        else
            //fail
            System.out.println("User can sign up with username less than 3 characters");

        //TEST 8. Verify that user cannot sign up with invalid email
        String ExpectedUrl = "https://selenium-blog.herokuapp.com/users";
        String ActualUrl = driver.getCurrentUrl();
        if (ActualUrl.contains(ExpectedUrl))
            //pass
            System.out.println("User cannot sign up with invalid email");
        else
            //fail
            System.out.println("User can sign up with invalid email");


        //TEST 9. Verify that user cannot sign up with any/all fields blank
        String expectedURl = "https://selenium-blog.herokuapp.com/users";
        String actualURl = driver.getCurrentUrl();
        if (actualURl.contains(expectedURl))
            //pass
            System.out.println("User cannot sign up with a blank field");
        else
            //fail
            System.out.println("User can sign up with a blank field");



    }

    @Test (priority = 9)
    public void NegativeLogin() throws InterruptedException {
     //Go back to home page
    driver.findElement(By.xpath("//*[@id=\"logo\"]")).click();
    Thread.sleep(5000);
    //Click the login button
    driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
    Thread.sleep(5000);
    //Input valid your email
    driver.findElement(By.id("session_email")).sendKeys("testimonydefact0@gmail.com");
    //Input password of only one character
    driver.findElement(By.id("session_password")).sendKeys("1");
    //Click the login button
    driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div/input")).click();
    Thread.sleep(5000);

        //TEST 10. Verify user cannot login with password less than or equal to one character
        String expectedID = "flash_danger";
        String actualID = String.valueOf(driver.findElement(By.id("flash_danger")));
        if (actualID.contains(expectedID))
            //pass
            System.out.println("User cannot login with password of just 1 character");
        else
            //fail
            System.out.println("User can login with password of just 1 character");








    }

     @AfterTest
     public void closeBrowser() {
    //Quit the browser
    driver.quit();

     }

}