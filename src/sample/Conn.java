package sample;
import datesComparing.DateDeptor;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.*;

public class Conn {
    private String textRecipientCol = "Вер";
    private String textStationCol = "1";
    private String textNominationCol = "2";
    private String textSizeCol = "3";
    private String textIndexCol = "4";
    private String textDateOfIssueCol = "5";
    private String textReturnDateCol = "6";
    private String textDetailCol = "7";

    public static Connection conect;
    public static Statement statem;
    public static ResultSet resSet;

    BixStorage bix = new BixStorage();

    /**
     * подключение базы данных
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public  void connDB() throws ClassNotFoundException, SQLException {
        conect = null;
        Class.forName("org.sqlite.JDBC");
        conect = DriverManager.getConnection("jdbc:sqlite:baseTool.s3db");  //
        System.out.println("База Подключена!");
    }// public  void connDB()

    /**
     * проверка или создание таблицы
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public void createBd() throws ClassNotFoundException, SQLException {
        statem = conect.createStatement();
        statem.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'recipientCol' text, 'stationCol' text, 'nominationCol' text,'sizeCol' text, 'indexCol' text, 'dateOfIssueCol' text, 'returnDateCol' text, 'detailCol' text);");
        System.out.println("Таблица создана или существуее");
    }// public void createBd()

    /**
     * запись в базу данных(в дальнейшем Бд)
     * @param textRecipientCol
     * @param textStationCol
     * @param textNominationCol
     * @param textSizeCol
     * @param textIndexCol
     * @param textDateOfIssueCol
     * @param textReturnDateCol
     * @param textDetailCol
     */

    public void writeBd(String textRecipientCol,
                        String textStationCol,
                        String textNominationCol,
                        String textSizeCol,
                        String textIndexCol,
                        String textDateOfIssueCol,
                        String textReturnDateCol,
                        String textDetailCol) throws ClassNotFoundException, SQLException {

       statem.execute("INSERT INTO 'users' ('recipientCol', 'stationCol', 'nominationCol', 'sizeCol', 'indexCol', 'dateOfIssueCol', 'returnDateCol', 'detailCol') VALUES ('" + textRecipientCol + "','" + textStationCol + "','" + textNominationCol + "','" + textSizeCol + "','" + textIndexCol + "','" + textDateOfIssueCol + "','" + textReturnDateCol +"','"+ textDetailCol +"'); ");
        System.out.println("Таблица заполнена");
    }//  public void writeBd

    /**
     * Вывод Бд в таблицу
    */
    public void readBd(ObservableList<UserStorage> data) throws ClassNotFoundException, SQLException {

        resSet = statem.executeQuery("SELECT * FROM users");

        while (resSet.next()) {
            String iD = resSet.getString("id");
            String recipientConn = resSet.getString("recipientCol");
            String stationConn = resSet.getString("stationCol");
            String nominationConn = resSet.getString("nominationCol");
            String sizeConn = resSet.getString("sizeCol");
            String indexConn = resSet.getString("indexCol");
            String dateOfIssueConn = resSet.getString("dateOfIssueCol");
            String returnDateConn = resSet.getString("returnDateCol");
            String detailConn = resSet.getString("detailCol");
            iD.toString();
            bix.go(data, recipientConn, stationConn, nominationConn, sizeConn, indexConn, dateOfIssueConn, returnDateConn, detailConn, iD);

        }
    }//public void readBd(ObservableList<UserStorage> data)

    /**
     * Поиск по ID
     */
    public void readBdOnId(ObservableList<UserStorage> data, int id) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = conect.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setInt(1,id);
        resSet = ps.executeQuery();

        String iD = resSet.getString("id");
        String recipientConn = resSet.getString("recipientCol");
        String stationConn = resSet.getString("stationCol");
        String nominationConn = resSet.getString("nominationCol");
        String sizeConn = resSet.getString("sizeCol");
        String indexConn = resSet.getString("indexCol");
        String dateOfIssueConn = resSet.getString("dateOfIssueCol");
        String returnDateConn = resSet.getString("returnDateCol");
        String detailConn = resSet.getString("detailCol");
        bix.go(data, recipientConn, stationConn, nominationConn, sizeConn, indexConn, dateOfIssueConn, returnDateConn, detailConn, iD);
    }// public void readBdOnId(ObservableList<UserStorage> data, int id) throws ClassNotFoundException, SQLException

    /**
     * поиск по пораметру
     * @param sqlNameField
     */
    public void readBdOnCommon(ObservableList<UserStorage> data, String name, String sqlNameField) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = conect.prepareStatement("SELECT * FROM users WHERE " + sqlNameField + " = ?");
        ps.setString(1,name);
        resSet = ps.executeQuery();

        while (resSet.next()) {

            String iD = resSet.getString("id");
            String recipientConn = resSet.getString("recipientCol");
            String stationConn = resSet.getString("stationCol");
            String nominationConn = resSet.getString("nominationCol");
            String sizeConn = resSet.getString("sizeCol");
            String indexConn = resSet.getString("indexCol");
            String dateOfIssueConn = resSet.getString("dateOfIssueCol");
            String returnDateConn = resSet.getString("returnDateCol");
            String detailConn = resSet.getString("detailCol");
            bix.go(data, recipientConn, stationConn, nominationConn, sizeConn, indexConn, dateOfIssueConn, returnDateConn, detailConn, iD);
        }
    }// public void readBdOnCommon(ObservableList<UserStorage> data, String name, String sqlNameField) throws ClassNotFoundException, SQLException


    /**
     *предача параметров для определения должников
     * @param textDeptors для вывода на экран должников
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void readBdDeptor(TextArea textDeptors) throws ClassNotFoundException, SQLException {

        resSet = statem.executeQuery("SELECT * FROM users");
        while (resSet.next()) {
            String iD = resSet.getString("id");
            String recipientConn = resSet.getString("recipientCol");
            String stationConn = resSet.getString("stationCol");
            String nominationConn = resSet.getString("nominationCol");
            String sizeConn = resSet.getString("sizeCol");
            String indexConn = resSet.getString("indexCol");
            String dateOfIssueConn = resSet.getString("dateOfIssueCol");
            String returnDateConn = resSet.getString("returnDateCol");
            String detailConn = resSet.getString("detailCol");
            iD.toString();
            DateDeptor.receivingDateString(textDeptors, recipientConn, stationConn, nominationConn, sizeConn, indexConn, dateOfIssueConn, returnDateConn, detailConn, iD);
        }
    }//public void readBd(ObservableList<UserStorage> data)

    /**
     *удалить строку
     * @param id какую страку удалить
     */

    public void deletIdString(int id){
        try {
            statem.executeUpdate("DELETE  FROM users WHERE ID = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }// public void deletIdString()

    /**
     * изменение поля Бд
     * @param textCange на что изменяем
     * @param whoCange что изменяем
     * @param id какую страку изменяем
     */

    public void upDate(String textCange, String whoCange, int id){
       String sql = "UPDATE users SET " + whoCange + " = ? "
               + "WHERE ID = ?";
       try {
           PreparedStatement pstmt = conect.prepareStatement(sql);
           pstmt.setString(1, textCange);
           pstmt.setInt(2, id);
           pstmt.executeUpdate();

           } catch (SQLException e1) {
           e1.printStackTrace();
       }
   }//public void upDate(String textCange, String whoCange, int id)

    /**
     * закрытие Бд
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public void closeBd() throws ClassNotFoundException, SQLException {
        conect.close();
        statem.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }// public void closeBd()
}//public class Conn
