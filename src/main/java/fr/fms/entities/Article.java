package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Article implements Serializable{
	
	//RÉALISATION DES ENTITÉS JPA AVEC LE MÉCANISME D’ANNOTATIONS
	//utiliser @Etity et @id @GeneratedValue(strategy = GenerationType.IDENTITY).
	//Dans vos entités de classe ex : Article et Category.

	private static final long serialVersionUID = 1L;

	//L'attribut strategy est utilisé pour spécifier la stratégie de génération de clé primaire que
	//le fournisseur de persistance doit utiliser pour générer la clé primaire d'entité annotée.
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String brand;
	private double price;
	
	@ManyToOne  //Spécifie une association à valeur unique avec une autre classe d'entité qui a une multiplicité de plusieurs-à-un
	private Category category;

	public Article() {
	};
	
	public Article(String description, String brand, double price, Category category) {
		this.category = category;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}

	//EXÉCUTER L’APPLI ET VÉRIFIER SI LES TABLES SONT GÉNÉRÉES
	//Après il faut créer la couche DAO pour la généricité java.
	//Pour voir l'exemple de code pour la DAO saisissez SPRINGBOOT-DAO :
	
	public Article(String description, String brand, double price) {
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	public Article(long id) {
		this.id = id;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
