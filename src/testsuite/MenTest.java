package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //* Mouse Hover on Men Menu
        //* Mouse Hover on Bottoms
        //* Click on Pants
        WebElement text1 = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
        WebElement text2 = driver.findElement(By.xpath("//a[@id='ui-id-18']"));
        WebElement text3 = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[text()='Pants']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(text1).moveToElement(text2).moveToElement(text3).click().build().perform();


        // * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"),By.xpath("//div[@id='option-label-size-143-item-175']"));
        Thread.sleep(1000);
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"),By.xpath("//div[@id='option-label-color-93-item-49']"));
        Thread.sleep(1000);

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"),By.xpath("//span[text()='Add to Cart']"));
        Thread.sleep(1000);

        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("Text is not displayed",expectedText,actualText);
        Thread.sleep(1000);

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);

        //* Verify the text ‘Shopping Cart.’
        String expectedText1 = "Shopping Cart";
        String actualText1 = getTextFromElement(By.xpath("//h1[@class='page-title']"));
        Assert.assertEquals("Text is not displayed",expectedText1,actualText1);
        Thread.sleep(1000);

        //* Verify the product name ‘Cronus Yoga Pant’
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Text is not displayed",expectedText2,actualText2);
        Thread.sleep(1000);

        //* Verify the product size ‘32’
        String expectedText3 = "32";
        String actualText3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("Text is not displayed",expectedText3,actualText3);
        Thread.sleep(1000);

        //* Verify the product colour ‘Black’
        String expectedText4 = "Black";
        String actualText4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Text is not displayed",expectedText4,actualText4);
        Thread.sleep(1000);

    }

    @After
    public void tearDown(){
//        closeBrowser();
    }
}
