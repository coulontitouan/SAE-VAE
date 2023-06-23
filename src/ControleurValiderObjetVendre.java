import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;

import java.io.File;
import java.util.Optional;

import javafx.scene.Parent;
import java.sql.Date;
import javafx.scene.control.Button;

/**
 * 
 */
public class ControleurValiderObjetVendre implements EventHandler<ActionEvent> {
    /**
     * vue de l'application
     **/
    private VAE vueVAE;

    /**
     * @param vueVAE vue d'application'
     */
    public ControleurValiderObjetVendre(VAE vueVAE) {
        this.vueVAE = vueVAE;
    }
    
    /**
     * 
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        // .getImage().getPixelReader().getPixels(0, 0, width, height,PixelFormat.getByteBgraInstance(),pixelBytes, 0, width * 4)
        Requete.insertionObjet(this.vueVAE.getObjetAjoutNomField().getText(),this.vueVAE.getObjetAjoutDescField().getText(),this.vueVAE.getObjetAjoutCategorieCombo().getValue().toString(),java.sql.Date.valueOf( this.vueVAE.getObjetAjoutDateFinPicker().getValue()), Double.parseDouble(this.vueVAE.getObjetAjoutPrixInitialField().getText()), Double.parseDouble(this.vueVAE.getObjetAjoutPrixMinimalField().getText()),this.vueVAE.getObjetAjoutImage().getImage(),this.vueVAE.getObjetAjoutDescField().getText());
        this.vueVAE.modeAccueil();

    }
}