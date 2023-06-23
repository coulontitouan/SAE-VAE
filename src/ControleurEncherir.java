import Exceptions.MontantTropFaibleException;
import Exceptions.UtilisateurNonConnecteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurEncherir implements EventHandler<ActionEvent> {
    
    private VAE vueVAE;

    public ControleurEncherir(VAE vueVAE){
        this.vueVAE = vueVAE;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.vueVAE.getConnecte() && this.vueVAE.getValideAge()){
            try{
                Double montant = Double.parseDouble(this.vueVAE.getValeurEnchere());
                Requete.faitUneEnchere(Requete.getObjet().getIdObjet(), montant);
                this.vueVAE.setMessageErreurEnchere(false);
            }catch(UtilisateurNonConnecteException e){
                this.vueVAE.fenetreConnexion();
            }catch(MontantTropFaibleException e){
                this.vueVAE.setMessageErreurEnchere(true);
            }catch(NumberFormatException e){
                this.vueVAE.setMessageErreurEnchere(true);
            }
        }else{
            this.vueVAE.setMessageErreurEnchere(true);
        }
        this.vueVAE.setValideAge(false);
        this.vueVAE.majAffichageFenetreEnchere();
        
    }
}
