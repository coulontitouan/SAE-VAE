import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurSelectionnerUser implements EventHandler<ActionEvent> {
    
    private VAE vueVAE;

    private Utilisateur user;

    public ControleurSelectionnerUser(VAE vueVAE, Utilisateur user){
        this.vueVAE = vueVAE;
        this.user = user;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        
        this.vueVAE.majAffichageObjet(Requete.obtenirParUtilisateur(this.user.getNum()));
        
    }
}
