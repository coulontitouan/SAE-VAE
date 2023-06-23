import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

import java.util.List;


import java.util.ArrayList;


/**
 * Vue du jeu du pendu
 */
public class VAE extends Application {

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
     * Bouton pemettant d'aller sur la page de vente
     */
    private Button boutonVendre;

    /**
     * Bouton permettant d'aller sur la page Ventes Suivi
     */
    private Button boutonVenteSuivis;

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
    private boolean estConnecte;

    /**
     * boolean indiquant si l'utilisateur est admin (A SUUPRIMER)
     */
    private int role;

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
     * Textfield du prix minimum dans le filtre
     */
    private TextField prixMinField;
    /**
     * Textfield du prix maximum dans le filtre
     */
    private TextField prixMaxField;
    /**
     * Bouton qui lance page de connexion
     */
    private Button boutonSeConnecter;
    /**
     * Bouton qui lance page de d'inscription
     */
    private Button boutonInscription;
    /**
     * combobox des catégories dans le filtre
     */
    private ComboBox comboCat;

    //attributs pour la page de connexion


    /**
     * Le stage de la page de connexion
     */
    private Stage stageConnexion;
    /**
     * permet de savoir si l'utilisateur est sur la page de connexion
     */
    private boolean seConnecte;

    //attributs pour récupérer les données de la page de connexion

    /**
     * TextField qui permet de récupérer l'identifiant de l'utilisateur lors de la connexion
     */
    private TextField textFieldIdentifiant;
    /**
     * TextField qui permet de récupérer le mot de passe de l'utilisateur lors de la connexion
     */
    private TextField passwordFieldMotDePasse;

    //attributs pour ouvrir la page d'inscription

    /**
     * Le stage de la fenetre d'inscription
     */
    private Stage stageInscription;
    /**
     * Permet de savoir si l'utilisateur est en train de s'inscrire
     */
    private boolean sInscrit;

    //attributs pour récupérer les données de la page d'inscription
    
    /**
     * un textField où l'utilisateur doit le remplire avec un nom lors de l'inscription
     */
    private TextField TextFieldInscriptionNom;

    /**
     * un textField où l'utilisateur doit le remplire avec un prenom lors de l'inscription
     */
    private TextField TextFieldInscriptionPrenom;
    /**
     * textField qui récupère le pseudo lors de l'inscription
     */
    private TextField TextFieldInscriptionPseudo;
    /**
     * un textField où l'utilisateur doit le remplire avec un mot de passe lors de l'inscription
     */
    private PasswordField TextFieldInscriptionMDP;
    /**
     * textField qui récupère le la confirmation du mot de passe lors de l'inscription
     */
    private PasswordField TextFieldInscriptionConfirmationMDP;
    /**
     * textField qui récupère le mail lors de l'inscription
     */
    private TextField TextFieldInscriptionMail;
    /**
     * bouton qui permet de lancer l'inscription
     */
    private Button boutonSinscrire;
    /**
     * Permet de choisir une image
     */
    private FileChooser fileChooserImg;
    /**
     * Ajouter un nom a l'objet pour le mettre en vente
     */
    private TextField objetAjoutNomField;
    /**
     * Ajouter une description a l'objet pour le mettre en vente
     */
    private TextField objetAjoutDescField;
    /**
     * Ajouter un prix initial a l'objet pour le mettre en vente
     */
    private TextField objetAjoutPrixInitialField;
    /**
     * Ajouter un prix minimal a l'objet pour le mettre en vente
     */
    private TextField objetAjoutPrixMinimalField;
    /**
     * Choisis la catégorie de l'objet pour le mettre en vente
     */
    private ComboBox objetAjoutCategorieCombo;
    /**
     * Choisis la date de fin d'un enchere de l'objet pour le mettre en vente
     */
    private DatePicker objetAjoutDateFinPicker;
    /**
     * Choisis une image pour l'enchere de l'objet pour le mettre en vente
     */
    private ImageView objetAjoutImage;
    /**
     * un message d'erreur lors de la connexion
     */
    private Label messageErreurConnexion;
    /**
     * un message d'erreur lors de l'inscription
     */
    private Label messageErreurInscription;
    /**
     * un bouton retour qui permet a l'utilisateur de revenir de la page inscription sur la page connexion 
     */
    private Button boutonRetourInscription;
    /**
     *
     */
    private Label typeMoney;
    /**
     *  Checkbox qui permet de vérifier que l'utilisateur a bien accepté les conditions
     */
    private CheckBox valideAge;
    /**
     * Un bouton qui permet d'accéder a la page administrateur.
     */
    private Button boutonAdmin;
    /**
     * Permetd de connaitre les informations de l'utilisateur qui est actuellement connecté
     */
    private UserConnecte utilisateurConnecte;
    /**
     * Message d'erreur lors d'un ajout d'enchère
     */
    private Label messageErreurEnchere;
    /**
     * TextField qui permet de de récupérer le montant de l'enchère à ajouter
     */
    private TextField tfPrix;
    /**
     * VBox qui regroupe les objets associés à un utilisateur pour la fenetre administrateur
     */
    private VBox vboxObjet;
    /**
     * VBox qui regroupe les utilisateurs dans la fenetre administrateur
     */
    private VBox usersVBox;


    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
    @Override
    public void init() {
        ImageView imgBTDeconnexion = new ImageView(new Image("deco.png",25,25,true,false,false));
        ImageView imgPanier = new ImageView(new Image("panier.png",25,25,true,false,false));

        this.panelCentral = new BorderPane();
        
        this.logo = new ImageView(new Image("Logo_VAE.png"));
        this.barreRecherche = new TextField();
        this.barreRecherche.setPromptText("Rechercher un objet en vente"); 
        this.barreRecherche.setMinWidth(600);
        this.barreRecherche.setMinHeight(40); 

        this.userNom = new Label(); // a modifier pour recupere sur le model le nom de l'utilisateur 
        this.boutonConnexion = new Button("Identifiez-vous");
        this.boutonConnexion.setOnAction(new ControleurFenetreConnexion(this));
        this.boutonDeconnexion = new Button("", imgBTDeconnexion);
        this.boutonRecherche = new Button("Rechercher");
        this.boutonPanier = new Button("", imgPanier);
        this.imgConnectee = new ImageView("profilConnect.png");
        this.imgDeco = new ImageView(new Image("profilDeco.png",40,40,true,false,false));
        this.boutonConnexion.setGraphic(this.imgDeco);

        this.boutonAcceuil = new Button("Accueil");
        this.boutonAcceuil.setOnAction(new ControleurFenetres(this));
        this.boutonVendre = new Button("Vendre");
        this.boutonVenteSuivis = new Button("Ventes Suivis");
        this.boutonVenteSuivis.setOnAction(new ControleurFenetres(this));
        this.boutonUtilisateurVente = new Button("Vos ventes");
        this.boutonUtilisateurVente.setOnAction(new ControleurFenetres(this));
        this.boutonAPropos = new Button("A propos du service");
        this.boutonAPropos.setOnAction(new ControleurPopUpAPropos(this));
        this.boutonSinscrire = new Button("S'inscrire");
        this.boutonRetourInscription = new Button("Retour");
        this.boutonRetourInscription.setOnAction(new ControleurRetourInscription(this));
        this.boutonAdmin = new Button("Administrateur");
        this.boutonAdmin.setOnAction(new ControleurFenetres(this));
        
        

        // retaillage d'image
        this.imgConnectee.setFitHeight(50);
        this.imgConnectee.setFitWidth(50);

        this.logo.setFitHeight(70);
        this.logo.setPreserveRatio(true);

        // stylisation des boutons (à améliorer)
        
        this.boutonRecherche.getStyleClass().add("bRecherche");
        this.boutonAPropos.getStyleClass().add("boutonDuHeader");
        this.boutonAcceuil.getStyleClass().add("boutonDuHeader");
        this.boutonVendre.getStyleClass().add("boutonDuHeader");
        this.boutonVenteSuivis.getStyleClass().add("boutonDuHeader");
        this.boutonUtilisateurVente.getStyleClass().add("boutonDuHeader");
        this.boutonConnexion.getStyleClass().add("identification");
        this.boutonDeconnexion.getStyleClass().add("bHautADroite");
        this.boutonPanier.getStyleClass().add("bHautADroite");
        this.boutonAdmin.getStyleClass().add("boutonDuHeader");

        
        this.boutonDeconnexion.setPadding(new Insets(8,8,8,8));
        this.boutonPanier.setPadding(new Insets(8,8,8,8));

        this.seConnecte = false;
        this.sInscrit = false;

        this.boutonSeConnecter = new Button("Se connecter");
        this.boutonSeConnecter.setOnAction(new ControleurConnexion(this));

        this.textFieldIdentifiant = new TextField();
        this.passwordFieldMotDePasse = new PasswordField();

        this.boutonInscription = new Button("Inscription");
        this.boutonInscription.setOnAction(new ControleurFenetreInscription(this));
        // this.bou.setOnAction(new ControleurFenetreInscription(this));
        this.comboCat = new ComboBox<>();

        
        this.TextFieldInscriptionNom = new TextField();
        this.TextFieldInscriptionPrenom = new TextField();
        this.TextFieldInscriptionPseudo = new TextField();
        this.TextFieldInscriptionMDP = new PasswordField();
        this.TextFieldInscriptionConfirmationMDP = new PasswordField();
        this.TextFieldInscriptionMail = new TextField();

        this.messageErreurConnexion = new Label("Identidiant ou mot de passe incorrect. Veuillez réessayer.");
        this.messageErreurConnexion.setTextFill(Color.rgb(244,244,244));

        this.messageErreurInscription = new Label("Les informations entrées sont incorrectes. Veuillez réessayer.");
        this.messageErreurInscription.setTextFill(Color.rgb(244,244,244));

        this.messageErreurEnchere = new Label("Action refusée. Vérifiez que tous les critères sont remplis et que le montant est correct.");
        this.messageErreurEnchere.setTextFill(Color.rgb(255,255,255));

        for (Categorie categorie : Requete.obtenirCategorie()){
        	this.comboCat.getItems().add(categorie.getNom());	
	    }   
        this.comboCat.setValue("Toutes");

        this.typeMoney = new Label("€");
        this.valideAge = new CheckBox("J’ai lu et accepté les règles de\n confidencialité et confirme avoir\n plus de 18 ans.");
        this.usersVBox = new VBox();

    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        this.panelCentral.setTop(this.banniere());
        this.panelCentral.setCenter(fenetreAccueil());
        return new Scene(this.panelCentral, 1420, 1080);
    }

