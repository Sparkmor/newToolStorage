package sample;

import reportUser.Report;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;


public class DeleteId {
    private int id;
    Conn connDel = new Conn();
    Report report = new Report();
    public void delString(Stage stage, ObservableList<UserStorage> data) {
        Stage delStage = new Stage();
        delStage.setTitle("Удалить строку");
        delStage.initModality(Modality.WINDOW_MODAL);
        delStage.initOwner(stage);
        delStage.setX(stage.getX() + 890);
        delStage.setY(stage.getY() + 100);

        Pane delPane = new Pane();
        delPane.setStyle("-fx-background-color: rgb(143, 188, 143);");

        Button btDel = new Button("удалить");
        btDel.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: Honeydew;");
        btDel.setTranslateX(170);
        btDel.setTranslateY(10);
        btDel.setPrefSize(60, 15);

        TextField textFieldDel = new TextField();
        textFieldDel.setPromptText("№ строки");
        textFieldDel.setTranslateX(20);
        textFieldDel.setTranslateY(10);
        textFieldDel.setPrefSize(80, 15);

        btDel.setOnAction(event -> {
            if (textFieldDel.getText().length() == 0 || textFieldDel.getText().matches("-?[\\d]+") == false ) {
                System.out.println("выход");
                report.message();
            }else {
                id = Integer.parseInt(textFieldDel.getText());
                connDel.deletIdString(id);
                data.removeAll(data);
                try {
                    connDel.readBd(data);
                    delStage.close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }//else
        });//btDel
        delPane.getChildren().addAll(btDel, textFieldDel);

        Scene delScene = new Scene(delPane, 260, 50);

        delStage.setScene(delScene);
        delStage.show();
    }// public void delString
}
