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

	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}

}
