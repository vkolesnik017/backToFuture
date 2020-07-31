package abTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class QC_98 extends BaseTest {

    @Test
    public void checkSortingOfProductByGeneric() {
        LkwCategoryCarList carListPage = PageFactory.initElements(WebDriverProvider.getWebDriver(), abTest.LkwCategoryCarList.class);
    }
}
