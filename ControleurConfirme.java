import javafx.event.EventHandler;
import java.util.Optional;
import javafx.event.ActionEvent ;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;


public class ControleurConfirme implements EventHandler<ActionEvent>{                           
    private PageAccueil appli;                                                                  
                                                                                                
    public ControleurConfirme(PageAccueil appli){
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent e){
        if(this.appli.verifSiChiffre()){
            if(this.appli.verifSiPlusGrand()){
                ButtonType reponse = this.appli.popUpMessagCofirmation().showAndWait().orElse(ButtonType.CANCEL); 
                if (reponse == ButtonType.YES){
                    this.appli.encherir();
                }
                if(reponse == ButtonType.NO){
                    this.appli.resetField();
                }  
            }
            else{
                this.appli.popMessageRapel().showAndWait();
                this.appli.resetField();
            }
        }
        else{
            this.appli.popMessageErreur().showAndWait();
            this.appli.resetField();
        }
        this.appli.resetField();
    }
}