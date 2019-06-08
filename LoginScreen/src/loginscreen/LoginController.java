/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginscreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Piotr
 */
public class LoginController implements Initializable {
    
    @FXML
    private Label lblStatus;
    
    @FXML
    private TextField txtUsername;
    
    @FXML
    private TextField txtPassword;
    
    
    public void Login(ActionEvent event) throws Exception{
        if(txtUsername.getText().equals("employee") && txtPassword.getText().equals("passe")){
            lblStatus.setTextFill(Color.web("#00ff00"));
            JOptionPane.showMessageDialog(null, "Logged in as employee #123");
            Stage employeeStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Employee.fxml")); 
            ShowScreen(employeeStage, event, root);
        }else if (txtUsername.getText().equals("client") && txtPassword.getText().equals("passc")){
            lblStatus.setTextFill(Color.web("#00ff00"));
            JOptionPane.showMessageDialog(null, "Logged in as client Piotr Swistak");
            Stage clientStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            ShowScreen(clientStage, event, root);            
        }
        else if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("passa")){
            lblStatus.setTextFill(Color.web("#00ff00"));
            JOptionPane.showMessageDialog(null, "Logged in as admin");
            Stage adminStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            ShowScreen(adminStage, event, root);
        }
        else
        {
            lblStatus.setTextFill(Color.web("#ff0000"));
            JOptionPane.showMessageDialog(null, "Wrong login or password, try again");
        }
    }
    
    private void HideScreen(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    private void ShowScreen(Stage stage, ActionEvent event, Parent parent) throws Exception{
            Scene scene = new Scene(parent);        
            HideScreen(event);            
            stage.setScene(scene);
            stage.show();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
