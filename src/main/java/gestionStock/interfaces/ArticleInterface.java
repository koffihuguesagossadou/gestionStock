package gestionStock.interfaces;

import java.util.List;

import gestionStock.entities.Article;


public interface ArticleInterface {
	public List<Article> getProduits();
	/**
	 * @param article
	 * @return boolean, true if item is save in db or false if is not
	 */
	public boolean addArticle(Article article);
	
	public boolean supprimerArticle(int id);
	public boolean modifierArticle(Article article);
	public Article rechercher(String designation);
	public Article getArticle(int id);
}
