import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;



public class AppliVAE extends Application{
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
     * Bouton pour afficher les ventes de l'utilisateur
     */

     private Button boutonUtilisateurVente;

    /**
     * Textfiel pour la recherche (à enlever si necessaire)
     */
    private TextField barreRecherche;

    /**
     * boolean indiquant si l'utilisateur est connectée (A SUPPRIMER)
     */
    private boolean estConnectee;

    /**
     * boolean indiquant si l'utilisateur est admin (A SUUPRIMER)
     */
    private boolean estAdmin;

    /**
     * Logo du site
     */
    private ImageView logo;

    /**
     * Image utilisateur connectee
     */
    private ImageView imgConnectee;

    /**
     * Image utilisateur pas connecter
     */
    private ImageView imgDeco;

    /**
     * Image du panier
     */
    private ImageView imgPanier;

    /**
     * Nom de l'utilisateur
     */
    private Label userNom;

    /**
     * le panel Central qui pourra être modifié selon le mode
     */
    private BorderPane panelCentral;

    @Override
    public void init() {
        ImageView imgBTDeconnexion = new ImageView("deco.png");
        ImageView imgPanier = new ImageView("panier.png");

        this.panelCentral = new BorderPane();
        
        this.logo = new ImageView("Logo_VAE.png");
        this.barreRecherche = new TextField();
        this.barreRecherche.setPromptText("Recherches ventes");                                              
        this.userNom = new Label("Mario"); // a modifier pour recupere sur le model le nom de l'utilisateur 
        this.boutonConnexion = new Button("Connexion");
        this.boutonDeconnexion = new Button("", imgBTDeconnexion);
        this.boutonPanier = new Button("", imgPanier);
        this.imgConnectee = new ImageView("profilConnect.png");
        this.imgDeco = new ImageView("profilDeco.png");

        this.boutonAcceuil = new Button("Accueil");
        this.boutonCategorie = new Button("Catégories");
        this.boutonVenteSuivi = new Button("Ventes Suivi");
        this.boutonUtilisateurVente = new Button("Vos ventes");
        this.boutonAPropos = new Button("A propos du service");
        

        // retaillage d'image
        this.imgConnectee.setFitHeight(50);
        this.imgConnectee.setFitWidth(50);

        this.imgDeco.setFitHeight(50);
        this.imgDeco.setFitWidth(50);

        this.logo.setFitHeight(70);
        this.logo.setPreserveRatio(true);

        // stylisation des boutons (à améliorer)
        
        this.boutonAPropos.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        this.boutonAcceuil.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        this.boutonCategorie.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        this.boutonVenteSuivi.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        this.boutonUtilisateurVente.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        this.boutonConnexion.setStyle("-fx-background-color: transparent;");
        this.boutonDeconnexion.setStyle("-fx-background-color: transparent;");
        

        

    }

    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.baniere());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }

    private Pane baniere(){
        BorderPane pane = new BorderPane();
        BorderPane top = new BorderPane();
        HBox down = new HBox();
        HBox connexion = new HBox();

        pane.setCenter(top);
        pane.setBottom(down);

        top.setLeft(this.logo);
        top.setRight(connexion);
        top.setCenter(this.barreRecherche);

        
        // A MODIFIER QUAND MODELE FINI !!! (doit interroger le modele pour savoir si l'utilisateur est connecter)
        if(estConnectee){
            connexion.getChildren().addAll(this.imgConnectee, this.userNom, this.boutonPanier, this.boutonDeconnexion);
            down.getChildren().addAll(this.boutonAcceuil, this.boutonCategorie, this.boutonVenteSuivi, this.boutonUtilisateurVente, this.boutonAPropos);
        }
        else{
            connexion.getChildren().addAll(this.boutonConnexion, this.imgDeco);
            down.getChildren().addAll(this.boutonAcceuil, this.boutonCategorie, this.boutonVenteSuivi,  this.boutonAPropos);
        }

        

        connexion.setPadding(new Insets(10));
        connexion.setAlignment(Pos.CENTER);

        down.setStyle("-fx-background-color: #005C83;");
        down.setPadding(new Insets(10));
        

        return pane;
        
    }

    public void modeAccueil(){
        this.panelCentral.setCenter(this.fenetreAccueil());
    }

    public void modeCategorie(){
        this.panelCentral.setCenter(this.fenetreCategorie());
    }
    public void modeVentes(){
        this.panelCentral.setCenter(this.fenetreVentes());
    }

    public void modeConsultation(){
        this.panelCentral.setCenter(this.fenetreConsultation());
    }

    public void modeCredit(){
        this.panelCentral.setCenter(this.fenetreCredit());
    }


    //partie Louis (à editer)
    public Pane fenetreAccueil(){
        BorderPane res = new BorderPane();
        VBox gauche = new VBox();
        HBox premier = new HBox();
        HBox second = new HBox();
        VBox premierdesc = new VBox();
        VBox seconddesc = new VBox();
        Image imgobj1 = new Image("profilDeco.png", 200, 200, false, false, false);
        Image imgobj2 = new Image("profilDeco.png", 200, 200, false, false, false);
        Label titre = new Label("Meilleurs ventes en cours");
        Label obj1 = new Label("Lumpus Corpes");
        Label obj2 = new Label("Lumpus Corpes");
        HBox ench1 = new HBox();
        HBox ench2 = new HBox();
        Image note1 = new Image("jauge_5.png", 300, 100, false, false, false);
        Image note2 = new Image("jauge_4.png", 300, 100, false, false, false);
        Label prix1 = new Label("250 €");
        Label prix2 = new Label("126 €");
        Button encher1 = new Button("Enchérir");
        // ench1.setStyle("-fx-background-color: white");
        Button encher2 = new Button("Enchérir");
        // ench2.setStyle("-fx-background-color: white");
        Label desc1 = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed \n do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n Ut enim ad minim veniam, quis nostrud exercitation ullamco \n laboris nisi ut aliquip ex ea commodo consequat.");
        Label desc2 = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed \n do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n Ut enim ad minim veniam, quis nostrud exercitation ullamco \n laboris nisi ut aliquip ex ea commodo consequat.");
        ench1.getChildren().addAll(prix1, encher1);
        ench2.getChildren().addAll(prix2, encher2);
        titre.setStyle("-fx-font-size: 40px;");
        obj1.setStyle("-fx-font-size: 30px;");
        obj2.setStyle("-fx-font-size: 30px;");
        premierdesc.getChildren().addAll(obj1, ench1, desc1, new ImageView(note1));
        seconddesc.getChildren().addAll(obj2, ench2, desc2, new ImageView(note2));
        premier.getChildren().addAll(new ImageView(imgobj1), premierdesc);
        second.getChildren().addAll(new ImageView(imgobj2), seconddesc);
        gauche.getChildren().addAll(titre, premier, second);


        GridPane droite = new GridPane();
        HBox principal = new HBox();

        droite.setStyle("-fx-background-color: white");
        Label filtre= new Label("Filtre");
        filtre.setStyle("-fx-font-size: 40px;");
        principal.getChildren().addAll(filtre);
        droite.getChildren().add(principal);

        res.setRight(droite);
        res.setLeft(gauche);
        return res;
    }

    public Pane fenetreCategorie(){
        Pane pane = new Pane();
        return pane;
    }

    public Pane fenetreVentes(){
        Pane pane = new Pane();
        return pane;
    }

    public Pane fenetreConsultation(){
        Pane pane = new Pane();
        return pane;
    }

    public Pane fenetreCredit(){
        Pane pane = new Pane();
        return pane;
    }



    @Override
    public void start(Stage stage) {
        stage.setTitle("VAE - Ventes, Achats, Enchères");
        stage.setScene(this.laScene());
        this.modeAccueil();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AppliVAE.class, args);
    }  
    
}