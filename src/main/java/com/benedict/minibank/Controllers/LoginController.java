package com.benedict.minibank.Controllers;

import com.benedict.minibank.Models.Model;
import com.benedict.minibank.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_lbl;
    public TextField payee_address_fld;
    public Label password_lbl;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;

    public void initialize( URL url, ResourceBundle resourceBundle ){
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> setAcc_selector());
        login_btn.setOnAction(actionEvent -> onLogin());
    }

    public void onLogin() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        //Model.getInstance().getViewFactory().closeStage(stage);
        //Model.getInstance().getViewFactory().showClientWindow();
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT) {
            //Check client credentials
            Model.getInstance().checkClientCredentials(payee_address_fld.getText(), password_fld.getText());
            if (Model.getInstance().getClientSuccessFlag()) {
                Model.getInstance().getViewFactory().showClientWindow();
                //Close login stage
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("Neteisingi prisijungimo duomenys");
            }
            //Model.getInstance().getViewFactory().showClientWindow();
        } else {
            //Check admin credentials
            Model.getInstance().checkAdminCredentials(payee_address_fld.getText(), password_fld.getText());
            if (Model.getInstance().getAdminSuccessFlag()) {
                Model.getInstance().getViewFactory().showAdminWindow();
                //Close login stage
                Model.getInstance().getViewFactory().closeStage(stage);
                // Model.getInstance().getViewFactory().showAdminWindow();
            }else{
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("Neteisingi prisijungimo duomenys");
            }
        }
    }

    private void setAcc_selector(){
        Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue());
        if(acc_selector.getValue() == AccountType.ADMIN){
            payee_address_lbl.setText("Vartotojo vardas");
        }else{
            payee_address_lbl.setText("Mokėtojo adresas");
        }
    }


}
