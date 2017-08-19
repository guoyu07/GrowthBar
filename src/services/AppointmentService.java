package services;

import common.model.Appointment;

import java.util.List;

/**
 * Version:v1.0 (description:  )
 */
public class AppointmentService implements BaseService<Appointment> {

	@Override
	public Appointment select(int id) {
		return Appointment.dao.findById(id);
	}

	@Override
	public List<Appointment> selectList() {
		return Appointment.dao.find("SELECT * FROM appointment");
	}

	/**
	 * 用户查询所有的预约的历史记录
	 * @param userAccount 用户账号
	 * @return list
	 */
	public List<Appointment> selectListByUser(String userAccount) {
		return Appointment.dao
				.find("SELECT * FROM appointment ORDER BY time WHERE user_account = ?",
						userAccount);
	}

	/**
	 * 查询活动编号对应的所有预约信息
	 * @param activityId 活动编号
	 * @return list
	 */
	public List<Appointment> slectListByActivity(int activityId) {
		return Appointment.dao
				.find("SELECT * FROM appointment ORDER BY time WHERE activity_id = ?", activityId);
	}

	@Override
	public Boolean save(Appointment entity) {
		if (null == entity.getAppointmentId()) {
			return entity.save();
		} else {
			return entity.update();
		}
	}

	@Override
	public Boolean remove(int id) {
		Appointment appointment = select(id);
		appointment.setStatus(-1);
		return appointment.update();
	}
}
