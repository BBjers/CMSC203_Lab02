
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed. Before
 * beginning to implement, design the structure of your GUI in order to
 * understand what panels go inside which ones, and what buttons or other
 * components go in which panels.
 * 
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	// student Task #2:
	// declare five buttons, a label, and a textfield
	Button bt1;
	Button bt2;
	Button bt3;
	Button bt4;
	Button bt5;
	Label label;
	TextField textField;

	// Additional Button for "Just For Fun" task
	Button bt6;

	// declare two HBoxes
	HBox hBox1;
	HBox hBox2;

	// student Task #4:
	// declare an instance of DataManager
	DataManager dataMng;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach. Remember
	 * to wait to add a component to its containing component until the container
	 * has been created. This is the only constraint on the order in which the
	 * following statements appear.
	 */
	FXMainPane() {
		// student Task #2:
		// instantiate the buttons, label, and textfield
		bt1 = new Button("Hello");
		bt2 = new Button("Howdy");
		bt3 = new Button("Chinese");
		bt4 = new Button("Clear");
		bt5 = new Button("Exit");
		label = new Label("Feedback");
		textField = new TextField();

		// Additional Button
		bt6 = new Button("Vietnamese");

		// Register the event handler.
		bt1.setOnAction(new ButtonHandler());
		bt2.setOnAction(new ButtonHandler());
		bt3.setOnAction(new ButtonHandler());
		bt4.setOnAction(new ButtonHandler());
		bt5.setOnAction(new ButtonHandler());

		bt6.setOnAction(new ButtonHandler());

		// instantiate the HBoxes
		hBox1 = new HBox();
		hBox2 = new HBox();

		// student Task #4:
		// instantiate the DataManager instance
		dataMng = new DataManager();

		// set margins and set alignment of the components
		HBox.setMargin(label, new Insets(5));
		HBox.setMargin(bt1, new Insets(2));
		HBox.setMargin(bt2, new Insets(2));
		HBox.setMargin(bt3, new Insets(2));
		HBox.setMargin(bt4, new Insets(2));
		HBox.setMargin(bt5, new Insets(2));

		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);

		// student Task #3:
		// add the label and textfield to one of the HBoxes
		hBox1.getChildren().addAll(label, textField);

		// add the buttons to the other HBox
		hBox2.getChildren().addAll(bt1, bt2, bt3, bt6, bt4, bt5);

		// add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hBox1, hBox2);
	}

	// Task #4:
	// create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getTarget() == bt1) {
				textField.setText(dataMng.getHello());
			} else if (event.getTarget() == bt2) {
				textField.setText(dataMng.getHowdy());
			} else if (event.getTarget() == bt3) {
				textField.setText(dataMng.getChinese());
			} else if (event.getTarget() == bt6) {
				textField.setText(dataMng.getViet());
			} else if (event.getTarget() == bt4) {
				textField.setText("");
			} else if (event.getTarget() == bt5) {
				Platform.exit();
				System.exit(0);
			} else {
				System.out.println("Not implemented yet");
			}
		}
	}

}
