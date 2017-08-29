package controllers;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.Page;

import common.model.Article;

import services.ArticleServices;
import utils.TimeUtils;

import static common.StatusType.SAVED;
import static common.StatusType.SUBMITTED;

public class ArticleController extends Controller implements BaseController {

	private ArticleServices articleServices = new ArticleServices();

	public void index() {

		render("Art_index.html");
	}

	public void add() {

		render("Art_edit.html");
	}

	/**
	 * 保存文章 or 发表文章 or 修改文章
	 */
	public void save() {

		Article article;
		Integer artId = getParaToInt("artId", 0);
		if (isEmptyInteger(artId)) {
			article = new Article();
		} else {
			article = articleServices.select(artId);
		}

		boolean saveSuccess = false;
		// TODO 从session中读取用户信息
		//article.setUserAccount(getPara("user_id"));
		article.setUserAccount("test-user");

		String content = getPara("artContent");
		article.setArticleContent(content);

		String title = getPara("artTitle");
		article.setArticleTitle(title);

		Integer status = getParaToInt("status");
		if (SAVED.equals(status) || SUBMITTED.equals(status)) {
			article.setStatus(status);
		}
		article.setPostTime(TimeUtils.getCurrentTime());

		saveSuccess = articleServices.save(article);

		setAttr("status", saveSuccess);
		setAttr("article", article);
		renderJson();
	}

	public void queryOwnArticles() {

		boolean querySuccess = false;
		String status = getPara("status", "submitted");

		Integer pageNum = getParaToInt("pageNum", 1);
		String userId = getPara("userId", "");
		if (null != userId && !"".equals(userId)) {
			if ("submitted".equals(status)) {
				setAttr("articleList", articleServices.queryByUserId(userId, pageNum, 5));
			} else if ("saved".equals(status)) {
				setAttr("articleList", articleServices.queryOwnSavedArticles(userId, pageNum, 5));
			} else {
				return;
			}
			querySuccess = true;
		}
		setAttr("status", querySuccess);
		renderJson();
	}

	/**
	 * 查询相关文章 条件查询
	 */
	public void query() {

		boolean querySuccess = false;
		Integer pageNum = getParaToInt("pageNum", 1);

		String artName = getPara("artName", "");
		if (null != artName) {
			setAttr("articleList", articleServices.queryByArtName(artName, pageNum, 5));
			querySuccess = true;
		}

		String userId = getPara("userId", "");
		if (null != userId && !"".equals(userId)) {
			setAttr("articleList", articleServices.queryByUserId(userId, pageNum, 5));
			querySuccess = true;
		}
		setAttr("status", querySuccess);
		renderJson();
	}

	/**
	 * 预览文章列表
	 */
	public void viewArticles() {

		Page<Article> articlesPage = null;

		Integer pageNum = getParaToInt("pageNum", 1);

		boolean queryStatus = false;

		articlesPage = articleServices.paginate(pageNum, 5);
		if (null != articlesPage.getList()) {
			List<Article> articleList = articlesPage.getList();
			setAttr("articles", articleList);
			queryStatus = true;
		}

		setAttr("status", queryStatus);
		renderJson();
	}

	/**
	 * 查看某篇文章
	 */
	public void viewArticle() {

		Integer artId = getParaToInt("artId");
		boolean querySuccess = false;

		if (null != artId) {
			Article article = articleServices.select(artId);
			if (null != article) {
				setAttr("article", article);
			}
			querySuccess = true;
		}
		setAttr("status", querySuccess);
		renderJson();
	}

	/**
	 * 用户删除自己的文章
	 */
	public void delete() {

		//TODO 用户删除权限验证

		Integer artId = getParaToInt("artId", 0);
		boolean deleteSuccess = false;
		Article article = articleServices.select(artId);
		if (null != article) {
			deleteSuccess = articleServices.remove(artId);
			setAttr("article", article);
		}
		setAttr("status", deleteSuccess);
		renderJson();
	}

	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}

}
