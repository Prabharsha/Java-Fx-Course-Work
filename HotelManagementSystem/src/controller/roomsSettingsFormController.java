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
import model.Customer;
import model.RoomsManage;
import view.tm.CustomerTM;
import view.tm.RoomsManageTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static controller.bookingFormController.customerList;

public class roomsSettingsFormController {
    public AnchorPane roomsContext;
    public TableView tblRoom;
    public TableColumn colRoomNo;
    public TableColumn colRoomType;
    public TableColumn delete;
    public TableColumn edit;
    public JFXTextField txtRoomNo;
    public JFXTextField txtRoomType;
    public TableColumn coldelete;
    public TableColumn coledit;

    static ArrayList<RoomsManage> roomsManageList = new ArrayList();


    public void refresh(ActionEvent actionEvent) {
        loadAllRooms();
    }

    public void initialize() {
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        coldelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        coledit.setCellValueFactory(new PropertyValueFactory<>("edit"));

    }

    public void backTo(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/adminPageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void saveData(ActionEvent actionEvent) {
        RoomsManage roomsManage = new RoomsManage(txtRoomNo.getText(),txtRoomType.getText());
        if (ifExist(roomsManage)){
            if (roomsManageList.add(roomsManage)) {

                loadAllRooms();
                new Alert(Alert.AlertType.CONFIRMATION, "Room Added", ButtonType.CLOSE).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
            }

        }else {
            new Alert(Alert.AlertType.WARNING, "Room Already In List", ButtonType.CLOSE).show();
        }
    }
    public boolean ifExist(RoomsManage customer){
        for (RoomsManage r:roomsManageList
        ) {
            if(r.getRoomNumber().equalsIgnoreCase(customer.getRoomNumber())){
                return false;
            }
        }
        return true;
    }
    private void loadAllRooms(){
        ObservableList<RoomsManageTM> tmObservableList = FXCollections.observableArrayList();
        for (RoomsManage temp : roomsManageList
        ) {
            Button delete = new Button("Delete Room");
            Button edit = new Button("Edit");
            tmObservableList.add(
                    new RoomsManageTM(temp.getRoomNumber(),temp.getRoomType(),delete,edit)
            );
            delete.setOnAction((e)-> {
                roomsManageList.remove(temp);
                loadAllRooms();
            });
            edit.setOnAction((e)->{
                roomsManageList.contains(temp);
                loadAllRooms();
            });
        }
        tblRoom.setItems(tmObservableList);
    }
}
