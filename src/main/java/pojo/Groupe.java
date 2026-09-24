package pojo;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Groupe")
@Entity
public class Groupe{

	@Id
	@GeneratedValue
	private int idGroupe;
	
	@Column(length=50)
	private String nomGroupe;
	
	@Column(columnDefinition = "integer default 0")
	private int nbMembres;

	@OneToMany( targetEntity = Personne.class, mappedBy="groupe")
	private List<Personne> membres;

	
	public Groupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	
	public Groupe() {

	}

	public int getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}
	
	public int getNbMembres() {
		return nbMembres;
	}
	public void setNbMembres(int nbMembres) {
		this.nbMembres = nbMembres;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	
}
