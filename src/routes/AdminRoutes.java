package routes;

import com.jfinal.config.Routes;

import controllers.admin.AdminActivityController;
import controllers.admin.AdminArticleController;
import controllers.admin.AdminControllers;
import controllers.admin.AdminTeacherController;

/**
 *
 */
public class AdminRoutes extends Routes {

	@Override
	public void config() {
		add("/admin", AdminControllers.class);
		add("/admin/article", AdminArticleController.class, "/admin");
		add("/admin/teacher", AdminTeacherController.class, "/admin");
		add("/admin/activity", AdminActivityController.class, "/admin");
	}

}
