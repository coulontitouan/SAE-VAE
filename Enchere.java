import java.sql.Date;

public class Enchere {
    private double montant;
    private Date dateEnchere;
    public Enchere(double montant, Date date){
        this.montant =montant;
        this.dateEnchere =dateEnchere;
    }
    public double getMontant(){
        return this.montant;
    }
    public Date getDate(){
        return this.dateEnchere;
    }
}
