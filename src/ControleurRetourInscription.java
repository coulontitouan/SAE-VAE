import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.control.Button;

public class ControleurRetourInscription implements EventHandler<ActionEvent>{

    /**
     * vue de l'application
     **/
    private VAE vueVAE;

    /**
    * @param modeleVAE modèle de l'application
    * @param vueVAE vue d'application'
    */
    public ControleurRetourInscription(VAE vueVAE) {
        this.vueVAE = vueVAE;
    }

    @Override
    public void handle(ActionEvent e){
        this.vueVAE.setSInscrit(false);
        this.vueVAE.setSeConnecte(false);
        this.vueVAE.modeFenetreConnexion();
        this.vueVAE.exitFenetreInscription();
        
    }
}