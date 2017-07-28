package common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseAppointment<M extends BaseAppointment<M>> extends Model<M> implements IBean {

	public M setAppointmentId(Integer appointmentId) {
		set("appointment_id", appointmentId);
		return (M)this;
	}

	public Integer getAppointmentId() {
		return get("appointment_id");
	}

	public M setActivityId(Integer activityId) {
		set("activity_id", activityId);
		return (M)this;
	}

	public Integer getActivityId() {
		return get("activity_id");
	}

	public M setUserAccount(String userAccount) {
		set("user_account", userAccount);
		return (M)this;
	}

	public String getUserAccount() {
		return get("user_account");
	}

	public M setUserNum(Integer userNum) {
		set("user_num", userNum);
		return (M)this;
	}

	public Integer getUserNum() {
		return get("user_num");
	}

	public M setUserTel(String userTel) {
		set("user_tel", userTel);
		return (M)this;
	}

	public String getUserTel() {
		return get("user_tel");
	}

	public M setStatus(Integer status) {
		set("status", status);
		return (M)this;
	}

	public Integer getStatus() {
		return get("status");
	}

}
