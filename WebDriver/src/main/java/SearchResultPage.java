import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for page - result of the mobile phones search
 */

public class SearchResultPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[1]/h1")
    private WebElement titleSmartphones;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div/div[2]/div/div/div/div/div/span[1]")
    private WebElement cmpBtn1;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div")
    private WebElement cmpBtn2;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[3]/div/div[2]/div/div/div/div/div/span[1]")
    private WebElement cmpBtn3;

    @FindBy(xpath = "/html/body/div[6]/div/div/div[3]/a")
    private WebElement showCompareInfoBtn;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkPage(String logo1) {
        return titleSmartphones.getText().equals(logo1);
    }

    public CompareInfoPage comparePositions() {
        cmpBtn1.click();
        cmpBtn2.click();
        cmpBtn3.click();

        showCompareInfoBtn.click();
        return PageFactory.initElements(driver, CompareInfoPage.class);
    }
}
