package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyTheSortByProductNameFilter(){
        //* Mouse Hover on Women Menu
        //* Mouse Hover on Tops
        //* Click on Jackets
        WebElement text1 = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement text2 = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement text3 = driver.findElement(By.xpath("//span[text()='Jackets']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(text1).moveToElement(text2).moveToElement(text3).click().build().perform();


        //* Select Sort By filter “Product Name”
        selectByValue(By.xpath("//select[@id='sorter']"), "name");

        //* Verify the products name display in alphabetical order
        List<WebElement> productsName = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        System.out.println("Product List in ascending order : ");
        for (WebElement products: productsName)
        {
            System.out.println(products.getText());
        }
    }

    @Test
    public void verifyTheSortByPriceFilter(){
        //* Mouse Hover on Women Menu
        //* Mouse Hover on Tops
        //* Click on Jackets
        WebElement text1 = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement text2 = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement text3 = driver.findElement(By.xpath("//span[text()='Jackets']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(text1).moveToElement(text2).moveToElement(text3).click().build().perform();


        //* Select Sort By filter “Price”
        selectByValue(By.xpath("//select[@id='sorter']"), "price");

        //* Verify the products price display in Low to High
        List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        System.out.println("Products price is display in Low to High : ");
        for (WebElement products: productsPrice)
        {
            System.out.println(products.getText());
        }
    }

    @After
    public void tearDown(){
//        closeBrowser();
    }
}
