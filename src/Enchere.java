import java.sql.Date;

public class Enchere {
    private double montant;
    private Date dateEnchere;
    private int idUtilisateur;
    public Enchere(double montant, Date date, int idUtilisateur){
        this.montant =montant;
        this.dateEnchere =dateEnchere;
        this.idUtilisateur =idUtilisateur;
    }
    public double getMontant(){
        return this.montant;
    }
    public Date getDate(){
        return this.dateEnchere;
    }
    public int getIdUtilisateur(){
        return this.idUtilisateur;
    }
}
