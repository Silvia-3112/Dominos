package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VegPizza_Page {
    WebDriver driver;
    JavascriptExecutor js;

    public VegPizza_Page(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@data-label='Veg Pizza']//span[text()='VEG PIZZA']")
    private WebElement vegPizza;

    @FindBy(xpath="//div[@data-label='Veg Pizza']//span[text()='Margherita']//parent::div//parent::div//button")
    private WebElement margeritaAddCartBtn;

    @FindBy(xpath="//button[@class='btn--gry']//span[text()='NO THANKS']")
    private WebElement noThanks;

    @FindBy(xpath="//div[@class='crt-itms']//div[@data-label='quantity']//div[@data-label='increase']")
    private WebElement margheritaIncBtn;

    @FindBy(xpath="//div[@data-label='Veg Pizza']//span[text()='Peppy Paneer']//parent::div//parent::div//button")
    private WebElement peppPaneerAddCartBtn;

    @FindBy(xpath="//div[@data-label='Veg Pizza']//div[@data-label='Peppy Paneer']//div[@data-label='increase']")
    private WebElement pepPaneerIncBtn;

    @FindBy(xpath="//div[@data-label='Veg Pizza']//span[text()='Cheese n Corn']//parent::div//parent::div//button")
    private WebElement CheeseNCornAddCartBtn;

    @FindBy(xpath="//div[@data-label='Veg Pizza']//div[@data-label='Cheese n Corn']//div[@data-label='increase']")
    private WebElement CheeseNCornIncBtn;

    @FindBy(xpath="//span[text()='Margherita']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement margheritaTotalPrice;

    @FindBy(xpath="//span[text()='Peppy Paneer']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement peppPaneerTotalPrice;

    @FindBy(xpath="//span[text()='Cheese n Corn']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement CheeseNCornTotalPrice;

    @FindBy(xpath="//span[@class='rupee sb-ttl']")
    private WebElement subTotalPrice;

    @FindBy(xpath="//div[@data-label='Beverages']//span[text()='BEVERAGES']")
    private WebElement beverages;

    @FindBy(xpath="//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//button")
    private WebElement pepsiAddCartBtn;

    @FindBy(xpath="//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//div[@data-label='increase']")
    private WebElement pepsiIncBtn;

    @FindBy(xpath="//span[text()='Pepsi 475ml']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement pepsiTotalPrice;

    @FindBy(xpath="//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Margherita']//parent::div//parent::div//div[@data-label='decrease']")
    private WebElement margheritaDecBtn;

    @FindBy (xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//div[@data-label='decrease']")
    private WebElement pepsiDecBtn;

    @FindBy(xpath="//span[text()='Pepsi 475ml']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//div//div//span")
    private WebElement pepsiQtyNo;


    public void addMargherita() throws InterruptedException {

        vegPizza.click();
        Thread.sleep(5000);
        js.executeScript("arguments[0].click();", margeritaAddCartBtn);
        js.executeScript("arguments[0].click();", noThanks);
        margheritaIncBtn.click();
    }
    public void addPeppyPaneer(){
        peppPaneerAddCartBtn.click();
        pepPaneerIncBtn.click();
    }
    public void addCheeseCorn(){
        CheeseNCornAddCartBtn.click();
        CheeseNCornIncBtn.click();
    }
    public boolean totalOfpizza(){
        String sub= subTotalPrice.getText();
        String marg = margheritaTotalPrice.getText();
        String cheecorn = CheeseNCornTotalPrice.getText();
        String peppPan = peppPaneerTotalPrice.getText();

        double margPrice = Double.parseDouble(marg);
        double cheecornPrice = Double.parseDouble(cheecorn);
        double PeppPanPrice = Double.parseDouble(peppPan);
        double totalPrice = margPrice+cheecornPrice+PeppPanPrice;
        double subPrice = Double.parseDouble(sub);
        boolean equals;
        if(totalPrice==subPrice) {
            equals = true;
        }else {
            equals = false;
        }

        return equals;
    }
    public void addPepsi(){

        beverages.click();
        pepsiAddCartBtn.click();
        String pepsiQuantity = pepsiQtyNo.getText();

        int pepQty = Integer.parseInt(pepsiQuantity);
        int i=0;
        int targetQuantity = 12;

        while (pepQty < targetQuantity) {
            pepsiIncBtn.click();
            i++;
            pepsiQuantity = pepsiQtyNo.getText();
            pepQty = Integer.parseInt(pepsiQuantity);
        }
    }
    public boolean allProductPrice(){
        String sub= subTotalPrice.getText();
        String marg = margheritaTotalPrice.getText();
        String cheecorn = CheeseNCornTotalPrice.getText();
        String peppPan = peppPaneerTotalPrice.getText();
        String peps = pepsiTotalPrice.getText();

        double margPrice = Double.parseDouble(marg);
        double cheecornPrice = Double.parseDouble(cheecorn);
        double PeppPanPrice = Double.parseDouble(peppPan);
        double pepsPrice = Double.parseDouble(peps);
        double totalPrice = margPrice+cheecornPrice+PeppPanPrice+pepsPrice;
        double subPrice = Double.parseDouble(sub);


        boolean equals;

        if(totalPrice==subPrice){
            equals = true;
        }else {
            equals = false;
        }
        return equals;

    }
    public void remMargPizza(){
        vegPizza.click();
        margheritaDecBtn.click();
    }
    public void remPepsi() {
        beverages.click();
        String pepsiQuantity = pepsiQtyNo.getText();

        int pepQty = Integer.parseInt(pepsiQuantity);
        int i = 0;
        int targetQuantity = 6;

        while (pepQty > targetQuantity) {
            pepsiDecBtn.click();
            i++;
            pepsiQuantity = pepsiQtyNo.getText();
            pepQty = Integer.parseInt(pepsiQuantity);
        }
    }
    }


