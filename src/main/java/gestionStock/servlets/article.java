package gestionStock.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gestionStock.entities.Article;
import gestionStock.interfaces.ArticleInterface;
import gestionStock.requests.articleRequest;

/**
 * Servlet implementation class article
 */
public class article extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrintWriter out;
	private ArticleInterface articleInterface = new articleRequest();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public article() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
		out = response.getWriter();

		String idArticle = request.getParameter("idArticle");
		
		if(idArticle == null || idArticle.equals("")) {
			
			ArticleInterface articleInterface = new articleRequest();
			List<Article> dataArticleList;
			
			dataArticleList = articleInterface.getProduits();
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			
			Gson gson = gsonBuilder.create();
			
			String dataJson = gson.toJson(dataArticleList);
		
			out.print(dataJson);
			out.flush();
			

			
		}else {
			
			System.out.println(idArticle);
			
			Article article = articleInterface.getArticle(Integer.parseInt(idArticle));
			//System.out.println(article);
			// remplir l'objet avec les données nécessaires
			request.setAttribute("article", article);
			request.getRequestDispatcher("pages/modifArticle.jsp").forward(request, response);
			
		}
		
		
		
		
		
		/*String currentPageUrl = request.getRequestURI();
		System.out.println(currentPageUrl);		
		
		switch (currentPageUrl) {
		case "/gestionStock/article":
			getArticle(request, response);
			break;
		case "":
			break;
		default:
			break;
		}*/
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status");
		
		if(!status.equals("") || status != null) {
			switch (status) {
			case "add":
				addArticle(request, response);
				break;
				
			case "del":
				delArticle(request, response);
				break;
				
			case "upd":
				udpArticle(request, response);
				break;
			default:
				break;
			}
		}
	}
	
	private void udpArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		out = response.getWriter();
		
		boolean updateStatus;
		String designation = request.getParameter("designation");
		String prix = request.getParameter("prix");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		Article article = new Article(designation, prix, quantite);
	
		article.setId(Integer.parseInt(request.getParameter("id")));
		
		updateStatus= articleInterface.modifierArticle(article);
		System.out.println(updateStatus);
		if(updateStatus == true) {
			response.sendRedirect("/gestionStock/");
		}else {
			System.out.println("modification non effectué");
		}
	}

	protected void delArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		boolean suppStatus;
		String dataToSupp = request.getParameter("id");
		
		if(!dataToSupp.equals("") || dataToSupp != null) {
			suppStatus = articleInterface.supprimerArticle(Integer.parseInt(dataToSupp));
			if(suppStatus == true) {
				response.sendRedirect("/gestionStock/");
			}else {
				out.print("Suppression non effectue");
			}
		}
		
	}
	

	protected void addArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		out = response.getWriter();
		
		boolean insertStatus;
		String designation = request.getParameter("designation");
		String prix = request.getParameter("prix");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		
		Article article = new Article(designation, prix, quantite);
		
		System.out.println(article.toString());
		
		insertStatus = articleInterface.addArticle(article);
		
		if(insertStatus == true) {
			response.sendRedirect("/gestionStock/");
		}else {
			out.print("enregistrement non effectue");
		}
		
	}

	protected void getArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		
		
		ArticleInterface articleInterface = new articleRequest();
		List<Article> dataArticleList;
		
		dataArticleList=  articleInterface.getProduits();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		Gson gson = gsonBuilder.create();
		
		String dataJson = gson.toJson(dataArticleList);
	
		out.print(dataJson);
		out.flush();
	}

}
