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
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
    @Override
    public void init() {
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        // this.majAffichage();
        fenetre.setTop(this.banniere());
        fenetre.setCenter(fenetreAccueil());
        return new Scene(fenetre, 1200, 1000);
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private Pane banniere(){        
        BorderPane banniere = new BorderPane();
        return banniere;
    }





    public BorderPane fenetreAccueil(){
        BorderPane res = new BorderPane();
        res.setStyle("-fx-background-color: lightGray");
        VBox gauche = new VBox();
        HBox premier = new HBox();
        HBox second = new HBox();
        VBox premierdesc = new VBox();
        VBox seconddesc = new VBox();
        Image imgobj1 = new Image("profil.png", 200, 200, false, false, false);
        Image imgobj2 = new Image("profil.png", 200, 200, false, false, false);
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
