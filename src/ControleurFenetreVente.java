import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Optional;

import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * 
 */
public class ControleurFenetreVente implements EventHandler<ActionEvent> {
    /**
     * vue de l'application
     **/
    private VAE vueVAE;
    private Objet objetEnchere;

    /**
     * @param vueVAE vue d'application'
     */
    public ControleurFenetreVente(VAE vueVAE, Objet obj) {
        this.vueVAE = vueVAE;
        this.objetEnchere = obj;
    }
    public ControleurFenetreVente(VAE vueVAE) {
        this.vueVAE = vueVAE;
        this.objetEnchere = null;
    }
    
    /**
     * 
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        if (!this.vueVAE.getConnecte()){
            this.vueVAE.modeFenetreConnexion();
        }
        if (this.vueVAE.getConnecte()){
            Requete.getObjet().setTout(this.objetEnchere.getIdObjet(),this.objetEnchere.getNom(),this.objetEnchere.getDescription(),this.objetEnchere.getImageObjet(),this.objetEnchere.getPrixActuel(),this.objetEnchere.getObjetCategorie(),this.objetEnchere.getNote(),this.objetEnchere.getIdUtilisateur());
            this.vueVAE.modeEnchere(); 
        }

    }
}