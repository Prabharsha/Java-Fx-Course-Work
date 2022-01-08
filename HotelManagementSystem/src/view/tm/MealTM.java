package view.tm;

import javafx.scene.control.Button;

public class MealTM {
    private String packageM;
    private String price;
    private Button delete;
    private Button edit;

    public MealTM() {
    }

    public MealTM(String packageM, String price, Button delete, Button edit) {
        this.setPackageM(packageM);
        this.setPrice(price);
        this.setDelete(delete);
        this.setEdit(edit);
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

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }
}
