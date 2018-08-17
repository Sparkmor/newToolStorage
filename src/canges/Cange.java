package canges;

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


public class Cange {
    private String textRecipientCol = "recipientCol";
    private String textStationCol = "stationCol";
    private String textNominationCol = "nominationCol";
    private String textSizeCol = "sizeCol";
    private String textIndexCol = "indexCol";
    private String textDateOfIssueCol = "dateOfIssueCol";
    private String textReturnDateCol = "returnDateCol";
    private String textDetailCol = "detailCol";
    private int id = 0;

    Conn connCange = new Conn();
    Report report = new Report();

    public void newCange(Stage stage, ObservableList<UserStorage> data) {
        Stage newStrStStage = new Stage();
        newStrStStage.setTitle("Изменить");
        newStrStStage.initModality(Modality.WINDOW_MODAL);
        newStrStStage.initOwner(stage);
        newStrStStage.setX(stage.getX() + 900);
        newStrStStage.setY(stage.getY() + 40);


        final Label labeID = new Label("Номер ID");
        labeID.setFont(new Font("Arial", 16));
        labeID.setTranslateY(10);
        labeID.setTranslateX(20);


        final Label labeRecipient = new Label("Получатель");
        labeRecipient.setFont(new Font("Arial", 16));
        labeRecipient.setTranslateY(50);
        labeRecipient.setTranslateX(20);

        final Label labeStation = new Label("Участок");
        labeStation.setFont(new Font("Arial", 16));
        labeStation.setTranslateY(90);
        labeStation.setTranslateX(20);

        final Label labeNomination = new Label("Наименование");
        labeNomination.setFont(new Font("Arial", 16));
        labeNomination.setTranslateY(130);
        labeNomination.setTranslateX(20);

        final Label labeSize = new Label("Размер");
        labeSize.setFont(new Font("Arial", 16));
        labeSize.setTranslateY(170);
        labeSize.setTranslateX(20);

        final Label labeIndex = new Label("№ номер");
        labeIndex.setFont(new Font("Arial", 16));
        labeIndex.setTranslateY(210);
        labeIndex.setTranslateX(20);

        final Label labeDateOfIssue = new Label("Д/выдачи");
        labeDateOfIssue.setFont(new Font("Arial", 16));
        labeDateOfIssue.setTranslateY(250);
        labeDateOfIssue.setTranslateX(20);

        final Label labeReturnDate = new Label("Д/возврата");
        labeReturnDate.setFont(new Font("Arial", 16));
        labeReturnDate.setTranslateY(290);
        labeReturnDate.setTranslateX(20);

        final Label labeDetail = new Label("Деталь");
        labeDetail.setFont(new Font("Arial", 16));
        labeDetail.setTranslateY(330);
        labeDetail.setTranslateX(20);


        final TextField textFieldID = new TextField();//est
        textFieldID.setTranslateY(10);
        textFieldID.setTranslateX(140);
        textFieldID.setPrefSize(130, 20);

        final TextField textFieldRecipint = new TextField();//est
        textFieldRecipint.setTranslateY(50);
        textFieldRecipint.setTranslateX(140);
        textFieldRecipint.setPrefSize(130, 20);


        final TextField textFieldNomination = new TextField();
        textFieldNomination.setTranslateY(130);
        textFieldNomination.setTranslateX(140);
        textFieldNomination.setPrefSize(130, 16);

        final TextField textFieldSize = new TextField();
        textFieldSize.setTranslateY(170);
        textFieldSize.setTranslateX(140);
        textFieldSize.setPrefSize(130, 16);

        final TextField textFieldIndex = new TextField();
        textFieldIndex.setTranslateY(210);
        textFieldIndex.setTranslateX(140);
        textFieldIndex.setPrefSize(130, 16);

        final TextField textFieldDateOfIssue = new TextField();
        textFieldDateOfIssue.setTranslateY(250);
        textFieldDateOfIssue.setTranslateX(140);
        textFieldDateOfIssue.setPrefSize(130, 16);

        final TextField textFieldReturnDate = new TextField();
        textFieldReturnDate.setTranslateY(290);
        textFieldReturnDate.setTranslateX(140);
        textFieldReturnDate.setPrefSize(130, 16);

        final TextField textFieldDetail = new TextField();
        textFieldDetail.setTranslateY(330);
        textFieldDetail.setTranslateX(140);
        textFieldDetail.setPrefSize(130, 16);

        final ComboBox comboStation = new ComboBox();
        comboStation.setTranslateY(90);
        comboStation.setTranslateX(140);
        comboStation.setPrefSize(80, 16);
        comboStation.getItems().addAll("1", "2", "3", "4", "5", "склад");


        final Button btnNewTableColum = new Button("Изменить");
        btnNewTableColum.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: MistyRose;");
        btnNewTableColum.setTranslateY(370);
        btnNewTableColum.setTranslateX(140);
        btnNewTableColum.setPrefSize(100, 16);


        Pane paneNewStr = new Pane();
        paneNewStr.setStyle("-fx-background-color: rgb(143, 188, 143);");
        paneNewStr.getChildren().addAll(
                textFieldID,
                textFieldRecipint,
                comboStation,
                textFieldNomination,
                textFieldSize,
                textFieldIndex,
                textFieldDateOfIssue,
                textFieldReturnDate,
                textFieldDetail,
                labeID,
                labeRecipient,
                labeStation,
                labeNomination,
                labeSize,
                labeIndex,
                labeDateOfIssue,
                labeReturnDate,
                labeDetail,
                btnNewTableColum);

        Scene sceneNewStr = new Scene(paneNewStr, 300, 500, Color.rgb(143, 188, 143));

        newStrStStage.setScene(sceneNewStr);
        newStrStStage.show();


        btnNewTableColum.setOnAction(event -> {
            goButtonCange(data, textFieldID,
                    textFieldRecipint,
                    textFieldNomination,
                    textFieldSize,
                    textFieldIndex,
                    textFieldDateOfIssue,
                    textFieldReturnDate,
                    textFieldDetail,
                    comboStation);

        });
    }

