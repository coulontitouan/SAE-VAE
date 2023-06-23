import Exceptions.PermissionsManquantesException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurBannir implements EventHandler<ActionEvent> {
    
    private VAE vueVAE;

    private Utilisateur user;

    public ControleurBannir(VAE vueVAE, Utilisateur user){
        this.vueVAE = vueVAE;
        this.user = user;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Requete.changeStatutUtilisateur(this.user.getNum(),false);
        } catch (PermissionsManquantesException e) {
            System.out.println(e);
        }
        this.vueVAE.majAffichageUtlisateur();
        
    }
}
