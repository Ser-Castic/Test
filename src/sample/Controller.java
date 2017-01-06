package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    TextField textName;

    @FXML
    TextField textPhone;

    @FXML
    TextField textEmail;

    @FXML
    ListView list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

        public void addItem() {
            if(textName.getLength() != 0 && textPhone.getLength() != 0 && textEmail.getLength() != 0) {
                contacts.add(new Contact(textName.getText(), textPhone.getText(), textEmail.getText()));
                textName.setText("");
                textPhone.setText("");
                textEmail.setText("");
            } else {
                System.out.println("Error");
            }
        }

    public void removeItem() {
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }
}
