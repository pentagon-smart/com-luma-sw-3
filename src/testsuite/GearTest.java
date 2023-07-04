package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //* Mouse Hover on Gear Menu
        //* Click on Bags
        mouseHover(By.xpath("//span[contains(text(),'Gear')]"),By.xpath("//a[@id='ui-id-25']"));
        Thread.sleep(1000);

        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        //* Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        Assert.assertEquals("Text is not displayed",expectedText,actualText);
        Thread.sleep(1000);

        //* Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendKeyToElement(By.xpath("//input[@id='qty']"),"3");
        Thread.sleep(1000);

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));

        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’

        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals("Text is not displayed",expectedText1,actualText1);
        Thread.sleep(1000);

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);

        //* Verify the product name ‘Cronus Yoga Pant’
//        String expectedText2 = "";
//        String actualText2 = getTextFromElement(By.xpath("//strong[@class='product-item-name']//a[contains(text(),'Cronus Yoga Pant')]"));
//        Assert.assertEquals("Text is not displayed",expectedText2,actualText2);
//        Thread.sleep(1000);

        //* Verify the Qty is ‘3’
//        String expectedText3 = "3";
//        String actualText3 = getTextFromElement(By.xpath("//input[@class='input-text qty']"));
//        Assert.assertEquals("Text is not displayed",expectedText3,actualText3);
//        Thread.sleep(1000);

        //* Verify the product price ‘$135.00’
        String expectedText4 = "$135.00";
        String actualText4 = getTextFromElement(By.xpath("//td[@class='col subtotal']//span[text()='$135.00']"));
        Assert.assertEquals("Text is not displayed",expectedText4,actualText4);
        Thread.sleep(1000);

        //* Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendKeyToElement(By.xpath("//input[@class='input-text qty']"),"5");

        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //* Verify the product price ‘$225.00’

        String expectedText5 = "$225.00";
        String actualText5 = getTextFromElement(By.xpath("//td[@class='col subtotal']//span[text()='$225.00']"));
        Assert.assertEquals("Text is not displayed",expectedText5,actualText5);
        Thread.sleep(1000);

    }

    @After
    public void tearDown(){
//        closeBrowser();
    }
}
