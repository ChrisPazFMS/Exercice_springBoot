package fr.fms.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//L'attribut strategy est utilisé pour spécifier la stratégie de génération de clé primaire que
	//le fournisseur de persistance doit utiliser pour générer la clé primaire d'entité annotée.
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	/*
	L’annotation @OneToMany définit une relation 1:n
	entre deux entités.
	Cette annotation ne peut être utilisée qu’avec une collection d’éléments
	puisqu’elle implique qu’il peut y avoir plusieurs entités associées.
	L’annotation @OneToMany implique que la table Article
	contient une colonne qui est une clé étrangère contenant la clé d’une category. 
	*/

	@OneToMany(mappedBy = "category") //Spécifie une association à valeur unique avec une autre classe d'entité qui a une multiplicité de un à plusieurs
	private Collection<Article> article;

	public Category() {}

	public Category(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + "]";
	}

}
