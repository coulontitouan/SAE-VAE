import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class AppliVAE extends application{
    /**
     * Boutton permettant de se connecter
     */
    private Button boutonConnexion;

    /**
     * Boutton permettant de se deconnecter
     */
    private Button boutonDeconnexion;

    /**
     * Bouton permettant d'accéder à son panier
     */
    private Button boutonPanier;

    /**
     * Bouton permettant d'aller sur la page acceuil
     */
    private Button boutonAcceuil;

    /**
     * Bouton pemettant d'aller sur la page Catégorie
     */
    private Button boutonCategorie;

    /**
     * Bouton permettant d'aller sur la page Ventes Suivi
     */
    private Button boutonVenteSuivi;

    /**
     * Bouton permettant d'aller sur la page "A propos du service"
     */
    private Button boutonAPropos;

    /**
     * Textfiel pour la recherche (à enlever si necessaire)
     */
    private TextField barreRecherche;

    /**
     * boolean indiquant si l'utilisateur est connectée (à modifier quand modele dispo)
     */
    private boolean estConnectee;

    /**
     * Logo du site
     */
    private ImageView logo;

    @Override
    public void init() {
        this.logo = new ImageView("Logo_VAE.png");
        this.barreRecherche = new TextField();

    }

    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.baniere());
        return new Scene(fenetre, 800, 1000);
    }

    private Pane baniere(){
        BorderPane pane = new BorderPane();
        BorderPane top = new BorderPane();
        VBox down = new VBox();
        VBox connexion = new VBox();

        pane.setCenter(top);
        pane.setBottom(down);

        top.setLeft(this.logo);
        top.setRight(connexion);
        
    }
}