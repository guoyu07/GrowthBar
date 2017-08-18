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

	@Override
	public Boolean save(Appointment entity) {
		if (null == entity.getAppointmentId()) {
			return entity.save();
		} else {
			return entity.update();
		}	}

	@Override
	public Boolean remove(int id) {
		Appointment appointment = select(id);
		appointment.setStatus(-1);
		return appointment.update();
	}
}
