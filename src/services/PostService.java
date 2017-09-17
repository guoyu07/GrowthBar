package services;

import com.jfinal.plugin.activerecord.Page;

import common.model.Post;

import java.util.List;

import javafx.geometry.Pos;

/**
 * Version:v1.0 (description:  )
 */
public class PostService implements BaseService<Post> {

	@Override
	public Post select(int id) {
		return Post.dao.findById(id);
	}

	@Override
	public List<Post> selectList() {
		return Post.dao.find("SELECT * FROM post ORDER BY post_time");
	}

	public Page<Post> paginate(Integer pageNumber, Integer pageSize) {
		return Post.dao
				.paginate(pageNumber, pageSize, "SELECT DISTINCT post.post_id,post.post_title",
						"FROM post LEFT JOIN comment ON post.post_id = comment.post_id and post_status != -1 and post_status != 0 ORDER BY comment_time DESC");
	}

	public List<Post> selectAllPostByUser(String userAccount) {
		return Post.dao.find("SELECT * FROM post ORDER BY post_time WHERE user_account LIKE ?",
				userAccount);
	}

	@Override
	public Boolean save(Post entity) {
		if (null == entity.getPostId()) {
			return entity.save();
		}
		return entity.update();
	}

	@Override
	public Boolean remove(int id) {
		Post post = select(id);
		post.setPostStatus(-1);
		return post.update();
	}
}
