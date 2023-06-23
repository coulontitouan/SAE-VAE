import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Vente {
    private int numVente;
    private double prixBase;
    private double prixMin;
    private Date debutVente;
    private Date finVente;
    private String statut;
    private List<Enchere> lesEncheres;
    public Vente(int numVente, double prixBase, double prixMin, Date debutVente, Date finVente, String statut){
        this.numVente= numVente;
        this.prixBase = prixBase;
        this.prixMin = prixMin;
        this.debutVente = debutVente;
        this.finVente = finVente;
        this.statut = statut;
        this.lesEncheres = new ArrayList<>();
    }
    public int getNumVente(){
        return this.numVente;
    }
    public double getPrixBase(){
        return this.prixBase;
    }
    public double getPrixMin(){
        return this.prixMin;
    }
    public Date getDebutVente(){
        return this.debutVente;
    }
    public Date getFinVente(){
        return this.finVente;
    }
    public String getStatut(){
        return this.statut;
    }
    public void ajouteEnchere(Enchere enchere){
        this.lesEncheres.add(enchere);
    }
    public List<Enchere> lesEncheres(){
        return this.lesEncheres;
    }
}
