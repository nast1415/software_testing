import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for results of comparing
 */

public class CompareInfoPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div/div[3]/h1")
    private WebElement titleCompare;

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[5]/div[18]/div")
    private WebElement attribute1;

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[5]/div[19]/div")
    private WebElement attribute2;

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[5]/div[21]/div")
    private WebElement attribute3;

    @FindBy(xpath = "/html/body/div/div[4]")
    private WebElement attribute4;

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[5]/div[2]/div/div[1]")
    private WebElement sameAttribute1;

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[5]/div[3]/div/div[1]")
    private WebElement sameAttribute2;

    @FindBy(xpath = "/html/body/div/div[4]/div[2]/div[5]/div[5]/div/div[1]")
    private WebElement sameAttribute3;

    @FindBy(xpath = "/html/body/div/div[4]/div[1]/div[2]/div[1]/span[3]/span")
    private WebElement allAttributes;


    public CompareInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkPage(String title) {
        return titleCompare.getText().equals(title);
    }

    public Boolean checkDifferentAttributes() {
        Boolean flag = true;
        Double value1 = 0.0;
        Double value2 = 0.0;
        Double value3 = 0.0;

        String text = attribute1.getText();
        text = text.split("ШИРИНА\n")[1];
        value1 = Double.parseDouble(text.split(" мм")[0]);
        value2 = Double.parseDouble(text.split(" мм")[1]);
        value3 = Double.parseDouble(text.split(" мм")[2]);

        if ((value1.equals(value2)) && (value1.equals(value3)) && (value2.equals(value3))) {
            flag = false;
        }
        text = attribute2.getText();
        text = text.split("ВЫСОТА\n")[1];
        value1 = Double.parseDouble(text.split(" мм")[0]);
        value2 = Double.parseDouble(text.split(" мм")[1]);
        value3 = Double.parseDouble(text.split(" мм")[2]);

        if ((value1.equals(value2)) && (value1.equals(value3)) && (value2.equals(value3))) {
            flag = false;
        }

        text = attribute3.getText();
        text = text.split("ВЕС\n")[1];
        value1 = Double.parseDouble(text.split(" г")[0]);
        value2 = Double.parseDouble(text.split(" г")[1]);
        value3 = Double.parseDouble(text.split(" г")[2]);

        if ((value1.equals(value2)) && (value1.equals(value3)) && (value2.equals(value3))) {
            flag = false;
        }

        text = attribute4.getText();
        text = text.split("ДИАГОНАЛЬ ЭКРАНА\n")[1];
        value1 = Double.parseDouble(text.split(" \"")[0]);
        value2 = Double.parseDouble(text.split(" \"")[1]);
        value3 = Double.parseDouble(text.split(" \"")[2]);

        if ((value1.equals(value2)) && (value1.equals(value3)) && (value2.equals(value3))) {
            flag = false;
        }
        return flag;
    }

    public CompareInfoPage selectAllAttributes() {
        allAttributes.click();
        return PageFactory.initElements(driver, CompareInfoPage.class);
    }

    public Boolean checkAllAttributes() {
        Boolean flag = true;

        String text = sameAttribute1.getText();
        if (!text.equals("ТИП")) {
            flag = false;
        }

        text = sameAttribute2.getText();
        if (!text.equals("ОПЕРАЦИОННАЯ СИСТЕМА")) {
            flag = false;
        }

        text = sameAttribute3.getText();
        if (!text.equals("КОЛИЧЕСТВО SIM-КАРТ")) {
            flag = false;
        }
        return flag;
    }
}
