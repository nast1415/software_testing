import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class YandexTest {
    @Test
    public void testCompare() {
        // Find chrome driver and create new web driver
        File file = new File("C:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();

        // Set time for waiting elements loading
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // First go to 'market.yandex.ru' page
        HomePage homePage = HomePage.navigateTo(driver);
        // Check that the right page was loaded
        assertTrue(homePage.checkPage("Яндекс", "Маркет"));
        // Tape 'Apple smartphones' into the search textbox, press 'find' button and go to SearchResultPage
        SearchResultPage searchResultPage = homePage.searchFor("apple smartphones");
        // Check that the right page was loaded
        assertTrue(searchResultPage.checkPage("Мобильные телефоны"));

        // Add items to compare list, press 'compare' button and go to CompareInfoPage
        CompareInfoPage compareInfoPage = searchResultPage.comparePositions();
        // Check that the right page was loaded
        assertTrue(compareInfoPage.checkPage("Сравнение товаров"));
        // Check that 'different attributes' selector works correctly
        assertTrue(compareInfoPage.checkDifferentAttributes());
        // Press 'all attributes'
        compareInfoPage = compareInfoPage.selectAllAttributes();
        // Check that 'all attributes' selector works correctly
        assertTrue(compareInfoPage.checkAllAttributes());
    }
}
