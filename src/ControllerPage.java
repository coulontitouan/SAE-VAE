import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControllerPage implements EventHandler<ActionEvent> {
    
    private AppliVAE appli;

    public ControllerPage(AppliVAE appli){
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button button = (Button) (actionEvent.getSource());
        
        if(button.getText().contains("Accueil")){
            this.appli.modeAccueil();
        }

        if(button.getText().contains("Catégories")){
            this.appli.modeCategorie();
        }

        if(button.getText().contains("Ventes Suivi")){
            this.appli.modeVentes();
        }

        if(button.getText().contains("Vos ventes")){
            this.appli.modeConsultation();
        }

        if(button.getText().contains("A propos du service")){
            this.appli.modeCredit();
        }
    }
}
