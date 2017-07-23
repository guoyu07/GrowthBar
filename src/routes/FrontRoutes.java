package routes;

import com.jfinal.config.Routes;

import controllers.ActivityController;
import controllers.ArticleController;
import controllers.IndexController;
import controllers.PostBarCommentController;
import controllers.PostBarController;
import controllers.TeacherController;

/**
 * 
 */
public class FrontRoutes extends Routes{

	@Override
	public void config() {
		add("/",IndexController.class);
		add("/article",ArticleController.class);
		add("/teacher",TeacherController.class);
		add("/activity",ActivityController.class);
		add("/postbar",PostBarController.class);
		add("/postbar-comment",PostBarCommentController.class);
		
	}

}
