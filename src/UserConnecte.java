public class UserConnecte{
    private int idUser;
    private String pseudoUser;
    private String mdpUser;
    private String mailUser;
    private boolean actifUser;
    private int roleUser;

    public UserConnecte(int idUser, String pseudoUser, String mdpUser, String mailUser, boolean actifUser, int roleUser){
        this.setTout(idUser,pseudoUser,mdpUser,mailUser,actifUser,roleUser);
    }
    public int getId(){
        return this.idUser;
    }
    public String getPseudo(){
        return this.pseudoUser;
    }
    public String getMdp(){
        return this.mdpUser;
    }
    public String getMail(){
        return this.mailUser;
    }
    public boolean getActif(){
        return this.actifUser;
    }
    public int getRole(){
        return this.roleUser;
    }
    public void setTout(int idUser, String pseudoUser, String mdpUser, String mailUser, boolean actifUser, int roleUser){
        this.idUser = idUser;
        this.pseudoUser = pseudoUser;
        this.mdpUser = mdpUser;
        this.mailUser = mailUser;
        this.actifUser = actifUser;
        this.roleUser =roleUser;
    }
    public void setId(int idUser){
        this.idUser = idUser;
    }
    public void setPseudo(String pseudo){
        this.pseudoUser = pseudo;
    }
    public void setMdp( String mdp){
        this.mdpUser = mdp;
    }
    public void setMail(String mail){
        this.mailUser = mail;
    }
    public void setActif(boolean actif){
        this.actifUser = actif;
    }
    public void setRole(int role){
        this.roleUser = role;
    }
    @Override
    public String toString(){
        return "ID : " + this.idUser + " Pseudo : " + this.pseudoUser + " MotDePasse : " + this.mdpUser + " Mail : " + this.mailUser + " Actif : " + this.actifUser + " Role : " + this.roleUser;
    }
}