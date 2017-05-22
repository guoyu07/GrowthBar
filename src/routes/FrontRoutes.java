package routes;

import com.jfinal.config.Routes;

import controllers.ArticleController;
import controllers.IndexController;
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
	}

}
