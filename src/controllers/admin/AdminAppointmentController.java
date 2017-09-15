package controllers.admin;

import com.jfinal.core.Controller;

import common.model.Appointment;

import java.util.List;

import services.AppointmentService;

/**
 * Version:v1.0 (description:  )
 */
public class AdminAppointmentController extends Controller {

	private AppointmentService appointmentService = new AppointmentService();

	public void index() {

	}

	public void viewAll() {
		List<Appointment> appointments = appointmentService.selectList();
		setAttr("appointments",appointments);
		renderJson();
	}

	public void viewByActivity() {
		Integer id = getParaToInt("activityId");
		List<Appointment> appointments = appointmentService.selectListByActivity(id);
		setAttr("appointments",appointments);
		renderJson();
	}
}
