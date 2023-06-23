import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur qui permet de se connecter à l'application et de se déconnecter de celle-ci
 */
public class ControleurConnexion implements EventHandler<ActionEvent> {
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

        String pseudo = this.vueVAE.getIdentifiant().getText();
        String mdp = this.vueVAE.getMotDePasse().getText();

        if (Requete.connexion(pseudo, mdp)){
            int role = Requete.getUser().getRole();
            System.out.println(role);
            this.vueVAE.setRole(role);
            this.vueVAE.exitFenetreConnexion();
            this.vueVAE.setEstConnecte(true);
            this.vueVAE.setSeConnecte(false);
            this.vueVAE.setMessageErreurConnexion(false);
            this.vueVAE.resetTextFieldConnexion();
            this.vueVAE.majAffichageConnexion();
        }
        else{
            this.vueVAE.erreurConnexion();
            this.vueVAE.setMessageErreurConnexion(true);
        }
    }
}