package Views;

import Models.Communication;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CellFactoryDate implements Callback<TableColumn<Communication, Date>, TableCell<Communication, Date>> {
    @Override
    public TableCell<Communication, Date> call(TableColumn<Communication, Date> param) {
        return new TableCell<Communication, Date>() {
            @Override
            protected void updateItem(Date item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                    setText(dateFormat.format(item));
                    setStyle("-fx-text-fill: blue;");
                }
            }
        };
    }
}

