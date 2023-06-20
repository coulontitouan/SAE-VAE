import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

import java.sql.SQLException;
import java.util.Optional;

import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * Contrôleur qui permet de se connecter à l'application et de se déconnecter de celle-ci
 */
public class ControleurConnexion implements EventHandler<ActionEvent> {
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
    public ControleurConnexion(VAE vueVAE) {
        //this.modeleVAE = modeleVAE;
        this.vueVAE = vueVAE;
    }

    /**
     * L'action consiste à se connecter si on appuie sur le bouton de connexion et se déconnecter si on appuie sur le bouton de déconnexion
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {

        //this.modeleVAE.getUser().setNomUser(fenetre.getLoginFieldText());
        //this..getUser().setMdpUser(fenetre.getPasswordFieldText());

        // Button b = (Button) actionEvent.getSource();
        // if (b.getText().equals("Connexion")){
        //     this.modeleVAE.connexion();
        // }
        // if (b.getText().equals("Déconnexion")){
        //     this.modeleVAE.deconnecter();
        // }

        String pseudo = this.vueVAE.getIdentifiant();
        String mdp = this.vueVAE.getMotDePasse();

        try {
			if (Requete.connexion(new ConnexionMySQL(), pseudo, mdp)){
                this.vueVAE.majAffichage();
                this.vueVAE.exitFenetreConnexion();
                System.out.println("connecté");
            }
            else{
                this.vueVAE.erreurConnexion();
                System.out.println("non trouvé");
            }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}