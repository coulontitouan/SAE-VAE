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
        
        if(button.getText().equals("Accueil")){
            this.appli.modeAccueil();
        }

        if(button.getText().equals("Catégories")){
            this.appli.modeCategorie();
        }

        if(button.getText().equals("Ventes Suivi")){
            this.appli.modeVentes();
        }

        if(button.getText().equals("Vos ventes")){
            this.appli.modeConsultation();
        }

        if(button.getText().equals("A propos du service")){
            this.appli.modeCredit();
        }
    }
}