    public Scene laSceneConnexion(){
        
        BorderPane fenetre = new BorderPane();
        fenetre.setCenter(this.fenetreConnexion());
        Scene s = new Scene(fenetre, 600, 460);
        s.getStylesheets().add("file:./ressources/styles.css");
        return s;
    }

    public Scene laSceneInscription(){
        
        BorderPane fenetre = new BorderPane();
        fenetre.setCenter(this.fenetreInscription());
        Scene s = new Scene(fenetre, 600, 460);
        s.getStylesheets().add("file:./ressources/styles.css");
        return s;
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

        boutonRecherche.setPadding(new Insets(11,11,11,11));
        boutonRecherche.setOnAction(new ControleurRechercheObjet(this));
        barre.getChildren().addAll(this.barreRecherche,boutonRecherche);
        barre.setAlignment(Pos.CENTER);
        barre.setMargin(this.barreRecherche, new Insets(10,0,10,10));
        barreRecherche.textProperty().addListener(new ListenerRechercheTempsReel(this));

        top.setLeft(this.logo);
        top.setRight(connexion);
        top.setMargin(connexion, new Insets(0,50,0,0));
        top.setCenter(barre);

        // A MODIFIER QUAND MODELE FINI !!! (doit interroger le modele pour savoir si l'utilisateur est connecté)
        if(this.estConnecte){
            this.boutonVendre.setOnAction(new ControleurFenetres(this));
            this.boutonVenteSuivis.setOnAction(new ControleurFenetreConnexion(this));
            this.boutonDeconnexion.setOnAction(new ControleurDeconnexion(this));
            this.userNom.setText(Requete.getUser().getPseudo());
            connexion.getChildren().addAll(this.imgConnectee, this.userNom, this.boutonPanier, this.boutonDeconnexion);
            connexion.setMargin(this.userNom, new Insets(0,10,0,10));
            connexion.setMargin(this.boutonPanier, new Insets(0,10,0,0));
            down.getChildren().addAll(this.boutonAcceuil, this.boutonVendre, this.boutonVenteSuivis, this.boutonUtilisateurVente, this.boutonAPropos);
            down.setMargin(this.boutonUtilisateurVente, new Insets(0, 0, 0, 50));
            if (this.role == 1){
                down.getChildren().add(this.boutonAdmin);
                down.setMargin(this.boutonAdmin, new Insets(0,0,0,50));
            }
        }
        else{
            this.boutonConnexion.setText("Identifiez-vous");
            this.boutonConnexion.setGraphic(this.imgDeco);
            this.boutonVenteSuivis.setOnAction(null);
            this.boutonVendre.setOnAction(new ControleurFenetreConnexion(this));
            connexion.getChildren().addAll(this.boutonConnexion);
            down.getChildren().addAll(this.boutonAcceuil, this.boutonVendre, this.boutonVenteSuivis,  this.boutonAPropos);
        }
        
        connexion.setPadding(new Insets(10));
        connexion.setAlignment(Pos.CENTER);
        
        top.setMargin(this.logo, new Insets(5,0,0,40));

        down.setStyle("-fx-background-color: #005C83;");
        down.setPadding(new Insets(10));
        down.setMargin(boutonAcceuil, new Insets(0,0,0,50));
        down.setMargin(boutonVendre, new Insets(0,0,0,50));
        down.setMargin(boutonVenteSuivis, new Insets(0,0,0,50));
        down.setMargin(boutonAPropos, new Insets(0,0,0,50));
        down.setAlignment(Pos.CENTER);
        
        return pane;

    }


