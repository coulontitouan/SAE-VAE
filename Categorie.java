
public class Categorie {
    private String nom;
    private String description;
    public Categorie(String nom, String description){
        this.nom = nom;
        this.description = description;
    }
    public String getNom(){
        return this.nom;
    }
    public String getDescription(){
        return this.description;
    }
}
