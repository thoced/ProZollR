package Views;

import Models.Case.CaseInfo;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class CaseDialog extends Dialog<CaseInfo> {

    public CaseDialog() {
        this.setTitle("Création de dossier");

        // Créer un formulaire avec des champs de texte
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);


        TextField folderNameField = new TextField();
        TextField referenceField = new TextField();
        TextArea remarkField = new TextArea();

        grid.add(new Label("Nom du dossier:"), 0, 0);
        grid.add(folderNameField, 1, 0);
        grid.add(new Label("Référence:"), 0, 1);
        grid.add(referenceField, 1, 1);
        grid.add(new Label("Remarque:"), 0, 2);
        grid.add(remarkField, 1, 2);

        // Ajouter les boutons à la boîte de dialogue
        ButtonType createButtonType = new ButtonType("Créer", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

        this.getDialogPane().setContent(grid);
        this.getDialogPane().getButtonTypes().addAll(createButtonType, cancelButtonType);

        // Récupérer les résultats de la boîte de dialogue lorsqu'elle est fermée
        this.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                return new CaseInfo(
                        folderNameField.getText(),
                        referenceField.getText(),
                        remarkField.getText()
                );
            }
            return null;
        });
    }
}

