package routes;

import com.jfinal.config.Routes;

import controllers.*;

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
	    add("/User",UserInformationController.class);
	}

}
