package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TextContextSetup;
public class landingPageStepDefinition {
    TextContextSetup textContextSetup;
    public WebDriver driver;
    public String homePageProductPage;
    public String offerPageProductName;

    public landingPageStepDefinition(TextContextSetup textContextSetup){
        this.textContextSetup=textContextSetup;
    }
    @Given("User is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        textContextSetup.driver = new ChromeDriver();
        textContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched for shortname {string} and fetch the full name of product")
    public void user_searched_for_shortname_and_fetch_the_full_name_of_product(String shortName) throws InterruptedException {
        textContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        textContextSetup.homePageProductPage = textContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println("Full name : "+textContextSetup.homePageProductPage );
    }


}