    public BorderPane fenetreVenteUtilisateur(){
        BorderPane res = new BorderPane();
        res.setStyle("-fx-background-color: white;");
        
        VBox gauche = new VBox();
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(gauche); 
        

        for (Objet obj : Requete.obtenirObjetEnVentesParUtilisateur()){
            HBox boxObjet = new HBox();
            Label nomObjet = new Label(obj.getNom());
            nomObjet.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
            Label descriptionObjet = new Label(obj.getDescription());
            HBox ench = new HBox();
            VBox objetDesc = new VBox();
            Button boutonEncherir = new Button("Enchérir");
            boutonEncherir.setOnAction(new ControleurFenetreVente(this));
            boutonEncherir.getStyleClass().add("encher");
            Label prixObjet = new Label("Prix: "+obj.getPrixActuel()+" €"); 
            prixObjet.setStyle("-fx-background-color: #005C83; -fx-text-fill: white; -fx-background-radius: 10px; -fx-font-size: 30px;");
            ench.getChildren().addAll(prixObjet, boutonEncherir);
            objetDesc.getChildren().addAll(nomObjet, ench, descriptionObjet, new ImageView(new Image("jauge_"+obj.getNote()+".png")));
            ImageView imageObjet = new ImageView(obj.getImageObjet());
            imageObjet.setFitWidth(300);
            imageObjet.setFitHeight(300);
            boxObjet.getChildren().addAll(imageObjet, objetDesc);
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



        gauche.setStyle("-fx-background-color: white");
        scroll.setStyle("-fx-background-color: white");
        scroll.setMinSize(1400, 850);
        gauche.setMinSize(1400,850);
        //scroll.setVbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        res.setLeft(scroll);
        res.setMargin(scroll, new Insets(50,50,50,50));
        return res;
    }


    public BorderPane fenetreAccueil(){
        BorderPane res = new BorderPane();
        res.setStyle("-fx-background-color: white;");
        //List<Objet> lesObjets = Arrays.asList(new Objet("Stylo", "Petit stylo fait maison ", new ImageView(new Image("https://raja.scene7.com/is/image/Raja/products/bic-4-couleurs-original-stylo-bille-r-tractable-pointe-moyenne-1-mm_33841-00J.jpg?template=withpicto410&$image=asset3395155&$picto=JPG_picto-vert-bas&hei=410&wid=410&fmt=jpg&qlt=85,0&resMode=sharp2&op_usm=1.75,0.3,2,0", 200, 200, true, false, false)), 3.75, new Categorie("Meubles"), 4),new Objet("Chaise", "Petites chaises faites maison par Louis Lebeaupin", new ImageView(new Image("chaise.png", 200, 200, true, false, false)), 25, new Categorie("Meubles"), 5),new Objet("Table", "Petite table faite maison par Louis Lebeaupin", new ImageView(new Image("https://media.maxiburo.fr/j2svp/zoomhd/12/54/24184.jpg", 200, 200, true, false, false)), 90, new Categorie("Meubles"), 5),new Objet("Luntette", "Petite paire de lunette faites maison par Louis Lebeaupin", new ImageView(new Image("https://lpt-prod-frames.imgix.net/WF02/WF02-BM-001.png", 200, 200, true, false, false)), 210, new Categorie("Meubles"), 0),new Objet("Chaise", "Petites chaises faites maison par Louis Lebeaupin", new ImageView(new Image("profilDeco.png", 200, 200, true, false, false)), 22, new Categorie("Meubles"), 5));
        this.vboxObjet = new VBox();
        VBox gauche = new VBox();
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(this.vboxObjet); 
        

        for (Objet obj : Requete.obtenirObjetEnVentes()){
            HBox boxObjet = new HBox();
            Label nomObjet = new Label(obj.getNom());
            nomObjet.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
            Label descriptionObjet = new Label(obj.getDescription());
            HBox ench = new HBox();
            VBox objetDesc = new VBox();
            Button boutonEncherir = new Button("Enchérir");
            boutonEncherir.setOnAction(new ControleurFenetreVente(this,obj));
            boutonEncherir.getStyleClass().add("encher");
            Label prixObjet = new Label("Prix: "+obj.getPrixActuel()+" €"); 
            prixObjet.setStyle("-fx-background-color: #005C83; -fx-text-fill: white; -fx-background-radius: 10px; -fx-font-size: 30px;");
            ench.getChildren().addAll(prixObjet, boutonEncherir);
            objetDesc.getChildren().addAll(nomObjet, ench, descriptionObjet, new ImageView(new Image("jauge_"+obj.getNote()+".png")));

            ImageView imageObjet = new ImageView(obj.getImageObjet());
            imageObjet.setFitWidth(300);
            imageObjet.setFitHeight(300);
            boxObjet.getChildren().addAll(imageObjet, objetDesc);
            ench.setMargin(prixObjet, new Insets(10));
            ench.setMargin(boutonEncherir, new Insets(10));
            boxObjet.setMargin(objetDesc, new Insets(5));
            objetDesc.setMargin(nomObjet, new Insets(10));
            objetDesc.setMargin(ench, new Insets(10));
            objetDesc.setMargin(descriptionObjet, new Insets(10));
            prixObjet.setPadding(new Insets(10,10,10,10)); 
            this.vboxObjet.getChildren().add(boxObjet);
            this.vboxObjet.setMargin(boxObjet,new Insets(30));
        }


        GridPane droite = new GridPane();
        VBox vBoxFiltre = new VBox();
        //HBox categorie = new HBox();
        ComboBox<String> comboCat = new ComboBox<>();
        // comboCat.getItems().add("Toutes");
        HBox prixV = new HBox();
        VBox typeV = new VBox();
        HBox valide = new HBox();
        droite.setStyle("-fx-background-color: white; -fx-background-radius: 20px; -fx-border-style: solid; -fx-border-color: black; -fx-border-radius: 15px;");
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
        this.prixMinField = new TextField();
        this.prixMaxField = new TextField();
        this.prixMinField.setPromptText("0");
        this.prixMaxField.setPromptText("250");
        Button appliquer  = new Button("Appliquer");
        appliquer.setOnAction(new ControleurFiltreObjet(this));
        Button reset = new Button("Réinitialiser");
        reset.setOnAction(new ControleurReinitialiser(this));

        //appliquer.setStyle("-fx-background-color: #10668a; -fx-text-fill: #FFFFFF; -fx-background-radius: 10px;");
        appliquer.getStyleClass().add("applique");
        reset.getStyleClass().add("reset");
        filtre.setStyle("-fx-font-size: 40px;");


        ToggleButton rBtn1 = new RadioButton("En cours");
        ToggleButton rBtn2 = new RadioButton("A venir");
        ToggleGroup rBTn = new ToggleGroup();
        rBtn1.setToggleGroup(rBTn);
        rBtn2.setToggleGroup(rBTn);


        //categorie.getChildren().addAll(cate,this.comboCat);
        prixV.getChildren().addAll(prix, this.prixMinField, unTiret,this.prixMaxField, euro);
        valide.getChildren().addAll();
        typeV.getChildren().addAll(type, rBtn1, rBtn2);
        vBoxFiltre.getChildren().addAll(filtre, cate, this.comboCat,prixV, typeV, valide);
        droite.getChildren().add(vBoxFiltre);
        droite.setMinSize(400,400);
        droite.setMaxSize(400,400);
        droite.setPrefSize(400,400);
        valide.getChildren().addAll(reset, appliquer);
        

        vBoxFiltre.setMargin(filtre, new Insets(10));
        vBoxFiltre.setMargin(cate, new Insets(20));
        vBoxFiltre.setMargin(prixV, new Insets(20));
        vBoxFiltre.setMargin(typeV, new Insets(20));
        vBoxFiltre.setMargin(valide, new Insets(20));
        vBoxFiltre.setMargin(this.comboCat, new Insets(0,0,10,20));

        prixV.setMargin(prix,new Insets(5));
        prixV.setMargin(unTiret,new Insets(5));
        prixV.setMargin(euro, new Insets(5,10,0,0));
        this.prixMinField.setMaxWidth(100);
        this.prixMaxField.setMaxWidth(100);

        typeV.setMargin(type, new Insets(0,0,10,0));
        typeV.setMargin(rBtn1, new Insets(0,50,10,0));
        typeV.setMargin(rBtn2, new Insets(0,50,10,0));
        
        valide.setMargin(reset, new Insets(0,0,0,10));
        valide.setMargin(appliquer, new Insets(0,0,0,80));
        
        res.setLeft(droite);
        this.vboxObjet.setStyle("-fx-background-color: white");
        scroll.setStyle("-fx-background-color: white");
        this.vboxObjet.setMinSize(1400,915);
        //scroll.setVbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        res.setRight(scroll);
        res.setMargin(scroll, new Insets(50,50,50,50));
        res.setMargin(droite, new Insets(50,50,50,50));
        return res;
    }

        public Pane fenetreConnexion(){
        BorderPane fenetre = new BorderPane();

        ImageView logo = new ImageView(new Image("Logo_VAE.png",300,120,true,false,false));

        VBox vBoxConnexion = new VBox();
        Label identifiant = new Label("identifiant");
        this.textFieldIdentifiant.setPromptText("Entrez votre identifiant");

        Label motDePasse = new Label("Mot de passe");
        this.passwordFieldMotDePasse.setPromptText("Entrez votre mot de passe");

        this.boutonSeConnecter.getStyleClass().add("bConnexion");
        //this.boutonSeConnecter.setStyle("-fx-background-color: #10668a; -fx-text-fill: #FFFFFF; -fx-border-radius: 15px;");

        Label messageInscription = new Label("Pas encore de compte ? Inscrivez-vous !");
        this.boutonInscription.getStyleClass().add("bInscription");
        //this.boutonInscription.setStyle("-fx-background-color: #10668a; -fx-text-fill: #FFFFFF; -fx-border-radius: 15px;");

        vBoxConnexion.getChildren().addAll(identifiant,textFieldIdentifiant,motDePasse,passwordFieldMotDePasse,this.boutonSeConnecter,this.messageErreurConnexion);
        vBoxConnexion.setMargin(identifiant, new Insets(0,10,0,10));
        vBoxConnexion.setMargin(textFieldIdentifiant, new Insets(10));
        vBoxConnexion.setMargin(motDePasse, new Insets(10));
        vBoxConnexion.setMargin(passwordFieldMotDePasse, new Insets(10));
        vBoxConnexion.setMargin(this.boutonSeConnecter, new Insets(7,0,0,0));
        vBoxConnexion.setMargin(this.messageErreurConnexion, new Insets(7,0,0,0));
        vBoxConnexion.setAlignment(Pos.CENTER);
        vBoxConnexion.setStyle("-fx-border-style : solid; -fx-border-radius: 15px");
        vBoxConnexion.setPadding(new Insets(10));

        VBox vBoxInscription = new VBox();
        vBoxInscription.getChildren().addAll(messageInscription,this.boutonInscription);
        vBoxInscription.setMargin(messageInscription, new Insets(0,0,0,0));
        vBoxInscription.setMargin(this.boutonInscription, new Insets(10,0,20,0));
        vBoxInscription.setAlignment(Pos.CENTER);

        fenetre.setTop(logo);
        fenetre.setAlignment(logo, Pos.CENTER);
        fenetre.setCenter(vBoxConnexion);
        fenetre.setBottom(vBoxInscription);
        fenetre.setMargin(vBoxConnexion, new Insets(10,80,40,80));

        return fenetre;
    }

    public Pane fenetreInscription(){
        ImageView logo = new ImageView(new Image("Logo_VAE.png",300,120,true,false,false));

        BorderPane fenetre = new BorderPane();
        VBox inscription = new VBox();
        
        HBox nomPrenom = new HBox();
        VBox nom = new VBox();
        VBox prenom = new VBox();
        Label leNom = new Label("Nom");
        nom.getChildren().addAll(leNom,this.TextFieldInscriptionNom);
        Label lePrenom = new Label("Prénom");
        prenom.getChildren().addAll(lePrenom, this.TextFieldInscriptionPrenom);
        nomPrenom.getChildren().addAll(nom,prenom);
        
        VBox nomUtilisateur = new VBox();
        Label pseudo = new Label("Nom d'utilisateur");
        nomUtilisateur.getChildren().addAll(pseudo, this.TextFieldInscriptionPseudo);

        VBox motDePasse = new VBox();
        Label mdp = new Label("Mot de Passe");
        motDePasse.getChildren().addAll(mdp, this.TextFieldInscriptionMDP);

        VBox ConfirmeMotDePasse = new VBox();
        Label confMdp = new Label("Entrez le mot de passe à nouveau");
        ConfirmeMotDePasse.getChildren().addAll(confMdp, this.TextFieldInscriptionConfirmationMDP);
        
        VBox mail = new VBox();
        Label email = new Label("Adresse e-mail");
        mail.getChildren().addAll(email, this.TextFieldInscriptionMail);

        nom.setMargin(leNom, new Insets(5,0,0,10));
        nom.setMargin(this.TextFieldInscriptionNom, new Insets(0,20,0,0));
        prenom.setMargin(lePrenom, new Insets(5,0,0,10));
        nomUtilisateur.setMargin(pseudo, new Insets(5,0,0,10));
        motDePasse.setMargin(mdp, new Insets(5,0,0,10));
        ConfirmeMotDePasse.setMargin(confMdp, new Insets(5,0,0,10));
        mail.setMargin(email, new Insets(5,0,0,10));


        this.TextFieldInscriptionNom.setPromptText("ex : choux de bruxelles");
        this.TextFieldInscriptionPrenom.setPromptText("ex : Loann");
        this.TextFieldInscriptionPseudo.setMaxWidth(361);
        this.TextFieldInscriptionPseudo.setPromptText("ex : avidson11");
        this.TextFieldInscriptionMDP.setMaxWidth(361);
        this.TextFieldInscriptionMDP.setPromptText("Entrez votre mot de passe");
        this.TextFieldInscriptionConfirmationMDP.setMaxWidth(361);
        this.TextFieldInscriptionConfirmationMDP.setPromptText("Entrez à nouveau votre mot de passe");
        this.TextFieldInscriptionMail.setMaxWidth(361);
        this.TextFieldInscriptionMail.setPromptText("ex : avidson11@gmail.com");

        this.boutonSinscrire.setOnAction(new ControleurInscription(this));

        this.boutonSinscrire.getStyleClass().add("bSinscrire");
        this.boutonRetourInscription.getStyleClass().add("reset");
        //this.boutonSinscrire.setStyle("-fx-background-color: #10668a; -fx-text-fill: #FFFFFF; -fx-border-radius: 15px;");
        
        HBox boutonDuBas = new HBox();
        boutonDuBas.getChildren().addAll(this.boutonRetourInscription, this.boutonSinscrire);
        
        inscription.getChildren().addAll(nomPrenom, nomUtilisateur, motDePasse, ConfirmeMotDePasse, mail, boutonDuBas, this.messageErreurConnexion);
        inscription.setMargin(nomPrenom, new Insets(10,0,0,120));
        inscription.setMargin(nomUtilisateur, new Insets(10,0,0,120));
        inscription.setMargin(motDePasse, new Insets(10,0,0,120));
        inscription.setMargin(ConfirmeMotDePasse, new Insets(10,0,0,120));
        inscription.setMargin(mail, new Insets(10,0,10,120));
        inscription.setMargin(boutonDuBas, new Insets(10));
        boutonDuBas.setMargin(this.boutonRetourInscription, new Insets(0, 20, 0, 0));
        inscription.setMargin(boutonDuBas, new Insets(5, 0, 5, 200));
        inscription.setMargin(this.messageErreurInscription, new Insets(5, 0, 0, 200));

        fenetre.setTop(logo);
        fenetre.setAlignment(logo, Pos.CENTER);
        fenetre.setCenter(inscription);

        fenetre.setAlignment(boutonDuBas,Pos.CENTER);
        fenetre.setAlignment(inscription,Pos.CENTER_LEFT);
        return fenetre;
    }

    public BorderPane fenetreAjouterObjet(){
        BorderPane res = new BorderPane();
        res.setStyle("-fx-background-color: white");
        // List<Objet> lesObjets = Arrays.asList(new Objet("Stylo", "Petit stylo fait maison par Louis Lebeaupin", new ImageView(new Image("https://raja.scene7.com/is/image/Raja/products/bic-4-couleurs-original-stylo-bille-r-tractable-pointe-moyenne-1-mm_33841-00J.jpg?template=withpicto410&$image=asset3395155&$picto=JPG_picto-vert-bas&hei=410&wid=410&fmt=jpg&qlt=85,0&resMode=sharp2&op_usm=1.75,0.3,2,0", 200, 200, false, false, false)), 3.75, new Categorie("Meubles"), 4),new Objet("Chaise", "Petites chaises faites maison par Louis Lebeaupin", new ImageView(new Image("chaise.png", 200, 200, false, false, false)), 25, new Categorie("Meubles"), 5),new Objet("Table", "Petite table faite maison par Louis Lebeaupin", new ImageView(new Image("https://media.maxiburo.fr/j2svp/zoomhd/12/54/24184.jpg", 200, 200, false, false, false)), 90, new Categorie("Meubles"), 5),new Objet("Luntette", "Petite paire de lunette faites maison par Louis Lebeaupin", new ImageView(new Image("https://lpt-prod-frames.imgix.net/WF02/WF02-BM-001.png", 200, 200, false, false, false)), 210, new Categorie("Meubles"), 0),new Objet("Chaise", "Petites chaises faites maison par Louis Lebeaupin", new ImageView(new Image("profilDeco.png", 200, 200, false, false, false)), 22, new Categorie("Meubles"), 5));
        List<Objet> lesObjets = new ArrayList<>();
        VBox gauche = new VBox();

        HBox nomBox = new HBox();
        Label nomText = new Label("Nom :");
        this.objetAjoutNomField = new TextField();
        this.objetAjoutNomField.setMinSize(300, 20);
        nomBox.getChildren().addAll(nomText,this.objetAjoutNomField);
        nomBox.setMargin(this.objetAjoutNomField, new Insets(0,0,0,40));
        nomBox.setAlignment(Pos.CENTER_LEFT);

        HBox descBox = new HBox();
        Label descText = new Label("Description :");
        this.objetAjoutDescField = new TextField();
        this.objetAjoutDescField.setMinSize(500, 20);
        descBox.getChildren().addAll(descText,this.objetAjoutDescField);
        descBox.setMargin(this.objetAjoutDescField, new Insets(0,0,0,40));
        descBox.setAlignment(Pos.CENTER_LEFT);

        HBox prixInitialBox = new HBox();
        Label prixInitialText = new Label("Prix de Départ :");
        this.objetAjoutPrixInitialField = new TextField();
        this.objetAjoutPrixInitialField.setMaxSize(75, 20);
        Label prixInitialLabelEuro = new Label("€");
        prixInitialBox.getChildren().addAll(prixInitialText,this.objetAjoutPrixInitialField,prixInitialLabelEuro);
        prixInitialBox.setMargin(this.objetAjoutPrixInitialField, new Insets(0,0,0,40));
        prixInitialBox.setMargin(prixInitialLabelEuro, new Insets(0,0,0,5));
        prixInitialBox.setAlignment(Pos.CENTER_LEFT);


        HBox prixMinimumBox = new HBox();
        Label prixMinimumText = new Label("Prix minimum de Vente :");
        this.objetAjoutPrixMinimalField = new TextField();
        this.objetAjoutPrixMinimalField.setMaxSize(75, 20);
        Label prixMinimumLabelEuro = new Label("€");
        prixMinimumBox.getChildren().addAll(prixMinimumText,this.objetAjoutPrixMinimalField,prixMinimumLabelEuro);
        prixMinimumBox.setMargin(this.objetAjoutPrixMinimalField, new Insets(0,0,0,40));
        prixMinimumBox.setMargin(prixMinimumLabelEuro, new Insets(0,0,0,5));
        prixMinimumBox.setAlignment(Pos.CENTER_LEFT);

        HBox catBox = new HBox();
        this.objetAjoutCategorieCombo = new ComboBox<>();
        Label catText = new Label("Catégorie :");
        for (Categorie categorie : Requete.obtenirCategorie()){
        	this.objetAjoutCategorieCombo.getItems().add(categorie.getNom());	
	    }
        catBox.getChildren().addAll(catText,this.objetAjoutCategorieCombo);
        catBox.setMargin(this.objetAjoutCategorieCombo, new Insets(0,0,0,40));
        catBox.setAlignment(Pos.CENTER_LEFT);


        HBox dateFinBox = new HBox();
        Label dateFinText = new Label("Date de Fin :");
        this.objetAjoutDateFinPicker = new DatePicker();
        this.objetAjoutDateFinPicker.setMinSize(125, 30);
        this.objetAjoutDateFinPicker.setMaxSize(125, 30);
        dateFinBox.getChildren().addAll(dateFinText,this.objetAjoutDateFinPicker);
        dateFinBox.setMargin(this.objetAjoutDateFinPicker, new Insets(0,0,0,40));
        dateFinBox.setAlignment(Pos.CENTER_LEFT);


        HBox imgBox = new HBox();
        Label imgText = new Label("Image :");
        this.fileChooserImg = new FileChooser();
        this.fileChooserImg.getExtensionFilters().add(new ExtensionFilter("Images de type PNG", "*.png"));
        this.objetAjoutImage = new ImageView(new Image("https://media.istockphoto.com/id/1147544807/fr/vectoriel/pas-image-miniature-graphique-vectoriel.jpg?s=612x612&w=0&k=20&c=Sh1MFiTUP-JtcUfRL2X1qex8BDwZTf1zGSHweIentbc=",300,300,true,false,false));
        Button imgBouton = new Button("Ajouter Image");
        imgBouton.getStyleClass().add("identification");
        imgBouton.setOnAction(new ControleurRechercheImage(this,this.objetAjoutImage));
        imgBox.getChildren().addAll(imgText,this.objetAjoutImage,imgBouton);
        imgBox.setMargin(imgBouton, new Insets(0,0,0,20));
        imgBox.setMargin(this.objetAjoutImage, new Insets(0,0,0,80));
        imgBox.setAlignment(Pos.CENTER_LEFT);

        Button boutonValiderObjet = new Button("Valider");
        boutonValiderObjet.setOnAction(new ControleurValiderObjetVendre(this));
        

        gauche.setMargin(nomBox, new Insets(30));
        gauche.setMargin(descBox, new Insets(30));
        gauche.setMargin(imgBox, new Insets(30,30,30,30));
        gauche.setMargin(prixInitialBox, new Insets(30));
        gauche.setMargin(prixMinimumBox, new Insets(30));
        gauche.setMargin(catBox, new Insets(30));
        gauche.setMargin(dateFinBox, new Insets(30));
        gauche.getChildren().addAll(nomBox,descBox,prixInitialBox,prixMinimumBox,catBox,dateFinBox,imgBox,boutonValiderObjet);
        gauche.setStyle("-fx-background-color: lightgray");
        gauche.setMinSize(1220,915);
        res.setCenter(gauche);
        return res;

    }
    
    public Pane fenetreVentes(){

        BorderPane pane = new BorderPane();
        VBox center = new VBox();
        VBox left = new VBox();
        pane.setCenter(center);
        pane.setRight(left);

        //Titre de l'objet-article
        Label intituler = new Label(); // a modifier pour récupéré le nom de l'objet
        intituler.setText(Requete.getObjet().getNom());
        intituler.setFont(Font.font("Arial", FontWeight.MEDIUM, 30));
        intituler.setPadding(new Insets(10));

        //l'article avec d'un coté l'image et de l'autre le contenu
        BorderPane article = new BorderPane();

        //Image de l'article en vente
        ImageView imgArticle = new ImageView();
        imgArticle.setFitWidth(150);
        imgArticle.setPreserveRatio(true);
        imgArticle.setImage(Requete.getObjet().getImageObjet());

        //Contenu de l'article
        VBox contenu = new VBox();

        //Jauge (à modifier)
        ImageView jauge = new ImageView("jauge_4.png");

        //Prix
        HBox infoPrix = new HBox();
        Label prixinit = new Label("prix initial:");
        prixinit.setStyle("-fx-background-color: white; -fx-background-radius: 15px; -fx-font-weight: bold;");
        prixinit.setPadding(new Insets(5));
        Label prix = new Label(Requete.getObjet().getPrixActuel()+""); //a modifier pour récupéré le prix initial avant enchère
        prix.setStyle("-fx-background-color: #005C83; -fx-text-fill: white; -fx-font-weight: bold;-fx-background-radius: 15px;");
        prix.setPadding(new Insets(5));
        Button annuler = new Button("Annuler");
        annuler.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;-fx-background-radius: 15px;");
        annuler.setPadding(new Insets(5));

        infoPrix.getChildren().addAll(prixinit, prix, annuler);
        infoPrix.setSpacing(10);

        //Description
        Text description = new Text(Requete.getObjet().getDescription());

        //Mise en vente par un gens
        HBox miseVentePar = new HBox();
        miseVentePar.setAlignment(Pos.CENTER_LEFT);
        miseVentePar.setPadding(new Insets(10));
        miseVentePar.setSpacing(15.0);

        //avatar du vendeur
        Circle avatarVendeur = new Circle(25);
        Image imgAvatar = new Image("profilConnect.png");
        ImagePattern pattern = new ImagePattern(imgAvatar);
        avatarVendeur.setFill(pattern);

        //Text à propos du vendeur
        Label infoVendeur = new Label("Mise en vente par ");
        infoVendeur.setText(infoVendeur.getText() + Requete.getNomParId(Requete.getObjet().getIdUtilisateur())); //A modifier pour recupéré le nom du propriétaire de l'objet
        infoVendeur.setStyle("-fx-text-fill: #005C83;");
        miseVentePar.getChildren().addAll(avatarVendeur, infoVendeur);

        //Titre Enchère
        Label titreEnchere = new Label(Requete.getObjet().getNom()); // a modifier pour récupéré le nom de l'objet
        titreEnchere.setFont(Font.font("Arial", FontWeight.MEDIUM, 30));
        titreEnchere.setPadding(new Insets(10));

        //Ensemble des propositions
        VBox lesProposition = new VBox();

    

        //Nom acheteur
        int cpt = 0;
        HBox grapheBox = new HBox();

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        LineChart<Number,Number> graph = new LineChart<Number,Number>(xAxis,yAxis);
            XYChart.Series series1 = new XYChart.Series();
        List<Enchere> lesObjets = Requete.obtenirVenteObjet();
        for (int i=0;i<lesObjets.size();i++){ 
            GridPane proposition = new GridPane();
            proposition.setStyle("-fx-background-color: white; -fx-background-radius: 15px;");
            proposition.setPadding(new Insets(5));

            Circle avatarAcheteur = new Circle(25);
            avatarAcheteur.setFill(pattern);
            proposition.add(avatarAcheteur, 0, 0);

            Text nomAcheteur = new Text(Requete.getNomParId(lesObjets.get(i).getIdUtilisateur())); //A changer pour recupérer le nom des personnes ayant mis une enchère
            proposition.add(nomAcheteur, 1, 0);

            //recommandation
            Label recommander = new Label("Recommandée");
            recommander.setStyle("-fx-text-fill: #31D455;");
            proposition.add(recommander, 2, 0);

            //montant
            Label montant = new Label(lesObjets.get(i).getMontant()+"");
            montant.setStyle("-fx-background-color: #D9D9D9; -fx-font-weight: bold;-fx-background-radius: 15px;");
            montant.setPadding(new Insets(5));
            proposition.add(montant, 3, 0,2,1);

            //Validée (reservé au personne ayant mis en ligne l'article)
            Button valider = new Button("valider");
            valider.setStyle("-fx-background-color: #31D455; -fx-text-fill: white; -fx-font-weight: bold;-fx-background-radius: 15px;");
            valider.setPadding(new Insets(5));
            proposition.add(valider, 5, 0);
            //taillage de proposition
            proposition.getColumnConstraints().add(new ColumnConstraints(50)); // column 0 is 100 wide
            proposition.getColumnConstraints().add(new ColumnConstraints(100));
            proposition.getColumnConstraints().add(new ColumnConstraints(200));
            proposition.getColumnConstraints().add(new ColumnConstraints(75));
            proposition.getColumnConstraints().add(new ColumnConstraints(75));

            proposition.setHgap(10);
            lesProposition.getChildren().addAll(proposition);


            series1.getData().add(new XYChart.Data(cpt, lesObjets.get(lesObjets.size()-1-i).getMontant()));
            graph.getData().add(series1);
            cpt +=1 ;
        }
        grapheBox.getChildren().addAll(graph);
        


   
        


        
        contenu.getChildren().addAll(jauge, infoPrix, description, miseVentePar);
        contenu.setPadding(new Insets(0, 0, 0, 30));
        contenu.setSpacing(10);
        article.setLeft(imgArticle);
        article.setCenter(contenu);
        article.setPadding(new Insets(40));

        //zone concernant l'enchère
        VBox pageEnchere = new VBox();
        pageEnchere.setStyle("-fx-background-color: white; -fx-background-radius: 15px;");
        pageEnchere.setPadding(new Insets(25));

        //Titre
        Label titreAchat = new Label("Proposer un prix");
        titreAchat.setFont(Font.font("Arial", FontWeight.MEDIUM, 30));
        titreAchat.setPadding(new Insets(0, 50, 10, 0));

        //Rentrer un prix
        HBox prixEnchere = new HBox();

        //Textfield pour entrer une valeur
        this.tfPrix = new TextField();
        this.tfPrix.setPromptText(Requete.getObjet().getPrixActuel()+""); //a modifier pour s'adapter au prix minimal

        //Valeur monetaire
        // typeMoney //a modifier eventuellement pour changer le type de money (ex: euro en dollard)
        this.typeMoney.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));
        this.typeMoney.setPadding(new Insets(0, 0, 0, 10));
    
