import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Objet {
    protected int idObjet;
    protected String nom;
    protected String description;
    protected Image imageObjet;
    protected List<Double> lesPrix;
    protected double prixActuel;
    protected Categorie objetCategorie;
    protected int note;
    protected int idUtilisateur;

    public Objet(int idObjet, String nom, String description, Image imageObjet, double prixInitial, Categorie categorie, int note,int idUtilisateur){
        this.idObjet = idObjet;
        this.nom = nom;
        this.description = description;
        this.imageObjet = imageObjet;
        this.lesPrix = new ArrayList<>();
        this.prixActuel = prixInitial;
        this.objetCategorie = categorie;
        this.note = note;
        this.idUtilisateur = idUtilisateur;
        
    }
    public int getIdObjet(){
        return this.idObjet;
    }
    public String getNom(){
        return this.nom;
    }
    public String getDescription(){
        return this.description;
    }
    public Image getImageObjet(){
        return this.imageObjet;
    }
    public List<Double> getLesPrix(){
        return this.lesPrix;
    }
    public double getPrixActuel(){
        return this.prixActuel;
    }
    public Categorie getObjetCategorie(){
        return this.objetCategorie;
    }
    public int getNote(){
        return this.note;
    }
    public int getIdUtilisateur(){
        return this.idUtilisateur;
    }
    public void setPrixActuel(double prix){
        this.prixActuel = prix;
    }
}
