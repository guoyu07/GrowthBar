package controllers.admin;

import java.util.List;

import com.jfinal.core.Controller;

import common.model.Teacher;
import services.TeacherServices;

/**
 * 
 */
public class AdminTeacherController extends Controller {
	
	private TeacherServices teacherServices = new TeacherServices();

	public void index() {
		render("viewTeachers.html");
	}

	public void add() {
	}

	public void save() {
		if(getModel(Teacher.class).save()){
			setAttr("status", true);
		}else{
			setAttr("status", false);
		}
		renderJson();
	}

	public void update() {
		if(getModel(Teacher.class).update()){
			setAttr("status",true);
		}else{
			setAttr("status", false);
		}
		renderJson();
	}

	public void delete() {
		if(Teacher.dao.deleteById(getParaToInt("teacherId"))){
			setAttr("status", true);
		}else{
			setAttr("status", false);
		}
		renderJson();
		
	}

	public void getTeachers(){
		List<Teacher> teachers = teacherServices.selectList();
		setAttr("teachers", teachers);
		renderJson();
	}
	
	public void getTeacher(){
		int teacherId = getParaToInt("teacherId");
		Teacher teacher = teacherServices.select(teacherId);
		setAttr("teacher", teacher);
		renderJson();
	}
}
