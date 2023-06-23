import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurDeconnexion implements EventHandler<ActionEvent> {
    
    private VAE vueVAE;

    public ControleurDeconnexion(VAE vueVAE){
        this.vueVAE = vueVAE;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Requete.getUser().setTout(0,null,null,null,false,0);
        this.vueVAE.setEstConnecte(false);
        this.vueVAE.majAffichage();
        this.vueVAE.majAffichageConnexion();
    }
}
