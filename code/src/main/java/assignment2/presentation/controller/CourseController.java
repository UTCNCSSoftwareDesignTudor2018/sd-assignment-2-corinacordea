package assignment2.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import assignment2.business.dto.CourseDto;
import assignment2.business.service.CourseService;
import assignment2.business.service.TeacherService;
import assignment2.presentation.view.CourseView;
import assignment2.presentation.view.TeacherView;

@Controller
public class CourseController {
	@Autowired
	CourseView courseView;
	@Autowired
	CourseService course;
	@Autowired
	TeacherService teacher;
	@Autowired
	TeacherView teacherView;
	public CourseController(CourseView cv) {
		super();
		this.courseView = cv;
		courseView.setAddCourseBttonActionListener(new AddCourseButtonActionListener());
	}
	
	private class AddCourseButtonActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				try {		
					CourseDto cDto = new CourseDto();
					int idteacher = Integer.parseInt(courseView.getIdTeacherTextField().getText());
					String name = courseView.getNameTextField().getText();
					cDto.setCourseName(name);
					cDto.setTeacherId(idteacher);
					course.saveCourse(cDto);
					List<CourseDto> courses = course.getCourses();
					DefaultTableModel model = courseView.getCourseTableModel();
					courseView.getViewCourses().setModel(model);
					for(CourseDto course: courses) {
						int id = course.getCourseId();
						String cName = course.getCourseName();
						model.addRow(new Object[]{id, cName});
					}
					List<CourseDto> coursesList = course.getCourses();
					DefaultTableModel modelCourses = teacherView.getCourseTableModel();
					courseView.getCourses().setModel(modelCourses);
					for(CourseDto courseDto: coursesList) {
						int id = courseDto.getCourseId();
						String courseName = courseDto.getCourseName();
						int teacherId = courseDto.getTeacherId();
						String teacherName = courseDto.getTeacher().getTeacherName();
						modelCourses.addRow(new Object[]{ teacherId, teacherName,id, courseName});
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				courseView.getCourseFrame().repaint();			
			}
	}
	
}
