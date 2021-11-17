import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class PatientVisitSidebarPane extends Pane {

    private Label nameLabel, birthdayLabel, idLabel;
    private ComboBox<LocalDate> visitDateComboBox;
    private ObservableList<LocalDate> list = FXCollections.observableArrayList();

    public PatientVisitSidebarPane() {
        //Set size of the sidebar across all calls to view it
        this.setPrefWidth(427);
        this.setPrefHeight(720);

        //LABELS
        nameLabel = new Label(Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName());
        nameLabel.getStyleClass().add("whiteLabel");
        nameLabel.setLayoutX(70);
        nameLabel.setLayoutY(187);

        birthdayLabel = new Label("DOB: " + Main.currentPatient.getBirthDate());
        birthdayLabel.getStyleClass().add("sidebarDOBID");
        birthdayLabel.setLayoutX(100);
        birthdayLabel.setLayoutY(235);

        idLabel = new Label("ID: " + Main.currentPatient.getPatientID());
        idLabel.getStyleClass().add("sidebarDOBID");
        idLabel.setLayoutX(114);
        idLabel.setLayoutY(277);

        for (int i = 0; i < Main.currentPatient.visits.size(); i++) {
            list.add(Main.currentPatient.visits.get(i).getVisitDate());
        }

        visitDateComboBox = new ComboBox(list);

        if (Main.currentVisitDate == null)
            visitDateComboBox.setValue(Main.currentPatient.visits.get(0).getVisitDate());
        else
            visitDateComboBox.setValue(Main.currentVisitDate);

        visitDateComboBox.getStyleClass().add("selectPatientDropdown");
        visitDateComboBox.setEditable(false);
        visitDateComboBox.setLayoutX(84);
        visitDateComboBox.setLayoutY(360);
        visitDateComboBox.getStyleClass().add("selectPatientDropdown");
        visitDateComboBox.setMaxWidth(259);

        visitDateComboBox.setOnAction(new ComboBoxHandler());
        this.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));
        this.getChildren().addAll(nameLabel, birthdayLabel, idLabel, visitDateComboBox);

    }

    private class ComboBoxHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Main.currentVisitDate = visitDateComboBox.getValue();
            System.out.println(Main.currentVisitDate);
            HealthCarePortalSystem.showPatientHealthHistoryPane();
        }
    }


}
