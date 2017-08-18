package services;

import common.model.Activity;

import java.util.List;

/**
 * Version:v1.0 (description:  )
 */
public class ActivityService implements BaseService<Activity> {

	@Override
	public Activity select(int id) {
		return Activity.dao.findById(id);
	}

	@Override
	public List<Activity> selectList() {
		return Activity.dao.find("SELECT * FROM activity order by activity_time desc");
	}

	@Override
	public Boolean save(Activity entity) {
		if(null == entity.getActivityId()) {
			return entity.save();
		}
		return entity.update();
	}

	@Override
	public Boolean remove(int id) {
		return Activity.dao.deleteById(id);
	}
}
