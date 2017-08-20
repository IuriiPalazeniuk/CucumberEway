package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Acer on 14.08.2017.
 */


public class MyStepdefs {

    static WebDriver driver;

    private String choseCity = ".//*[@id='city']";
    private String vinnitsa = ".//*[@id='cities-link-vinnytsia']";
    private String easyWay = "http://eway.in.ua";
    private String startStreet = ".//*[@id='from']";
    private String addSreetFrom = "html/body/div[2]/ul/li[1]";
    private String addStreetTo = "html/body/div[3]/ul/li[1]";
    private String endStreet = ".//*[@id='to']";
    private String st600let = "600річчя";
    private String stPrivokzalnaya = "Привокзальна";
    private String makeRoute = "//span [@class='menu-go-button-center-span']";
    private String bestResult = "//span [@class='result_num_right_span']";

    @Before
    public  void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Given("^I go to easyWay page$")
    public void iGoToEasyWayPage(){
        driver.get(easyWay);
    }
    @And("^I chose Vinnitsa city$")
    public void iChoseVinnitsaCity(){
       driver.findElement(By.xpath(choseCity)).click();
       driver.findElement(By.xpath(vinnitsa)).click();
    }

    @When("^Add streets$")
    public void addStreets() {
        driver.findElement(By.xpath(startStreet)).sendKeys(st600let);
        driver.findElement(By.xpath(addSreetFrom)).click();
        driver.findElement(By.xpath(endStreet)).sendKeys(stPrivokzalnaya);
        driver.findElement(By.xpath(addStreetTo)).click();
    }

    @And("^Press make a route$")
    public void pressMakeARoute(){
        driver.findElement(By.xpath(makeRoute)).click();
    }

    @Then("^I check best result$")
    public void iCheckBestResult(){
        Assert.assertTrue(driver.findElements( By.xpath(bestResult) ).size() != 0);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
