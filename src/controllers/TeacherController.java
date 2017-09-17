package controllers;


import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.core.JFinal;

import common.model.Teacher;
import services.TeacherServices;

/**
 * 
 */
public class TeacherController extends Controller{
	
	private TeacherServices teacherServices = new TeacherServices();
	
	public void index(){
		render("teacher_info.html");
	}
	
	public void viewTeachers(){
		List<Teacher> teachers = teacherServices.selectList();
		setAttr("teachers", teachers);
		setAttr("status",true);
		renderJson();
	}
	
	public void viewTeacher(){
		Integer teacherId = getParaToInt("teacherId");
		if(null == teacherId) {
			setAttr("status",false);
		} else {
			Teacher teacher = teacherServices.select(teacherId);
			setAttr("teacher", teacher);
			setAttr("status",true);

		}
		renderJson();
	}
	
}
