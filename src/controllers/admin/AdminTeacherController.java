package controllers.admin;

import com.jfinal.core.Controller;

import common.model.Teacher;

/**
 * 
 */
public class AdminTeacherController extends Controller {

	public void index() {
		setAttr("teachers", Teacher.dao.findTeachers());
		render("viewTeachers.html");
	}

	public void add() {
	}

	public void save() {
		getModel(Teacher.class).save();
		redirect("/admin/teacher");
	}

	public void update() {
		getModel(Teacher.class).update();
		redirect("/admin/teacher");
	}

	public void edit() {
		setAttr("teacher", Teacher.dao.findById(getParaToInt()));
		render("admin_Teacher_edit.html");
	}

	public void delete() {
		Teacher.dao.deleteById(getParaToInt());
		redirect("/admin/teacher");
	}

	public void query() {

	}
	
	public void viewTeachers(){
		setAttr("teachers", Teacher.dao.findTeachers());
		renderJson();
	}
}
