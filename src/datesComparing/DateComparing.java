package datesComparing;

import javafx.collections.ObservableList;
import javafx.stage.Stage;
import sample.UserStorage;

public interface DateComparing {
    //получил, преоброзовал
  void receivingDateString(Stage stage, ObservableList<UserStorage> data, String recipientConn, String stationConn, String nominationConn, String sizeConn, String indexConn, String dateOfIssueConn, String returnDateConn, String detailConn, String iD);
    }

