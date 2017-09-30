package employee_Manager;

import java.util.Optional;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class employeeManager extends Application {
	private VBox leftBox = new VBox(25);
	private Boolean isAdmin = false;
	private HBox colorHolder = new HBox();
	private Button newEmpBut = new Button("Add New Employee");
	private Button findEmpBut = new Button("Edit Employee");
	private Button removeEmpBut = new Button("Remove Employee");
	private Button clockBut = new Button("Clock In/Out");
	private NumberFormats numberFormats = new NumberFormats();
	private Label logo = new Label("Employee Manager");
	private Alert youSure = new Alert(AlertType.CONFIRMATION);

	Database empDB = new Database();

	@Override
	public void start(Stage mainStage) throws Exception {
		colorHolder.getChildren().add(logo);
		colorHolder.setPadding(new Insets(15));
		colorHolder.setAlignment(Pos.BOTTOM_RIGHT);
		colorHolder.setPrefHeight(250);
		colorHolder.setStyle("-fx-Background-Color: #FF0000");
		
		logo.setFont(new Font("Arial", 70));
		logo.setTextFill(Color.web("#ff4d4d"));

		mainStage.setMaximized(true);
		BorderPane bP = new BorderPane();
		BorderPane bP2 = new BorderPane();
		Scene initialScene = new Scene(bP);
		mainStage.setTitle("Employee Manager");
		bP.setLeft(leftBox);
		bP.setCenter(bP2);
		bP2.setBottom(colorHolder);
		leftBox.setMinHeight(1000);
		leftBox.setStyle("-fx-Background-Color:#595959");
		leftBox.getChildren().addAll(newEmpBut, findEmpBut, removeEmpBut, clockBut);
		leftBox.setPadding(new Insets(25));
		leftBox.setAlignment(Pos.TOP_CENTER);
		newEmpBut.setPrefSize(150, 100);
		findEmpBut.setPrefSize(150, 100);
		removeEmpBut.setPrefSize(150, 100);
		clockBut.setPrefSize(150, 100);

		mainStage.setScene(initialScene);
		mainStage.show();

		newEmpBut.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				HBox newCustBox = new HBox();
				TextField first, last, street, city, state, email, phone, zip, social1, social2, social3, pin, dob;
				CheckBox adminCB = new CheckBox();
				Button submitNewEmp = new Button("Submit");
				Button cancelNewCust = new Button("Cancel");
				submitNewEmp.setPrefSize(120, 60);
				cancelNewCust.setPrefSize(120, 60);
				Label firstLabel = new Label("First Name");
				firstLabel.setFont(new Font("Arial", 17));
				Label lastLabel = new Label("Last Name");
				lastLabel.setFont(new Font("Arial", 17));
				Label streetLabel = new Label("Street Address");
				streetLabel.setFont(new Font("Arial", 17));
				Label cityLabel = new Label("City");
				cityLabel.setFont(new Font("Arial", 17));
				Label stateLabel = new Label("State");
				stateLabel.setFont(new Font("Arial", 17));
				Label zipLabel = new Label("Zip Code");
				zipLabel.setFont(new Font("Arial", 17));
				Label phoneLabel = new Label("Phone Number");
				phoneLabel.setFont(new Font("Arial", 17));
				Label emailLabel = new Label("Email");
				emailLabel.setFont(new Font("Arial", 17));
				Label socialLabel = new Label("SSN");
				socialLabel.setFont(new Font("Arial", 17));
				Label pinLabel = new Label("PIN");
				pinLabel.setFont(new Font("Arial", 17));
				Label dobLabel = new Label("Date of Birth");
				dobLabel.setFont(new Font("Arial", 17));
				Label adminLabel = new Label("Administrator");
				adminLabel.setFont(new Font("Arial", 17));
				Label message = new Label("");

				GridPane gP = new GridPane();
				GridPane socialGP = new GridPane();
				BorderPane borPan = new BorderPane();
				gP.setPadding(new Insets(20));
				gP.setAlignment(Pos.TOP_CENTER);
				gP.setPrefSize(mainStage.getWidth(), mainStage.getHeight());
				gP.setHgap(20);
				gP.setVgap(20);
				socialGP.getColumnConstraints().addAll(new ColumnConstraints(40), new ColumnConstraints(), new ColumnConstraints(30), new ColumnConstraints(), new ColumnConstraints(50));


				newCustBox.getChildren().add(borPan);
				borPan.setCenter(gP);
				bP.setCenter(newCustBox);

				borPan.setBottom(colorHolder);

				gP.add(firstLabel, 0, 0);
				gP.add(lastLabel, 0, 1);
				gP.add(streetLabel, 0, 2);
				gP.add(cityLabel, 0, 3);
				gP.add(stateLabel, 0, 4);
				gP.add(dobLabel, 0, 5);
				gP.add(zipLabel, 2, 0);
				gP.add(phoneLabel, 2, 1);
				gP.add(emailLabel, 2, 2);
				gP.add(socialLabel, 2, 3);
				gP.add(pinLabel, 2, 4);
				gP.add(adminLabel, 2, 5);
				gP.add(message, 0, 7);

				gP.add(first = new TextField(), 1, 0);
				gP.add(last = new TextField(), 1, 1);
				gP.add(street = new TextField(), 1, 2);
				gP.add(city = new TextField(), 1, 3);
				gP.add(state = new TextField(), 1, 4);
				gP.add(dob = new TextField(), 1, 5);
				gP.add(zip = new TextField(), 3, 0);
				gP.add(phone = new TextField(), 3, 1);
				gP.add(email = new TextField(), 3, 2);
				gP.add(socialGP, 3, 3);
				socialGP.add(social1 = new TextField(), 0, 0);
				socialGP.add(new Label("-"), 1,0);
				socialGP.add(new Label("-"), 3, 0);
				socialGP.add(social2 = new TextField(), 2, 0);
				socialGP.add(social3 = new TextField(), 4, 0);
				gP.add(pin = new TextField(), 3, 4);
				gP.add(adminCB, 3, 5);
				first.setPrefWidth(500);
				zip.setPrefWidth(500);
				gP.setHalignment(submitNewEmp, HPos.CENTER);
				gP.setHalignment(cancelNewCust, HPos.CENTER);
				gP.add(submitNewEmp, 0, 6);
				gP.add(cancelNewCust, 2, 6);
				gP.setColumnSpan(submitNewEmp, 2);
				gP.setColumnSpan(cancelNewCust, 2);
				gP.setColumnSpan(message, 4);
				gP.setHalignment(message, HPos.CENTER);
				
				adminCB.selectedProperty().addListener(new ChangeListener<Boolean>() {
					public void changed(ObservableValue<? extends Boolean> ov,
							Boolean old_val, Boolean new_val) {
								isAdmin = true;
					}
				});				
				
				submitNewEmp.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						boolean worked;
						youSure.setTitle("Confirm New Employee");
						youSure.setHeaderText("Submit New Employee?");
						youSure.setContentText("Are you sure?");

						Optional<ButtonType> result = youSure.showAndWait();
						if (result.get() == ButtonType.OK) {
							String social = social1.getText() + social2.getText()+ social3.getText();
							if (numberFormats.isInt(zip.getText()) && numberFormats.isInt(pin.getText())) {
								worked = empDB.insertEmp(first.getText(), last.getText(), street.getText(),
										city.getText(), state.getText(), zip.getText(), email.getText(),
										social, pin.getText(), phone.getText(), dob.getText(), isAdmin);
							} else {
								worked = false;
							}
							if (worked) {
								message.setText("New employee added successfully");
							} else {
								message.setText("Error occured while adding employee");
							}
						}

					}

				});

				cancelNewCust.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent arg0) {
						youSure.setTitle("Cancel New Employee");
						youSure.setHeaderText("Cancel adding new employee?");
						youSure.setContentText("Are you sure?");

						Optional<ButtonType> result = youSure.showAndWait();
						if (result.get() == ButtonType.OK) {
							first.clear();
							last.clear();
							street.clear();
						}
					}
				});

			}
		});
	}

	public static void main(String args[]) {
		Application.launch(args);
	}

}