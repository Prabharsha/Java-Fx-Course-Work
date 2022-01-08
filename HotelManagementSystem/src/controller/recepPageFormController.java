package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class recepPageFormController {
    public AnchorPane recepPageContext;

    public void LogOut(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/repSignInForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) recepPageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToBooking(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/bookingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) recepPageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void viewRoomsInMaintain(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/roomsInMaintainForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) recepPageContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }


    }

