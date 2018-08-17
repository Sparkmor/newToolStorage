package searsh;

import canges.Cange;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import reportUser.Report;
import sample.Conn;
import sample.UserStorage;

import java.sql.SQLException;


public class SearshCommon {

    private String result;
    Conn connReadBd = new Conn();
    Report report = new Report();
    Cange cange = new Cange();

    public void sCommon(ObservableList<UserStorage> data, Stage stage, String searshName, String searshSqlField) {
        Stage searStage = new Stage();
        searStage.setTitle("Поиск");
        searStage.initModality(Modality.WINDOW_MODAL);
        searStage.initOwner(stage);
        searStage.setX(stage.getX() + 890);
        searStage.setY(stage.getY() + 100);


        final Label labeCommon = new Label(searshName);
        labeCommon.setFont(new Font("Arial", 16));
        labeCommon.setTranslateY(10);
        labeCommon.setTranslateX(10);


        final TextField textCommon = new TextField();
        textCommon.setStyle("-fx-background-radius: 10;");
        textCommon.setTranslateY(10);
        textCommon.setTranslateX(130);
        textCommon.setPrefSize(130, 16);


        final Button btnSershColum = new Button("поиск");
        btnSershColum.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: Honeydew;");
        btnSershColum.setTranslateY(40);
        btnSershColum.setTranslateX(130);
        btnSershColum.setPrefSize(100, 16);


        final Button btnCange = new Button("изменить");
        btnCange.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: Honeydew;");
        btnCange.setTranslateY(40);
        btnCange.setTranslateX(10);
        btnCange.setPrefSize(100, 16);


        Pane paneSearhs = new Pane();
        paneSearhs.setStyle("-fx-background-color: rgb(143, 188, 143);");
        paneSearhs.getChildren().addAll(
                textCommon,
                labeCommon,
                btnSershColum,
                btnCange);

        Scene sceneNewStr = new Scene(paneSearhs, 340, 70);

        searStage.setScene(sceneNewStr);
        searStage.show();

        btnSershColum.setOnAction(event -> {
            try {
                goButun(data, textCommon, searshSqlField);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        btnCange.setOnAction(event -> {
            cange.newCange(stage,data);
        });
    }

    private void goButun(ObservableList<UserStorage> data, TextField textID, String searshSqlField) throws SQLException, ClassNotFoundException {

        if (textID.getText().length() == 0) {
            System.out.println("ошибка");
            report.message();
        } else {
            data.removeAll(data);
            result = textID.getText().toString();
            connReadBd.readBdOnCommon(data, result, searshSqlField);
        }

    }
}

