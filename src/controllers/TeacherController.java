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
	
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}
