package services;

import com.jfinal.plugin.activerecord.Page;

import common.model.Post;

import java.util.List;

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

	public List<Post> selectAllPostByUser(String userAccount) {
		return Post.dao
				.find("SELECT * FROM post ORDER BY post_time WHERE user_account = ?", userAccount);
	}

	public Page<Post> paginate(int pageNum, int pageSize) {
		return Post.dao
				.paginate(pageNum, pageSize, "SELECT *", "FROM post ORDER BY post_time desc");
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
