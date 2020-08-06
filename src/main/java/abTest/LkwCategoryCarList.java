package abTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import specialFiles.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LkwCategoryCarList {
    private WebDriver driver = WebDriverProvider.getWebDriver();
    WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);

    @FindBy(how = How.XPATH, xpath = "//div[@class='button ']")
    List<WebElement> activeProduct;

    @FindBy(how = How.XPATH, xpath = "//div[@class='button not_active']")
    List<WebElement> notActiveProduct;

    @FindBy(how = How.XPATH, xpath = "//div[@class='count']/following-sibling::div[1]")
    List<WebElement> productsList;

    @FindBy(how = How.XPATH, xpath = "//p[@class='actual_price']")
    List<WebElement> priceOfProduct;

    public LkwCategoryCarList(WebDriver driver) {
        this.driver = driver;
        driver.get("https://lkwteile.autodoc.de/ersatzteile/olfilter-200157/mercedes-benz/actros?car_id=1000784");
    }

    public LkwCategoryCarList checkSortingOfListing() {
        List<Product> activeProductList = new ArrayList<>();
        List<Product> notActiveProductList = new ArrayList<>();
        List<String> expectedGeneric = Arrays.asList("Ölfilter", "Dichtung, Ölfilter");

        addProductToList(activeProductList,notActiveProductList,productsList);

        for (int i=0; i<activeProductList.size();i++) {
            System.out.println(activeProductList.get(i).getGenericOfProduct()+ " - " + activeProductList.get(i).getPriceOfProduct());
        }

        return this;
    }

    public LkwCategoryCarList addProductToList(List<Product> activeList, List<Product> notActiveList, List<WebElement> products) {


        for (int i = 0; i < products.size(); i++) {
            Product product = new Product();
            if (products.get(i).getAttribute("class").equals("button ")) {
                product.setGenericOfProduct(products.get(i).getAttribute("data-name"));
                product.setPriceOfProduct(Double.parseDouble(priceOfProduct.get(i).getText().replaceAll("[^0-9,]", "").replace(",", ".")));
             //   activeList.add(product);
            } else if (products.get(i).getAttribute("class").equals("button not_active")){
                product.setGenericOfProduct(products.get(i).getAttribute("data-name"));
                product.setPriceOfProduct(Double.parseDouble(priceOfProduct.get(i).getText().replaceAll("[^0-9,]", "").replace(",", ".")));
          //      notActiveList.add(product);
            }
            activeList.add(product);
        }

        return this;
    }
}
