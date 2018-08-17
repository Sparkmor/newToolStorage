package newStorUse;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import reportUser.Report;
import sample.Conn;
import sample.UserStorage;

import java.sql.SQLException;


public class NewStringStorage {

    private String textRecipientCol = "";
    private String textStationCol = "";
    private String textNominationCol = "";
    private String textSizeCol = "";
    private String textIndexCol = "";
    private String textDateOfIssueCol = "";
    private String textReturnDateCol = "";
    private String textDetailCol = "";

    Conn db = new Conn();
    Report report = new Report();

    public void newStorUser(Stage stage, ObservableList<UserStorage> data) {
        Stage newStrStStage = new Stage();
        newStrStStage.setTitle("новая строка");
        newStrStStage.initModality(Modality.WINDOW_MODAL);
        newStrStStage.initOwner(stage);
        newStrStStage.setX(stage.getX() + 900);
        newStrStStage.setY(stage.getY() + 40);


        final Label labeRecipient = new Label("Получатель");
        labeRecipient.setFont(new Font("Arial", 16));
        labeRecipient.setTranslateY(10);
        labeRecipient.setTranslateX(20);

        final Label labeStation = new Label("Участок");
        labeStation.setFont(new Font("Arial", 16));
        labeStation.setTranslateY(50);
        labeStation.setTranslateX(20);

        final Label labeNomination = new Label("Наименование");
        labeNomination.setFont(new Font("Arial", 16));
        labeNomination.setTranslateY(90);
        labeNomination.setTranslateX(20);

        final Label labeSize = new Label("Размер");
        labeSize.setFont(new Font("Arial", 16));
        labeSize.setTranslateY(130);
        labeSize.setTranslateX(20);

        final Label labeIndex = new Label("№ номер");
        labeIndex.setFont(new Font("Arial", 16));
        labeIndex.setTranslateY(170);
        labeIndex.setTranslateX(20);

        final Label labeDateOfIssue = new Label("Д/выдачи");
        labeDateOfIssue.setFont(new Font("Arial", 16));
        labeDateOfIssue.setTranslateY(210);
        labeDateOfIssue.setTranslateX(20);

        final Label labeReturnDate = new Label("Д/возврата");
        labeReturnDate.setFont(new Font("Arial", 16));
        labeReturnDate.setTranslateY(250);
        labeReturnDate.setTranslateX(20);

        final Label labeDetail = new Label("Деталь");
        labeDetail.setFont(new Font("Arial", 16));
        labeDetail.setTranslateY(290);
        labeDetail.setTranslateX(20);

        final TextField textFieldRecipint = new TextField();//est
        textFieldRecipint.setTranslateY(10);
        textFieldRecipint.setTranslateX(140);
        textFieldRecipint.setPrefSize(130, 20);


        final TextField textFieldNomination = new TextField();
        textFieldNomination.setTranslateY(90);
        textFieldNomination.setTranslateX(140);
        textFieldNomination.setPrefSize(130, 16);

        final TextField textFieldSize = new TextField();
        textFieldSize.setTranslateY(130);
        textFieldSize.setTranslateX(140);
        textFieldSize.setPrefSize(130, 16);

        final TextField textFieldIndex = new TextField();
        textFieldIndex.setTranslateY(170);
        textFieldIndex.setTranslateX(140);
        textFieldIndex.setPrefSize(130, 16);

        final TextField textFieldDateOfIssue = new TextField();
        textFieldDateOfIssue.setTranslateY(210);
        textFieldDateOfIssue.setTranslateX(140);
        textFieldDateOfIssue.setPrefSize(130, 16);

        final TextField textFieldReturnDate = new TextField();
        textFieldReturnDate.setTranslateY(250);
        textFieldReturnDate.setTranslateX(140);
        textFieldReturnDate.setPrefSize(130, 16);

        final TextField textFieldDetail = new TextField();
        textFieldDetail.setTranslateY(290);
        textFieldDetail.setTranslateX(140);
        textFieldDetail.setPrefSize(130, 16);

        final ComboBox comboStation = new ComboBox();
        comboStation.setTranslateY(50);
        comboStation.setTranslateX(140);
        comboStation.setPrefSize(50, 16);
        comboStation.getItems().addAll(1, 2, 3, 4, 5);
        //for (String name : nominationComb) {
        //  comboNomination.getItems().addAll(name);
        //}


        final Button btnNewTableColum = new Button("новая строка");
        btnNewTableColum.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: MistyRose;");
        btnNewTableColum.setTranslateY(330);
        btnNewTableColum.setTranslateX(140);
        btnNewTableColum.setPrefSize(100, 16);


        Pane paneNewStr = new Pane();
        paneNewStr.setStyle("-fx-background-color: rgb(143, 188, 143);");
        paneNewStr.getChildren().addAll(
                textFieldRecipint,
                comboStation,
                textFieldNomination,
                textFieldSize,
                textFieldIndex,
                textFieldDateOfIssue,
                textFieldReturnDate,
                textFieldDetail,
                labeRecipient,
                labeStation,
                labeNomination,
                labeSize,
                labeIndex,
                labeDateOfIssue,
                labeReturnDate,
                labeDetail,
                btnNewTableColum);

        Scene sceneNewStr = new Scene(paneNewStr, 300,500, Color.rgb(143, 188, 143));

        newStrStStage.setScene(sceneNewStr);
        newStrStStage.show();


        btnNewTableColum.setOnAction(event -> {
            try {
                if (textFieldRecipint.getText().length() == 0 ||
                        comboStation.getValue() == null ||
                        textFieldNomination.getText().length() == 0 ||
                        textFieldSize.getText().length() == 0 ||
                        textFieldIndex.getText().length() == 0 ||
                        textFieldDateOfIssue.getText().length() == 0 ||
                        textFieldReturnDate.getText().length() == 0 ||
                        textFieldDetail.getText().length() == 0) {
                    report.message();
                } else {
                    textRecipientCol = textFieldRecipint.getText();
                    textStationCol = comboStation.getValue().toString();
                    textNominationCol = textFieldNomination.getText();
                    textSizeCol = textFieldSize.getText();
                    textIndexCol = textFieldIndex.getText();
                    textDateOfIssueCol = textFieldDateOfIssue.getText();
                    textReturnDateCol = textFieldReturnDate.getText();
                    textDetailCol = textFieldDetail.getText();
                    data.removeAll(data);
                    db.writeBd(textRecipientCol, textStationCol, textNominationCol, textSizeCol, textIndexCol, textDateOfIssueCol, textReturnDateCol, textDetailCol);
                    db.readBd(data);
                    newStrStStage.close();
                }



                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                } catch(SQLException e){
                    e.printStackTrace();
                }

        });




    }
}