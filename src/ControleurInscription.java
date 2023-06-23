import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Optional;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * Contrôleur qui permet de s'inscrire à l'application (à s'inscrire dans la BD)
 */
public class ControleurInscription implements EventHandler<ActionEvent> {
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
    public ControleurInscription(VAE vueVAE) {
        this.vueVAE = vueVAE;
    }

    /**
     * L'action consiste à se connecter si on appuie sur le bouton de connexion et se déconnecter si on appuie sur le bouton de déconnexion
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        if(!vueVAE.getInscriptionMDP().equals(vueVAE.getInscriptionConfirmationMDP())){
            //return motDePasseDifferent
            this.vueVAE.setMessageErreurInscription(true);
        }else{
            if(Requete.inscription(vueVAE.getInscriptionPseudo(), vueVAE.getInscriptionMail(), vueVAE.getInscriptionMDP())){
                int role = Requete.getUser().getRole();
                System.out.println(role);
                this.vueVAE.setRole(role);
                this.vueVAE.setSeConnecte(false);
                this.vueVAE.setSInscrit(false);
                this.vueVAE.setMessageErreurInscription(false);
                this.vueVAE.exitFenetreInscription();
                this.vueVAE.setEstConnecte(true);
                this.vueVAE.majAffichageConnexion();
                this.vueVAE.majAffichage();
            }
            else{
                System.out.println("ca marche passsss");
                this.vueVAE.setMessageErreurInscription(true);
            }
        }

        // String pseudo = this.vueVAE.getIdentifiant().getText();
        // String email = this.vueVAE.getEmail().getText();
        // String mdp = this.vueVAE.getMotDePasse().getText();

        // if (Requete.inscription( pseudo , email , mdp )){
        //     this.vueVAE.exitFenetreConnexion();
        //     this.vueVAE.setEstConnecte(true);
        //     this.vueVAE.setMessageErreurConnexion(false);
        //     this.vueVAE.majAffichageConnexion();
        // }
        // else{
        //     this.vueVAE.erreurConnexion();
        //     this.vueVAE.setMessageErreurConnexion(true);
        // }
    }
}