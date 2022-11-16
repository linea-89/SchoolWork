package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;


//Controller used to catch clicks on yet to be implemented buttons
public class ViewerOopsController {

    public TextField textSearchBar;
    public static String landingSearch;

    public void switchToSearch(ActionEvent actionEvent) throws IOException {
        landingSearch = textSearchBar.getText();
        App.setRoot("viewerSearch");
    }

    @FXML
    private void switchToViewerLanding() throws IOException {
        App.setRoot("viewerLanding");
    }

    @FXML
    private void switchToViewerProductions() throws IOException {
        App.setRoot("viewerProductions");
    }

    @FXML
    private void switchToViewerSearch() throws IOException {
        App.setRoot("viewerSearch");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchToViewerOops() throws IOException {
        App.setRoot("viewerOops");
    }
}
