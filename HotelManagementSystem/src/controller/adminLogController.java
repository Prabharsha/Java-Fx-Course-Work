package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class adminLogController {
    public AnchorPane adminFormContext;
    public Label label;
    public JFXTextField txtName;
    public JFXTextField txtPassword;

    public void backToSelect(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/selectUser.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToHome(ActionEvent actionEvent) throws IOException {
        if(txtName.getText().equals("Admin")& !txtPassword.getText().isEmpty()){
            if(txtPassword.getText().equals("1234") ){

                URL resource = getClass().getResource("../view/adminPageForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Stage window = (Stage) adminFormContext.getScene().getWindow();
                window.setScene(new Scene(load));
            }
        }else{
            label.setText("Enter correct username or password");
        }
    }
}
