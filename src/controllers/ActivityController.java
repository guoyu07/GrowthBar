/**
 * <p>Project: 网络管理委员会招新网站, NetUnion Recruit WebSite </p> <p>File: ActivityController.java</p>
 * <p>Description: </p> <p>Copyright: Copyright (c) 2017</p>
 *
 * @author 张健顺
 * @email: 1224522500@qq.com
 * @date 2017年6月2日
 */
package controllers;

import com.jfinal.core.Controller;

import common.model.Activity;

import java.util.ArrayList;
import java.util.List;

import services.ActivityService;
import utils.DateHelper;

import static common.GrowthbarObjects.OVERDUE;

/**
 *
 */
public class ActivityController extends Controller {

	private ActivityService activityService = new ActivityService();

	public void index() {

	}

	public void viewAll() {
		List<Activity> activities = activityService.selectList();
		List<Activity> activityList = new ArrayList<>();

		for (Activity activity : activities) {
			if (DateHelper.getCurrentTimestamp() > DateHelper
					.getDefaultFormatTimeStamp(activity.getActivityTime())) {
				activity.setStatus(OVERDUE);
				activityService.save(activity);
			}
			activityList.add(activity);
		}

		setAttr("activities", activityList);
		renderJson();
	}

	public void viewSingle() {
		Integer activityId = getParaToInt("activityId");
		Activity activity = activityService.select(activityId);
		setAttr("activity", activity);
		renderJson();
	}
}
