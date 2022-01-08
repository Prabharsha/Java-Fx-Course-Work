package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Meal;
import model.RoomsManage;
import view.tm.MealTM;
import view.tm.RoomsManageTM;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class mealsSettingsFormController {


    static ArrayList<Meal> mealList = new ArrayList();
    public AnchorPane mealManageContext;
    public JFXTextField txtPackageM;
    public JFXTextField txtPrice;
    public TableView tblMeal;
    public TableColumn colPackageM;
    public TableColumn colPrice;
    public TableColumn colDelete;
    public TableColumn colEdit;

    public void initialize() {
        colPackageM.setCellValueFactory(new PropertyValueFactory<>("packageM"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        colEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));

    }



    public void saveData(ActionEvent actionEvent) {
        Meal meal = new Meal(txtPackageM.getText(),txtPrice.getText());
        if (ifExist(meal)){
            if (mealList.add(meal)) {

                loadAllMeals();
                new Alert(Alert.AlertType.CONFIRMATION, "Meal Added", ButtonType.CLOSE).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
            }

        }else {
            new Alert(Alert.AlertType.WARNING, "Meal Already In List", ButtonType.CLOSE).show();
        }
    }

    public void backTo(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/adminPageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) mealManageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void refresh(ActionEvent actionEvent) {
        loadAllMeals();
    }

    public boolean ifExist(Meal meal){
        for (Meal m:mealList
        ) {
            if(m.getPackageM().equalsIgnoreCase(meal.getPackageM())){
                return false;
            }
        }
        return true;
    }
    private void loadAllMeals(){
        ObservableList<MealTM> tmObservableList = FXCollections.observableArrayList();
        for (Meal m : mealList
        ) {
            Button delete = new Button("Delete Meal");
            Button edit = new Button("Edit");
            tmObservableList.add(
                    new MealTM(m.getPackageM(),m.getPrice(),delete,edit)
            );
            delete.setOnAction((e)-> {
                mealList.remove(m);
                loadAllMeals();
            });
            edit.setOnAction((e)->{
                mealList.equals(m);
                loadAllMeals();
            });
        }
        tblMeal.setItems(tmObservableList);
    }
}