    private void goButtonCange(ObservableList<UserStorage> data,
                               TextField textFieldID,
                               TextField textFieldRecipint,
                               TextField textFieldNomination,
                               TextField textFieldSize,
                               TextField textFieldIndex,
                               TextField textFieldDateOfIssue,
                               TextField textFieldReturnDate,
                               TextField textFieldDetail,
                               ComboBox comboStation) {

        if (textFieldID.getText().length() == 0 || textFieldID.getText().matches("-?[\\d]+") == false) {
            report.messageID();
        } else {
            setId(Integer.parseInt(textFieldID.getText().toString()));

            if (textFieldRecipint.getText().length() == 0) {
                System.out.println("Recipient = 0");
              } else {
                connCange.upDate(textFieldRecipint.getText().toString(), textRecipientCol, getId());
              }
            if (textFieldNomination.getText().length() == 0) {
                System.out.println("Nomination = 0");
              } else {
                connCange.upDate(textFieldNomination.getText().toString(), textNominationCol, getId());
              }
            if (textFieldSize.getText().length() == 0) {
                System.out.println("Size = 0");
              } else {
                connCange.upDate(textFieldSize.getText().toString(), textSizeCol, getId());
              }
            if (textFieldIndex.getText().length() == 0) {
                System.out.println("Index = 0");
              } else {
                connCange.upDate(textFieldIndex.getText().toString(), textIndexCol, getId());
              }
            if (textFieldDateOfIssue.getText().length() == 0) {
                System.out.println("DateOfIssue = 0");
            } else {
                connCange.upDate(textFieldDateOfIssue.getText().toString(), textDateOfIssueCol, getId());
            }
            if (textFieldReturnDate.getText().length() == 0) {
                System.out.println("ReturnDate = 0");
              } else {
                connCange.upDate(textFieldReturnDate.getText().toString(), textReturnDateCol, getId());
              }
            if (textFieldDetail.getText().length() == 0) {
                System.out.println("Detail = 0");
              } else {
                connCange.upDate(textFieldDetail.getText().toString(), textDetailCol, getId());
              }
            if (comboStation.getValue() == null) {
                System.out.println("Station = 0");
              } else {
                connCange.upDate(comboStation.getValue().toString(), textStationCol, getId());
              }
            renewalCange(data);
        }
    }

    private void renewalCange(ObservableList<UserStorage> data) {
        data.removeAll(data);
        try {
            connCange.readBdOnId(data, getId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
