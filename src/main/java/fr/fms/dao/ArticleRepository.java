package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	//interface générique pour tout projet :
	//créer une interface qui hérite de JpaRepository qui aura besoin 
	//d’une entité Jpa et d’un Id associé
	//exemple d'interface générique : avec la class ArticleRepository

	public List<Article> findByBrand(String brand);

	public List<Article> findByBrandContains(String brand);

	public List<Article> findByBrandAndPrice(String brand, double price);

	public List<Article> findByBrandAndPriceGreaterThan(String brand, double price);

	public List<Article> findByCategory(long categoryId);

	@Query("select A from Article A where A.brand like %:x% and A.price > :y")
	public List<Article> searchArticles(@Param("x") String kw, @Param("y") double price);
	

	//@Query("SELECT * FROM article")
	//public List<Article> findAllArticleMethode();
	
	  @Query("select u from Article u where u.brand = ?1")
	  List<Article> showByAllBrand(String brand);
	
	/**
	 * 
	 * @param id
	 */
	public void deleteById(long id);
	



}
