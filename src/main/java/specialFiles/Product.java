package specialFiles;

public class Product {

    private String genericOfProduct;
    private double priceOfProduct;
    private String attributeOfButton;

    public void setAttributeOfButton(String attribute){attributeOfButton=attribute;}

    public String getAttributeOfButton() {return attributeOfButton;}

    public void setGenericOfProduct(String generic) {
        genericOfProduct = generic;
    }

    public String getGenericOfProduct() {
        return genericOfProduct;
    }

    public void setPriceOfProduct(double price) {
        priceOfProduct = price;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }
}
