import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.geometry.Side;

public class PageAccueil extends BorderPane {
    private Button bouton;
    private TextField l;
    private Label prixAcc;
       
    public PageAccueil(Button bouton){
      super();
      this.bouton = bouton;
      this.l = new TextField();
      //this.setTop(borderPaneTop());
      this.setBottom(VboxCenter());
   }

   /*private BorderPane borderPaneTop(){
      BorderPane pane = new BorderPane();
      pane.setPadding(new Insets(10, 20, 10, 20));
      Label text = new Label("Allo 45-Module Analyste");
      Font font = Font.font("Arial", FontWeight.BOLD, 20);
      text.setFont(font);
      this.bouton.setPrefSize(160, 50);
      ImageView imgBouton = new ImageView(new Image("user.png"));
      imgBouton.prefHeight(50);
      imgBouton.setPreserveRatio(true);
      this.bouton.setGraphic(imgBouton);
      pane.setLeft(text);
      pane.setRight(this.bouton);
      pane.setBackground(new Background(new BackgroundFill(Color.web("0x2471a3"),null,null)));
      return pane;
  }*/

  private HBox HBoxQuestion(){
    HBox hBox = new HBox();
    return hBox;
  }

  private VBox VboxCenter(){
    VBox v = new VBox();
    this.bouton = new Button("Confirmer");
    this.prixAcc = new Label("0");
    bouton.setOnAction(new ControleurConfirme(this));
    v.getChildren().addAll(this.l,this.bouton,this.prixAcc);
    return v;
  }
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  public void encherir(){
    this.prixAcc.setText(String.valueOf(Integer.parseInt(l.getText())));
  }

  public boolean verifSiPlusGrand(){
      int n = Integer.parseInt(l.getText());
      int prixDebut = Integer.parseInt(prixAcc.getText());
      if( n > prixDebut){
        return true;
      }
    return false; 
  }
  
  public boolean verifSiChiffre(){
    if (l.getText().matches("\\d+")){
        return true;
      }
    return false;
  }

  public void resetField(){
    this.l.setText("");
  }

  public Alert popUpMessagCofirmation(){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Êtes vous sûres ?", ButtonType.YES, ButtonType.NO);       
    return alert;
  }

  public Alert popMessageErreur(){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Erreur, cette zone doit contenir\nuniquement des chiffres.", ButtonType.OK);       
    return alert;
  }

  public Alert popMessageRapel(){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Erreur, vous devez enchérir avec un prix\nsupérieur au prix actuel", ButtonType.OK);       
    return alert;
  }
}
