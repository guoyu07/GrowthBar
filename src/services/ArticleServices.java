package services;


import com.jfinal.plugin.activerecord.Page;

import common.model.Article;
/**
 * 
 */
public class ArticleServices {

	public Page<Article> queryByUserId(String userId) {
		return Article.dao.paginate(1, 10, "select * ", "from article where user_id = ?", userId);

	}

	public Page<Article> queryByArtName(String artName) {
		return Article.dao.paginate(1, 10, "select * ", "from article where art_name = ?", artName);
	}
	
}