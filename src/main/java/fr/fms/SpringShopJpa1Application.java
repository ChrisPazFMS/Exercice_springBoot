package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopJpa1Application implements CommandLineRunner  {

	@Autowired
	private CategoryRepository categoryRepository; //connecter la couche DAO.
	
	@Autowired
	private ArticleRepository articleRepository; //connecter la couche DAO.
	
	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpa1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception { //Scope dans lequel on inject les dépendances.
		//categoryRepository.save(new Category("Smartphone"));
		//articleRepository.save(new Article("S20", "Samsung", 1254));
		/* Category smartphone = categoryRepository.save(new Category("Smartphone"));
		Category tablet = categoryRepository.save(new Category("Tablet"));
		Category pc = categoryRepository.save(new Category("PC"));
		
		articleRepository.save(new Article("S10", "Samsung", 500, smartphone));
		articleRepository.save(new Article("S9", "Samsung", 350, smartphone));
		articleRepository.save(new Article("MI10", "Samsung", 100, smartphone));
		     
		articleRepository.save(new Article("GalaxyTab", "Samsung", 450, tablet));
		articleRepository.save(new Article("Ipad", "Samsung", 325, tablet));
		
		articleRepository.save(new Article("R510", "Asus", 600, pc));
		*/

		
		 for (Article article : articleRepository.findByBrand("Samsung")) {
			System.out.println("article where brand : " + article);
		}
		
		for (Article article : articleRepository.findByBrandContains("amsun")) {
			System.out.println("article brand like : " + article);
		}
		
		for (Article article : articleRepository.findByBrandAndPrice("Samsung", 325)) {
			System.out.println("article where brand && price : " + article);
		}
		
		for (Article article : articleRepository.findByBrandAndPriceGreaterThan("Samsung", 250)) {
			System.out.println("article GreaterThan : " + article);
		}
		
		for (Article article : articleRepository.searchArticles("amsun", 250)) {
			System.out.println("article search : " + article);
		}
		
		// Exercice 1.2 : Trouver 2 moyens d’afficher sur la console un article en base.
		//Exemple n°1
		for (Article article : articleRepository.findByBrand("Samsung")) {
			System.out.println("article where brand : " + article);
		}
		
		//Exemple n°2
		for (Article article : articleRepository.findByBrand("Samsung")) {
			System.out.println("article where brand : " + article);
		}
		
		//Exercice 1.3 : Ajouter une méthode qui permet de renvoyer tous les articles contenants telle description et telle marque.
		
		
		
		
		//Exercice 1.4 : Ajouter une méthode qui permet de supprimer un article à partir de l’id

		//articleRepository.deleteById(9);
		
	}

	//VERIFIER LES ACTIONS EN BASE DE DONNER.

	//Dans la console :
	//mysql -u root -p
	//show databases; //Pour voire les tables.
	//use databasename; //Sélectionner une base.
	//show tables; //Lister les tables d'une base sélectionnée.
	//describe tablename; //Afficher les types des champs.
	//SELECT * FROM table_name; //Sélectionner tous les champs disponibles dans le tableau.


}
