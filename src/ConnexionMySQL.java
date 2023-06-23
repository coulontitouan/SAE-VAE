import java.sql.*;
public class ConnexionMySQL {
	private Connection mysql;
	private boolean connecte=false;

	public ConnexionMySQL(){
		this.mysql=null;
		this.connecte=false;
		try {
			Class.forName("org.mariadb.jdbc.Driver");			
		} catch (ClassNotFoundException exception) {
			System.out.println("Il faut importer /usr/share/java/mariadb-java-client.jar dans le classpath.");
			System.exit(1);
		}
		try{
			this.connecter();
		}catch(SQLException exception){
			System.out.println("Bug au niveau de la connexion MySQL...");
			System.exit(1);
		}
	}

	private void connecter() throws SQLException {
		this.mysql=null;
		this.connecte=false;
		this.mysql = DriverManager.getConnection("jdbc:mysql://servinfo-mariadb:3306/DBcoulon","coulon","coulon");
		this.connecte=true;
	}
	public void close() throws SQLException {
		this.mysql.close();
		this.connecte=false;
	}

    public boolean isConnecte() { return this.connecte;}
    public Blob createBlob()throws SQLException{
		return this.mysql.createBlob();
	}
	public Statement createStatement() throws SQLException {
		return this.mysql.createStatement();
	}

	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return this.mysql.prepareStatement(requete);
	}
	
}