module com.sandwichshop.my_sandwich_shop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sandwichshop.my_sandwich_shop to javafx.fxml;
    exports com.sandwichshop.my_sandwich_shop;
}