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

import services.PostService;
import utils.DateHelper;

import static common.GrowthbarObjects.UNCOMMITTED;

/**
 *
 */
public class PostBarController extends Controller {

	private PostService postService;

	public void index() {
		//TODO 贴吧主页
		render("index.html");
	}

	public void add() {

		boolean saveSuccess = false;
		String title = getPara("postTitle");
		String content = getPara("postContent");

		Post post = new Post();
		post.setPostTime(DateHelper.getCurrentTimestamp());
		//TODO 从session中读取userAccount
		post.setUserAccount("");
		post.setPostStatus(UNCOMMITTED);
		post.setPostTitle(title);
		post.setPostContent(content);
		saveSuccess = postService.save(post);

		setAttr("post", post);
		setAttr("status", saveSuccess);
	}

	public void submit() {

	}

}
