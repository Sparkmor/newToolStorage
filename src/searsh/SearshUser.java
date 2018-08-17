package searsh;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import newStorUse.NewStringStorage;
import reportUser.Report;
import sample.Conn;
import sample.UserStorage;

import java.sql.SQLException;

public class SearshUser extends NewStringStorage {
    private String result;
    Conn connReadBd = new Conn();
    Report report = new Report();
    public void searshs(ObservableList<UserStorage> data, Stage stage) {
        Stage searStage = new Stage();
        searStage.setTitle("Поиск");
        searStage.initModality(Modality.WINDOW_MODAL);
        searStage.initOwner(stage);
        searStage.setX(stage.getX() + 890);
        searStage.setY(stage.getY() + 100);


        final Label labeID = new Label("№ ID (строки)");
        labeID.setFont(new Font("Arial", 16));
        labeID.setTranslateY(10);
        labeID.setTranslateX(10);


        final TextField textID = new TextField();
        textID.setTranslateY(10);
        textID.setTranslateX(130);
        textID.setPrefSize(130, 16);


        final Button btnSershColum = new Button("поиск");
        btnSershColum.setTranslateY(40);
        btnSershColum.setTranslateX(130);
        btnSershColum.setPrefSize(100, 16);


        Pane paneNewStr = new Pane();
        paneNewStr.getChildren().addAll(
                textID,
                labeID,
                btnSershColum);

        Scene sceneNewStr = new Scene(paneNewStr, 340, 70);

        searStage.setScene(sceneNewStr);
        searStage.show();

        btnSershColum.setOnAction(event -> {
            try {
                goButun(data, textID);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private void goButun(ObservableList<UserStorage> data, TextField textID) throws SQLException, ClassNotFoundException {

        if (textID.getText().length() == 0 || textID.getText().matches("-?[\\d]+") == false) {
            System.out.println("ошибка");
            report.message();
        }else {
            data.removeAll(data);
            result = textID.getText().toString();
          int id = Integer.parseInt(result);

            connReadBd.readBdOnId(data, id);
        }

    }
}
