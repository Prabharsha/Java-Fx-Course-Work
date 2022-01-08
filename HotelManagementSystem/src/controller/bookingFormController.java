package controller;

import com.jfoenix.controls.JFXComboBox;
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
import model.Customer;
import view.tm.CustomerTM;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class bookingFormController {
    public AnchorPane bookingContext;
    public TableView tblCustomer;
    public TableColumn colNIC;
    public TableColumn colName;
    public TableColumn colAdd;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colRoomNo;
    public TableColumn colDelete;
    public TableColumn colEdit;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAdd;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;
    public JFXTextField txtRoomNo;
    public JFXComboBox cmbMeals;

    static ArrayList<Customer> customerList = new ArrayList();

    static ArrayList<String> mealBucket = new ArrayList<>();

    static {
        mealBucket.add("Local");
        mealBucket.add("Chines");
        mealBucket.add("French");

    }


    public void initialize(){
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAdd.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        colEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));

        ObservableList<String> obList= FXCollections.observableArrayList(mealBucket);
        cmbMeals.setItems(obList);
        cmbMeals.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtName.setText((String) newValue);
        });
    }

    public void bakTo(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/recepPageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) bookingContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void roomsInMaintain(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/roomsInMaintainForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) bookingContext.getScene().getWindow();
        window.setScene(new Scene(load));


    }

    public void printToken(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/printTokenForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) bookingContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }


    public void saveData(ActionEvent actionEvent) {
        Customer customer = new Customer(txtId.getText(), txtName.getText(), txtContact.getText(), txtAdd.getText(),txtEmail.getText(),txtRoomNo.getText());
        if (ifExist(customer)){
            if (customerList.add(customer)) {

                loadAllCustomers();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
            }

        }else {
            new Alert(Alert.AlertType.WARNING, "Room Unavailable", ButtonType.CLOSE).show();
        }

    }
    private void loadAllCustomers(){
        ObservableList<CustomerTM> tmObservableList = FXCollections.observableArrayList();
        for (Customer temp : customerList
        ) {
            Button delete = new Button("Delete");
            Button edit = new Button("Edit");
            tmObservableList.add(
                    new CustomerTM(temp.getNIC(), temp.getName(), temp.getContact(), temp.getAddress(),temp.getEmail(),temp.getRoomNum(),delete,edit)
            );
            delete.setOnAction((e)-> {
                customerList.remove(temp);
                loadAllCustomers();
            });
            edit.setOnAction((e)->{
                customerList.contains(temp);
                loadAllCustomers();
            });
        }
        tblCustomer.setItems(tmObservableList);
    }

    public void refreshTbl(ActionEvent actionEvent) {
        loadAllCustomers();
    }
    public boolean ifExist(Customer customer){
        for (Customer t:customerList
             ) {
            if(t.getRoomNum().equalsIgnoreCase(customer.getRoomNum())){
            return false;
            }
    }
        return true;
    }
}
