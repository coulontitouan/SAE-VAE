import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;

public class ListenerRechercheTempsReel implements ChangeListener<String> {

    private VAE vueVAE;


    public ListenerRechercheTempsReel(VAE vueVAE) {
        this.vueVAE = vueVAE;
    }


    @Override
    public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
        this.vueVAE.majAffichageObjet(Requete.obtenirObjetRecherche(this.vueVAE.getBarreRecherche().getText()));
    }
}
