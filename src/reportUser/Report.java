package reportUser;

import javafx.scene.control.Alert;
public class Report {
    public void message(){
        Alert report = new Alert(Alert.AlertType.INFORMATION);
        report.setTitle("Information");
        report.setHeaderText(null);
        report.setContentText("Неправильный ввод");
        report.showAndWait();
    }
    public void messageID(){
        Alert repor = new Alert(Alert.AlertType.INFORMATION);
        repor.setTitle("Information");
        repor.setHeaderText(null);
        repor.setContentText("Неправильный ввод ID");
        repor.showAndWait();
    }
    public void messageDate(){
        Alert repor = new Alert(Alert.AlertType.INFORMATION);
        repor.setTitle("Information");
        repor.setHeaderText(null);
        repor.setContentText("Неправильный ввод даты");
        repor.showAndWait();
    }
}
