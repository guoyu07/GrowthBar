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

	/**
	 * 查询对应编号父节点评论的所有子节点评论（即评论回复查询）
	 */
	public List<Comment> selectChildren(int commentId) {
		return Comment.dao.find("SELECT * FROM comment ORDER BY comment_time WHERE comment_id = ?",
				commentId);
	}

	/**
	 * 查询某帖子下对应的所有评论
	 * @param postId 帖子编号
	 * @return List
	 */
	public List<Comment> selectAllCommentsByPost(int postId) {
		return Comment.dao
				.find("SELECT * FROM comment WHERE post_id = ? AND status = 1 ORDER BY comment_time", postId);
	}

	@Override
	public Boolean save(Comment entity) {
		if (null == entity.getCommentId()) {
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