        //CheckBox pour valider qu'on a plus de 18 ans (doit empecher la validiter de l'achat tant que pas coché)
        this.valideAge.setPadding(new Insets(10, 10, 50, 10));
        
        //Bouton valider l'enchère
        Button valideAchat = new Button("Confirmer");
        valideAchat.setOnAction(new ControleurEncherir(this));
        valideAchat.setStyle("-fx-background-color: #31D455; -fx-text-fill: white; -fx-font-weight: bold;-fx-background-radius: 15px;");
        valideAchat.setAlignment(Pos.CENTER_RIGHT);


        prixEnchere.getChildren().addAll(tfPrix, this.typeMoney);
        pageEnchere.getChildren().addAll(titreAchat, prixEnchere, this.valideAge, valideAchat, this.messageErreurEnchere);
        pageEnchere.setMargin(this.messageErreurEnchere, new Insets(5));


        //pageGraphique (à affichier en mode connecter et si l'objet appartient à la personne)
        VBox pageGraph = new VBox();
        Label titreFlowChart = new Label("Evolution des prix");


        grapheBox.setStyle("fx-background-color: white; -fx-background-radius: 15px;");

        
        pageGraph.getChildren().addAll(titreFlowChart, grapheBox);
        center.getChildren().addAll(intituler, article, titreEnchere, lesProposition);
        left.getChildren().addAll(pageEnchere, pageGraph);
        left.setPadding(new Insets(20));

