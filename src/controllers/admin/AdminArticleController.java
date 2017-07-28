package controllers.admin;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.Page;

import common.model.Article;
import services.ArticleServices;
import utils.TimeUtils;

/**
 * 
 */
public class AdminArticleController extends Controller{
	
	private ArticleServices articleServices;

	public void index() {
		// 分页查询，前端故需分页显示
		//setAttr("articles", Article.dao.paginate(getParaToInt(0, 1), 10));
		render("viewArticles.html");
	}

	public void add() {
		render("admin_Article_add.html");
	}

	public void save() {
		Article article = getModel(Article.class);
		article.setPostTime(TimeUtils.getFormatTime());
		article.save();
		setAttr("article", article);
		setAttr("status", true);
		renderJson();
	}

	public void delete() {
		Article.dao.deleteById(getParaToInt("artId"));
		setAttr("status", true);
		renderJson();
	}

	public void update() {
		Article article = getModel(Article.class);
		article.setPostTime(TimeUtils.getFormatTime());
		article.update();
		setAttr("article",article);
		setAttr("status", true);
		renderJson();
	}

	public void viewArticles() {

		List<Article> articleList = articleServices.findAllArticles();
		setAttr("articles", articleList);
		renderJson();
	}

	public void viewArticle() {
		Integer artId = getParaToInt("artId");
		if (null != artId) {
			Article article = articleServices.findArticleById(artId);
			setAttr("article", article);
		}
		renderJson();
	}

	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}

}
