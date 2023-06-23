import javafx.scene.image.Image;

public class ObjetEnchere extends Objet{
    public ObjetEnchere(){
        super(0, null, null, null, 0.0, null,0,0);
    }
    public void setTout(int idObjet, String nom, String description, Image imageObjet, double prixInitial, Categorie categorie, int note,int idUtilisateur){
        this.idObjet = idObjet;
        this.nom = nom;
        this.description = description;
        this.imageObjet = imageObjet;
        this.prixActuel = prixInitial;
        this.objetCategorie = categorie;
        this.note = note;
        this.idUtilisateur = idUtilisateur;
    }
}
