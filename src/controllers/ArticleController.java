package controllers;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.Page;

import common.model.Article;

import services.ArticleServices;
import utils.TimeUtils;

public class ArticleController extends Controller {

	private ArticleServices articleServices = new ArticleServices();

	public void index() {

		render("Art_index.html");
	}

	// @Before(ArticleValidator.class)
	public void add() {

		render("Art_edit.html");
	}

	public void save() {
		Article article = new Article();

		// TODO 从session中读取用户信息
		article.setUserId(getPara("user_id"));
		article.setArtContent(getPara("art_content"));
		article.setArtName(getPara("art_name"));
		article.setPostTime(TimeUtils.getCurrentTime());
		article.save();

		setAttr("status", 1);
		renderJson();
	}

	public void query() {
		Integer pageNum = getParaToInt("pageNum");
		int pageNumber = null == pageNum ? 1 : pageNum;
		String artName = getPara("artName");
		if (null != artName) {
			setAttr("queryResults", articleServices.queryByArtName(artName, pageNumber, 5));
		}

		String userId = getPara("userId");
		if (null != userId && !"".equals(userId)) {
			setAttr("queryResults", articleServices.queryByUserId(userId, pageNumber, 5));
		}
		renderJson();
	}

	public void viewArticles() {

		Page<Article> articlesPage = null;
		Integer pageNum = getParaToInt("pageNum");
		int pageNumber = null == pageNum ? 1 : pageNum;
		articlesPage = articleServices.paginate(pageNumber, 5);

		List<Article> articleList = articlesPage.getList();
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
