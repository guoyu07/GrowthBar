package services;

import common.model.Comment;

import java.util.List;

/**
 * Version:v1.0 (description:  )
 */
public class CommentService implements BaseService<Comment> {

	@Override
	public Comment select(int id) {
		return Comment.dao.findById(id);
	}

	@Override
	public List<Comment> selectList() {
		return Comment.dao.find("SELECT * FROM comment ORDER BY comment_time");
	}

	@Override
	public Boolean save(Comment entity) {
		if(null == entity.getCommentId()) {
			return entity.save();
		}
		return entity.update();
	}

	@Override
	public Boolean remove(int id) {
		Comment comment = select(id);
		comment.setStatus(-1);
		return Comment.dao.deleteById(id);
	}
}