        return pane;
    }

    private Pane fenetreAdmin(){
        BorderPane res = new BorderPane();
        res.setStyle("-fx-background-color: white;");

        Label titreFenetreAdmin = new Label("Module administrateur");

        //Partie de gauche : liste des utilisateurs
        
        Label titrePartieUtilisateurs = new Label("Utilisateurs");

        VBox gauche = new VBox();
        TextField barreRechercheUtilisateurAdmin = new TextField("Rechercher un utilisateur");
        ScrollPane scrollUsers = new ScrollPane();
        gauche.getChildren().addAll(barreRechercheUtilisateurAdmin, scrollUsers);
        gauche.setMargin(scrollUsers, new Insets(20,20,20,20));
        
        for(Utilisateur user : Requete.obtenirUtilisateurs()){
            HBox utilisateurs = new HBox();
            Button selectionner = new Button("Visualiser");
            selectionner.setOnAction(new ControleurSelectionnerUser(this,user));
            selectionner.getStyleClass().add("bRecherche");
            Button bannir = new Button("Bannir");
            bannir.setOnAction(new ControleurBannir(this,user));
            bannir.getStyleClass().add("bRecherche");
            Label pseudo = new Label("Pseudo : " + user.getpseudo());
            Label numero = new Label("Id : " + String.valueOf(user.getNum()));
            Label nbVentes = new Label("Nombre de ventes : " + String.valueOf(user.getNbVentes()));
            Insets insets = new Insets(5,10,5,10);
            utilisateurs.setMargin(pseudo, insets);
            utilisateurs.setMargin(numero, insets);
            utilisateurs.setMargin(nbVentes, insets);
            utilisateurs.setMargin(selectionner, insets);
            utilisateurs.setMargin(bannir, insets);

            
            utilisateurs.getChildren().addAll(pseudo,numero,nbVentes,selectionner,bannir);
            this.usersVBox.getChildren().add(utilisateurs);
        }
        scrollUsers.setContent(this.usersVBox);
        scrollUsers.setMaxWidth(500);

        //Partie de droite : liste des objets de l'utilisateur séléctionné
        
        Label titrePartieObjets = new Label("Objets");
        
        VBox droite = new VBox();
        TextField barreRechercheObjetAdmin = new TextField("Rechercher un objet en vente");
        ScrollPane scrollVentes = new ScrollPane();
        scrollVentes.setMaxWidth(500);

        scrollVentes.setContent(this.vboxObjet);
        droite.getChildren().addAll(barreRechercheObjetAdmin,scrollVentes);

        
        
        res.setRight(droite);
        res.setLeft(gauche);
        gauche.setStyle("-fx-background-color: white");
        //scroll.setStyle("-fx-background-color: white");
        //scroll.setVbarPolicy(ScrollBarPolicy.NEVER);
        //scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        //res.setLeft(scroll);
        res.setMargin(droite, new Insets(50));
        return res;
    }

    private Pane leGraphe(){
        HBox pane = new HBox();
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        LineChart<Number,Number> graph = new LineChart<Number,Number>(xAxis,yAxis);
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(0, 230));
        series1.getData().add(new XYChart.Data(1, 1250));
        graph.getData().addAll(series1);
        pane.getChildren().addAll(graph);
        pane.setStyle("fx-background-color: white; -fx-background-radius: 15px;");

        return pane;
    }


    public FileChooser getFileChooser(){
        return this.fileChooserImg;
    }
    public TextField getObjetAjoutNomField(){
        return this.objetAjoutNomField;
    }
    public TextField getObjetAjoutDescField(){
        return this.objetAjoutDescField;
    }
    public DatePicker getObjetAjoutDateFinPicker(){
        return this.objetAjoutDateFinPicker;
    }
    public TextField getObjetAjoutPrixInitialField(){
        return this.objetAjoutPrixInitialField;
    }
    public TextField getObjetAjoutPrixMinimalField(){
        return this.objetAjoutPrixMinimalField;
    }
    public ComboBox getObjetAjoutCategorieCombo(){
        return this.objetAjoutCategorieCombo;
    }
    public ImageView getObjetAjoutImage(){
        return this.objetAjoutImage;
    }

    public void modeDeconnecte(){

    }

    public void modeConnecte(){

    }

    public void modeVosVentes(){
        this.panelCentral.setCenter(this.fenetreVenteUtilisateur());
    }

    public void modeEnchere(){
        this.panelCentral.setCenter(this.fenetreVentes());
    }
    public void modeAdmin(){
        this.panelCentral.setCenter(this.fenetreAdmin());
    }
    public void modeVentesSuivies(){

    }

    public void modeVentesVendeur(){

    }
    public void modeAccueil(){
        this.panelCentral.setCenter(this.fenetreAccueil());
    }
    public void modeVendre(){
        this.panelCentral.setCenter(this.fenetreAjouterObjet());
    }
    public void modeAProposDuService(){}


    public void modeFenetreConnexion(){
        this.stageConnexion.setScene(this.laSceneConnexion());
        this.stageConnexion.setTitle("Connexion");
        this.stageConnexion.setResizable(false);
        if (!this.seConnecte){
            this.stageConnexion.show();
        }
        this.seConnecte = true;
        this.stageConnexion.setOnCloseRequest(new ControleurFermerConnexion(this));
    }

    public void modeFenetreInscription(){
        this.stageInscription.setScene(this.laSceneInscription());
        this.stageInscription.setTitle("Inscription");
        this.stageInscription.setResizable(false);
        if (!this.sInscrit){
            this.stageInscription.show();
        }
        this.sInscrit = true;
        this.seConnecte = true;
        this.stageInscription.setOnCloseRequest(new ControleurFermerInscription(this));
    }

    public void setSeConnecte(boolean bool){
        this.seConnecte = bool;
    }

    public Pane fenetreConsultation(){
        Pane pane = new Pane();
        return pane;
    }

    public TextField getBarreRecherche(){
        return this.barreRecherche;
    }

    public Pane fenetreCredit(){
        Pane pane = new Pane();

        return pane;
    }

    public void majAffichageUtlisateur(){
        
        this.usersVBox.getChildren().clear();
        for(Utilisateur user : Requete.obtenirUtilisateurs()){
            HBox utilisateurs = new HBox();
            Button selectionner = new Button("Visualiser");
            selectionner.setOnAction(new ControleurSelectionnerUser(this,user));
            selectionner.getStyleClass().add("bRecherche");
            Button bannir = new Button("Bannir");
            bannir.setOnAction(new ControleurBannir(this,user));
            bannir.getStyleClass().add("bRecherche");
            Label pseudo = new Label(user.getpseudo());
            Label numero = new Label(String.valueOf(user.getNum()));
            Label nbVentes = new Label(String.valueOf(user.getNbVentes()));
            utilisateurs.getChildren().addAll(pseudo,numero,nbVentes,selectionner,bannir);
            this.usersVBox.getChildren().add(utilisateurs);

        }
    }
    public void majAffichageObjet(List<Objet> lesObjets){
        this.vboxObjet.getChildren().clear();
        for (Objet obj : lesObjets){
            HBox boxObjet = new HBox();
            Label nomObjet = new Label(obj.getNom());
            nomObjet.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
            Label descriptionObjet = new Label(obj.getDescription());
            HBox ench = new HBox();
            VBox objetDesc = new VBox();
            Button boutonEncherir = new Button("Enchérir");
            boutonEncherir.setOnAction(new ControleurFenetreVente(this,obj));
            boutonEncherir.getStyleClass().add("encher");
            Label prixObjet = new Label("Prix: "+obj.getPrixActuel()+" €"); 
            prixObjet.setStyle("-fx-background-color: #005C83; -fx-text-fill: white; -fx-background-radius: 10px; -fx-font-size: 30px;");
            ench.getChildren().addAll(prixObjet, boutonEncherir);
            objetDesc.getChildren().addAll(nomObjet, ench, descriptionObjet, new ImageView(new Image("jauge_"+obj.getNote()+".png")));

            ImageView imageObjet = new ImageView(obj.getImageObjet());
            imageObjet.setFitWidth(300);
            imageObjet.setFitHeight(300);
            boxObjet.getChildren().addAll(imageObjet, objetDesc);
            ench.setMargin(prixObjet, new Insets(10));
            ench.setMargin(boutonEncherir, new Insets(10));
            boxObjet.setMargin(objetDesc, new Insets(5));
            objetDesc.setMargin(nomObjet, new Insets(10));
            objetDesc.setMargin(ench, new Insets(10));
            objetDesc.setMargin(descriptionObjet, new Insets(10));
            prixObjet.setPadding(new Insets(10,10,10,10)); 
            this.vboxObjet.getChildren().add(boxObjet);
            this.vboxObjet.setMargin(boxObjet,new Insets(30));
        }
    }


    public void setSInscrit(boolean bool){
        this.sInscrit = bool;
    }

    public void reinitialiserFiltre(){
        this.prixMinField.setText("");
        this.prixMaxField.setText("");
        this.comboCat.setValue("Toutes");
    }

    public TextField getIdentifiant(){
        return this.textFieldIdentifiant;
    }

    public TextField getMotDePasse(){
        return this.passwordFieldMotDePasse;
    }

    public void exitFenetreConnexion(){
        this.stageConnexion.close();
    }

    public void exitFenetreInscription(){
        this.stageInscription.close();
    }

    public void majAffichageConnexion(){
        this.panelCentral.setTop(this.banniere());
    }

    public void majAffichageFenetreEnchere(){
        this.panelCentral.setCenter(this.fenetreVentes());
    }

    public void erreurConnexion(){

    }

    public void setEstConnecte(boolean bool){
        this.estConnecte = bool;
    }

    public void setMessageErreurConnexion(boolean bool){
        if (bool){
            this.messageErreurConnexion.setTextFill(Color.RED);
        }
        else{
            this.messageErreurConnexion.setTextFill(Color.rgb(244,244,244));
        }
    }

    public void setMessageErreurInscription(boolean bool){
        if (bool){
            this.messageErreurInscription.setTextFill(Color.RED);
        }
        else{
            this.messageErreurInscription.setTextFill(Color.rgb(244,244,244));
        }
    }

    public void setMessageErreurEnchere(boolean bool){
        if (bool){
            this.messageErreurEnchere.setTextFill(Color.RED);
        }
        else{
            this.messageErreurEnchere.setTextFill(Color.rgb(255,255,255));
        }
    }

    public void setValideAge(boolean bool){
        if (bool){
            this.valideAge.setSelected(true);
        }
        this.valideAge.setSelected(false);
    }



    public Alert popUpAPropos(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ce service vous est proposé pour consulter les objets mis aux enchères.\nEn vous connectant, il vous sera possible de participer aux enchères et de créer de nouvelles ventes.\n\nService proposé par l'équipe VAN ROSSUM.");
        alert.setTitle("A propos du service");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setHeaderText(null);
        return alert;
    }



    public void majAffichageFenetreConnexion(){
        this.stageConnexion.setScene(this.laSceneConnexion());
    }

    public void majAffichage(){
        this.panelCentral.setCenter(this.fenetreAccueil());
    }

    public boolean getValideAge(){
        return this.valideAge.isSelected();
    }

    public String getValeurEnchere(){
        return this.tfPrix.getText();
    }

    public boolean getConnecte(){
        return this.estConnecte;
    }

    public void setRole(int numRole){
        this.role = numRole;
    }

    public String getInscriptionPseudo(){
        return this.TextFieldInscriptionPseudo.getText();
    }

    public String getInscriptionMDP(){
        return this.TextFieldInscriptionMDP.getText();
    }

    public String getInscriptionConfirmationMDP(){
        return this.TextFieldInscriptionConfirmationMDP.getText();
    }

    public String getInscriptionMail(){
        return this.TextFieldInscriptionMail.getText();   
    }

    public void resetTextFieldConnexion(){
        this.passwordFieldMotDePasse.setText("");
    }


    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("VAE");
        stage.setResizable(false);
        this.stageConnexion = new Stage();
        this.stageInscription = new Stage();
        Scene s = this.laScene();
        s.getStylesheets().add("file:./ressources/styles.css");
        stage.setScene(s);

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

    public ComboBox getCategorieCombo() {
        return this.comboCat;
    }

    public TextField getPrixMinObjet() {
        return this.prixMinField;
    }

    public TextField getPrixMaxObjet() {
        return this.prixMaxField;
    }    
}
