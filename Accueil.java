import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ButtonBar.ButtonData ;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.UIDefaults.LazyValue;

import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;


/**
 * Vue du jeu du pendu
 */
public class Accueil extends Application {

    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;
    /**
     * le bouton Paramètre / Engrenage
     */
    private Button boutonParametres;
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonMaison;


    private Button infos;

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


    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
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

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        
        BorderPane fenetre = new BorderPane();
        // this.majAffichage();
        fenetre.setTop(this.banniere());
        fenetre.setCenter(fenetreAccueil());
        return new Scene(fenetre, 1920, 1080);
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private Pane banniere(){        
        BorderPane pane = new BorderPane();
        BorderPane top = new BorderPane();
        HBox down = new HBox();
        HBox connexion = new HBox();

        pane.setCenter(top);
        pane.setBottom(down);

        top.setLeft(this.logo);
        top.setRight(connexion);
        top.setCenter(this.barreRecherche);

        
        // A MODIFIER QUAND MODELE FINI !!! (doit interroger le modele pour savoir si l'utilisateur est connecté)
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


    public BorderPane fenetreAccueil(){
        BorderPane res = new BorderPane();
        res.setStyle("-fx-background-color: lightGray");
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
        ench1.setMargin(prix1, new Insets(10));
        ench1.setMargin(encher1, new Insets(10));
        ench2.setMargin(prix2, new Insets(10));
        ench1.setMargin(encher2, new Insets(10));
        titre.setStyle("-fx-font-size: 40px;");
        obj1.setStyle("-fx-font-size: 30px;");
        obj2.setStyle("-fx-font-size: 30px;");
        premierdesc.getChildren().addAll(obj1, ench1, desc1, new ImageView(note1));
        seconddesc.getChildren().addAll(obj2, ench2, desc2, new ImageView(note2));
        premier.getChildren().addAll(new ImageView(imgobj1), premierdesc);
        premier.setMargin(premierdesc, new Insets(5));
        premierdesc.setMargin(obj1, new Insets(10));
        premierdesc.setMargin(ench1, new Insets(10));
        premierdesc.setMargin(desc1, new Insets(10));
        second.getChildren().addAll(new ImageView(imgobj2), seconddesc);
        second.setMargin(seconddesc, new Insets(10));
        seconddesc.setMargin(obj2, new Insets(10));
        seconddesc.setMargin(ench2, new Insets(10));
        seconddesc.setMargin(desc2, new Insets(10));
        gauche.getChildren().addAll(titre, premier, second);
        gauche.setMargin(titre, new Insets(30));
        gauche.setMargin(premier, new Insets(30));
        gauche.setMargin(second, new Insets(30));
        gauche.setMargin(titre, new Insets(30));


        GridPane droite = new GridPane();
        VBox vBoxFiltre = new VBox();
        HBox categorie = new HBox();
        ComboBox<String> comboCat = new ComboBox<>();
        HBox prixV = new HBox();
        VBox typeV = new VBox();
        HBox valide = new HBox();
        droite.setStyle("-fx-background-color: white");
        Label filtre= new Label("Filtre");
        Label cate= new Label("Catégorie");
        Label prix= new Label("Prix");
        Label unTiret = new Label("-");            // le - entre les text field prix
        Label euro = new Label("€");
        Label type= new Label("Type de ventes");
        TextField prixMin = new TextField();
        TextField prixMax = new TextField();
        filtre.setStyle("-fx-font-size: 40px;");


        ToggleButton rBtn1 = new RadioButton("En cours");
        ToggleButton rBtn2 = new RadioButton("A venir");

        ToggleGroup rBTn = new ToggleGroup();
        rBtn1.setToggleGroup(rBTn);
        rBtn2.setToggleGroup(rBTn);


        categorie.getChildren().addAll(cate,comboCat);
        prixV.getChildren().addAll(prix, prixMin, unTiret,prixMax, euro);
        valide.getChildren().addAll();
        typeV.getChildren().addAll(type, rBtn1, rBtn2);
        vBoxFiltre.getChildren().addAll(filtre, categorie,prixV, typeV, valide);
        droite.getChildren().add(vBoxFiltre);
        vBoxFiltre.setMargin(filtre, new Insets(10));
        vBoxFiltre.setMargin(categorie, new Insets(20));
        vBoxFiltre.setMargin(prixV, new Insets(20));
        vBoxFiltre.setMargin(typeV, new Insets(20));
        vBoxFiltre.setMargin(valide, new Insets(20));

        prixV.setMargin(prix,new Insets(5));
        prixV.setMargin(unTiret,new Insets(5));
        prixV.setMargin(euro, new Insets(5,5,0,0));
        prixMin.setMaxWidth(50);
        prixMax.setMaxWidth(50);

        typeV.setMargin(type, new Insets(0,0,10,0));
        typeV.setMargin(rBtn1, new Insets(0,50,10,0));
        typeV.setMargin(rBtn2, new Insets(0,50,10,0));

        res.setRight(droite);
        res.setLeft(gauche);
        res.setMargin(droite, new Insets(50));
        return res;
    }


    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("VAE");
        stage.setScene(this.laScene());
        // this.modeAccueil();
        stage.show();
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
