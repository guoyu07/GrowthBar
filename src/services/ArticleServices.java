package services;


import com.jfinal.plugin.activerecord.Page;

import common.model.Article;
/**
 * 
 */
public class ArticleServices {
	
	public Page<Article> paginate(int pageNumber, int pageSize) {
		return Article.dao.paginate(pageNumber, pageSize, "select art_id,art_name", "from article order by post_time desc");
	}
	
	public Article findArticleById(int artId){
		return Article.dao.findById(artId);
	}
	
	public Page<Article> queryByUserId(String userId) {
		return Article.dao.paginate(1, 10, "select * ", "from article where user_id = ?", userId);
	}

	public Page<Article> queryByArtName(String artName) {
		return Article.dao.paginate(1, 10, "select * ", "from article where art_name like ?", artName);
	}
	
}