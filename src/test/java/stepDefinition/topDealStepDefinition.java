package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.TextContextSetup;

import java.util.Iterator;
import java.util.Set;

public class topDealStepDefinition {
    TextContextSetup textContextSetup;
    public String offerPageProductName;

    public topDealStepDefinition(TextContextSetup textContextSetup){
        this.textContextSetup=textContextSetup;
    }
    @Then("user searched for {string} shortname in top deals page")
    public void user_searched_for_shortname_in_top_deals_page(String shortName) throws InterruptedException {
        textContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = textContextSetup.driver.getWindowHandles();
        Iterator<String> I1 = s1.iterator();
        String pwindow = I1.next();
        String cwindow = I1.next();
        textContextSetup.driver.switchTo().window(cwindow);

        textContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = textContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();

    }

    @Then("Compare full name of product fetched from both pages")
    public void Compare_full_name_of_product_fetched_from_both_pages(){
        Assert.assertEquals(offerPageProductName,textContextSetup.homePageProductPage);
    }
}
