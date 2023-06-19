import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.ImageView;

public class Objet {
    private String nom;
    private String description;
    private ImageView imageObjet;
    private List<Double> lesPrix;
    private double prixActuel;
    private Categorie objetCategorie;
    public Objet(String nom, String description, Image imageObjet, double prixInitial, Categorie categorie){
        this.nom = nom;
        this.description = description;
        this.imageObjet = imageObjet;
        this.lesPrix = new ArrayList<>();
        this.prixActuel = prixInitial;
        this.objetCategorie = categorie;
    }
    public String getNom(){
        return this.nom;
    }
    public String getDescription(){
        return this.description;
    }
    public ImageView getImageObjet(){
        return this.imageObjet;
    }
    public List<Double> getLesPrix(){
        return this.lesPrix;
    }
    public double getPrixActuel(){
        return this.prixActuel;
    }
    public void setPrixActuel(double prix){
        this.prixActuel = prix;
    }
}
