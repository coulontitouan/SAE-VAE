import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.control.Button;

/**
 * Contrôleur qui permet de filtrer les résultats dans la recherche d'objets
 */
public class ControleurFiltre implements EventHandler<ActionEvent> {
    /**
     * modèle de l'application
     */
    private ModeleVAE modeleVAE;
    /**
     * vue de l'application
     **/
    private AppliVAE appliVAE;

    /**
     * @param modeleVAE modèle de l'application
     * @param vueVAE vue d'application'
     */
    public ControleurFiltre(VAE modeleVAE, vueVAE vueVAE) {
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
        Categorie categorieFiltre = this.vueVAE.getCategorieFiltre();
        Integer prixMinFiltre = this.vueVAE.getPrixMinFiltre();
        Integer prixMaxFiltre = this.vueVAE.getPrixMaxFiltre();
        String typeVenteFiltre = this.vae.getTypeVenteFiltre();
        this.modeleVAE.setFiltre(categorieFiltre,prixMinFiltre,prixMaxFiltre,typeVenteFiltre);
    }
}