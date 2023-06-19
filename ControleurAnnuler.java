import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.control.Button;

/**
 * Contrôleur qui permet d'annuler une action
 */
public class ControleurAnnuler implements EventHandler<ActionEvent> {
    /**
     * modèle de l'application
     */
    private ModeleVAE modeleVAE;
    /**
     * vue de l'application
     **/
    private AppliVAE vueVAE;

    /**
     * @param modeleVAE modèle de l'application
     * @param vueVAE vue d'application'
     */
    public ControleurConnexionDeconnexion(VAE modeleVAE, vueVAE vueVAE) {
        this.modeleVAE = modeleVAE;
        this.vuePendu = vueVAE;
    }

    /**
     * L'action consiste à se connecter si on appuie sur le bouton de connexion et se déconnecter si on appuie sur le bouton de déconnexion
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        this.modeleVAE.annulerEnchere();
    }
}