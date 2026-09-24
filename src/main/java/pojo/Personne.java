package pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Personne")
@Entity 
public class Personne {

	@Id
	@GeneratedValue
	private int personID;
	
	@Column(length=50)
	private String  nom;
	@Column(length=50)
	private String  prenom;
	
	@Column
	private String  adressePostale;
	
	@Column
	private String ddn;
	@Column
	private String codePostal;
	@Column
	private String ville;
	@Column
	private String adresseCouriel;
	@Column
	private String numTel;
	@Column
	private String dateCotisation;
	
	@OneToOne @JoinColumn( name = "IDGROUPE")
	private Groupe groupe;
	
	public Personne( String  nom, String  prenom, String  adressePostale, String ddn, String codePostal, String ville, String adresseCouriel, String numTel, String dateCotisation) 
	{
		 this.nom = nom;
		 this.prenom = prenom;
		 this.adressePostale = adressePostale;
		 this.ddn = ddn;
		 this.codePostal = codePostal;
		 this.ville = ville;
		 this.adresseCouriel = adresseCouriel;
		 this.numTel = numTel;
		 this.dateCotisation = dateCotisation;
	}
	public Personne() {
		
	}
	public String toString()
	{
		return "Nom : " + nom + "\n"
				+ "Prenom :" + prenom + "\n"
				+ "Adresse : " + adressePostale + "\n"
				+ "Date de naissance : " + ddn + "\n"
				+ "Code Postal : " + codePostal + "\n"
				+ "Ville :" + ville + "\n"
				+ "Adresse Courriel :" + adresseCouriel + "\n"
				+ "numTel :" + numTel + "\n"
				+ "date de Cotisation : " + dateCotisation;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdressePostale() {
		return adressePostale;
	}
	public String getAdresseCouriel() {
		return adresseCouriel;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public String getDateCotisation() {
		return dateCotisation;
	}
	public String getDdn() {
		return ddn;
	}
	public String getNumTel() {
		return numTel;
	}
	public String getVille() {
		return ville;
	}
	public void setAdresseCouriel(String adresseCouriel) {
		this.adresseCouriel = adresseCouriel;
	}
	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public void setDateCotisation(String dateCotisation) {
		this.dateCotisation = dateCotisation;
	}
	public void setDdn(String ddn) {
		this.ddn = ddn;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
}

