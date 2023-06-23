import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur qui permet de filtrer les résultats dans la recherche d'objets
 */
public class ControleurFenetres implements EventHandler<ActionEvent> {
    /**
     * modèle de l'application
     */
    //private ModeleVAE modeleVAE;
    /**
     * vue de l'application
     **/
    private VAE vueVAE;

    /**
     * @param modeleVAE modèle de l'application
     * @param vueVAE vue d'application'
     */
    public ControleurFenetres(VAE vueVAE) {
        this.vueVAE = vueVAE;
    }

    /**
     * L'action consiste à filtrer les objets à afficher en fonction de ce que l'utilisateur choisi
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        if (b.getText().equals("Accueil")){
            this.vueVAE.modeAccueil();
        }
        if (b.getText().equals("Vendre")){
            this.vueVAE.modeVendre();
        }
        if (b.getText().equals("Ventes Suivies")){
            this.vueVAE.modeVentesSuivies();
        }
        if (b.getText().equals("A propos du service")){
            this.vueVAE.modeAProposDuService();
        }
        if (b.getText().equals("Vos ventes")){
            this.vueVAE.modeVosVentes();
        }
        if (b.getText().equals("Enchérir")){
            this.vueVAE.modeEnchere();
        }
        if (b.getText().equals("Administrateur")){
            System.out.println("a");
            this.vueVAE.modeAdmin();
        }
    }
}