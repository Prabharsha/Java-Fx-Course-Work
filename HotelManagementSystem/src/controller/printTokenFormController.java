package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class printTokenFormController {
    public AnchorPane printTokenContext;
    public Label label1;
    public Label label2;


    public void backTo(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/bookingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) printTokenContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void generateId(ActionEvent actionEvent) {
        Random r = new Random();
        label1.setText(String.valueOf(r.nextInt(200)));


    }

    public void sendMail(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION,"Mail Sanded", ButtonType.FINISH).show();
    }

    public void printToken(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION,"Token Printed", ButtonType.FINISH).show();
    }
}
