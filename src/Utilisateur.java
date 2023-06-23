public class Utilisateur{
    private int numUtilisateur;
    private String pseudo;
    private int nbVentes;
    public Utilisateur(int numUtilisateur, String pseudo, int nbVentes){
        this.numUtilisateur = numUtilisateur;
        this.pseudo = pseudo;
        this.nbVentes = nbVentes;
    }
    public int getNum(){
        return this.numUtilisateur;
    }
    public String getpseudo(){
        return this.pseudo;
    }
    public int getNbVentes(){
        return this.nbVentes;
    }
    public void setNum(int numUtilisateur){
        this.numUtilisateur = numUtilisateur;
    }
    public void setpseudo(String pseudo){
        this.pseudo = pseudo;
    }
    public void setNbVentes(int nbVentes){
        this.nbVentes = nbVentes;
    }

}