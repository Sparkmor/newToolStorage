package reportUser;

import javafx.collections.ObservableList;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Conn;
import sample.UserStorage;

import java.sql.SQLException;

public class ReportDeptor {

    public static void startMessageDeptor(Stage stage, ObservableList<UserStorage> data) {

        Stage stRd = new Stage();
        stRd.setTitle("Сообщение о должниках");
        stRd.initModality(Modality.WINDOW_MODAL);
        stRd.initOwner(stage);
        stRd.setX(stage.getX() + 900);
        stRd.setY(stage.getY() + 40);

        final Label labeDeptor = new Label();
        labeDeptor.setFont(new Font("Arial", 16));
        labeDeptor.setTranslateY(210);
        labeDeptor.setTranslateX(20);

        TextArea textDeptors = new TextArea();
        textDeptors.setPrefSize(400, 400);

        Button bTDeptor = new Button("Должники");
        bTDeptor.setTranslateX(10);
        bTDeptor.setTranslateY(410);
        bTDeptor.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: MistyRose;");

        Button bTprintTextArea = new Button("Печать");
        bTprintTextArea.setTranslateX(90);
        bTprintTextArea.setTranslateY(410);
        bTprintTextArea.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: MistyRose;");

        Pane paneDeptor = new Pane();
        paneDeptor.setStyle("-fx-background-color: rgb(143, 188, 143);");
        paneDeptor.getChildren().addAll(textDeptors, bTDeptor, bTprintTextArea);

        Scene sceneDeptor = new Scene(paneDeptor, 400, 500, Color.rgb(143, 188, 143));

        stRd.setScene(sceneDeptor);
        stRd.show();

        bTDeptor.setOnAction(event -> {
            try {
                Conn.readBdDeptor(textDeptors);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        bTprintTextArea.setOnAction(event -> {
            print(textDeptors);
        });

    }

    public static void goPrintDeptors(String dedtors, TextArea textDeptor) {
        textDeptor.appendText(dedtors);
        textDeptor.appendText("\n");
    }



    private static void print(Node node) {

            PrinterJob job = PrinterJob.createPrinterJob();

            if (job != null) {
                boolean printed = job.printPage(node);
                if (printed) {
                    job.endJob();
                } else {
                    System.out.println("ошибка печати");
                }
            } else {
                System.out.println("ошибка задания печати");
            }
        }
    }

