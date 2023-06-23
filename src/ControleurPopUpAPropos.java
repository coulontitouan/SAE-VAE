import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurPopUpAPropos implements EventHandler<ActionEvent> {
    
    private VAE vueVAE;

    public ControleurPopUpAPropos(VAE vueVAE){
        this.vueVAE = vueVAE;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button button = (Button) (actionEvent.getSource());

        if(button.getText().contains("A propos du service")){
            this.vueVAE.popUpAPropos().show();
        }
    }
}
