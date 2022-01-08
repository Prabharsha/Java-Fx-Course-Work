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
import model.Room;
import view.tm.RoomTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class roomsInMaintainFormController {
    public AnchorPane roomsInMaintain;
    public TableColumn colRoomNo;
    public TableColumn colAvailability;
    public TableColumn colButton;
    public JFXTextField txtRoomNo;
    public JFXTextField txtAvailability;

    static ArrayList<Room> roomList = new ArrayList();
    public TableView tblRooms;

    public void initialize(){
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("roomAvailability"));
        colButton.setCellValueFactory(new PropertyValueFactory<>("available"));
    }

    public void backTo(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/recepPageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomsInMaintain.getScene().getWindow();
        window.setScene(new Scene(load));
    }


    public void save(ActionEvent actionEvent) {
        Room room = new Room(txtRoomNo.getText(), txtAvailability.getText());
       if (ifExist(room)) {
           if (roomList.add(room)) {
               loadAllRooms();
               new Alert(Alert.AlertType.CONFIRMATION, "Done", ButtonType.FINISH).show();
           } else {
               new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
           }
       }else{
           new Alert(Alert.AlertType.WARNING,"Already In Maintainance",ButtonType.OK).show();
       }

    }
     private void loadAllRooms(){
         ObservableList <RoomTM>tmObservableList= FXCollections.observableArrayList();
         for (Room r:roomList
              ) {
             Button available = new Button("Make Available");
             tmObservableList.add(
                     new RoomTM(r.getRoomNumber(),r.getRoomAvailability(),available)
             );
             available.setOnAction((e)->{
                 roomList.remove(r);
                 loadAllRooms();
             });
         }
         tblRooms.setItems(tmObservableList);

     }
     public boolean ifExist(Room room){
         for (Room r:roomList
              ) {
             if (r.getRoomNumber().equalsIgnoreCase(room.getRoomNumber())){
                 return false;
             }
         }
         return true;
     }

    public void refresh(ActionEvent actionEvent) {
        loadAllRooms();
    }
}