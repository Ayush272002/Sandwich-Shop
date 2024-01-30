package com.sandwichshop.my_sandwich_shop;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button ExitButton;
    @FXML
    private Label finalBill;
    @FXML
    private Button SubmitButton;
    @FXML
    private ListView<String> Branches;
    @FXML
    private ChoiceBox<String> sandwichFillings;
    @FXML
    private RadioButton ThickBread;
    @FXML
    private RadioButton ThinBread;
    @FXML
    private TextField name;
    @FXML
    private Label selectedBranchLabel;

    private double cost;
    String selectedBranch;


    private final String[] fillings = {"Cheese", "Ham and Cheese", "Cheese and Onion", "Egg mayonnaise"};
    private final String[] branches = {"Selly Oak","Bournville","Solihull"};
    @Override
    public void initialize(URL location, ResourceBundle rb)
    {
        sandwichFillings.getItems().addAll(fillings);
        Branches.getItems().addAll(branches);
        Branches.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldVal, String newVal) {
                selectedBranch = Branches.getSelectionModel().getSelectedItem();
                selectedBranchLabel.setText(selectedBranch);
            }
        });

        cost = 0.00;
        sandwichFillings.setOnAction(this::getFillingCost);
    }
    public void radioSelect(ActionEvent actionEvent)
    {
        if(ThickBread.isSelected()) cost+= 0.90;
        if(ThinBread.isSelected()) cost += 0.75;
    }

    public void getFillingCost(ActionEvent e)
    {
        String choice = sandwichFillings.getValue();

        if (choice.equals("Cheese")) cost += 1.00;
        if (choice.equals("Ham and Cheese")) cost += 2.00;
        if (choice.equals("Cheese and Onion")) cost += 3.00;
        if (choice.equals("Egg mayonnaise")) cost += 4.00;
    }


    public void SubmitButtonPressed(ActionEvent actionEvent) {
        finalBill.setText("Thank You "+name.getText() +", The total bill is £"+cost+", will deliver to "+selectedBranch);
    }

    public void ExitButtonPressed(ActionEvent actionEvent)
    {
        Platform.exit();
    }
}