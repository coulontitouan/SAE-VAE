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
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

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
     * Boutton connecter a la barre de recherche, il permet de lancer la recherche
     */
    private Button boutonRecherche;

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

    
    private boolean seConnecte;

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
        this.barreRecherche.setMinWidth(600);        

        this.userNom = new Label("Mario"); // a modifier pour recupere sur le model le nom de l'utilisateur 
        this.boutonConnexion = new Button("Connexion");
        this.boutonDeconnexion = new Button("", imgBTDeconnexion);
        this.boutonRecherche = new Button("Rechercher");
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
        
        this.boutonAPropos.getStyleClass().add("boutonDuHeader");
        this.boutonAcceuil.getStyleClass().add("boutonDuHeader");
        this.boutonCategorie.getStyleClass().add("boutonDuHeader");
        this.boutonVenteSuivi.getStyleClass().add("boutonDuHeader");
        this.boutonUtilisateurVente.getStyleClass().add("boutonDuHeader");
        
        //this.boutonAPropos.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        //this.boutonAcceuil.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        //this.boutonCategorie.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        //this.boutonVenteSuivi.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        //this.boutonUtilisateurVente.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        this.boutonConnexion.setStyle("-fx-background-color: transparent;");
        this.boutonDeconnexion.setStyle("-fx-background-color: transparent;");

        this.seConnecte = false;

    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        
        BorderPane fenetre = new BorderPane();
        // this.majAffichage();
        fenetre.setTop(this.banniere());
        fenetre.setCenter(fenetreAccueil());
        // scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
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
        //ImageView recherche = new ImageView(new Image("694985.png"));
        //recherche.setFitWidth(20);
        //recherche.setFitHeight(20);
        HBox barre = new HBox();
        
        barre.getChildren().addAll(this.barreRecherche,boutonRecherche);
        barre.setAlignment(Pos.CENTER);

        top.setLeft(this.logo);
        top.setRight(connexion);
        top.setCenter(barre);

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
        down.setMargin(boutonAcceuil, new Insets(0,0,0,50));
        down.setMargin(boutonCategorie, new Insets(0,0,0,50));
        down.setMargin(boutonVenteSuivi, new Insets(0,0,0,50));
        down.setMargin(boutonAPropos, new Insets(0,0,0,50));
        down.setAlignment(Pos.CENTER);
        
        return pane;

    }


    public BorderPane fenetreAccueil(){
        BorderPane res = new BorderPane();
        res.setStyle("-fx-background-color: lightGray");
        List<Objet> lesObjets = Arrays.asList(new Objet("Table", "Petite table faite maison par Louis Lebeaupin", new ImageView(new Image("profilDeco.png", 200, 200, false, false, false)), 50, new Categorie("Meubles"), 4),new Objet("Chaise", "Petites chaises faites maison par Louis Lebeaupin", new ImageView(new Image("profilDeco.png", 200, 200, false, false, false)), 20, new Categorie("Meubles"), 5),new Objet("Chaise", "Petites chaises faites maison par Louis Lebeaupin", new ImageView(new Image("profilDeco.png", 200, 200, false, false, false)), 20, new Categorie("Meubles"), 5),new Objet("Chaise", "Petites chaises faites maison par Louis Lebeaupin", new ImageView(new Image("profilDeco.png", 200, 200, false, false, false)), 20, new Categorie("Meubles"), 5),new Objet("Chaise", "Petites chaises faites maison par Louis Lebeaupin", new ImageView(new Image("profilDeco.png", 200, 200, false, false, false)), 22, new Categorie("Meubles"), 5));
        
        VBox gauche = new VBox();
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(gauche); 
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
        Label prix1 = new Label("Prix: 250 €");                                     // REMPLACER PAR LE PRIX DES OBJETS A PARTIRE D'UNE BASE DE DONEE
        Label prix2 = new Label("Prix: 126 €");                                     // REMPLACER PAR LE PRIX DES OBJETS A PARTIRE D'UNE BASE DE DONEE
        prix1.setStyle("-fx-background-color: #005C83; -fx-text-fill: white; -fx-background-radius: 10px; -fx-font-size: 30px;");
        prix2.setStyle("-fx-background-color: #005C83; -fx-text-fill: white; -fx-background-radius: 10px; -fx-font-size: 30px;");
        Button encher1 = new Button("Enchérir");
        encher1.getStyleClass().add("encher");
        //encher1.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 30px; -fx-background-radius: 10px;");
        Button encher2 = new Button("Enchérir");
        encher2.getStyleClass().add("encher");
        //encher2.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 30px; -fx-background-radius: 10px;");
        encher2.getStyleClass().add("encher");
        Label desc1 = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed \n do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n Ut enim ad minim veniam, quis nostrud exercitation ullamco \n laboris nisi ut aliquip ex ea commodo consequat.");
        Label desc2 = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed \n do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n Ut enim ad minim veniam, quis nostrud exercitation ullamco \n laboris nisi ut aliquip ex ea commodo consequat.");
        //prix1.setPadding(new Insets(10));
        // ench1.setMargin(encher1, new Insets(10));
        ench1.getChildren().addAll(prix1, encher1);
        ench2.getChildren().addAll(prix2, encher2);
        ench1.setMargin(prix1, new Insets(10));
        ench1.setMargin(encher1, new Insets(10));
        ench2.setMargin(prix2, new Insets(10));
        ench2.setMargin(encher2, new Insets(10));
        prix1.setPadding(new Insets(10,10,10,10)); 
        prix2.setPadding(new Insets(10,10,10,10)); 

        titre.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");
        obj1.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        obj2.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
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
        // gauche.getChildren().addAll(titre, premier, second);
        gauche.getChildren().add(titre);
        gauche.setMargin(titre, new Insets(30));
        gauche.setMargin(premier, new Insets(30));
        gauche.setMargin(second, new Insets(30));
        gauche.setMargin(titre, new Insets(30));

        for (Objet obj : lesObjets){
            HBox boxObjet = new HBox();
            Label nomObjet = new Label(obj.getNom());
            nomObjet.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
            Label descriptionObjet = new Label(obj.getDescription());
            HBox ench = new HBox();
            VBox objetDesc = new VBox();
            Button boutonEncherir = new Button("Enchérir");
            boutonEncherir.getStyleClass().add("encher");
            Label prixObjet = new Label("Prix: "+obj.getPrixActuel()+" €"); 
            prixObjet.setStyle("-fx-background-color: #005C83; -fx-text-fill: white; -fx-background-radius: 10px; -fx-font-size: 30px;");
         
            ench.getChildren().addAll(prixObjet, boutonEncherir);
            objetDesc.getChildren().addAll(nomObjet, ench, descriptionObjet, new ImageView(new Image("jauge_"+obj.getNote()+".png")));
            boxObjet.getChildren().addAll(obj.getImageObjet(), objetDesc);
            ench.setMargin(prixObjet, new Insets(10));
            ench.setMargin(boutonEncherir, new Insets(10));
            boxObjet.setMargin(objetDesc, new Insets(5));
            objetDesc.setMargin(nomObjet, new Insets(10));
            objetDesc.setMargin(ench, new Insets(10));
            objetDesc.setMargin(descriptionObjet, new Insets(10));
            prixObjet.setPadding(new Insets(10,10,10,10)); 
            gauche.getChildren().add(boxObjet);
            gauche.setMargin(boxObjet,new Insets(30));
        }


        GridPane droite = new GridPane();
        VBox vBoxFiltre = new VBox();
        HBox categorie = new HBox();
        ComboBox<String> comboCat = new ComboBox<>();
        // comboCat.getItems().add("Toutes");
        comboCat.getItems().add("Vêtement");
        comboCat.getItems().add("Ustensile Cuisine");
        comboCat.getItems().add("Meuble");
        comboCat.getItems().add("Outil");
        comboCat.setValue("Toutes");
        HBox prixV = new HBox();
        VBox typeV = new VBox();
        HBox valide = new HBox();
        droite.setStyle("-fx-background-color: white; -fx-background-radius: 20px;");
        Label filtre= new Label("Filtre");
        filtre.setStyle("-fx-font-weight: bold;");
        Label cate= new Label("Catégorie");
        cate.setStyle("-fx-font-weight: bold;");
        Label prix= new Label("Prix");
        prix.setStyle("-fx-font-weight: bold;");
        Label unTiret = new Label("-");            // le - entre les text field prix
        Label euro = new Label("€");
        Label type= new Label("Type de ventes");
        type.setStyle("-fx-font-weight: bold;");
        TextField prixMin = new TextField();
        TextField prixMax = new TextField();
        prixMin.setPromptText("0");
        prixMax.setPromptText("250");
        Button appliquer  = new Button("Appliquer");
        Button reset = new Button("Réinitialiser");

        appliquer.setStyle("-fx-background-color: #10668a; -fx-text-fill: #FFFFFF; -fx-background-radius: 10px;");
        reset.getStyleClass().add("reset");
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
        droite.setMinSize(400,400);
        droite.setMaxSize(400,400);
        droite.setPrefSize(400,400);
        valide.getChildren().addAll(reset, appliquer);
        

        vBoxFiltre.setMargin(filtre, new Insets(10));
        vBoxFiltre.setMargin(categorie, new Insets(20));
        vBoxFiltre.setMargin(prixV, new Insets(20));
        vBoxFiltre.setMargin(typeV, new Insets(20));
        vBoxFiltre.setMargin(valide, new Insets(20));
        categorie.setMargin(comboCat, new Insets(0,0,0,20));

        prixV.setMargin(prix,new Insets(5));
        prixV.setMargin(unTiret,new Insets(5));
        prixV.setMargin(euro, new Insets(5,10,0,0));
        prixMin.setMaxWidth(100);
        prixMax.setMaxWidth(100);

        typeV.setMargin(type, new Insets(0,0,10,0));
        typeV.setMargin(rBtn1, new Insets(0,50,10,0));
        typeV.setMargin(rBtn2, new Insets(0,50,10,0));
        
        valide.setMargin(reset, new Insets(0,0,0,10));
        valide.setMargin(appliquer, new Insets(0,0,0,80));
        
        res.setRight(droite);
        gauche.setStyle("-fx-background-color: lightgrey");
        scroll.setStyle("-fx-background-color: lightgrey");
        gauche.setMinSize(1400,915);
        scroll.setVbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        res.setLeft(scroll);
        res.setMargin(droite, new Insets(50));
        return res;
    }

    public void modeDeconnecte(){

    }

    public void modeConnecte(){

    }

    public void modeEnchere(){

    }

    public void modeVentesSuivies(){

    }

    public void modeVentesVendeur(){

    }


    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("VAE");
        Scene s = this.laScene();
        s.getStylesheets().add("styles.css");
        stage.setScene(s);
        //this.laScene().getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

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
