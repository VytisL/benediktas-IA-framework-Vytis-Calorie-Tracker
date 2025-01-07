package com.benedict.minibank.Controllers.Admin;

import com.benedict.minibank.Models.Model;
import com.benedict.minibank.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {

    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle) {
        addListeners();
    }


    private void addListeners(){
        create_client_btn.setOnAction(event -> onCreateClient());
        clients_btn.setOnAction(event->onClient());
        deposit_btn.setOnAction(event->onDeposit());
        logout_btn.setOnAction(event->onLogout());
    }

    private void onCreateClient(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClient(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }

    private void onDeposit(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DEPOSIT);
    }

    private void onLogout(){
        //Get stage
        Stage stage = (Stage) clients_btn.getScene().getWindow();
        //Close client window
        Model.getInstance().getViewFactory().closeStage(stage);
        //Show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        //Set flag to false
        Model.getInstance().setClientAdminSuccessFlag(false);

    }


}
