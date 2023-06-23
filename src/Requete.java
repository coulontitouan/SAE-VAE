import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import Exceptions.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Requete {
    private static Statement st;
    private static ResultSet resultat;
    private static ConnexionMySQL laConnexion = new ConnexionMySQL();

    private static UserConnecte utilisateur = new UserConnecte(0, null, null, null, false, 0);
    private static ObjetEnchere objetActuel = new ObjetEnchere();
    
    private Requete(){}

    public static boolean connexion(String pseudo, String motdepasse) {
        try {
            st = laConnexion.createStatement();
            resultat = st.executeQuery(
                    "select pseudout,mdput,idut,emailUt,activeut,idrole from UTILISATEUR where pseudout = '" + pseudo
                            + "' and mdput = '" + motdepasse + "';");
            resultat.next();
            if (resultat.getString(1).equals(pseudo) && resultat.getString(2).equals(motdepasse)) {
                boolean actif = false;
                if (resultat.getString(5).equals("O")) {
                    actif = true;
                }
                utilisateur.setTout(resultat.getInt(3), resultat.getString(1), resultat.getString(2),
                        resultat.getString(4), actif, resultat.getInt(6));
                return true;
            }
            else{
                throw new UtilisateurNonConnecteException();
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean inscription(String pseudo, String email, String motdepasse) {
        try {
            st = laConnexion.createStatement();

            String requeteIDString = "select max(idUt) from UTILISATEUR;";
            resultat = st.executeQuery(requeteIDString);
            int idUt = 1;
            if (resultat.next()) {
                idUt += resultat.getInt(1);
            }

            String requetePseudo = "select pseudoUt from UTILISATEUR where pseudoUt = '" + pseudo + "';";
            resultat = st.executeQuery(requetePseudo);
            if (resultat.next()) {
                throw new PseudoDejaUtiliseException();
            }
            if (pseudo.length() > 20) {
                throw new PseudoTropLongException();
            }
            if (pseudo.length() < 4) {
                throw new PseudoTropCourtException();
            }

            String requeteMail = "select emailUt from UTILISATEUR where emailUt = '" + email + "';";
            resultat = st.executeQuery(requeteMail);
            if (resultat.next()) {
                throw new MailDejaUtiliseException();
            }
            if (!Requete.emailValide(email)) {
                throw new MailNonCorrectException();
            }
            if (email.length() > 100) {
                throw new MailTropLongException();
            }

            if (motdepasse.length() < 8) {
                throw new MotDePasseTropCourtException();
            }
            if (motdepasse.length() > 100) {
                throw new MotDePasseTropLongException();
            }
            if (motdepasse.toLowerCase().equals(motdepasse)) {
                throw new MotDePasseSansMajusculeException();
            }
            int chiffre = 0;
            boolean charSpecial = false;
            for (char c : motdepasse.toCharArray()) {
                if (Character.isDigit(c)) {
                    chiffre += 1;
                } else if (!Character.isAlphabetic(c)) {
                    charSpecial = true;
                }
            }
            if (!charSpecial) {
                throw new MotDePasseSansCharactereSpecialException();
            }
            if (chiffre < 2) {
                throw new MotDePasseSansChiffresException();
            }
            utilisateur.setTout(idUt, pseudo, motdepasse, email, true, 2);

            String requete = "insert into UTILISATEUR(idUt,pseudoUt,emailUT,mdpUt,activeUt,idRole) values (" + idUt
                    + ",\"" + pseudo + "\",\"" + email + "\",\"" + motdepasse + "\",\"O\",2);";
            st.executeQuery(requete);

            System.out.println(requete);

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean faitUneEnchere(int idVe, double montant) throws UtilisateurNonConnecteException, MontantTropFaibleException{
        if (utilisateur.getPseudo().equals(null)) {
            throw new UtilisateurNonConnecteException();
        }
        try {
            st = laConnexion.createStatement();
            if (!utilisateur.getActif()) {
                throw new UtilisateurInactifException();
            }
            resultat = st.executeQuery(
                    "select max(montant),debutVe,finVe,prixBase,idSt from ENCHERIR natural join VENTE where idVe = "+ idVe + ";");
            double ancienMontant = 0;
            Timestamp dateDebut = null;
            Timestamp dateActuelle = new Timestamp(System.currentTimeMillis());
            Timestamp dateFin = null;
            double prixDeBase = 0;
            int statut = 0;
            while (resultat.next()) {
                ancienMontant = resultat.getDouble(1);
                dateDebut = resultat.getTimestamp(2);
                dateFin = resultat.getTimestamp(3);
                prixDeBase = resultat.getDouble(4);
                statut = resultat.getInt(5);
            }
            if (dateDebut.compareTo(dateActuelle) >= 0 || dateFin.compareTo(dateActuelle) < 0) {
                throw new VenteTermineeException();
            }
            if (montant < ancienMontant + 1 || montant <= prixDeBase) {
                throw new MontantTropFaibleException();
            }
            String requete = "insert into ENCHERIR(idUT,idVe,dateheure,montant) values ("
                + utilisateur.getId() + "," + idVe + "," + formateDate(dateActuelle) + "," + montant + ");";
            st.executeQuery(requete);
            return true;
        } catch (MontantTropFaibleException e) {
            throw e;
        }catch(Exception e){
            return false;
        }
    }

    public static boolean changeStatutUtilisateur(int idUT, boolean actif) throws PermissionsManquantesException {
        if (utilisateur.getRole() != 1) {
            throw new PermissionsManquantesException();
        }
        try {
            st = laConnexion.createStatement();
            String actifString = "N";
            if (actif) {
                actifString = "O";
            }
            String requete = "update UTILISATEUR set activeUt = \"" + actifString + "\" where idUT =" + idUT + ";";
            st.executeQuery(requete);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean insertionObjet(String nomOb, String descOb, String categorie, Date dateFin, Double prixBase, Double prixMin, Image img, String imgInfo) {
        try {
            st = laConnexion.createStatement();
            ResultSet resultatIdObjet = st.executeQuery("select MAX(idob) from OBJET;");
            resultatIdObjet.next();

            ResultSet resultatIdPhoto = st.executeQuery("select MAX(idph) from PHOTO;");
            resultatIdPhoto.next();

            ResultSet resultatCategorie = st
                    .executeQuery("select idcat from CATEGORIE where nomcat = '" + categorie + "';");
            resultatCategorie.next();
            

            ResultSet resultatIdVente = st.executeQuery("select MAX(idve) from VENTE;");
            resultatIdVente.next();
            int idVente = resultatIdVente.getInt(1) + 1;

            int idObj = resultatIdObjet.getInt(1) + 1;
            int idPhoto = resultatIdPhoto.getInt(1) + 1;

            st.executeQuery("INSERT INTO OBJET VALUES('" + idObj + "', '" + nomOb + "', '" + descOb + "', "
                    + utilisateur.getId() + " ," + resultatCategorie.getInt(1) + ");");

            st.executeQuery("insert into VENTE(idVe,prixBase,prixMin,debutVe,finVe,idSt,idOb) values(" + idVente + ", "
                    + prixBase + ", " + prixMin + ", CURDATE(), STR_TO_DATE('" + dateFin + "' ,'%Y-%c-%d'),2, " + idObj
                    + ");");




		    PreparedStatement ps= laConnexion.prepareStatement(
		    		"insert into PHOTO(idph, titreph, imgph, idob) values (?,?,?,?)");
		    ps.setInt(1, idPhoto);
		    ps.setString(2,imgInfo);
		    ps.setBlob(3,Requete.encodeImage(img));
		    ps.setInt(4,idObj);
		    ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static List<Objet> obtenirObjetEnVentes(){
        List<Objet> lesObjets = new ArrayList<>();
        try{  
            st = laConnexion.createStatement();
            st.executeQuery("CREATE OR REPLACE VIEW MONTANT_ENCHERE_MAX as SELECT idve, montant FROM ENCHERIR where montant = (SELECT MAX(montant) FROM ENCHERIR E WHERE ENCHERIR.idve = E.idve);");
            
            ResultSet resultatObjetEnVentes = st.executeQuery(" SELECT idob,nomob, descriptionob, nomcat, idut, prixbase, imgph FROM OBJET natural join VENTE natural join CATEGORIE natural join PHOTO where idst = 2 ORDER BY debutve;");
            
            while ( resultatObjetEnVentes.next()){
                ResultSet resultatMontantEnchere = st.executeQuery(" SELECT montant FROM VENTE natural join MONTANT_ENCHERE_MAX where idob = "+resultatObjetEnVentes.getInt(1)+";");

                if (resultatMontantEnchere.next()){
                    lesObjets.add(new Objet(resultatObjetEnVentes.getInt(1),resultatObjetEnVentes.getString(2),resultatObjetEnVentes.getString(3), Requete.decodeImage(resultatObjetEnVentes.getBlob(7)),resultatMontantEnchere.getDouble(1),new Categorie(resultatObjetEnVentes.getString(4)),4,resultatObjetEnVentes.getInt(5)));
                }else{
                    lesObjets.add(new Objet(resultatObjetEnVentes.getInt(1),resultatObjetEnVentes.getString(2),resultatObjetEnVentes.getString(3), Requete.decodeImage(resultatObjetEnVentes.getBlob(7)),resultatObjetEnVentes.getInt(6),new Categorie(resultatObjetEnVentes.getString(4)),4,resultatObjetEnVentes.getInt(5)));
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return lesObjets;
    }

    public static List<Objet> obtenirObjetEnVentesParUtilisateur(){
        List<Objet> lesObjets = new ArrayList<>();
        try{  
            st = laConnexion.createStatement();
            st.executeQuery("CREATE OR REPLACE VIEW MONTANT_ENCHERE_MAX as SELECT idve, montant FROM ENCHERIR where montant = (SELECT MAX(montant) FROM ENCHERIR E WHERE ENCHERIR.idve = E.idve);");
            
            ResultSet resultatObjetEnVentes = st.executeQuery(" SELECT idob,nomob, descriptionob, nomcat, idut, prixbase, imgph FROM OBJET natural join VENTE natural join CATEGORIE natural join PHOTO where idst = 2 AND idut = "+Requete.utilisateur.getId()+" ORDER BY debutve;");
            
            while ( resultatObjetEnVentes.next()){
                ResultSet resultatMontantEnchere = st.executeQuery(" SELECT montant FROM VENTE natural join MONTANT_ENCHERE_MAX where idob = "+resultatObjetEnVentes.getInt(1)+";");

                if (resultatMontantEnchere.next()){
                    lesObjets.add(new Objet(resultatObjetEnVentes.getInt(1),resultatObjetEnVentes.getString(2),resultatObjetEnVentes.getString(3), Requete.decodeImage(resultatObjetEnVentes.getBlob(7)),resultatMontantEnchere.getDouble(1),new Categorie(resultatObjetEnVentes.getString(4)),4,resultatObjetEnVentes.getInt(5)));
                }else{
                    lesObjets.add(new Objet(resultatObjetEnVentes.getInt(1),resultatObjetEnVentes.getString(2),resultatObjetEnVentes.getString(3), Requete.decodeImage(resultatObjetEnVentes.getBlob(7)),resultatObjetEnVentes.getInt(6),new Categorie(resultatObjetEnVentes.getString(4)),4,resultatObjetEnVentes.getInt(5)));
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return lesObjets;
    }

    public static List<Categorie> obtenirCategorie(){
        List<Categorie> lesCategories = new ArrayList<>();
        try{  
            st = laConnexion.createStatement();
            ResultSet resultatCat = st.executeQuery("SELECT nomcat FROM CATEGORIE;");
            
            while (resultatCat.next()){
                lesCategories.add(new Categorie(resultatCat.getString(1)));
            }
        }
        catch(Exception ex){
        
        } 
        return lesCategories;
    }

    static List<Enchere> obtenirVenteObjet(){
        try{
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select idve ,prixbase, prixmin, debutve, finve ,nomst from VENTE natural join STATUT where idob = "+ Requete.objetActuel.getIdObjet()+" ;");
            rs.next();
            Vente res = new Vente(rs.getInt(1),rs.getDouble(2), rs.getDouble(3), rs.getDate(4), rs.getDate(5), rs.getString(6));
            ResultSet resultatEnchere = st.executeQuery("select dateheure,montant, idut from ENCHERIR where idve = "+ rs.getInt(1)+"  ORDER BY montant DESC LIMIT 8;");
            
            while(resultatEnchere .next()) {
                res.ajouteEnchere(new Enchere( resultatEnchere.getDouble(2), resultatEnchere.getDate(1), resultatEnchere.getInt(3)));
            }
            return res.lesEncheres();

        }catch(SQLException ex){
            return new ArrayList<>();
        }
        
    }

    public static List<Objet> obtenirObjetRecherche(String recherche){

        List<Objet> lesObjets = new ArrayList<>();
        try{  
            st = laConnexion.createStatement();
            st.executeQuery("CREATE OR REPLACE VIEW MONTANT_ENCHERE_MAX as SELECT idve, montant FROM ENCHERIR where montant = (SELECT MAX(montant) FROM ENCHERIR E WHERE ENCHERIR.idve = E.idve);");
            
            ResultSet resultatObjetEnVentes = st.executeQuery(" SELECT idob,nomob, descriptionob, nomcat, idut, prixbase, imgph FROM OBJET natural join VENTE natural join CATEGORIE natural join PHOTO where idst = 2 and nomob LIKE '%"+ recherche +"%' ORDER BY debutve;");
            
            while ( resultatObjetEnVentes.next()){
                ResultSet resultatMontantEnchere = st.executeQuery(" SELECT montant FROM VENTE natural join MONTANT_ENCHERE_MAX where idob = "+resultatObjetEnVentes.getInt(1)+";");

                if (resultatMontantEnchere.next()){
                    lesObjets.add(new Objet(resultatObjetEnVentes.getInt(1),resultatObjetEnVentes.getString(2),resultatObjetEnVentes.getString(3), Requete.decodeImage(resultatObjetEnVentes.getBlob(7)),resultatMontantEnchere.getDouble(1),new Categorie(resultatObjetEnVentes.getString(4)),4,resultatObjetEnVentes.getInt(5)));
                }else{
                    lesObjets.add(new Objet(resultatObjetEnVentes.getInt(1),resultatObjetEnVentes.getString(2),resultatObjetEnVentes.getString(3), Requete.decodeImage(resultatObjetEnVentes.getBlob(7)),resultatObjetEnVentes.getInt(6),new Categorie(resultatObjetEnVentes.getString(4)),4,resultatObjetEnVentes.getInt(5)));
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return lesObjets;
    }

    public static List<Objet> obtenirObjetFiltre(String categorie, String prixMin, String prixMax){

        List<Objet> lesObjets = new ArrayList<>();
        try{  
            st = laConnexion.createStatement();
            st.executeQuery("CREATE OR REPLACE VIEW MONTANT_ENCHERE_MAX as SELECT idve, montant FROM ENCHERIR where montant = (SELECT MAX(montant) FROM ENCHERIR E WHERE ENCHERIR.idve = E.idve);");
            
            ResultSet resultatObjetEnVentes = st.executeQuery(" SELECT idob,nomob, descriptionob, nomcat, idut, prixbase, imgph FROM OBJET natural join VENTE natural join CATEGORIE natural join PHOTO where idst = 2 and nomcat = '"+categorie +"'ORDER BY debutve;");
            
            while ( resultatObjetEnVentes.next()){
                ResultSet resultatMontantEnchere = st.executeQuery(" SELECT montant FROM VENTE natural join MONTANT_ENCHERE_MAX where idob = "+resultatObjetEnVentes.getInt(1)+";");

                if (resultatMontantEnchere.next()){
                    if (resultatMontantEnchere.getInt(1)>=Integer.parseInt(prixMin) && resultatMontantEnchere.getInt(1)<=Integer.parseInt(prixMax)){
                            lesObjets.add(new Objet(resultatObjetEnVentes.getInt(1),resultatObjetEnVentes.getString(2),resultatObjetEnVentes.getString(3), Requete.decodeImage(resultatObjetEnVentes.getBlob(7)),resultatMontantEnchere.getDouble(1),new Categorie(resultatObjetEnVentes.getString(4)),4,resultatObjetEnVentes.getInt(5)));
                    }
                }else{
                    if (resultatObjetEnVentes.getInt(6)>=Integer.parseInt(prixMin) && resultatObjetEnVentes.getInt(6)<=Integer.parseInt(prixMax)){
                        
                        lesObjets.add(new Objet(resultatObjetEnVentes.getInt(1),resultatObjetEnVentes.getString(2),resultatObjetEnVentes.getString(3), Requete.decodeImage(resultatObjetEnVentes.getBlob(7)),resultatObjetEnVentes.getInt(6),new Categorie(resultatObjetEnVentes.getString(4)),4,resultatObjetEnVentes.getInt(5)));
                    }
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return lesObjets;
    }

    public static UserConnecte getUser() {
        return utilisateur;
    }

    private static boolean emailValide(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    private static String formateDate(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        return String.format("%s%d/%d/%d:%d:%d:%d%s", "STR_TO_DATE('", calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR), calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), "','%d/%m/%Y:%H:%i:%s')");
    }

    private static Blob encodeImage(Image image){
        try{
            Blob b = laConnexion.createBlob();
            ByteArrayOutputStream s = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", s);
            byte[] res  = s.toByteArray();
            s.close();
            b.setBytes(1, res);
            return b;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static ObjetEnchere getObjet(){
        return Requete.objetActuel;
    }

    private static Image decodeImage(Blob blob){
        Image image = null;
        try {
            InputStream is = blob.getBinaryStream();
            return new Image(is);
        } catch (SQLException e) {
            System.out.println(e);
            return image;
        }
    }

    public static String getNomParId(int idUt) {
        try {
            st = laConnexion.createStatement();
            resultat = st.executeQuery(
                    "select pseudout from UTILISATEUR where idUt = " + idUt + ";");
            if(resultat.next()){
                return resultat.getString(1);
            }
            else{
                return "Mario";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Mario";
        }
    }
}