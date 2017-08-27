package services;

import com.jfinal.plugin.activerecord.Page;

import common.model.Article;

import java.util.List;

public class ArticleServices implements BaseService<Article> {

	public Page<Article> paginate(int pageNumber, int pageSize) {
		return Article.dao.paginate(pageNumber, pageSize, "select article_id,article_title",
				"from article order by post_time desc");
	}

	public Page<Article> queryByUserId(String userId, int pageNum, int pageSize) {
		return Article.dao
				.paginate(pageNum, pageSize, "select * ", "from article where user_id = ?", userId);
	}

	public Page<Article> queryByArtName(String artName, int pageNum, int pageSize) {
		return Article.dao
				.paginate(pageNum, pageSize, "select * ", "from article where art_name like ?",
						artName);
	}

	@Override
	public Article select(int id) {
		return Article.dao.findById(id);
	}

	@Override
	public List<Article> selectList() {
		return paginate(1, 10000).getList();
	}

	@Override
	public Boolean save(Article entity) {
		if (null == entity.getArticleId()) {
			return entity.save();
		} else {
			return entity.update();
		}
	}

	@Override
	public Boolean remove(int id) {
		Article article = select(id);
		article.setStatus(-1);

		return article.update();
	}
}