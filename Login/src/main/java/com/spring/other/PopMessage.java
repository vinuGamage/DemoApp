package com.spring.other;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopMessage {

    public static void infoBox(String infoMessage, String titleBar)
    {
        /* By specifying a null headerMessage String, we cause the dialog to
           not have a header */
        infoBox(infoMessage, titleBar, null);
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}
