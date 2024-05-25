package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
//import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.logging.Level;

public class TestCases {
    WebDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--disable-notifications");

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

//    //button[@jsname = 'jnPWCc']
//    //ul[@jsname = 'rymPhb']/li
//    //div[@data-datekey = '27689']
//    //button[@class = 'nUt0vb zmrbhe']
//    //input[@placeholder = 'Add title and time']
//    //textarea[@placeholder = 'Add description']
//    //button[@jsname = 'x8hlje']

    
    public void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        String currURL = driver.getCurrentUrl();
        System.out.println("Current URL --> "+currURL);
        if(currURL.contains("calendar")){
            System.out.println("TestCase 01: Passed");
        }else{
            System.out.println("TestCase 01: Failed");
        }
        System.out.println("End Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Start Test case: testCase02");
        driver.get("https://calendar.google.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@jsname = 'jnPWCc']")).click();
        Thread.sleep(3000);
        List<WebElement> dropDown = driver.findElements(
                By.xpath("//ul[@jsname = 'rymPhb']/li")
        );
        for(WebElement element: dropDown){
            String elementText = element.getText();
            if(elementText.contains("Month")){
                element.click();
                Thread.sleep(3000);
                break;
            }
        }
              
        WebElement taskSet = driver.findElement(By.xpath("//div[@data-datekey = '27689']"));
//        js.executeScript("arguments[0].click();", taskSet);
        taskSet.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='x5FT4e kkUTBb'][normalize-space()='Task']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder = 'Add title and time']"))
                        .sendKeys("Crio INTV Task Automation");
                        Thread.sleep(5000);
        driver.findElement(By.xpath("//textarea[@aria-label='Add description']"))
                        .sendKeys("Crio INTV Calendar Task Automation");

        driver.findElement(By.xpath("//button[@jsname = 'x8hlje']")).click();
        Thread.sleep(5000);

        WebElement verificationElement = driver.findElement(By.xpath(
                "//div[@jscontroller = 'NAKBTc']/div[@style = 'background-color: rgb(66, 133, 244);']/span/span[@class = 'yzifAd']"
        ));
        String eleText = verificationElement.getText();
        if(eleText.contains("Crio INTV Task Automation")){
            System.out.println("TestCase 02: Passed");
        }
        else {
            System.out.println("TestCase 02: Failed");
        }

        System.out.println("End Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        Thread.sleep(5000);
        driver.get("https://calendar.google.com/");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement TaskButton01 = driver.findElement(By.xpath(
                "//div[@jscontroller = 'NAKBTc']/div[@style = 'background-color: rgb(66, 133, 244);']"
        ));
//        js.executeScript("arguments[0].click();", TaskButton);
        TaskButton01.click();
        Thread.sleep(5000);
//        //button[@aria-label = 'Edit task']
        driver.findElement(By.xpath("//button[@aria-label = 'Edit task']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder = 'Add description']"))
                .sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        driver.findElement(By.xpath("//button[@jsname = 'x8hlje']")).click();
        Thread.sleep(5000);
//        js.executeScript("arguments[0].click();", TaskButton);
        WebElement TaskButton02 = driver.findElement(By.xpath(
                "//div[@jscontroller = 'NAKBTc']/div[@style = 'background-color: rgb(66, 133, 244);']"
        ));
        TaskButton02.click();
        Thread.sleep(5000);
        WebElement verification = driver.findElement(By.xpath("//div[@class = 'toUqff D29CYb']"));
        String verificationText = verification.getText();
        if(verificationText.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")){
            System.out.println("TestCase 03: Passed");
        }
        else {
            System.out.println("TestCase 03: Failed");
        }

        System.out.println("End Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        Thread.sleep(5000);
        driver.get("https://calendar.google.com/");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement TaskButton01 = driver.findElement(By.xpath(
                "//div[@jscontroller = 'NAKBTc']/div[@style = 'background-color: rgb(66, 133, 244);']"
        ));
//        js.executeScript("arguments[0].click();", TaskButton);
        TaskButton01.click();
        Thread.sleep(5000);
        WebElement verification = driver.findElement(By.xpath("//div[@class = 'toUqff ']/span[@role = 'heading']"));
        String verificationText = verification.getText();
        if(verificationText.contains("Crio INTV Task Automation")){
            System.out.println("TestCase 04: Step-1 Passed");
            driver.findElement(By.xpath("//button[@aria-label = 'Delete task']")).click();
            WebElement taskDeleted = driver.findElement(By.xpath("//div[@class = 'VYTiVb']"));
            String taskDelText = taskDeleted.getText();
            if(taskDelText.contains("Task deleted")){
                System.out.println("TestCase 04: Step-2 Passed");
                System.out.println("TestCase 04: Passed");
            }
            else {
                System.out.println("TestCase 04: Step-2 Failed");
            }

        }else {
            System.out.println("TestCase 04: Failed");
        }
        System.out.println("End Test case: testCase04");
//        //button[@aria-label = 'Delete task']
}


}