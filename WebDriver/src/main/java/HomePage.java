import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for page market.yandex.ru
 */

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[1]/noindex/div/div/div[1]/a[1]")
    private WebElement logoYandex;

    @FindBy(xpath = "/html/body/div[1]/div[1]/noindex/div/div/div[1]/a[2]")
    private WebElement logoMarket;

    @FindBy(xpath = "//*[@id=\"header-search\"]")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[1]/div[1]/noindex/div/div/div[2]/div/div[1]/form/span[2]/button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkPage(String logo1, String logo2) {
        return logoYandex.getText().equals(logo1) && logoMarket.getText().equals(logo2);
    }

    public SearchResultPage searchFor(String searchPosition) {
        searchField.sendKeys(searchPosition);
        searchButton.submit();
        return PageFactory.initElements(driver, SearchResultPage.class);
    }

    public static HomePage navigateTo(WebDriver driver) {
        driver.get("https://market.yandex.ru");
        return PageFactory.initElements(driver, HomePage.class);
    }

}
