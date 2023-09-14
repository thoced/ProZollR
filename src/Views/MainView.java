package Views;

import Models.Case.CaseInfo;
import Models.Communication;
import javafx.application .Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MainView extends Application {


    @Override
    public void init() throws Exception {
        super.init();

        // génération des tables
        Communication communication = new Communication();
        communication.Create();

        CaseInfo caseInfo =  new CaseInfo();
        caseInfo.Create();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {

        // Création d'un MenuBar
        MenuBar menuBar = new MenuBar();

        // Création du premier menu "File" avec les items "Ouvrir" et "Fermer"
        Menu fileMenu = new Menu("File");
        MenuItem newCaseItem = new MenuItem("Créer un nouveau dossier");
        MenuItem fermerItem = new MenuItem("Fermer");
        fileMenu.getItems().addAll(newCaseItem, fermerItem);

        // Création du second menu "Options" avec l'item "Importer"
        Menu optionsMenu = new Menu("Options");
        MenuItem importerItem = new MenuItem("Importer");
        optionsMenu.getItems().add(importerItem);

        newCaseItem.setOnAction(event -> {
            CaseDialog dialog = new CaseDialog();
            Optional<CaseInfo> result =  dialog.showAndWait();
            result.ifPresent(caseInfo -> {
                try {
                    caseInfo.Insert();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        // Ajout des menus au MenuBar
        menuBar.getMenus().addAll(fileMenu, optionsMenu);

        // Création d'un TableView avec trois colonnes : Caller, Called, Duration
        TableView<Communication> tableView = new TableView<>();
        TableColumn<Communication, String> callerColumn = new TableColumn<>("Appelant");
        TableColumn<Communication, String> calledColumn = new TableColumn<>("Appelé");
        TableColumn<Communication, Integer> durationColumn = new TableColumn<>("Durée");
        TableColumn<Communication, String> typeColumn = new TableColumn<>("Type");
        TableColumn<Communication, Date> dateStartColumn = new TableColumn<>("Date de debut");
        TableColumn<Communication, Date> dateEndColumn = new TableColumn<>("Date de fin");
        TableColumn<Communication, Integer> roamingColumn = new TableColumn<>("Roaming");


        // Liaison des propriétés aux colonnes
        callerColumn.setCellValueFactory(new PropertyValueFactory<>("caller"));
        calledColumn.setCellValueFactory(new PropertyValueFactory<>("called"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateStartColumn.setCellValueFactory(new PropertyValueFactory<>("timeStart"));
        dateEndColumn.setCellValueFactory(new PropertyValueFactory<>("timeEnd"));
        roamingColumn.setCellValueFactory(new PropertyValueFactory<>("roaming"));

        durationColumn.setCellFactory(p -> {
            return new TableCell<Communication,Integer>()
            {
                @Override
                protected void updateItem(Integer duration, boolean b) {
                    super.updateItem(duration, b);

                    if(duration == null)
                    {
                        setText("");
                        setStyle("");

                    }
                    else
                    {
                        Calendar calendar = Calendar.getInstance();
                        calendar.clear();
                        calendar.set(Calendar.SECOND,duration);
                        int hour = calendar.get(Calendar.HOUR);
                        int minute = calendar.get(Calendar.MINUTE);
                        int second = calendar.get(Calendar.SECOND);
                        String durationString = hour + ":" + minute + ":" + second;
                        setText(durationString);
                    }
                }
            };

        });
        roamingColumn.setCellFactory(p ->{
            return new TableCell<Communication,Integer>(){
                @Override
                protected void updateItem(Integer item, boolean b) {
                    super.updateItem(item, b);

                    if(item == null)
                    {
                        setText("");
                        setStyle("");

                    }
                    else
                    {
                        if(item == 0)
                        {
                            setText("NON");
                        }
                        else
                        {
                            setText("OUI");
                        }

                    }
                }
            };
        });
        dateStartColumn.setCellFactory(new CellFactoryDate());
        dateEndColumn.setCellFactory(new CellFactoryDate());

        // Ajout des colonnes au TableView
        tableView.getColumns().addAll(callerColumn, calledColumn, durationColumn,typeColumn,dateStartColumn,dateEndColumn,roamingColumn);

        Communication communication = new Communication();
        List<Communication> list = communication.Select("1 = 1");
        tableView.getItems().addAll(list);


        // Création d'un conteneur VBox pour organiser les éléments
        VBox root = new VBox();
        root.getChildren().addAll(menuBar, tableView);
        VBox.setVgrow(tableView, Priority.ALWAYS);

        // Création de la scène
        Scene scene = new Scene(root, 800, 600);

        // Configuration de la scène
        primaryStage.setTitle("JavaFX Menu and TableView Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
