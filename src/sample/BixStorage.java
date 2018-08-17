package sample;

import canges.Cange;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import newStorUse.NewStringStorage;
import reportUser.ReportDeptor;
import searsh.SearshCommon;
import searsh.SearshUser;
import java.sql.SQLException;

import static javafx.scene.paint.Color.WHITESMOKE;

public class BixStorage extends Application {
    private String recipientS = "Фамилия";
    private String recip = "recipientCol";

    private String station = "Участок";
    private String stat = "stationCol";

    private String nomination = "Наименование";
    private String nomina = "nominationCol";

    private String size = "Размер";
    private String si = "sizeCol";

    private String detail = "Деталь";
    private String deta = "detailCol";

    ObservableList<UserStorage> data =
            FXCollections.observableArrayList();
    TableView<UserStorage> table = new TableView<UserStorage>();

    @Override
    public void start(Stage stage) {
        SearshCommon searshCommon = new SearshCommon();
        Conn db = new Conn();

        /*
        подключение базы SQLite  и заполнение таблицы
         */
        Cange cange = new Cange();
        try {
            db.connDB();
            db.createBd();
            db.readBd(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.setEditable(true);

        Scene scene = new Scene(new Group(), WHITESMOKE);
        stage.setTitle("Таблица Мерительного инструмента (БИХ)");
        stage.setWidth(1250);
        stage.setHeight(600);

        final Label label = new Label("Мерительный инструмент");
        label.setFont(new Font("Arial", 20));


        TableColumn recipientCol = new TableColumn("получатель");
        recipientCol.setMinWidth(200);
        recipientCol.setCellValueFactory(
                new PropertyValueFactory<>("recipient"));//


        TableColumn stationCol = new TableColumn("участок");
        stationCol.setMinWidth(30);
        stationCol.setCellValueFactory(
                new PropertyValueFactory<UserStorage, String>("station"));

        TableColumn nominationCol = new TableColumn("наименование");
        nominationCol.setMinWidth(100);
        nominationCol.setCellValueFactory(
                new PropertyValueFactory<UserStorage, String>("nomination"));

        TableColumn sizeCol = new TableColumn("размер");
        sizeCol.setMinWidth(40);
        sizeCol.setCellValueFactory(
                new PropertyValueFactory<UserStorage, String>("size"));

        TableColumn indexCol = new TableColumn("№ номер");
        indexCol.setMinWidth(40);
        indexCol.setCellValueFactory(new PropertyValueFactory<UserStorage, String>("index"));

        TableColumn dateOfIssueCol = new TableColumn("Д/выдачи");
        dateOfIssueCol.setMinWidth(60);
        dateOfIssueCol.setCellValueFactory(
                new PropertyValueFactory<UserStorage, String>("dateOfIssue"));

        TableColumn returnDateCol = new TableColumn("Д/возврата");
        returnDateCol.setMinWidth(60);
        returnDateCol.setCellValueFactory(
                new PropertyValueFactory<UserStorage, String>("returnDate"));

        TableColumn detailCol = new TableColumn("деталь");
        detailCol.setMinWidth(70);
        detailCol.setCellValueFactory(
                new PropertyValueFactory<UserStorage, String>("detail"));


        TableColumn idCol = new TableColumn("№ строки");
        idCol.setMinWidth(40);
        idCol.setCellValueFactory(
                new PropertyValueFactory<UserStorage, String>("id"));


        final MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-background-radius: 5;" + "-fx-background-color: rgb(119, 136, 153);");
        final Menu fileMenu = new Menu("File");
        fileMenu.setStyle("-fx-color: rgb(119, 136, 153);");
        final Menu editMenu = new Menu("Edit");
        final Menu newEditMenu = new Menu("Поиск");
        final Menu view = new Menu("View");


        MenuItem delet = new MenuItem("Удалить");
        MenuItem exit = new MenuItem("Выход");
        MenuItem searshID = new MenuItem("Поиск № ID");
        MenuItem searshRecipient = new MenuItem("Поиск по получателю");
        MenuItem searshStation = new MenuItem("Поиск по участку");
        MenuItem searshNomination = new MenuItem("Поиск по ноименованию");
        MenuItem searSize = new MenuItem("Поиск по размеру");
        MenuItem searDetail = new MenuItem("Поиск по детали");
        MenuItem newStrStor = new MenuItem("Новая строка");
        MenuItem debtor = new MenuItem("Должники");

        fileMenu.getItems().addAll(exit);
        newEditMenu.getItems().addAll(searshID, searshRecipient, searshStation, searshNomination, searSize, searDetail);
        editMenu.getItems().addAll(newEditMenu, newStrStor, delet);
        view.getItems().addAll(debtor);

        menuBar.getMenus().addAll(fileMenu, editMenu, view);

        Button btRenewal = new Button("Обновить");
        btRenewal.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: MistyRose;");
        btRenewal.setPrefSize(100, 30);

        Button btChange = new Button("Изменить");
        btChange.setStyle("-fx-background-radius: 20;" + "-fx-background-color: rgb(105, 105, 105);" + "-fx-text-fill: MistyRose;");
        btChange.setPrefSize(100, 30);



        table.getColumns().addAll(recipientCol, stationCol, nominationCol, sizeCol, indexCol, dateOfIssueCol, returnDateCol, detailCol, idCol);
        table.setStyle("-fx-border-color: black;");


        final VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: transparent;");
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(menuBar, label, table, btRenewal, btChange);

        table.setItems(data);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setFullScreenExitHint("");
        stage.setScene(scene);
        stage.show();


        delet.setOnAction(event -> {
            DeleteId deletId = new DeleteId();
            deletId.delString(stage, data);
        });

        searshID.setOnAction(event -> {
            SearshUser searshUser = new SearshUser();
            searshUser.searshs(data, stage);
        });

        searshRecipient.setOnAction(event -> {
            searshCommon.sCommon(data, stage, recipientS, recip);
        });

        searshStation.setOnAction(event -> {
            searshCommon.sCommon(data, stage, station, stat);
        });

        searshNomination.setOnAction(event -> {
            searshCommon.sCommon(data, stage, nomination, nomina);
        });

        searSize.setOnAction(event -> {
            searshCommon.sCommon(data, stage, size, si);
        });

        searDetail.setOnAction(event -> {
            searshCommon.sCommon(data, stage, detail, deta);
        });

        newStrStor.setOnAction(event -> {
            NewStringStorage nss = new NewStringStorage();
            nss.newStorUser(stage, data);
        });

        debtor.setOnAction(event -> {
                ReportDeptor.startMessageDeptor(stage, data);
            });


        /*
        обновление таблицы
         */
        btRenewal.setOnAction(event -> {
            data.removeAll(data);
            try {
                db.readBd(data);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        /*
        изменение в таблице
         */
        btChange.setOnAction(event -> {
           cange.newCange(stage, data);
        });


        exit.setOnAction(event -> {
            try {
                db.closeBd();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.exit(0);
        });
    }

    /*
    добавление в таблицу
     */
    protected void go(ObservableList<UserStorage> data, String recipientConn, String stationConn, String nominationConn, String sizeConn, String indexConn, String dateOfIssueConn, String returnDateConn, String detailConn, String id) {
        data.add(new UserStorage(recipientConn, stationConn, nominationConn, sizeConn, indexConn, dateOfIssueConn, returnDateConn, detailConn, id));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
