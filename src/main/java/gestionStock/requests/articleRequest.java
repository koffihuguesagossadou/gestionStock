package gestionStock.requests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestionStock.db.DbConnection;
import gestionStock.entities.Article;
import gestionStock.interfaces.ArticleInterface;


public class articleRequest implements ArticleInterface {
	//@Override
		private Connection connectionToDb = new DbConnection().myConnect();
		private PreparedStatement prepareStatment;
		private String sqlQuery;
		
		public List<Article> getProduits() {
			// TODO Auto-generated method stub
			List<Article> articleList = new ArrayList<Article>();
			
			try {
				sqlQuery = "SELECT * FROM article";
				prepareStatment = this.connectionToDb.prepareStatement(sqlQuery);
				ResultSet queryResults = prepareStatment.executeQuery();
				while (queryResults.next()) {
					
					Article article = new Article();
					
					article.setId(queryResults.getInt("id"));
					article.setDesignation(queryResults.getString("Designation"));
					article.setPrix(queryResults.getString("Prix"));
					article.setQuantite(queryResults.getInt("Quantite"));
					
					articleList.add(article);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return articleList;
		}
		
		@Override
		public Article getArticle(int id) {
			
			Article article = new Article();

			
			try {
				sqlQuery = "SELECT * FROM article WHERE id=?";
				prepareStatment = this.connectionToDb.prepareStatement(sqlQuery);
				prepareStatment.setInt(1, id);
				ResultSet queryResult = prepareStatment.executeQuery();
				while (queryResult.next()) {	
					
					article.setId(queryResult.getInt("id"));
					article.setDesignation(queryResult.getString("Designation"));
					article.setPrix(queryResult.getString("Prix"));
					article.setQuantite(queryResult.getInt("Quantite"));
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return article;
		}

		@Override
		public boolean addArticle(Article article) {
			
			boolean status=false;
			
			this.sqlQuery = "INSERT INTO article(designation,prix,quantite) VALUES (?,?,?)";
			
			try {
				
				prepareStatment = this.connectionToDb.prepareStatement(this.sqlQuery);
				prepareStatment.setString(1, article.getDesignation());
				prepareStatment.setString(2, article.getPrix());
				prepareStatment.setInt(3, article.getQuantite());

				System.out.println(article.toString());
				
				prepareStatment.execute();
				status = true;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			System.out.println(status);
			
			return status;
		}

		@Override
		public boolean supprimerArticle(int id) {
			// TODO Auto-generated method stub
			boolean status = false;
			sqlQuery="DELETE FROM article WHERE id = ?";
			try {
				prepareStatment = this.connectionToDb.prepareStatement(sqlQuery);
				prepareStatment.setInt(1, id);
				prepareStatment.executeUpdate();
				status = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}

		@Override
		public boolean modifierArticle(Article article) {
			// TODO Auto-generated method stub		
			boolean status=false;
			this.sqlQuery = "UPDATE article SET designation = ?, prix = ?, quantite = ? WHERE id = ?";
			
			try {
				prepareStatment = this.connectionToDb.prepareStatement(this.sqlQuery);
				
				prepareStatment.setString(1, article.getDesignation());
				prepareStatment.setString(2, article.getPrix());
				prepareStatment.setInt(3, article.getQuantite());
				prepareStatment.setInt(4, article.getId());

				System.out.println(article.toString());
				
				prepareStatment.executeUpdate();
				
				status = true;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return status;
		}

		@Override
		public Article rechercher(String designation) {
			Article article = new Article();
			
			sqlQuery = "SELECT designation, prix, quantite FROM article WHERE id =?";
			try {
				prepareStatment = this.connectionToDb.prepareStatement(sqlQuery);
				prepareStatment.setString(1, designation);
				ResultSet result = prepareStatment.executeQuery();
				
				while(result.next()) {
					article.setDesignation(result.getString("designation"));
					article.setPrix(result.getString("prix"));
					article.setQuantite(result.getInt("quantite"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return article;

			
		}
}
