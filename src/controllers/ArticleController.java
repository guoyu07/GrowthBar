package controllers;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.Page;

import common.model.Article;
import services.ArticleServices;
import utils.TimeUtils;

public class ArticleController extends Controller {

	private ArticleServices articleServices;

	public void index() {
		// 分页查询，前端故需分页显示
		//setAttr("articles", Article.dao.paginate(getParaToInt(0, 1), 10));
		render("Art_index.html");
	}

	// @Before(ArticleValidator.class)
	public void add() {
		render("Art_edit.html");
	}

	public void save() {
		Article article = new Article();
		article.setUserId(getPara("user_id"));
		article.setArtContent(getPara("art_content"));
		article.setArtName(getPara("art_name"));
		article.setPostTime(TimeUtils.getFormatTime());
		article.save();
		render("Art_index.html");
	}

	public void query() {
		// 均使用分页查询
		String artName = getPara("artName");
		setAttr("queryResults", articleServices.queryByArtName(artName));

		String userId = getPara("userId");
		setAttr("queryResults", articleServices.queryByUserId(userId));
	}
	
	public void viewArticles(){
		Page<Article> articlesPage = null;
		if(null != getParaToInt("pageNum")){
			int pageNumber = getParaToInt("pageNum");
			articlesPage = Article.dao.paginate(pageNumber, 5);
		}else{
			articlesPage = Article.dao.paginate(1, 5);
		}
		List<Article> articleList = articlesPage.getList();
		setAttr("articles", articleList);
		renderJson();	
	}
	
	public void viewArticle(){
		int artId = getParaToInt("artId");
		Article article = Article.dao.findArticleById(artId);
		setAttr("article", article);
		renderJson();;
	}

	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}

}
