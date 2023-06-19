import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import java.util.Locale.Category;

import javafx.scene.control.Button;

/**
 * Contrôleur qui permet de filtrer les résultats dans la recherche d'objets
 */
public class ControleurEncherir implements EventHandler<ActionEvent> {
    /**
     * modèle de l'application
     */
    private ModeleVAE modeleVAE;
    /**
     * vue de l'application
     **/
    private VueVAE vueVAE;

    /**
     * @param modeleVAE modèle de l'application
     * @param vueVAE vue d'application'
     */
    public ControleurEncherir(VAE modeleVAE, vueVAE vueVAE) {
        this.modeleVAE = modeleVAE;
        this.vuePendu = vueVAE;
    }

    /**
     * L'action consiste à filtrer les objets à afficher en fonction de ce que l'utilisateur choisi
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        if (b.getText().equals("Confirmer")){
            this.modeleVAE.encherir(this.vueVAE.getObjet(),this.vueVAE.getPrixEnchere());
        }
        
    }
}