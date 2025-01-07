package com.benedict.minibank.Controllers.Client;

import com.benedict.minibank.Models.Transaction;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {

    public Text in_icon;
    public Text out_icon;
    public Label trans_date_lbl;
    public Label sender_lbl;
    public Label receiver_lbl;
    public Label amount_lbl;

    private final Transaction transaction;

    public TransactionCellController(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle) {}
}
