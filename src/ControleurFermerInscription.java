import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

import java.util.Optional;
import javafx.scene.control.Button;

/**
 * Contrôleur qui permet de se connecter à l'application et de se déconnecter de celle-ci
 */
public class ControleurFermerInscription implements EventHandler<WindowEvent> {
    /**
     * vue de l'application
     **/
    private VAE vueVAE;

    /**
     * @param modeleVAE modèle de l'application
     * @param vueVAE vue d'application'
     */
    public ControleurFermerInscription(VAE vueVAE) {
        //this.modeleVAE = modeleVAE;
        this.vueVAE = vueVAE;
    }

    /**
     * L'action consiste à se connecter si on appuie sur le bouton de connexion et se déconnecter si on appuie sur le bouton de déconnexion
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(WindowEvent windowEvent) {
        this.vueVAE.setSInscrit(false);
        this.vueVAE.setSeConnecte(false);
    }
}