package controllers;


import com.jfinal.core.Controller;

import common.model.Teacher;

/**
 * 
 */
public class TeacherController extends Controller{
	
	public void index(){
		//setAttr("teachers", Teacher.dao.findTeachers());
		render("teacher_info.html");
	}
	
	public void viewTeachers(){
		setAttr("teachers", Teacher.dao.findTeachers());
		renderJson();
	}
}
