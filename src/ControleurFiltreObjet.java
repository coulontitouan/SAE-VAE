import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.control.Button;

/**
 * Contrôleur qui permet de rechercher un objet dans les objets mis en vente
 */
public class ControleurFiltreObjet implements EventHandler<ActionEvent> {
    /**
     * vue de l'application
     **/
    private VAE vueVAE;

    /**
     * @param vueVAE vue d'application'
     */
    public ControleurFiltreObjet(VAE vueVAE) {
        this.vueVAE = vueVAE;
    }

    /**
     * L'action consiste à rechercher si le nom entré dans la barre de recherche se rapproche du nom d'un objet dans la BD
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        
        this.vueVAE.majAffichageObjet(Requete.obtenirObjetFiltre(this.vueVAE.getCategorieCombo().getValue().toString(), this.vueVAE.getPrixMinObjet().getText(), this.vueVAE.getPrixMaxObjet().getText()));
    }
}