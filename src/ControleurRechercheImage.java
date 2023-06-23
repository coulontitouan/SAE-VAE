import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.Optional;

import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * 
 */
public class ControleurRechercheImage implements EventHandler<ActionEvent> {
    /**
     * vue de l'application
     **/
    private VAE vueVAE;
    private ImageView img;

    /**
     * @param vueVAE vue d'application'
     */
    public ControleurRechercheImage(VAE vueVAE,ImageView img) {
        this.vueVAE = vueVAE;
        this.img = img;
    }

    /**
     * 
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        File file = this.vueVAE.getFileChooser().showOpenDialog(null);

        try{  
        byte[] img=Files.readAllBytes(file.toPath());
        this.img.setImage(new Image(new ByteArrayInputStream(img)));
        this.img.setFitHeight(300);
        this.img.setFitWidth(300);

        int width = (int) this.img.getImage().getWidth();
        int height = (int) this.img.getImage().getHeight();
        byte[] pixelBytes = new byte[width * height * 4];
        
        this.img.getImage().getPixelReader().getPixels(0, 0, width, height,PixelFormat.getByteBgraInstance(),pixelBytes, 0, width * 4);
        System.out.println(pixelBytes+"");
        }catch (Exception ex){
            byte[] img=null;
        }
        
    }
}