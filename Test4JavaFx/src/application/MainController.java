package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private Button btn_Login;
	@FXML
	private TextField txtFld_UName;
	@FXML
	private TextField txtFld_UPassword;

	public void Login() {
		System.out.println(txtFld_UName.getText() + txtFld_UPassword.getText());
		// System.out.println("Hello world");
		Alert msgBox = new Alert(AlertType.ERROR, "出错了", new ButtonType("确定", ButtonBar.ButtonData.YES));
		msgBox.show();
	}

	// When user click on myButton
	// this method will be called.
	//ActionEvent event
	public void showDateTime() {
		System.out.println("Button Clicked!");

		Date now = new Date();

		DateFormat df = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		String dateTimeString = df.format(now);
		// Show in VIEW
		txtFld_UPassword.setText(dateTimeString);

	}

}
