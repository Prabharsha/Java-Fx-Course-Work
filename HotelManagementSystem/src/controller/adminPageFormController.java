package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class adminPageFormController {
    public AnchorPane adminPageContext;

    public void goToRooms(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/roomsSettingsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminPageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToMeals(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/mealsSettingsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminPageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToFinancials(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/financeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminPageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/adminLogForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminPageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
