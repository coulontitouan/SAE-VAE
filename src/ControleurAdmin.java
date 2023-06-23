import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Optional;

import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * 
 */
public class ControleurAdmin implements EventHandler<ActionEvent> {
    /**
     * vue de l'application
     **/
    private VAE vueVAE;

    /**
     * @param vueVAE vue d'application'
     */
    public ControleurAdmin(VAE vueVAE) {
        this.vueVAE = vueVAE;
    }
    
    /**
     * 
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.vueVAE.modeAdmin(); 
    }
}