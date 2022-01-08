package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SelectUserController {

    public AnchorPane selectUserContext;

    public void signIn(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/repSignInForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) selectUserContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void signInAdmin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/adminLogForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) selectUserContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
