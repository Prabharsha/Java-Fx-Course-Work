package model;



public class Meal {
    private String packageM;
    private String price;

    public Meal() {
    }

    public Meal(String packageM, String price) {
        this.setPackageM(packageM);
        this.setPrice(price);
    }


    public String getPackageM() {
        return packageM;
    }

    public void setPackageM(String packageM) {
        this.packageM = packageM;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
