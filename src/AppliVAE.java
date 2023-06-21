import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;



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

        this.boutonAcceuil.setOnAction(new ControllerPage(this));
        this.boutonCategorie.setOnAction(new ControllerPage(this));
        this.boutonVenteSuivi.setOnAction(new ControllerPage(this));
        this.boutonUtilisateurVente.setOnAction(new ControllerPage(this));
        this.boutonAPropos.setOnAction(new ControllerPage(this));
        

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
        Scene scene = new Scene(fenetre, 1220, 1080);
        
        return scene;
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

        BorderPane pane = new BorderPane();
        VBox center = new VBox();
        VBox left = new VBox();
        pane.setCenter(center);
        pane.setRight(left);

        //Titre de l'objet-article
        Label intituler = new Label("Lumpus Corpes"); // a modifier pour récupéré le nom de l'objet
        intituler.setFont(Font.font("Arial", FontWeight.MEDIUM, 30));
        intituler.setPadding(new Insets(10));

        //l'article avec d'un coté l'image et de l'autre le contenu
        BorderPane article = new BorderPane();

        //Image de l'article en vente
        ImageView imgArticle = new ImageView("profilConnect.png");
        imgArticle.setFitWidth(150);
        imgArticle.setPreserveRatio(true);

        //Contenu de l'article
        VBox contenu = new VBox();

        //Jauge (à modifier)
        ImageView jauge = new ImageView("jauge_4.png");

        //Prix
        HBox infoPrix = new HBox();
        Label prixinit = new Label("prix initial:");
        prixinit.setStyle("-fx-background-color: white; -fx-background-radius: 15px; -fx-font-weight: bold;");
        prixinit.setPadding(new Insets(5));
        Label prix = new Label("230€"); //a modifier pour récupéré le prix initial avant enchère
        prix.setStyle("-fx-background-color: #005C83; -fx-text-fill: white; -fx-font-weight: bold;-fx-background-radius: 15px;");
        prix.setPadding(new Insets(5));
        Button annuler = new Button("Annuler");
        annuler.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;-fx-background-radius: 15px;");
        annuler.setPadding(new Insets(5));

        infoPrix.getChildren().addAll(prixinit, prix, annuler);
        infoPrix.setSpacing(10);

        //Description
        Text description = new Text("Harum trium sententiarum nulli prorsus assentior. Nec \nnim illa prima vera est, \nt, quem ad modum in se quisque sit, \nic in amicum sit animatus");

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
        Label infoVendeur = new Label("Mise en vente par Mario"); //A modifier pour recupéré le nom du propriétaire de l'objet
        infoVendeur.setStyle("-fx-text-fill: #005C83;");
        miseVentePar.getChildren().addAll(avatarVendeur, infoVendeur);

        //Titre Enchère
        Label titreEnchere = new Label("Meilleurs Enchères"); // a modifier pour récupéré le nom de l'objet
        titreEnchere.setFont(Font.font("Arial", FontWeight.MEDIUM, 30));
        titreEnchere.setPadding(new Insets(10));

        //Ensemble des propositions
        HBox lesProposition = new HBox();

        //Une proposition à répéter avec une MaJAffichge
        GridPane proposition = new GridPane();
        proposition.setStyle("-fx-background-color: white; -fx-background-radius: 15px;");
        proposition.setPadding(new Insets(5));

        //avartar proposition (à modifier pour ajouter les images d'avatar different)
        Circle avatarAcheteur = new Circle(25);
        avatarAcheteur.setFill(pattern);
        proposition.add(avatarAcheteur, 0, 0);

        //Nom acheteur
        Text nomAcheteur = new Text("Chao"); //A changer pour recupérer le nom des personnes ayant mis une enchère
        proposition.add(nomAcheteur, 1, 0);

        //recommandation
        Label recommander = new Label("Recommandée");
        recommander.setStyle("-fx-text-fill: #31D455;");
        proposition.add(recommander, 2, 0);

        //montant
        Label montant = new Label("1250€");
        montant.setStyle("-fx-background-color: #D9D9D9; -fx-font-weight: bold;-fx-background-radius: 15px;");
        montant.setPadding(new Insets(5));
        proposition.add(montant, 3, 0);

        //Validée (reservé au personne ayant mis en ligne l'article)
        Button valider = new Button("valider");
        valider.setStyle("-fx-background-color: #31D455; -fx-text-fill: white; -fx-font-weight: bold;-fx-background-radius: 15px;");
        valider.setPadding(new Insets(5));
        proposition.add(valider, 4, 0);


        //taillage de proposition
        proposition.getColumnConstraints().add(new ColumnConstraints(50)); // column 0 is 100 wide
        proposition.getColumnConstraints().add(new ColumnConstraints(100));
        proposition.getColumnConstraints().add(new ColumnConstraints(200));
        proposition.getColumnConstraints().add(new ColumnConstraints(75));
        proposition.getColumnConstraints().add(new ColumnConstraints(75));
   
        


        proposition.setHgap(10);

        lesProposition.getChildren().addAll(proposition);
        
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
        TextField tfPrix = new TextField();
        tfPrix.setPromptText("230"); //a modifier pour s'adapter au prix minimal

        //Valeur monetaire
        Label typeMoney = new Label("€"); //a modifier eventuellement pour changer le type de money (ex: euro en dollard)
        typeMoney.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));
        typeMoney.setPadding(new Insets(0, 0, 0, 10));
    
        //CheckBox pour valider qu'on a plus de 18 ans (doit empecher la validiter de l'achat tant que pas cocher)
        CheckBox valideAge = new CheckBox("J’ai lu et accepté les règles de\n confidencialité et confirme avoir\n plus de 18 ans.");
        valideAge.setPadding(new Insets(10, 10, 50, 10));
        
        //Bouton valider l'enchère
        Button valideAchat = new Button("Confirmer");
        valideAchat.setStyle("-fx-background-color: #31D455; -fx-text-fill: white; -fx-font-weight: bold;-fx-background-radius: 15px;");
        valideAchat.setAlignment(Pos.CENTER_RIGHT);


        prixEnchere.getChildren().addAll(tfPrix, typeMoney);
        pageEnchere.getChildren().addAll(titreAchat, prixEnchere, valideAge, valideAchat);

        //pageGraphique (à affichier en mode connecter et si l'objet appartient à la personne)
        VBox pageGraph = new VBox();
        Label titreFlowChart = new Label("Evolution des prix");


        pageGraph.getChildren().addAll(titreFlowChart, this.leGraphe());
        center.getChildren().addAll(intituler, article, titreEnchere, lesProposition);
        left.getChildren().addAll(pageEnchere, pageGraph);
        left.setPadding(new Insets(20));

        return pane;
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
        this.modeVentes();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AppliVAE.class, args);
    }  
    
}