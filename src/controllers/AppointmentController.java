package controllers;

import com.jfinal.core.Controller;

import common.StatusType;
import common.model.Appointment;
import common.model.UserInformation;

import java.util.ArrayList;
import java.util.List;

import services.AppointmentService;
import utils.DateHelper;

import static common.GrowthbarObjects.SUBMITTED;

/**
 * Version:v1.0 (description:  )
 */
public class AppointmentController extends Controller implements BaseController {

	private AppointmentService appointmentService = new AppointmentService();

	public void index() {

	}

	public void order() {
		Appointment appointment = new Appointment();

		Integer activityId = getParaToInt("activityId");
		UserInformation userInformation = getSessionAttr("user");
		String userAccount = (null == userInformation ? null : userInformation.getUserAccount());

		if(isEmptyString(userAccount)) {
			setAttr("status",false);
			renderJson();
			return;
		}

		String desc = getPara("desc");
		String tel = getPara("telephone");

		appointment.setActivityId(activityId);
		//从session中读取用户信息
		appointment.setUserAccount(userAccount);
		appointment.setDescription(desc);
		appointment.setUserTel(tel);
		appointment.setStatus(SUBMITTED);
		appointment.setTime(DateHelper.getDateTime());

		boolean saveSuccess = false;
		saveSuccess = appointmentService.save(appointment);
		setAttr("status", saveSuccess);
		setAttr("appointment", appointment);

		renderJson();
	}

	public void cancel() {

		Integer id = getParaToInt("appointmentId");
		UserInformation userInformation = getSessionAttr("user");
		String userAccount = (null == userInformation ? null : userInformation.getUserAccount());

		if(isEmptyString(userAccount)) {
			setAttr("status",false);
			renderJson();
			return;
		}
		boolean deleteSuccess = false;
		deleteSuccess = appointmentService.remove(id);

		setAttr("status", deleteSuccess);

		renderJson();
	}

	public void viewOwn() {
		UserInformation userInformation = getSessionAttr("user");
		List<Appointment> appointments;
		if (null != userInformation) {
			String userAccount = userInformation.getUserAccount();
			appointments = appointmentService.selectListByUser(userAccount);
		} else {
			appointments = new ArrayList<>();
		}

		setAttr("appointments", appointments);
		renderJson();
	}

}
