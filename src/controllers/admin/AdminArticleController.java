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
		redirect("/admin/article");
	}

	public void delete() {
		Article.dao.deleteById(getParaToInt());
		redirect("/admin/article");
	}

	public void update() {
		Article article = getModel(Article.class);
		article.setPostTime(TimeUtils.getFormatTime());
		article.update();
		redirect("/admin/article");
	}

	public void edit() {
		setAttr("article", Article.dao.findById(getParaToInt()));
		render("admin_Article_edit.html");
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
			articlesPage = articleServices.paginate(pageNumber, 5);
		}else{
			articlesPage = articleServices.paginate(1, 5);
		}
		List<Article> articleList = articlesPage.getList();
		setAttr("articles", articleList);
		renderJson();	
	}

	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}

}
