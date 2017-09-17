/**
 * <p>Project: 网络管理委员会招新网站, NetUnion Recruit WebSite </p> <p>File: PostBarCommentController.java</p>
 * <p>Description: </p> <p>Copyright: Copyright (c) 2017</p>
 *
 * @author 张健顺
 * @email: 1224522500@qq.com
 * @date 2017年6月2日
 */
package controllers;

import com.jfinal.core.Controller;

import common.model.Comment;
import common.model.UserInformation;

import java.util.ArrayList;
import java.util.List;

import services.CommentService;
import utils.DateHelper;

/**
 *
 */
public class PostBarCommentController extends Controller implements BaseController {

	private CommentService commentService = new CommentService();

	public void index() {
		render("index.html");
	}

	public void viewCommentByPost() {
		Integer postId = getParaToInt("postId");
		List<Comment> commentList = commentService.selectAllCommentsByPost(postId);
		List<Comment> comments = new ArrayList<>();
		for (Comment comment : commentList) {
			comment.setUserAccount(null);
			comments.add(comment);
		}
		setAttr("comments", commentList);
		renderJson();
	}

	public void comment() {

		boolean saveSuccess = false;
		UserInformation userInformation = getSessionAttr("user");
		if (null == userInformation) {
			setAttr("status", false);
		} else {
			Integer postId = getParaToInt("postId");
			Integer parentId = getParaToInt("parentId", ZERO_INT);
			String commentContent = getPara("content");
			Comment comment = new Comment();
			comment.setPostId(postId);
			comment.setParentId(parentId);
			comment.setCommentTime(DateHelper.getDateTime());
			comment.setStatus(SUBMITTED);
			comment.setUserAccount(userInformation.getUserAccount());
			comment.setCommentContent(commentContent);
			saveSuccess = commentService.save(comment);
			setAttr("comment", comment);
			setAttr("status", saveSuccess);
		}

		renderJson();

	}
}
