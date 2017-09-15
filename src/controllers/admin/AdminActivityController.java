package controllers.admin;

import com.jfinal.core.Controller;

import common.model.Activity;

import services.ActivityService;

import static common.GrowthbarObjects.ON_TIME;

/**
 * Version:v1.0 (description:  )
 */
public class AdminActivityController extends Controller {

	private ActivityService activityService = new ActivityService();

	public void index() {

	}

	public void release() {

		String content = getPara("content");
		String place = getPara("place");
		String time = getPara("time");
		String compere = getPara("compere");

		Activity activity = new Activity();
		activity.setActivityCompere(compere);
		activity.setActivityContent(content);
		activity.setActivityPlace(place);
		activity.setActivityTime(time);
		activity.setStatus(ON_TIME);

		boolean saveSuccess = false;
		saveSuccess = activityService.save(activity);

		setAttr("status", saveSuccess);
		setAttr("activity", activity);
		renderJson();

	}

	public void update() {

		Integer activityId = getParaToInt("activityId");
		String content = getPara("content");
		String place = getPara("place");
		String time = getPara("time");
		String compere = getPara("compere");

		Activity activity = new Activity();
		activity.setActivityId(activityId);
		activity.setActivityTime(time);
		activity.setActivityPlace(place);
		activity.setActivityCompere(compere);
		activity.setActivityContent(content);

		boolean saveSuccess = false;
		saveSuccess = activityService.save(activity);
		setAttr("activity", activity);
		setAttr("status", saveSuccess);
		renderJson();
	}

	public void delete() {

		boolean deleteSuccess = false;
		Integer id = getParaToInt("activityId");
		deleteSuccess = activityService.remove(id);

		setAttr("status",deleteSuccess);
		renderJson();
	}

}
