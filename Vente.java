import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Vente {
    private int numVente;
    private int prixBase;
    private int prixMin;
    private Date debutVente;
    private Date finVente;
    private String statut;
    private List<Enchere> lesEncheres;
    public Vente(int numVente, int prixBase, int prixMin, Date debutVente, Date finVente, String statut){
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
    public int getPrixBase(){
        return this.prixBase;
    }
    public int getPrixMin(){
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
    public List<Enchere> lesEncheres(){
        return this.lesEncheres;
    }
}
