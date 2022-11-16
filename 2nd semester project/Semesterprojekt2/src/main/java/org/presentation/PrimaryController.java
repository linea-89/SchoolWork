package org.presentation;

import java.io.IOException;

import domain.TvCreditsFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController {


    @FXML
    private void switchToProducer() throws IOException {
        App.setRoot("producerLanding");
    }

    @FXML
    public void switchToViewer(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewerLanding");
    }

    @FXML
    private void switchToAdminLanding() throws IOException {
        App.setRoot("administration");
    }


}