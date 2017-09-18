/**
 * <p>Project: 网络管理委员会招新网站, NetUnion Recruit WebSite </p> <p>File: PostBarController.java</p>
 * <p>Description: </p> <p>Copyright: Copyright (c) 2017</p>
 *
 * @author 张健顺
 * @email: 1224522500@qq.com
 * @date 2017年6月2日
 */
package controllers;

import com.jfinal.core.Controller;

import common.model.Post;
import common.model.UserInformation;

import java.util.List;

import javafx.geometry.Pos;
import services.PostService;
import utils.DateHelper;

import static common.GrowthbarObjects.SUBMITTED;
import static common.GrowthbarObjects.UNCOMMITTED;

/**
 *
 */
public class PostBarController extends Controller {

	private PostService postService = new PostService();

	public void index() {
		render("index.html");
	}

	public void add() {

		boolean saveSuccess = false;
		String title = getPara("postTitle");
		String content = getPara("postContent");

		Post post = new Post();
		post.setPostTime(DateHelper.getDateTime());
		UserInformation userInformation = getSessionAttr("user");
		if (null == userInformation) {
			setAttr("status", false);
		} else {
			post.setUserAccount(userInformation.getUserAccount());
//			post.setPostStatus(UNCOMMITTED);
			post.setPostStatus(SUBMITTED);
			post.setPostTitle(title);
			post.setPostContent(content);
			saveSuccess = postService.save(post);
			setAttr("post", post);
			setAttr("status", saveSuccess);
		}

		renderJson();
	}

	public void submit() {
		Integer postId = getParaToInt("postId");
		Post post = postService.select(postId);
		post.setPostStatus(SUBMITTED);
		boolean saveSuccess = false;
		saveSuccess = postService.save(post);
		setAttr("status", saveSuccess);
		setAttr("post", post);
		renderJson();
	}

	public void update() {
		Integer postId = getParaToInt("postId");
		String title = getPara("postTitle");
		String content = getPara("postContent");
		boolean saveSuccess = false;
		Post post = new Post();
		post.setPostTime(DateHelper.getDateTime());
		UserInformation userInformation = getSessionAttr("user");
		post.setPostId(postId);
		if (null != userInformation) {

			post.setUserAccount(userInformation.getUserAccount());
			post.setPostStatus(UNCOMMITTED);
			post.setPostTitle(title);
			post.setPostContent(content);
			saveSuccess = postService.save(post);

			setAttr("post", post);

		}
		setAttr("status", saveSuccess);
		renderJson();
	}

	public void viewAll() {
		Integer pageNum = getParaToInt("pageNum",1);
		List<Post> postList = postService.paginate(pageNum, 8).getList();
		setAttr("postList", postList);
		renderJson();
	}

	public void viewOwn() {
		UserInformation userInformation = getSessionAttr("user");
		List<Post> postList = postService.selectAllPostByUser(userInformation.getUserAccount());
		setAttr("postList", postList);
		renderJson();
	}

	public void viewSingle() {
		Integer id = getParaToInt("postId");
		Post post = postService.select(id);
		post.setUserAccount(null);
		setAttr("post", post);
		renderJson();
	}

	public void removeOwn() {
		boolean deleteSuccess = false;
		Integer id = getParaToInt("postId");
		Post post = postService.select(id);
		UserInformation userInformation = getSessionAttr("user");
		if (null != userInformation && userInformation.getUserAccount().equals(post.getUserAccount())) {
			deleteSuccess = postService.remove(id);
		}

		setAttr("status", deleteSuccess);
	}

}
